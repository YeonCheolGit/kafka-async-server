package com.example.springboot.entity;

import com.example.springboot.DTO.kafka.SearchedTitleDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "searched")
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class SearchedTitle implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String searched_title;


}
