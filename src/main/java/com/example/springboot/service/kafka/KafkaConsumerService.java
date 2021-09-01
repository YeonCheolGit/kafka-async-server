package com.example.springboot.service.kafka;

import com.example.springboot.DTO.kafka.PostViewCountDTO;
import com.example.springboot.DTO.kafka.SearchedTitleDTO;
import com.example.springboot.repository.PostRepository;
import com.example.springboot.repository.SearchedTitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final PostRepository postRepository;
    private final SearchedTitleRepository searchedTitleRepository;
    private static final String topic_viewCount = "viewCount";
    private static final String topic_saveSearchTitle = "searchTitle";
    private static final String groupId = "yeon";

    @Async
    @KafkaListener(topics = topic_viewCount, groupId = groupId, containerFactory = "postViewCountListener")
    public void consume(@Payload PostViewCountDTO postViewCountDTO) {
        System.out.println("========================================");
        System.out.println("viewCount");
        System.out.printf("Consumed message : %s%n", postViewCountDTO.getPostNo());
        System.out.println("========================================");

        postRepository.updateViewCount(postViewCountDTO.getPostNo());
    }

    @Async
    @KafkaListener(topics = topic_saveSearchTitle, groupId = groupId, containerFactory = "searchedTitleListener")
    public void consume(@Payload SearchedTitleDTO title) {
        System.out.println("========================================");
        System.out.println("searched");
        System.out.printf("Consumed message : %s%n", title.getSearched_title());
        System.out.println("========================================");

        searchedTitleRepository.save(title.toRequest_SearchedTitle_Entity(title));
    }
}
