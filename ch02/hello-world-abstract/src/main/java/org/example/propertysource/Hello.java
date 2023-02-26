package org.example.propertysource;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Hello {

    private final Environment environment;

    public Hello(Environment environment) {
        this.environment = environment;
    }

    public void hello() {
        System.out.println("foo.bar = " + environment.getProperty("foo.bar"));
    }
}
