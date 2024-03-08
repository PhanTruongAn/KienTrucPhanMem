package com.example.kttk_week05;

import com.example.kttk_week05.models.Student;
import com.example.kttk_week05.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class KttkWeek05Application {
@Autowired
private StudentService service;
	public static void main(String[] args) {
		SpringApplication.run(KttkWeek05Application.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(){
//		return args -> {
//			Optional<Student> s= service.login("20085191","123");
//             System.out.println(s);
//		};
//	}

}
