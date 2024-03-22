package com.example.servicecustomer;

import com.example.servicecustomer.model.Customer;
import com.example.servicecustomer.repository.CustomerRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class ServiceCustomerApplication {
    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(ServiceCustomerApplication.class, args);
    }

//    @Bean
    CommandLineRunner test() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                Faker faker  = new Faker();

                for(int i = 0; i<2;i++){
                    Customer customer = new Customer(null,faker.name().fullName(),"123",faker.date().birthday().toLocalDateTime().toLocalDate());
                   customerRepository.save(customer);

                }
            }
        };
    }
}
