package org.example;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAspect {

    @Before("target(org.example.Hello) && args(words)")
    public void addWords(StringBuffer words) {
        words.append(" Welcome to Spring! ");
    }
}
