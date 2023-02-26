package org.example.scheduler;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduleConfig {

    /**
     * 每隔1000ms执行
     */
    @Scheduled(fixedRate = 1000L)
    public void task1() {
        Thread thread = Thread.currentThread();
        System.out.println("task1 " + thread.getId() + " " + thread.getName());
    }

    /**
     * 每次执行完后等待1000ms再执行下一次
     */
    @Scheduled(fixedDelay = 1000L)
    public void task2() {
        Thread thread = Thread.currentThread();
        System.out.println("task2 " + thread.getId() + " " + thread.getName());
    }

    /**
     * 先等待5000ms开始执行第一次，后续每隔1000ms执行一次
     */
    @Scheduled(initialDelay = 5000, fixedRate = 1000)
    public void task3() {
        Thread thread = Thread.currentThread();
        System.out.println("task3 " + thread.getId() + " " + thread.getName());
    }

    /**
     * 按Cron表达式执行
     */
    @Scheduled(cron = "0 15 15 * * 1-5")
    public void task4() {
        Thread thread = Thread.currentThread();
        System.out.println("task4 " + thread.getId() + " " + thread.getName());
    }
}
