package org.example.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Application implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Application.class);
        Application bean = annotationConfigApplicationContext.getBean(Application.class);
        Application bean1 = bean.getBean(Application.class);
        System.out.println(bean);
        System.out.println(bean1);
    }

    public <T> T getBean(Class<T> tClass) {
        return this.applicationContext.getBean(tClass);
    }
}