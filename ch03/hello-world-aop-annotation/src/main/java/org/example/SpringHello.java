package org.example;

import org.springframework.stereotype.Component;

@Component
public class SpringHello implements Hello {
    @Override
    public String sayHello(StringBuffer words) {
        return "Hello! " + words;
    }
}
