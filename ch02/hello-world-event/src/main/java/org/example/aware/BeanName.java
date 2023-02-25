package org.example.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component("my-bean-name")
public class BeanName implements BeanNameAware {

    private String beanName;

    @Override
    public void setBeanName(String s) {
        beanName = s;
    }

    public String getBeanName() {
        return beanName;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(BeanName.class);
        BeanName bean = annotationConfigApplicationContext.getBean(BeanName.class);
        System.out.println(bean.getBeanName());
    }
}
