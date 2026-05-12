package com.demo.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * ================================================================
 * CategoryDTO - Category ke liye request/response objects
 * ================================================================
 */
public class CategoryDTO {

    /**
     * CategoryRequest - Naya category banane ya update karne ke liye
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CategoryRequest {

        @NotBlank(message = "Category name khali nahi ho sakta")
        @Size(min = 2, max = 100, message = "Name 2-100 characters ka hona chahiye")
        private String name;

        @Size(max = 500, message = "Description 500 characters se zyada nahi honi chahiye")
        private String description;
    }

    /**
     * CategoryResponse - Client ko wapas bheja jaata hai
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CategoryResponse {
        private Long id;
        private String name;
        private String description;
        private Integer productCount; // Iss category mein kitne products hain
    }
}
