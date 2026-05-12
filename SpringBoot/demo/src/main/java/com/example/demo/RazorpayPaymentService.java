package com.example.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="payment.provider", havingValue= "razorpay") // payment.provider will be in the application.properties file
public class RazorpayPaymentService implements PaymentService{
    public String pay(){
        String payment = "Razorpay Payment";
        System.out.println("Payment from: "+payment);
        return payment;
    }
}
