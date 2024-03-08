package com.example.kttk_week05.controller;

import com.example.kttk_week05.models.Student;
import com.example.kttk_week05.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private StudentService service;
    @PostMapping("/login")
    public ResponseEntity<Student> login(String msv, String pass) {
        ResponseEntity<Student> s = service.login(msv,pass);
        return s;
    }

}
