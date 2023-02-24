package org.example;

public class Hello {
    private final String name;

    public Hello(String name) {
        this.name = name;
    }

    public String hello() {
        return "Hello World! by " + name;
    }

    public static Hello create(String name) {
        return new Hello(name);
    }

    @Override
    public String toString() {
        return super.toString() + " Hello {" +
                "name='" + name + '\'' +
                '}';
    }
}
