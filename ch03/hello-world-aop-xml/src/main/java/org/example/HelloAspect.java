package org.example;


import org.aspectj.lang.ProceedingJoinPoint;

import java.util.concurrent.atomic.AtomicInteger;

public class HelloAspect {

    private void pointCut(StringBuffer words) {

    }

    public void addWords1(StringBuffer words, GoodBye goodBye) {
        System.out.println("@Before - 1");
        words.append(" Welcome to Spring! ");
    }

    public void addWords2(StringBuffer words) {
        System.out.println("@Before - 2");
    }

    public void addWords3() {
        System.out.println("@Before - 3");
    }

    public void printWords(StringBuffer words, String returningWords) {
        System.out.println("@AfterReturning param: " + words);
        System.out.println("@AfterReturning returning: " + returningWords);
    }

    public void afterThrowing(Exception exception) {
        exception.printStackTrace();
        System.out.println("@AfterThrowing");
    }


    public void after1(StringBuffer words) {
        System.out.println("@After after - 1");
    }


    public void after2(StringBuffer words, GoodBye bye) {
        System.out.println("@After after - 2");
    }

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


    private GoodBye goodBye;

    private AtomicInteger counter = new AtomicInteger(0);

    public void resetCounter() {
        this.counter.set(0);
    }

    public String around2(ProceedingJoinPoint proceedingJoinPoint, GoodBye goodBye) {
        long start = System.currentTimeMillis();
        try {
            StringBuffer arg = (StringBuffer) proceedingJoinPoint.getArgs()[0];
            System.out.println("@Around start. - 2");
            return (String) proceedingJoinPoint.proceed(
                    new Object[]{arg.append(" around change - 2! ")
                            .append(goodBye.sayBye())
                            .append(counter.addAndGet(1))});
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return "error";
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("@Around end. Total time: " + (end - start) + "ms - 2");
            System.out.println(goodBye.sayBye() + " @Around - 2");
        }
    }
}
