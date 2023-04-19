package com.example.lab4_20202330.Entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser",nullable = false)
    private Integer id;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

}
