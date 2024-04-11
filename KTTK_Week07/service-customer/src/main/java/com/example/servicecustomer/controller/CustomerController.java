package com.example.servicecustomer.controller;


import com.example.servicecustomer.model.Customer;
import com.example.servicecustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;
    @GetMapping("/get-all-customer")
    public List<Customer> getAll(){
        return service.getAllCus();
    }
}
