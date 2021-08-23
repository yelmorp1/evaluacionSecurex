package com.tickets.demotickets.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
public class Cajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Es requerido")
    private String nombre;

    @NotBlank(message = "Es requerido")
    private boolean esExclusivo;

    @NotBlank(message = "Es requerido")
    private boolean esNormal;

    @NotBlank(message = "Es requerido")
    private boolean esPreferencial;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cajero")
    private List<Cola> colas;

    public int sizeCola(){
        return colas.size();
    }

    @Override
    public String toString(){
        if (isEsNormal())
            return getId() + " | " + getNombre() + " | Normal";
        else if (isEsExclusivo())
            return getId() + " | " + getNombre() + " | Exclusivo";
        else if (isEsPreferencial())
            return getId() + " | " + getNombre() + " | Preferente";

        return getId() + " | " + getNombre();
    }
}
