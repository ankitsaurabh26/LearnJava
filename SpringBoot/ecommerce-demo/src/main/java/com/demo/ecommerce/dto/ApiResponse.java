package com.demo.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

/**
 * ================================================================
 * ApiResponse - Saare APIs ka ek standard response format!
 *
 * Iska fayda:
 *   - Frontend ko hamesha same structure milega
 *   - Success/Error dono ke liye ek hi format
 *   - Professional dikhta hai manager ko 😄
 *
 * Example response:
 * {
 *   "success": true,
 *   "message": "Product successfully create ho gaya",
 *   "data": { ...product data... },
 *   "timestamp": "2024-01-15T10:30:00"
 * }
 * ================================================================
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
// null fields JSON mein nahi aayenge (response clean rahega)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;             // Generic type - kuch bhi ho sakta hai (Product, List, etc.)
    private LocalDateTime timestamp;

    // ---- Static factory methods: easy banane ke liye ----

    /**
     * Success response banana - data ke saath
     */
    public static <T> ApiResponse<T> success(String message, T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
    }

    /**
     * Success response - sirf message, koi data nahi
     * (jaise delete operation ke baad)
     */
    public static <T> ApiResponse<T> success(String message) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }

    /**
     * Error response banana
     */
    public static <T> ApiResponse<T> error(String message) {
        return ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
