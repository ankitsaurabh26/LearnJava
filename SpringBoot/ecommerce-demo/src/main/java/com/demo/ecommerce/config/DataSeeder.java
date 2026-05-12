package com.demo.ecommerce.config;

import com.demo.ecommerce.model.Category;
import com.demo.ecommerce.model.Product;
import com.demo.ecommerce.repository.CategoryRepository;
import com.demo.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * ================================================================
 * DataSeeder - App start hone par sample data automatically daalta hai
 *
 * @Component -> Spring ka bean hai yeh
 * CommandLineRunner -> App start hone ke baad run() method call hota hai
 *
 * DEMO ke liye bahut useful hai! Manager ko real data dikhana asaan hoga.
 * ================================================================
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) {
        // Sirf tabhi data daalo jab DB bilkul empty ho
        if (categoryRepository.count() == 0) {
            log.info("DB khali hai, sample data daal rahe hain...");
            seedData();
            log.info("Sample data successfully daal diya! Demo ke liye ready hai. ✅");
        } else {
            log.info("Data pehle se hai, seeding skip kar rahe hain.");
        }
    }

    private void seedData() {

        // ---- Categories banana ----

        Category electronics = categoryRepository.save(
                Category.builder()
                        .name("Electronics")
                        .description("Phones, Laptops, Gadgets aur zyada")
                        .build());

        Category fashion = categoryRepository.save(
                Category.builder()
                        .name("Fashion")
                        .description("Kapde, Joote, Accessories")
                        .build());

        Category books = categoryRepository.save(
                Category.builder()
                        .name("Books")
                        .description("Educational, Fiction, Self-Help books")
                        .build());

        Category homeAppliances = categoryRepository.save(
                Category.builder()
                        .name("Home Appliances")
                        .description("Ghar ke liye useful cheezein")
                        .build());

        // ---- Products banana ----

        // Electronics products
        productRepository.save(Product.builder()
                .name("Samsung Galaxy S24")
                .description("Latest Samsung flagship phone with AI features. 6.2 inch display, 50MP camera.")
                .price(new BigDecimal("74999.00"))
                .stockQuantity(50)
                .imageUrl("https://example.com/images/samsung-s24.jpg")
                .category(electronics)
                .active(true)
                .build());

        productRepository.save(Product.builder()
                .name("Apple MacBook Air M3")
                .description("Ultra-thin laptop with M3 chip. 13 inch Retina display, 18hr battery.")
                .price(new BigDecimal("114900.00"))
                .stockQuantity(25)
                .imageUrl("https://example.com/images/macbook-air.jpg")
                .category(electronics)
                .active(true)
                .build());

        productRepository.save(Product.builder()
                .name("Sony WH-1000XM5 Headphones")
                .description("Industry-leading noise cancellation wireless headphones.")
                .price(new BigDecimal("29990.00"))
                .stockQuantity(3)  // Low stock for demo!
                .imageUrl("https://example.com/images/sony-headphones.jpg")
                .category(electronics)
                .active(true)
                .build());

        // Fashion products
        productRepository.save(Product.builder()
                .name("Nike Air Max 270")
                .description("Comfortable running shoes with Air Max cushioning.")
                .price(new BigDecimal("12995.00"))
                .stockQuantity(100)
                .imageUrl("https://example.com/images/nike-airmax.jpg")
                .category(fashion)
                .active(true)
                .build());

        productRepository.save(Product.builder()
                .name("Levi's 501 Original Jeans")
                .description("Classic straight-fit jeans. Timeless style.")
                .price(new BigDecimal("4999.00"))
                .stockQuantity(75)
                .imageUrl("https://example.com/images/levis-501.jpg")
                .category(fashion)
                .active(true)
                .build());

        // Books
        productRepository.save(Product.builder()
                .name("Clean Code by Robert Martin")
                .description("A handbook of agile software craftsmanship. Every developer must read!")
                .price(new BigDecimal("899.00"))
                .stockQuantity(200)
                .imageUrl("https://example.com/images/clean-code.jpg")
                .category(books)
                .active(true)
                .build());

        productRepository.save(Product.builder()
                .name("System Design Interview")
                .description("An insider's guide to system design interviews. Vol 1 & 2.")
                .price(new BigDecimal("1299.00"))
                .stockQuantity(2) // Low stock for demo!
                .imageUrl("https://example.com/images/system-design.jpg")
                .category(books)
                .active(true)
                .build());

        // Home Appliances
        productRepository.save(Product.builder()
                .name("Dyson V15 Vacuum Cleaner")
                .description("Cordless vacuum with laser dust detection. Most powerful cordless available.")
                .price(new BigDecimal("52900.00"))
                .stockQuantity(15)
                .imageUrl("https://example.com/images/dyson-v15.jpg")
                .category(homeAppliances)
                .active(true)
                .build());

        productRepository.save(Product.builder()
                .name("Instant Pot Duo 7-in-1")
                .description("Multi-cooker: Pressure cooker, slow cooker, rice cooker in one!")
                .price(new BigDecimal("8999.00"))
                .stockQuantity(40)
                .imageUrl("https://example.com/images/instant-pot.jpg")
                .category(homeAppliances)
                .active(true)
                .build());
    }
}
