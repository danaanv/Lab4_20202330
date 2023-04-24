package com.example.lab4_20202330.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "aerolinea")
public class Aerolinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idaerolinea",nullable = false)
    private String idaerolinea;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "codigo",nullable = false)
    private String codigo;


}
