package com.demo.ecommerce.controller;

import com.demo.ecommerce.dto.ApiResponse;
import com.demo.ecommerce.dto.ProductDTO.ProductRequest;
import com.demo.ecommerce.dto.ProductDTO.ProductResponse;
import com.demo.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * ================================================================
 * ProductController - Yeh hai hamare API ka DARWAZA!
 *
 * Controller ka kaam sirf:
 *   1. HTTP request receive karo
 *   2. Service ko call karo
 *   3. HTTP response wapas bhejo
 *
 * Business logic yahan BILKUL NAHI honi chahiye!
 *
 * @RestController = @Controller + @ResponseBody
 * @RequestMapping = Base URL prefix
 * ================================================================
 *
 * Available Endpoints:
 * POST   /api/products          - Naya product create karo
 * GET    /api/products          - Saare products list (paginated)
 * GET    /api/products/{id}     - Ek product ID se
 * PUT    /api/products/{id}     - Product update karo
 * DELETE /api/products/{id}     - Product delete karo
 * GET    /api/products/search   - Name se search
 * GET    /api/products/category/{id} - Category ke products
 * GET    /api/products/price-range   - Price range filter
 * GET    /api/products/low-stock     - Low stock alert
 * PATCH  /api/products/{id}/stock    - Stock update karo
 */
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    // ============================================================
    // CREATE
    // ============================================================

    /**
     * POST /api/products
     * Naya product create karo
     *
     * @Valid -> Automatically request body validate karta hai
     * @RequestBody -> JSON ko Java object mein convert karta hai
     */
    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponse>> createProduct(
            @Valid @RequestBody ProductRequest request) {

        log.info("Product create request aayi: {}", request.getName());
        ProductResponse response = productService.createProduct(request);

        // 201 CREATED status bhejte hain naya resource create hone par
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success("Product successfully create ho gaya! 🎉", response));
    }

    // ============================================================
    // READ
    // ============================================================

    /**
     * GET /api/products?page=0&size=10&sortBy=name
     * Saare active products - pagination ke saath
     */
    @GetMapping
    public ResponseEntity<ApiResponse<Page<ProductResponse>>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        Page<ProductResponse> products = productService.getAllProducts(page, size, sortBy);
        return ResponseEntity.ok(
                ApiResponse.success("Products successfully fetch ho gaye", products));
    }

    /**
     * GET /api/products/{id}
     * Ek specific product ID se dhundho
     *
     * @PathVariable -> URL mein se {id} ka value leta hai
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponse>> getProductById(
            @PathVariable Long id) {

        ProductResponse product = productService.getProductById(id);
        return ResponseEntity.ok(
                ApiResponse.success("Product mil gaya!", product));
    }

    /**
     * GET /api/products/search?name=phone&page=0&size=5
     * Name se products search karo
     */
    @GetMapping("/search")
    public ResponseEntity<ApiResponse<Page<ProductResponse>>> searchProducts(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<ProductResponse> products = productService.searchProducts(name, page, size);
        return ResponseEntity.ok(
                ApiResponse.success("Search results aa gaye!", products));
    }

    /**
     * GET /api/products/category/{categoryId}
     * Kisi category ke saare products
     */
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getProductsByCategory(
            @PathVariable Long categoryId) {

        List<ProductResponse> products = productService.getProductsByCategory(categoryId);
        return ResponseEntity.ok(
                ApiResponse.success("Category ke products fetch ho gaye", products));
    }

    /**
     * GET /api/products/price-range?minPrice=100&maxPrice=5000
     * Price range ke andar products dhundho
     */
    @GetMapping("/price-range")
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getProductsByPriceRange(
            @RequestParam BigDecimal minPrice,
            @RequestParam BigDecimal maxPrice) {

        List<ProductResponse> products = productService.getProductsByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok(
                ApiResponse.success(
                        String.format("₹%.0f - ₹%.0f range ke products", minPrice, maxPrice),
                        products));
    }

    /**
     * GET /api/products/low-stock?threshold=5
     * Low stock products dhundho (restocking alert)
     */
    @GetMapping("/low-stock")
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getLowStockProducts(
            @RequestParam(defaultValue = "5") int threshold) {

        List<ProductResponse> products = productService.getLowStockProducts(threshold);
        return ResponseEntity.ok(
                ApiResponse.success("Low stock products: " + products.size() + " items", products));
    }

    // ============================================================
    // UPDATE
    // ============================================================

    /**
     * PUT /api/products/{id}
     * Product update karo (pura product replace hoga)
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponse>> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequest request) {

        ProductResponse response = productService.updateProduct(id, request);
        return ResponseEntity.ok(
                ApiResponse.success("Product successfully update ho gaya!", response));
    }

    /**
     * PATCH /api/products/{id}/stock?quantity=50
     * Sirf stock update karo (partial update)
     *
     * PATCH = Partial update, PUT = Full update
     */
    @PatchMapping("/{id}/stock")
    public ResponseEntity<ApiResponse<ProductResponse>> updateStock(
            @PathVariable Long id,
            @RequestParam int quantity) {

        ProductResponse response = productService.updateStock(id, quantity);
        return ResponseEntity.ok(
                ApiResponse.success("Stock update ho gaya! New quantity: " + quantity, response));
    }

    // ============================================================
    // DELETE
    // ============================================================

    /**
     * DELETE /api/products/{id}
     * Product soft-delete karo
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        // 200 ke saath success message
        return ResponseEntity.ok(
                ApiResponse.success("Product successfully delete ho gaya!"));
    }
}
