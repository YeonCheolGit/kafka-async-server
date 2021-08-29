package com.example.springboot.config;

import com.example.springboot.DTO.kafka.PostViewCountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class PostViewConsumerConfig {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServer;

    @Bean
    public Map<String,Object> postViewProducerConfigs() {
        return JsonDeserializer.getStringObjectMap(bootstrapServer);
    }

    @Bean
    public ProducerFactory<String, PostViewCountDTO> postViewCountDTOProducerFactory() {
        return new DefaultKafkaProducerFactory<>(postViewProducerConfigs());
    }

    @Bean
    public KafkaTemplate<String, PostViewCountDTO> postViewDTOKafkaTemplate() {
        return new KafkaTemplate<>(postViewCountDTOProducerFactory());
    }
}
