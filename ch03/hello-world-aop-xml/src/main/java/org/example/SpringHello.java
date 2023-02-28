package org.example;

public class SpringHello implements Hello {
    @Override
    public String sayHello(StringBuffer words) {
//        int i = 1 / 0;
        return "Hello! " + words;
    }
}
