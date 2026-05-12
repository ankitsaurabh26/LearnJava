package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	// @Autowired // Field Injection : Method 2 
    private PaymentService paymentService; // creation of object through bean

    public DemoApplication(PaymentService paymentService){ // Dependency Injection using Constructor : Method 1
        this.paymentService = paymentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String payment = paymentService.pay();
        System.out.println("Payment done: " + payment);
    }
}