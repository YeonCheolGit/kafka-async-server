package com.example.kafkaconsumerserver.service.kafka;

import com.example.kafkaconsumerserver.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final PostRepository postRepository;

    @Async
    @KafkaListener(topics = "viewCount", groupId = "yeon")
    public void consume(long postNo) {
        System.out.printf("Consumed message : %s%n", postNo);
        postRepository.updateViewCount(postNo);
    }
}
