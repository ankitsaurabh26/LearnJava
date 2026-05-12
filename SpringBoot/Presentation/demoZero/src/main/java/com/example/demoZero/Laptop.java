package com.example.demoZero;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer{
    public void compile(){
        System.out.println("Compiling with some bugss");
    }
}

// What if there is another class(say Desktop) with similar implementation as Laptop

// We'll use @Primary annotation or @Qualifier("laptop_object") in Desktop