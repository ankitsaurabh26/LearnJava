package com.demo.ecommerce.service;

import com.demo.ecommerce.dto.ProductDTO.ProductRequest;
import com.demo.ecommerce.dto.ProductDTO.ProductResponse;
import com.demo.ecommerce.exception.ResourceNotFoundException;
import com.demo.ecommerce.model.Category;
import com.demo.ecommerce.model.Product;
import com.demo.ecommerce.repository.CategoryRepository;
import com.demo.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ================================================================
 * ProductService - Yahan pe saari BUSINESS LOGIC hoti hai!
 *
 * Controller sirf request receive karta hai aur response deta hai.
 * Asli kaam yahan hota hai.
 *
 * @Service     -> Spring ko batata hai ki yeh ek service bean hai
 * @Transactional -> Database operations ek transaction mein honge
 *                   Agar beech mein error aaye toh rollback ho jaayega
 * @Slf4j       -> Logging ke liye (log.info, log.error, etc.)
 * @RequiredArgsConstructor -> Lombok se constructor injection
 * ================================================================
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    // Constructor injection best practice hai (field injection se behtar)
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    // ================================================================
    //  CREATE - Naya product banana
    // ================================================================

    /**
     * Naya product create karo
     * @param request - Product ki details
     * @return Naya product ka response
     */
    @Transactional
    public ProductResponse createProduct(ProductRequest request) {
        log.info("Naya product create ho raha hai: {}", request.getName());

        // Pehle check karo ki category exist karti hai ya nahi
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Category", "id", request.getCategoryId()));

        // Request se Product entity banao
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .stockQuantity(request.getStockQuantity())
                .imageUrl(request.getImageUrl())
                .category(category)
                .active(true)
                .build();

        // Database mein save karo
        Product savedProduct = productRepository.save(product);
        log.info("Product create ho gaya! ID: {}", savedProduct.getId());

        // Entity ko Response DTO mein convert karke return karo
        return mapToResponse(savedProduct);
    }

    // ================================================================
    //  READ - Products padhna/dhundhna
    // ================================================================

    /**
     * ID se product dhundho
     */
    @Transactional(readOnly = true) // readOnly = performance optimization
    public ProductResponse getProductById(Long id) {
        log.debug("Product dhundh raha hoon, ID: {}", id);

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

        return mapToResponse(product);
    }

    /**
     * Saare active products - pagination ke saath
     * @param page  - Page number (0 se start)
     * @param size  - Ek page mein kitne items
     * @param sortBy - Kaunse field se sort karna hai
     */
    @Transactional(readOnly = true)
    public Page<ProductResponse> getAllProducts(int page, int size, String sortBy) {
        log.debug("Saare products fetch ho rahe hain - page: {}, size: {}", page, size);

        // Pageable object banao - database se limited data aayega
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        Page<Product> products = productRepository.findByActiveTrue(pageable);

        // Saare products ko Response DTO mein convert karo
        return products.map(this::mapToResponse);
    }

    /**
     * Name se products search karo (partial match)
     */
    @Transactional(readOnly = true)
    public Page<ProductResponse> searchProducts(String name, int page, int size) {
        log.debug("Search: '{}' ke liye products dhundh raha hoon", name);

        Pageable pageable = PageRequest.of(page, size);
        return productRepository
                .findByNameContainingIgnoreCaseAndActiveTrue(name, pageable)
                .map(this::mapToResponse);
    }

    /**
     * Category ke saare products
     */
    @Transactional(readOnly = true)
    public List<ProductResponse> getProductsByCategory(Long categoryId) {
        // Pehle check karo category exist karti hai
        if (!categoryRepository.existsById(categoryId)) {
            throw new ResourceNotFoundException("Category", "id", categoryId);
        }

        return productRepository.findByCategoryIdAndActiveTrue(categoryId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    /**
     * Price range se products dhundho
     */
    @Transactional(readOnly = true)
    public List<ProductResponse> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        // Business validation
        if (minPrice.compareTo(maxPrice) > 0) {
            throw new IllegalArgumentException(
                    "Minimum price, maximum price se zyada nahi ho sakta!");
        }

        return productRepository.findByPriceBetween(minPrice, maxPrice)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    /**
     * Low stock products dhundho (5 se kam quantity)
     */
    @Transactional(readOnly = true)
    public List<ProductResponse> getLowStockProducts(int threshold) {
        return productRepository.findLowStockProducts(threshold)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ================================================================
    //  UPDATE - Product update karna
    // ================================================================

    /**
     * Product update karo
     */
    @Transactional
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        log.info("Product update ho raha hai, ID: {}", id);

        // Pehle product dhundho
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

        // Category validate karo
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Category", "id", request.getCategoryId()));

        // Existing product update karo
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStockQuantity(request.getStockQuantity());
        product.setImageUrl(request.getImageUrl());
        product.setCategory(category);

        // @Transactional hai toh save() explicitly call karna zaroori nahi
        // but clarity ke liye kar lete hain
        Product updatedProduct = productRepository.save(product);
        log.info("Product update ho gaya! ID: {}", id);

        return mapToResponse(updatedProduct);
    }

    /**
     * Stock update karo (inventory management)
     */
    @Transactional
    public ProductResponse updateStock(Long id, int quantity) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

        if (quantity < 0) {
            throw new IllegalArgumentException("Stock quantity negative nahi ho sakta!");
        }

        product.setStockQuantity(quantity);
        return mapToResponse(productRepository.save(product));
    }

    // ================================================================
    //  DELETE - Product delete karna (soft delete)
    // ================================================================

    /**
     * Product delete karo - SOFT DELETE use karte hain!
     *
     * Soft delete ka matlab: actual database se delete nahi hota,
     * sirf 'active = false' kar dete hain.
     * Fayda: Data recover kar sakte hain agar galti se delete ho gaya
     */
    @Transactional
    public void deleteProduct(Long id) {
        log.info("Product soft-delete ho raha hai, ID: {}", id);

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

        // Actual delete nahi, bas active false kar do
        product.setActive(false);
        productRepository.save(product);

        log.info("Product deactivate ho gaya, ID: {}", id);
    }

    // ================================================================
    //  PRIVATE HELPER METHOD - Entity to DTO conversion
    // ================================================================

    /**
     * Product entity ko ProductResponse DTO mein convert karo
     * Yeh private hai kyunki sirf is service ke andar use hota hai
     */
    private ProductResponse mapToResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stockQuantity(product.getStockQuantity())
                .imageUrl(product.getImageUrl())
                .active(product.getActive())
                .categoryId(product.getCategory().getId())
                .categoryName(product.getCategory().getName())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }
}
