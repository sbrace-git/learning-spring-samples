package org.example;

public class Main {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("this is a hook")));
        System.out.println("Hello world!");
    }
}