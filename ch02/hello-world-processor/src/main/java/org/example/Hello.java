package org.example;

import javax.annotation.PostConstruct;

public class Hello {
    @PostConstruct
    public void init() {
        System.out.println("Hello PostConstruct");
    }

    public Hello() {
        System.out.println("Hello Construct");
    }

    public void initMethod() {
        System.out.println("Hello initMethod");
    }

}
