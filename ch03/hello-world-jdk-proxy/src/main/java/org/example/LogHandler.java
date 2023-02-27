package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {


    private final Object source;

    public LogHandler(Object source) {
        this.source = source;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws InvocationTargetException, IllegalAccessException {
        System.out.println("log start");
        try {
            return method.invoke(source, args);
        } finally {
            System.out.println("log end");
        }
    }
}
