package com.demo.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

/**
 * ================================================================
 * Category Entity - Product ka category/type store karta hai
 * Jaise: Electronics, Fashion, Books, etc.
 *
 * @Entity  -> Yeh class ek database table represent karti hai
 * @Table   -> Table ka naam specify karte hain
 * ================================================================
 */
@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    // Primary key - auto increment hoga (1, 2, 3...)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Category ka naam - blank nahi hona chahiye
    @NotBlank(message = "Category name khali nahi ho sakta")
    @Column(nullable = false, unique = true, length = 100)
    private String name;

    // Optional description
    @Column(length = 500)
    private String description;

    // Ek category mein multiple products ho sakte hain (One-to-Many)
    // mappedBy = "category" matlab Product class mein 'category' field se linked hai
    // FetchType.LAZY = products tabhi load honge jab explicitly maange
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;
}
