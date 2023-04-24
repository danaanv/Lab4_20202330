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
    private Integer idreserva;

    @Column(name = "fecha_reserva",nullable = false)
    private String fecha_reserva;

    @Column(name = "estado_pago",nullable = false)
    private String estado_pago;

    @Column(name = "precio_total", nullable = false)
    private Integer precio_total;

    @ManyToOne
    @JoinColumn(name = "user_iduser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "vuelo_idvuelo")
    private Vuelo vuelo;

}
