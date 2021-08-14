package com.example.kafkaconsumerserver.service.kafka;

import com.example.kafkaconsumerserver.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final PostRepository postRepository;

    @KafkaListener(topics = "viewCount", groupId = "yeon")
    public void consume(long postNo) throws InterruptedException {
        System.out.println("=============== 비동기 대기 시작 ===============");
        Thread.sleep(10000);

        System.out.printf("Consumed message : %s%n", postNo);
        postRepository.updateViewCount(postNo);

        System.out.println("=============== DB 쿼리 실행됨 ===============");
    }
}
