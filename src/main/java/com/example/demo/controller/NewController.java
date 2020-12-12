package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.News;
import com.example.demo.repository.NewsRepository;


@CrossOrigin(origins = "http://localhost:8083/")
@RestController
@RequestMapping("/api")

public class NewController {

    @Autowired
    NewsRepository newsRepository;

    @GetMapping("/news")
  public ResponseEntity<List<News>> getAllNews(@RequestParam(required = false) String title) {
    try {
      List<News> News = new ArrayList<News>();
      if (title == null)
        newsRepository.findAll().forEach(News::add);
      else
        newsRepository.findByTitleContaining(title).forEach(News::add);
      
      if (News.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(News, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
    
}
