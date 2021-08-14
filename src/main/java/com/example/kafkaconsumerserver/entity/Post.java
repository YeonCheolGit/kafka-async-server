package com.example.kafkaconsumerserver.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "post")
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private long postNo;

    @Column
    private long viewCount;

}
