package com.demo.ecommerce.exception;

import com.demo.ecommerce.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * ================================================================
 * GlobalExceptionHandler - Poori app ke exceptions ek jagah handle!
 *
 * @RestControllerAdvice -> Yeh sabse badhiya feature hai Spring ka!
 * Koi bhi controller mein exception aaye, woh yahan pakdi jaati hai.
 * Isse har controller mein try-catch likhne ki zaroorat nahi.
 *
 * CLEAN CODE ka principle: Don't Repeat Yourself (DRY)
 * ================================================================
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 404 - Resource nahi mila toh yeh handle karta hai
     * Jaise: Product ID 999 maanga jo hai hi nahi
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleResourceNotFound(ResourceNotFoundException ex) {
        // 404 NOT FOUND status ke saath error response
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error(ex.getMessage()));
    }

    /**
     * 400 - Validation fail ho gayi
     * Jaise: Price negative diya, ya name khali chod diya
     *
     * Saare validation errors collect karke ek saath bhejte hain
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        // Saari field errors ek map mein collect karo
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.<Map<String, String>>builder()
                        .success(false)
                        .message("Validation fail ho gayi, please check karo")
                        .data(errors)
                        .build());
    }

    /**
     * 400 - Business logic se related errors
     * Jaise: Duplicate category name, ya stock se zyada order
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<Void>> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error(ex.getMessage()));
    }

    /**
     * 500 - Koi unexpected error aa gayi
     * Yeh catch-all handler hai - last resort!
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGenericException(Exception ex) {
        // Production mein yeh message alag hona chahiye (sensitive info hide karo)
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error("Kuch galat ho gaya! Backend team se contact karo."));
    }
}
