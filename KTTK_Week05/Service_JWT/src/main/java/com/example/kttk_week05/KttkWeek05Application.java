package com.example.kttk_week05;

import com.example.kttk_week05.models.Role;
import com.example.kttk_week05.models.User;
import com.example.kttk_week05.repository.RoleRepository;
import com.example.kttk_week05.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class KttkWeek05Application {
@Autowired
private UserService userService;
@Autowired
private  RoleRepository roleRepository;
	public static void main(String[] args) {
		SpringApplication.run(KttkWeek05Application.class, args);
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {
//			userService.saveRole(new Role(1L,"ADMIN"));
//			userService.saveRole(new Role(null,"USER"));
//			userService.saveRole(new Role(null,"CUSTOMER"));
//			userService.saveRole(new Role(null,"MANAGER"));
//
//			userService.saveUser(new User(null,"PhanTruongAn","an","123",new ArrayList<>()));
//			userService.addRoleToUser("an","CUSTOMER");
			User user = userService.login("an","123");
			System.out.println(user);
		};
	}

}
