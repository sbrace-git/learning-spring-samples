package org.example;

public class SpringHello implements Hello {
    @Override
    public void say() {
        System.out.println("Spring Hello!");
    }
}
