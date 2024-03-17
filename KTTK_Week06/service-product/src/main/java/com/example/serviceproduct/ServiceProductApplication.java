package com.example.serviceproduct;

import com.example.serviceproduct.model.Product;
import com.example.serviceproduct.repository.ProductRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceProductApplication {
@Autowired
private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(ServiceProductApplication.class, args);
    }
//    @Bean
    CommandLineRunner test(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Faker faker = new Faker();
                for (int i = 1;i<=2;i++){
                    Product product = new Product(null,faker.commerce().productName(),faker.number().numberBetween(10,100),faker.address().fullAddress());
                    productRepository.save(product);
                }
            }
        }
        ;
    }
}
