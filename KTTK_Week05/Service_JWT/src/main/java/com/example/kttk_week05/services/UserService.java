package com.example.kttk_week05.services;
import com.example.kttk_week05.models.Role;
import com.example.kttk_week05.models.User;

import java.util.List;

public interface UserService {
   User saveUser(User user);
   Role saveRole(Role role);
   User login(String username,String password);
   void addRoleToUser(String username,String roleName);
   User getUser(String username);
   List<User> getAllUser();
}
