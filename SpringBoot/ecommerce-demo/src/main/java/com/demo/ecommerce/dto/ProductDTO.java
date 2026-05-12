package com.demo.ecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * ================================================================
 * DTO = Data Transfer Object
 *
 * DTOs use karte hain taaki:
 * 1. Direct entity expose na ho API mein (security)
 * 2. Request aur Response alag alag control kar sakein
 * 3. Sirf zaroori fields bhejein
 *
 * Yahan do inner records hain:
 *   - ProductRequest  -> Client se aata hai (Create/Update ke liye)
 *   - ProductResponse -> Client ko jaata hai
 * ================================================================
 */
public class ProductDTO {

    /**
     * ProductRequest - Jab koi naya product create kare ya update kare
     * toh yeh object aata hai request body mein.
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ProductRequest {

        @NotBlank(message = "Product name dena zaroori hai")
        @Size(min = 2, max = 200)
        private String name;

        private String description;

        @NotNull(message = "Price dena zaroori hai")
        @DecimalMin(value = "0.0", inclusive = false, message = "Price 0 se zyada hona chahiye")
        private BigDecimal price;

        @NotNull(message = "Stock quantity dena zaroori hai")
        @Min(value = 0, message = "Stock negative nahi ho sakta")
        private Integer stockQuantity;

        private String imageUrl;

        // Kaunsi category mein product daalna hai
        @NotNull(message = "Category ID dena zaroori hai")
        private Long categoryId;
    }

    /**
     * ProductResponse - Jab hum product return karte hain client ko.
     * Isme createdAt, updatedAt, categoryName jaise extra fields hain.
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ProductResponse {
        private Long id;
        private String name;
        private String description;
        private BigDecimal price;
        private Integer stockQuantity;
        private String imageUrl;
        private Boolean active;
        private Long categoryId;
        private String categoryName;    // Category ka naam bhi saath mein bhejte hain
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }
}
