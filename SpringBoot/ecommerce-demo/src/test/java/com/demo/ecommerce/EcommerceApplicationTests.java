package com.demo.ecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * ================================================================
 * EcommerceApplicationTests - Basic smoke test
 *
 * Yeh test sirf check karta hai ki Spring context
 * successfully load ho raha hai ya nahi.
 *
 * Run karne ke liye: mvn test
 * ================================================================
 */
@SpringBootTest
class EcommerceApplicationTests {

    /**
     * Context load test - Agar yeh pass ho gaya toh
     * application theek se configure hua hai!
     */
    @Test
    void contextLoads() {
        // Agar koi exception nahi aayi toh test pass hai
        System.out.println("Spring context successfully load ho gaya! ✅");
    }
}
