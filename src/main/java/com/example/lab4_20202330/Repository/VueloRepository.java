package com.example.lab4_20202330.Repository;

import com.example.lab4_20202330.Entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo,Integer> {
}
