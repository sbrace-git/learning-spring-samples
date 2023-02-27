package org.example;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAspect {

    @Pointcut("target(org.example.Hello) && args(words)")
    private void pointCut(StringBuffer words) {

    }

    @Before("pointCut(words)")
    public void addWords(StringBuffer words) {
        words.append(" Welcome to Spring! ");
    }
}
