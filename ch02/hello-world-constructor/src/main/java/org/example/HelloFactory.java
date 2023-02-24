package org.example;

public class HelloFactory {
    public static Hello create(String name) {
        return new Hello(name);
    }
}
