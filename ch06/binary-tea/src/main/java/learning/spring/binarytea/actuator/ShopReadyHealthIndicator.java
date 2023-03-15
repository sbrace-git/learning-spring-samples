package learning.spring.binarytea.actuator;

import learning.spring.binarytea.BinaryTeaProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ShopReadyHealthIndicator extends AbstractHealthIndicator {

    private final BinaryTeaProperties binaryTeaProperties;

    public ShopReadyHealthIndicator(ObjectProvider<BinaryTeaProperties> binaryTeaProperties) {
        this.binaryTeaProperties = binaryTeaProperties.getIfAvailable();
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) {
        Boolean ready = Optional.ofNullable(binaryTeaProperties)
                .map(BinaryTeaProperties::getReady)
                .orElse(false);
        if (ready) {
            builder.up();
        } else {
            builder.down();
        }
    }
}
