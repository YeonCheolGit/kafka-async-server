package com.example.springboot.DTO.kafka;

import com.example.springboot.entity.Post;
import com.sun.istack.NotNull;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PostViewCountDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private long postNo;

    public Post toRequestPostEntity(PostViewCountDTO postViewCountDTO) {
        return Post.builder()
                .viewCount(postViewCountDTO.getPostNo())
                .build();
    }
}
