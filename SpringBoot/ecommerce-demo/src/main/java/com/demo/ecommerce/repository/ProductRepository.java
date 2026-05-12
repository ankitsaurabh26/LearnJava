package com.demo.ecommerce.repository;

import com.demo.ecommerce.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * ================================================================
 * ProductRepository - Database operations ke liye interface
 *
 * JpaRepository extend karne se yeh sab FREE milta hai:
 *   - save(), findById(), findAll(), delete(), count(), etc.
 *
 * Spring Data JPA magic karta hai - hume SQL likhni hi nahi padti!
 * Method ka naam dekhke automatically query bana deta hai.
 *
 * Jaise: findByName() -> SELECT * FROM products WHERE name = ?
 * ================================================================
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Category ke saare active products dhundho
     * Method naming convention se query automatic banti hai!
     */
    List<Product> findByCategoryIdAndActiveTrue(Long categoryId);

    /**
     * Name se product dhundho (case-insensitive search)
     * Pageable se pagination bhi milti hai
     */
    Page<Product> findByNameContainingIgnoreCaseAndActiveTrue(String name, Pageable pageable);

    /**
     * Price range ke beech products dhundho
     * Custom JPQL query - SQL jaisi hi hai but Java objects use karta hai
     */
    @Query("SELECT p FROM Product p WHERE p.active = true " +
           "AND p.price BETWEEN :minPrice AND :maxPrice " +
           "ORDER BY p.price ASC")
    List<Product> findByPriceBetween(
            @Param("minPrice") BigDecimal minPrice,
            @Param("maxPrice") BigDecimal maxPrice);

    /**
     * Saare active products - pagination ke saath
     */
    Page<Product> findByActiveTrue(Pageable pageable);

    /**
     * Low stock products dhundho (restocking alert ke liye)
     */
    @Query("SELECT p FROM Product p WHERE p.active = true AND p.stockQuantity <= :threshold")
    List<Product> findLowStockProducts(@Param("threshold") int threshold);

    /**
     * Ek category mein kitne products hain
     */
    long countByCategoryIdAndActiveTrue(Long categoryId);
}
