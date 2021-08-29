package com.example.springboot.DTO.kafka;

import com.example.springboot.entity.SearchedTitle;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class SearchedTitleDTO {

    @NotNull
    private String searched_title;

    public SearchedTitle toRequest_SearchedTitle_Entity(SearchedTitleDTO searchedTitleDTO) {
        return SearchedTitle.builder()
                .searched_title(searchedTitleDTO.getSearched_title())
                .build();
    }
}
