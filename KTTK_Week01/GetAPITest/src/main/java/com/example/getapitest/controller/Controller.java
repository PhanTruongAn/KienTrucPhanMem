package com.example.getapitest.controller;

import com.example.getapitest.Product;
import com.example.getapitest.Users;
import com.example.getapitest.repository.ProductRepository;
import com.example.getapitest.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class Controller {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ProductRepository productRepository;
    RestTemplate restTemplate = new RestTemplate();
    @GetMapping("/users")
    private List<Users> getAllUser(){
        List<Users> list = usersRepository.findAll();
        return list;
    }

    @GetMapping("/users/{id}")
    private Users getByid(@PathVariable("id")long id){
        Optional<Users> users = usersRepository.findById(id);
        return users.get();
    }

    @GetMapping("/products/{id}")
    public Product getApiProduct(@PathVariable("id")long id){
       Users user = restTemplate.getForObject("http://localhost:8080/api/users/"+id,Users.class);
       Product product = productRepository.findById(id).get();
       product.setUsers(user);
       return product;
    }
}
