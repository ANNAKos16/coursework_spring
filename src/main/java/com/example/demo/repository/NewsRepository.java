package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.News;

public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findByTitleContaining(String title);
}