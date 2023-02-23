package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private final ClassPathXmlApplicationContext context;

    public Main() {
        this.context = new ClassPathXmlApplicationContext("beans.xml");
    }

    public static void main(String[] args) {
        new Main().sayHello();
    }

    public void sayHello() {
        String hello = context.getBean("hello", Hello.class).hello();
        System.out.println(hello);
    }
}