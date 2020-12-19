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

    @PostMapping("/news")
  public ResponseEntity<News> createNew(@RequestBody News news) {
    try {
      News _news = newsRepository
          .save(new News(news.getTitle(), news.getDescription_1(), news.getHeader(), news.getDescription_2(),  news.getDate(), news.getPhoto()));
      return new ResponseEntity<>(_news, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

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
  
  @PutMapping("/news/{id}")
  public ResponseEntity<News> updateNew(@PathVariable("id") long id, @RequestBody News news) {
    Optional<News> newsData = newsRepository.findById(id);
    if (newsData.isPresent()) {
      News _news = newsData.get();
      _news.setTitle(news.getTitle());
      _news.setDescription_1(news.getDescription_1());
      _news.setHeader(news.getHeader());
      _news.setDescription_2(news.getDescription_2());
      _news.setDate(news.getDate());
      _news.setPhoto(news.getPhoto());
      return new ResponseEntity<>(newsRepository.save(_news), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/news/{id}")
  public ResponseEntity<HttpStatus> deleteNew(@PathVariable("id") long id) {
    try {
      newsRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
