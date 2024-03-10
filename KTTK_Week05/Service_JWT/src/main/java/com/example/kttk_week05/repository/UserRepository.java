package com.example.kttk_week05.repository;

import com.example.kttk_week05.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
   @Query("select s from User s where s.username = ?1 and s.password = ?2")
   User login(String username, String password);
   User findByUsername(String username);
}
