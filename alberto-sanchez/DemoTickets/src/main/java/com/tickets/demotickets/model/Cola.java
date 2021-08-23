package com.tickets.demotickets.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Entity
public class Cola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Es requerido")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "cajero_id", referencedColumnName = "id")
    private Cajero cajero;

    @NotBlank(message = "Es requerido")
    private int edad;

    @NotBlank(message = "Es requerido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraIngreso = new Date();


}
