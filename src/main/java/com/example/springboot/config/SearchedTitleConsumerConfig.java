package com.example.springboot.config;

import com.example.springboot.DTO.kafka.SearchedTitleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class SearchedTitleConsumerConfig {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServer;

    @Bean
    public Map<String,Object> searchedTitle_ConsumerConfigs() {
        return CommonJsonDeserializer.getStringObjectMap(bootstrapServer);
    }

    @Bean
    public ConsumerFactory<String, SearchedTitleDTO> searchedTitleDTO_ConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(searchedTitle_ConsumerConfigs());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, SearchedTitleDTO> searchedTitleListener() {
        ConcurrentKafkaListenerContainerFactory<String, SearchedTitleDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(searchedTitleDTO_ConsumerFactory());
        return factory;
    }
}
