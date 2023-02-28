package org.example;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SayMethodInterceptor implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("SayMethodInterceptor");
    }
}
