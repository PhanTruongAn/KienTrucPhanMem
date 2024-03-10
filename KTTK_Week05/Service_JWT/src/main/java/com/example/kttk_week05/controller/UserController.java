package com.example.kttk_week05.controller;

import com.example.kttk_week05.config.JwtService;
import com.example.kttk_week05.models.Role;
import com.example.kttk_week05.models.User;
import com.example.kttk_week05.services.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;
    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.saveUser(user));
    }
    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        return ResponseEntity.ok().body(userService.saveRole(role));
    }
    @GetMapping("/user/get-all")
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok().body(userService.getAllUser());
    }
    @PostMapping("/role/add-to-user")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUser form){
        userService.addRoleToUser(form.getUsername(),form.getRoleName());
        return ResponseEntity.ok().build();
    }
    @Data
    class RoleToUser{
        private String username;
        private String roleName;
    }
    @PostMapping("/user/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        User user = userService.login(username, password);
        if (user != null) {
            String token = jwtService.generateToken(user);
            return ResponseEntity.ok(user + "\n"+"Token: "+ token);

        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}
