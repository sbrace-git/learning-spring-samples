package org.example;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                SpringHello.class.getInterfaces(),
                new LogHandler(new SpringHello()));
        hello.say();

        /*
            log start
            Spring Hello!
            log end
        */
    }
}