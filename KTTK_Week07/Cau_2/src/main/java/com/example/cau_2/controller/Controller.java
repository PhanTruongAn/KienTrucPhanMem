package com.example.cau_2.controller;

import com.example.cau_2.model.User;
import com.example.cau_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequestMapping
public class Controller {
    @Autowired
    private UserService service;


    @GetMapping("/check/{id}")
    public ResponseEntity<String> checkUser(@PathVariable Long id){
     return service.findById(id);
    }
}
