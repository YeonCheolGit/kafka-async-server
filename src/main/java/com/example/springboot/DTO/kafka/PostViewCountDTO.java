package com.example.springboot.DTO.kafka;

import com.example.springboot.entity.Post;
import com.sun.istack.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PostViewCountDTO {

    @NotNull
    private long postNo;

    public Post toRequestPostEntity(PostViewCountDTO postViewCountDTO) {
        return Post.builder()
                .viewCount(postViewCountDTO.getPostNo())
                .build();
    }
}
