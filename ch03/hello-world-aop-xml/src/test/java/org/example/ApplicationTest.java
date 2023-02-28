package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(locations = "classpath:application.xml")
public class ApplicationTest {

    @Autowired
    private Hello hello;

    @Autowired
    private HelloAspect sayAspect;

    @BeforeEach
    public void setUp() {
        // Spring容器是同一个，因此SayAspect也是同一个
        // 重置计数器，方便进行断言判断
        sayAspect.resetCounter();
    }

    @Test
    @DisplayName("springHello不为空")
    public void testNotEmpty() {
        assertNotNull(hello);
    }

    @Test
    @DisplayName("springHello是否为GoodBye类型")
    public void testIntroduction() {
        // false
        assertFalse(hello instanceof SpringHello);
        assertFalse(hello instanceof DefaultGoodBye);

        // true
        assertTrue(hello instanceof Hello);
        assertTrue(hello instanceof GoodBye);

        // equals
        assertEquals("Hello! Test around change - 1! around change - 2! Bye! 1 Welcome to Spring! ",
                hello.sayHello(new StringBuffer("Test")));
        assertEquals("Bye! ", ((GoodBye) hello).sayBye());
    }

    @Test
    @DisplayName("通知是否均已执行")
    public void testAdvice() {
        StringBuffer words = new StringBuffer("Test. ");
        String sentence = hello.sayHello(words);
        assertEquals("Test.  around change - 1! around change - 2! Bye! 1 Welcome to Spring! ", words.toString());
        assertEquals("Hello! Test.  around change - 1! around change - 2! Bye! 1 Welcome to Spring! ", sentence);
    }

    @Test
    @DisplayName("说两句话，检查计数")
    public void testMultipleSpeaking() {
        assertEquals("Hello! Test.  around change - 1! around change - 2! Bye! 1 Welcome to Spring! ",
                hello.sayHello(new StringBuffer("Test. ")));
        assertEquals("Hello! Test.  around change - 1! around change - 2! Bye! 2 Welcome to Spring! ",
                hello.sayHello(new StringBuffer("Test. ")));
    }
}
