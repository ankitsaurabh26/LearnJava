package com.demo.ecommerce.controller;

import com.demo.ecommerce.dto.ApiResponse;
import com.demo.ecommerce.dto.CategoryDTO.CategoryRequest;
import com.demo.ecommerce.dto.CategoryDTO.CategoryResponse;
import com.demo.ecommerce.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ================================================================
 * CategoryController - Category CRUD endpoints
 *
 * Available Endpoints:
 * POST   /api/categories        - Naya category create karo
 * GET    /api/categories        - Saari categories list
 * GET    /api/categories/{id}   - Ek category ID se
 * PUT    /api/categories/{id}   - Category update karo
 * DELETE /api/categories/{id}   - Category delete karo
 * ================================================================
 */
@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    /** POST /api/categories - Naya category banao */
    @PostMapping
    public ResponseEntity<ApiResponse<CategoryResponse>> createCategory(
            @Valid @RequestBody CategoryRequest request) {

        CategoryResponse response = categoryService.createCategory(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success("Category create ho gayi!", response));
    }

    /** GET /api/categories - Saari categories */
    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryResponse>>> getAllCategories() {
        List<CategoryResponse> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(
                ApiResponse.success("Saari categories fetch ho gayi", categories));
    }

    /** GET /api/categories/{id} - Ek category */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponse>> getCategoryById(
            @PathVariable Long id) {

        CategoryResponse category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(ApiResponse.success("Category mil gayi!", category));
    }

    /** PUT /api/categories/{id} - Category update karo */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponse>> updateCategory(
            @PathVariable Long id,
            @Valid @RequestBody CategoryRequest request) {

        CategoryResponse response = categoryService.updateCategory(id, request);
        return ResponseEntity.ok(ApiResponse.success("Category update ho gayi!", response));
    }

    /** DELETE /api/categories/{id} - Category delete karo */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(ApiResponse.success("Category delete ho gayi!"));
    }
}
