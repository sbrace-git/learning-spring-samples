package learning.spring.config;

import learning.spring.binarytea.BinaryTeaApplication;
import learning.spring.binarytea.BinaryTeaProperties;
import learning.spring.binarytea.actuator.ShopReadyHealthIndicator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = BinaryTeaApplication.class, properties = {
        "binary-tea.ready=false"
})
public class ShopConfigurationDisableTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void testPropertiesBeanUnavailable() {
        assertEquals("false", applicationContext.getEnvironment().getProperty("binary-tea.ready"));
        assertFalse(applicationContext.containsBean("binary-tea-learning.spring.binarytea.BinaryTeaProperties"));
    }
    @Test
    void testIndicatorDown() {
        ShopReadyHealthIndicator bean = applicationContext.getBean(ShopReadyHealthIndicator.class);
        assertEquals(Status.DOWN, bean.getHealth(false).getStatus());
    }

}
