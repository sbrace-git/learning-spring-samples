package learning.spring.binarytea;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import io.micrometer.core.instrument.logging.LoggingMeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import learning.spring.binarytea.metrics.SalesMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

@EnableScheduling
@SpringBootApplication
public class BinaryTeaApplication {

    public static void main(String[] args) {
//        SpringApplication.run(BinaryTeaApplication.class, args);
        new SpringApplicationBuilder()
                .sources(BinaryTeaApplication.class)
                .main(BinaryTeaApplication.class)
                .bannerMode(Banner.Mode.LOG)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }

    private final Random random = new Random();

    @Autowired
    private SalesMetrics salesMetrics;

    private static final Logger logger = LoggerFactory.getLogger(BinaryTeaApplication.class);

//    @Scheduled(fixedRate = 5000L, initialDelay = 1000L)
    public void periodicallyMakeAnOrder() {
        int amount = random.nextInt(100);
        salesMetrics.makeNewOrder(amount);
        logger.info("Make an order of RMB {} yuan.", amount);
    }

    @Bean
    public MeterRegistry meterRegistry() {
        CompositeMeterRegistry compositeMeterRegistry = new CompositeMeterRegistry();
        compositeMeterRegistry.add(new SimpleMeterRegistry());
//        compositeMeterRegistry.add(new LoggingMeterRegistry());
        return compositeMeterRegistry;
    }


}
