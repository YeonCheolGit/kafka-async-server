package com.example.springboot.config;

import com.example.springboot.DTO.kafka.SearchedTitleDTO;
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
public class SearchedTitleConsumerConfig {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServer;

    @Bean
    public Map<String,Object> searchedTitle_ProducerConfigs() {
        return JsonDeserializer.getStringObjectMap(bootstrapServer);
    }

    @Bean
    public ProducerFactory<String, SearchedTitleDTO> searchedTitleDTO_ProducerFactory() {
        return new DefaultKafkaProducerFactory<>(searchedTitle_ProducerConfigs());
    }

    @Bean
    public KafkaTemplate<String, SearchedTitleDTO> searchedTitleDTO_ProducerTemplate() {
        return new KafkaTemplate<>(searchedTitleDTO_ProducerFactory());
    }
}
