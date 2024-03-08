package com.example.kttk_week05.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="student")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String maSinhVien;
    private String password;
    private String name;


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", maSinhVien='" + maSinhVien + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
