package com.demo.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * ================================================================
 * Product Entity - Hamare catalog ka sabse important model!
 *
 * Yeh class 'products' table ko represent karti hai database mein.
 * Ek product ke paas hoga:
 *   - Name, Description, Price, Stock
 *   - Category (Many-to-One relationship)
 *   - Timestamps (kab create/update hua)
 * ================================================================
 */
@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    // Auto-increment primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Product ka naam - required field
    @NotBlank(message = "Product name dena zaroori hai")
    @Size(min = 2, max = 200, message = "Name 2-200 characters ka hona chahiye")
    @Column(nullable = false, length = 200)
    private String name;

    // Detailed description
    @Column(columnDefinition = "TEXT")
    private String description;

    // Price - BigDecimal use karo money ke liye, kabhi float/double nahi!
    // (Float mein rounding errors hote hain jo paise mein nahi chalega)
    @NotNull(message = "Price dena zaroori hai")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price 0 se zyada hona chahiye")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    // Stock quantity - kitne items available hain
    @NotNull(message = "Stock quantity dena zaroori hai")
    @Min(value = 0, message = "Stock negative nahi ho sakta")
    @Column(nullable = false)
    private Integer stockQuantity;

    // Product image URL (optional)
    @Column(length = 500)
    private String imageUrl;

    // Product active hai ya nahi (soft delete ke liye)
    @Column(nullable = false)
    @Builder.Default
    private Boolean active = true;

    // Many products -> One category
    // @ManyToOne: Bahut saare products ek category mein ho sakte hain
    // @JoinColumn: 'category_id' foreign key column banega
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // Yeh automatically set hota hai jab record pehli baar save hota hai
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Yeh automatically update hota hai jab bhi record change hota hai
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
