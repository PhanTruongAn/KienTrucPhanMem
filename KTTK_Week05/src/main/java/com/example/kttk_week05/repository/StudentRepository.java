package com.example.kttk_week05.repository;

import com.example.kttk_week05.models.Student;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
@Query("select a from Student a where a.maSinhVien =:msv and a.password=:pass")
    public ResponseEntity<Student> login(String msv, String pass);
}
