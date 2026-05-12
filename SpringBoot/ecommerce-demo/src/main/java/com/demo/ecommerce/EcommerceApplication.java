package com.demo.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ================================================================
 * EcommerceApplication - Yeh hai hamare app ka MAIN ENTRY POINT
 *
 * @SpringBootApplication ek combination annotation hai jo teen
 * cheezein ek saath karta hai:
 *   1. @Configuration       -> Spring config class
 *   2. @EnableAutoConfiguration -> Auto-config on karta hai
 *   3. @ComponentScan       -> Saare beans dhundta hai
 *
 * Bas yahan se sab kuch start hota hai! 🚀
 * ================================================================
 */
@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
        System.out.println("===========================================");
        System.out.println("  E-Commerce Backend chal gaya! 🎉");
        System.out.println("  URL: http://localhost:8080/api");
        System.out.println("===========================================");
    }
}
