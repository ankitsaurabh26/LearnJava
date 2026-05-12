package com.demo.ecommerce.service;

import com.demo.ecommerce.dto.CategoryDTO.CategoryRequest;
import com.demo.ecommerce.dto.CategoryDTO.CategoryResponse;
import com.demo.ecommerce.exception.ResourceNotFoundException;
import com.demo.ecommerce.model.Category;
import com.demo.ecommerce.repository.CategoryRepository;
import com.demo.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ================================================================
 * CategoryService - Category ke liye business logic
 * ================================================================
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    /**
     * Naya category create karo
     */
    @Transactional
    public CategoryResponse createCategory(CategoryRequest request) {
        log.info("Naya category create ho raha hai: {}", request.getName());

        // Duplicate name check karo
        if (categoryRepository.existsByNameIgnoreCase(request.getName())) {
            throw new IllegalArgumentException(
                    "'" + request.getName() + "' naam ki category pehle se exist karti hai!");
        }

        Category category = Category.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();

        Category saved = categoryRepository.save(category);
        log.info("Category create ho gayi! ID: {}", saved.getId());

        return mapToResponse(saved);
    }

    /**
     * Saari categories fetch karo
     */
    @Transactional(readOnly = true)
    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    /**
     * ID se category dhundho
     */
    @Transactional(readOnly = true)
    public CategoryResponse getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
        return mapToResponse(category);
    }

    /**
     * Category update karo
     */
    @Transactional
    public CategoryResponse updateCategory(Long id, CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));

        // Duplicate check - apna current naam exclude karo
        categoryRepository.findByNameIgnoreCase(request.getName())
                .ifPresent(existing -> {
                    if (!existing.getId().equals(id)) {
                        throw new IllegalArgumentException(
                                "Yeh naam pehle se kisi aur category ke paas hai!");
                    }
                });

        category.setName(request.getName());
        category.setDescription(request.getDescription());

        return mapToResponse(categoryRepository.save(category));
    }

    /**
     * Category delete karo
     * Pehle check karo ki isme koi product toh nahi
     */
    @Transactional
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));

        // Check karo ki iss category mein active products hain ya nahi
        long productCount = productRepository.countByCategoryIdAndActiveTrue(id);
        if (productCount > 0) {
            throw new IllegalArgumentException(
                    "Category delete nahi ho sakta! Pehle iske " + productCount +
                    " products ko doosri category mein move karo.");
        }

        categoryRepository.delete(category);
        log.info("Category delete ho gayi, ID: {}", id);
    }

    // Category entity -> Response DTO
    private CategoryResponse mapToResponse(Category category) {
        // Products count karo (null safe)
        int count = (category.getProducts() != null)
                ? (int) category.getProducts().stream().filter(p -> p.getActive()).count()
                : (int) productRepository.countByCategoryIdAndActiveTrue(category.getId());

        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .productCount(count)
                .build();
    }
}
