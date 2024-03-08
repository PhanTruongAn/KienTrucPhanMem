package com.example.kttk_week05.services;

import com.example.kttk_week05.models.Student;
import com.example.kttk_week05.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository userRepository;

    public ResponseEntity<Student> login(String msv, String pass){
        return userRepository.login(msv,pass);
    }

}
