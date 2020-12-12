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

import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepository;


@CrossOrigin(origins = "http://localhost:8083/")
@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
  MessageRepository messageRepository;

  @GetMapping("/messages")
  public ResponseEntity<List<Message>> getAllMessages(@RequestParam(required = false) String title) {
    try {
      List<Message> messages = new ArrayList<Message>();

      if (title == null)
        messageRepository.findAll().forEach(messages::add);
      else
        messageRepository.findByTitleContaining(title).forEach(messages::add);

      if (messages.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(messages, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/messages")
  public ResponseEntity<Message> createTutorial(@RequestBody Message message) {
    try {
      Message _message = messageRepository
          .save(new Message(message.getTitle(), message.getEmail(), message.getContact(), message.getDescription(), false));
      return new ResponseEntity<>(_message, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

    
}
