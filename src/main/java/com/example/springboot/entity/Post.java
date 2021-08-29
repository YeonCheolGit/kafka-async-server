package com.example.springboot.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "post")
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postNo;

    @Column
    private long viewCount;



}
