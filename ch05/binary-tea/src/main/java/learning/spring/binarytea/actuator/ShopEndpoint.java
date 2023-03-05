package learning.spring.binarytea.actuator;

import learning.spring.binarytea.BinaryTeaProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Endpoint(id = "shop")
public class ShopEndpoint {

    private final BinaryTeaProperties binaryTeaProperties;

    public ShopEndpoint(ObjectProvider<BinaryTeaProperties> binaryTeaProperties) {
        this.binaryTeaProperties = binaryTeaProperties.getIfAvailable();
    }

    @ReadOperation
    public String state() {
        if (null == binaryTeaProperties || !Boolean.TRUE.equals(binaryTeaProperties.getReady())) {
            return "We're not ready";
        }
        return "We open " + Optional.ofNullable(binaryTeaProperties.getOpenHours()).orElse("") + ".";
    }
}
