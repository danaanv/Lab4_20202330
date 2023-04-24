package com.example.lab4_20202330.Entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vuelo")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvuelo",nullable = false)
    private Integer idvuelo;

    @Column(name = "origen",nullable = false)
    private String origen;

    @Column(name = "destino",nullable = false)
    private String destino;

    @Column(name = "fecha_salida",nullable = false)
    private String fecha_salida;

    @Column(name = "fecha_llegada",nullable = false)
    private String fecha_llegada;

    @Column(name = "duracion",nullable = false)
    private Integer duracion;

    @Column(name = "precio",nullable = false)
    private Integer precio;

    @Column(name = "asientos_disponibles",nullable = false)
    private Integer asientos_disponibles;

    @Column(name = "descripcion",nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "aerolinea_idaerolinea")
    private Aerolinea aerolinea;

}
