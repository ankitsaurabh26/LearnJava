package com.demo.ecommerce.repository;

import com.demo.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * ================================================================
 * CategoryRepository - Category ke liye database operations
 *
 * Yahan bhi Spring Data JPA ka magic kaam aata hai.
 * ================================================================
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    /**
     * Naam se category dhundho
     * Duplicate names check karne ke liye use hota hai
     */
    Optional<Category> findByNameIgnoreCase(String name);

    /**
     * Check karo ki yeh naam pehle se exist karta hai ya nahi
     */
    boolean existsByNameIgnoreCase(String name);
}
