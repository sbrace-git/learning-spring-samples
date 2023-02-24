package org.example;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Hello implements DisposableBean, InitializingBean {
    public String hello() {
        return "Hello World!";
    }

    public void init() {
        System.out.println("init()");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy()");
    }

    public void close() {
        System.out.println("close()");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet()");
    }
}
