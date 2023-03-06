package learning.spring.binarytea;

import learning.spring.binarytea.metrics.SalesMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

@EnableScheduling
@SpringBootApplication
public class BinaryTeaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BinaryTeaApplication.class, args);
    }

    private final Random random = new Random();

    @Autowired
    private SalesMetrics salesMetrics;

    private static final Logger logger = LoggerFactory.getLogger(BinaryTeaApplication.class);

    @Scheduled(fixedRate = 5000L, initialDelay = 1000L)
    public void periodicallyMakeAnOrder() {
        int amount = random.nextInt(100);
        salesMetrics.makeNewOrder(amount);
        logger.info("Make an order of RMB {} yuan.", amount);
    }


}
