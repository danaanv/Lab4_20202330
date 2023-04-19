package com.example.lab4_20202330.Repository;

import com.example.lab4_20202330.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<User, Integer> {



}
