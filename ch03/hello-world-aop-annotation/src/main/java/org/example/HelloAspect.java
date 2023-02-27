package org.example;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAspect {

    @Pointcut("target(org.example.Hello) && args(words)")
    private void pointCut(StringBuffer words) {

    }

    @Order(1)
    @Before(value = "pointCut(words)", argNames = "words")
    public void addWords1(StringBuffer words) {
        System.out.println("@Before - 1");
        words.append(" Welcome to Spring! ");
    }

    @Order(2)
    @Before("target(org.example.Hello) && args(words)")
    public void addWords2(StringBuffer words) {
        System.out.println("@Before - 2");
    }

    @Order(3)
    @Before("target(org.example.Hello)")
    public void addWords3() {
        System.out.println("@Before - 3");
    }

    @AfterReturning(value = "pointCut(words)", argNames = "words")
    public void printWords(StringBuffer words) {
        System.out.println("@AfterReturning Say something: " + words);
    }

    @AfterThrowing(value = "pointCut(StringBuffer)", throwing = "exception")
    public void afterThrowing(Exception exception) {
        exception.printStackTrace();
        System.out.println("@AfterThrowing");
    }

    @After(value = "pointCut(words)", argNames = "words")
    public void after(StringBuffer words) {
        System.out.println("@After after");
    }

    @Around(value = "pointCut(StringBuffer)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        long start = System.currentTimeMillis();
        try {
            System.out.println("@Around start.");
            return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return "error";
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("@Around end. Total time: " + (end - start) + "ms");
        }
    }
}
