package com.wilderness.consumer;

import com.wilderness.consumer.action.MergeServiceAction;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.wilderness.consumer.action")
public class ConsumerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ConsumerApplication.class, args);
        context.start();

        final MergeServiceAction mergeServiceAction = context.getBean("mergeServiceAction", MergeServiceAction.class);
        System.out.println(mergeServiceAction.mergeResult("313123123"));
    }
}
