package com.example.cau_1.controller;


import com.example.cau_1.model.User;
import com.example.cau_1.repository.UserRepository;
import com.example.cau_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class Controller {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/create-user")
   public User createUser(User user){
        return userService.saveUser(user);

    }

    @GetMapping("/{id}")
   public ResponseEntity<String> getID(@PathVariable Long id){
        User user = userService.findById(id);
          return ResponseEntity.ok(user+"");
    }

}
