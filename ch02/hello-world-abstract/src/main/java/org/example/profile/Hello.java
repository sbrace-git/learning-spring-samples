package org.example.profile;

public class Hello {
    public Hello(String name) {
        this.name = name;
    }

    private final String name;

    public void hello() {
        System.out.println("hello " + name);
    }
}
