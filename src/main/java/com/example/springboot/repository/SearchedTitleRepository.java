package com.example.springboot.repository;

import com.example.springboot.entity.SearchedTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchedTitleRepository extends JpaRepository<SearchedTitle, Long> {
}
