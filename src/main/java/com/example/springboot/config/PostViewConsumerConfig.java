package com.example.springboot.config;

import com.example.springboot.DTO.kafka.PostViewCountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class PostViewConsumerConfig {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServer;

    @Bean
    public Map<String,Object> postViewConsumerConfigs() {
        return CommonJsonDeserializer.getStringObjectMap(bootstrapServer);
    }

    @Bean
    public ConsumerFactory<String, PostViewCountDTO> postViewCountDTO_ConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(postViewConsumerConfigs());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PostViewCountDTO> postViewCountListener() {
        ConcurrentKafkaListenerContainerFactory<String, PostViewCountDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(postViewCountDTO_ConsumerFactory());
        return factory;
    }

    @Bean
    public StringJsonMessageConverter jsonConverter() {
        return new StringJsonMessageConverter();
    }
}
