package org.example.java;

import org.example.Hello;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
@ImportResource("classpath:beans.xml")
public class Config {

    @Primary
    @Bean
    @Lazy
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Hello helloBean() {
        return new Hello("java config");
    }

    @Bean
    public Foo foo() {
        return new Foo();
    }

    @Bean
    public Bar bar(Foo foo) {
        return new Bar(foo);
    }

    @Bean
    public Bar baz() {
        return new Bar(foo());
    }

}
