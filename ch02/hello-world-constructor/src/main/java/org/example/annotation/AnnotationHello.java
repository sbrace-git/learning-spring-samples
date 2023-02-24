package org.example.annotation;

import org.example.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AnnotationHello extends Hello {

    @Autowired
    @Qualifier("my-hello")
    private Hello hello;

    @Value("${hello.value}")
    private String value;

    @Value("${wrong.value:#{'default value'}}")
    private String wrongValue;

    public String getWrongValue() {
        return wrongValue;
    }

    public void setWrongValue(String wrongValue) {
        this.wrongValue = wrongValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Hello getHello() {
        return hello;
    }

    public void setHello(Hello hello) {
        this.hello = hello;
    }

    public AnnotationHello() {
        super("annotation-hello-name");
    }
}
