package org.example;

import org.junit.jupiter.api.Test;
import org.speaker.ChineseSpeaker;
import org.speaker.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringJUnitConfig(Main.class)
@TestPropertySource(properties = {
        "spring.speaker.enable=true",
        "spring.speaker.language=Chinese"
})
public class ChineseAutoConfigurationTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void testHasChineseSpeaker() {
        assertTrue(applicationContext.containsBean("speaker"));
        Speaker speaker = applicationContext.getBean("speaker", Speaker.class);
        assertEquals(ChineseSpeaker.class, speaker.getClass());
    }
}