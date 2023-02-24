package org.example;

public class Hello {
    private final String name;

    public Hello(String name) {
        System.out.println("create " + name + " @" + Integer.toHexString(hashCode()));
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
        return "@" + Integer.toHexString(hashCode()) + " Hello {" +
                "name='" + name + '\'' +
                '}';
    }
}
