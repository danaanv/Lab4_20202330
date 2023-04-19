package com.example.lab4_20202330.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreserva",nullable = true)
    private String idreserva;

    @Column(name = "fecha_reserva",nullable = false)
    private Double fecha_reserva;

    @Column(name = "estado_pago",nullable = false)
    private String estado_pago;

    @Column(name = "user_iduser",nullable = false)
    private String user_id;

    @Column(name = "vuelo_idvuelo",nullable = false)
    private String vuelo_id;

}
