package com.example.cau_1.service;

import com.example.cau_1.model.User;
import com.example.cau_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user){
        return repository.save(user);
    }

    public User findById(Long id){
        return repository.findById(id).get();
    }
}
