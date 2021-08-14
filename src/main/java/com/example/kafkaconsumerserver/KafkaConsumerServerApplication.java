package com.example.kafkaconsumerserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class KafkaConsumerServerApplication {

    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "optional:classpath:application-kafka.yml,"
            + "optional:/home/ubuntu/deploy/application-kafka.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(KafkaConsumerServerApplication.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }

}
