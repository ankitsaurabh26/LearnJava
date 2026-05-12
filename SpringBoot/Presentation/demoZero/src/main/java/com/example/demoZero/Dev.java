package com.example.demoZero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dev {

    // @Autowired // 1. Field Injection
    private Computer Dell;
    // private Laptop Dell;

    @Autowired // 2. Setter Injection
    public void setLaptop(Laptop Dell){
        this.Dell = Dell;
    }

    // 3. Constructor Injection

    public void build(){
        System.out.println("Letsss build something!!");
        
        Dell.compile();

    }
}