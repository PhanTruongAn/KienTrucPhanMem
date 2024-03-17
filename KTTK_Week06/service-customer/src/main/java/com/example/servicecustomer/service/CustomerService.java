package com.example.servicecustomer.service;

import com.example.servicecustomer.model.Customer;
import com.example.servicecustomer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCus(){
        return customerRepository.findAll();
    }
}
