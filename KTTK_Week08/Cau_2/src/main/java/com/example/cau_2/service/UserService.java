package com.example.cau_2.service;

import com.example.cau_2.model.User;
import com.example.cau_2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public User save(User user){
        return repository.save((user));
    }
    @Retryable(maxAttempts=5, value = RuntimeException.class,
            backoff = @Backoff(delay = 1000, multiplier = 2))
    public ResponseEntity<String> findById(Long id){
        System.out.println("Check");
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8082/api/user/"+id;
            String response = restTemplate.getForObject(url,String.class);
            return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
