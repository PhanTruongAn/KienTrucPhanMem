package com.example.tuan04_th_kientruc.repository;

import com.example.tuan04_th_kientruc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
