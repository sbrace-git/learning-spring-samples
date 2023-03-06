package learning.spring.binarytea.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class SalesMetrics implements MeterBinder {

    private Counter orderCount;
    private Counter totalAmount;
    private DistributionSummary orderSummary;
    private final AtomicInteger averageAmount = new AtomicInteger();

    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        orderCount = meterRegistry.counter("order.count", "direction", "income");
        totalAmount = meterRegistry.counter("order.amount.sum", "direction", "income");
        orderSummary = meterRegistry.summary("order.summary", "direction", "income");
        meterRegistry.gauge("order.amount.average", averageAmount);
    }

    public void makeNewOrder(int amount) {
        orderCount.increment();
        totalAmount.increment(amount);
        orderSummary.record(amount);
        averageAmount.set((int) orderSummary.mean());

    }
}
