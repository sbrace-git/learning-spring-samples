package org.example;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

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

    @Order(1)
    @After(value = "pointCut(words)", argNames = "words")
    public void after1(StringBuffer words) {
        System.out.println("@After after - 1");
    }

    @Order(2)
    @After(value = "pointCut(words) && this(bye)", argNames = "words,bye")
    public void after2(StringBuffer words, GoodBye bye) {
        System.out.println("@After after - 2");
    }

    @Order(1)
    @Around(value = "pointCut(StringBuffer)")
    public String around1(ProceedingJoinPoint proceedingJoinPoint) {
        long start = System.currentTimeMillis();
        try {
            StringBuffer arg = (StringBuffer) proceedingJoinPoint.getArgs()[0];
            System.out.println("@Around start. - 1");
            return (String) proceedingJoinPoint.proceed(new Object[]{arg.append(" around change - 1!")});
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return "error";
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("@Around end. Total time: " + (end - start) + "ms - 1");
        }
    }

    @DeclareParents(value = "org.example.*", defaultImpl = DefaultGoodBye.class)
    private GoodBye goodBye;

    private final AtomicInteger counter = new AtomicInteger(0);

    @Order(2)
    @Around(value = "execution(* sayHello(..)) && this(goodBye)", argNames = "proceedingJoinPoint,goodBye")
    public String around2(ProceedingJoinPoint proceedingJoinPoint, GoodBye goodBye) {
        long start = System.currentTimeMillis();
        try {
            StringBuffer arg = (StringBuffer) proceedingJoinPoint.getArgs()[0];
            System.out.println("@Around start. - 2");
            return (String) proceedingJoinPoint.proceed(new Object[]{arg.append(" around change - 2!")});
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return "error";
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("@Around end. Total time: " + (end - start) + "ms - 2");
            System.out.println(goodBye.sayBye() + " @Around - 2");
            int count = counter.addAndGet(1);
            System.out.println("count = " + count);
        }
    }
}
