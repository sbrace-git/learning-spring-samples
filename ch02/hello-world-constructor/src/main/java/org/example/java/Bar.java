package org.example.java;

public class Bar {
    private Foo foo;


    public Bar(Foo foo) {
        this.foo = foo;
    }


    @Override
    public String toString() {
        return super.toString() + " Bar{" +
                "foo=" + foo +
                '}';
    }
}
