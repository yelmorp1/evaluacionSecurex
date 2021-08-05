package com.csandovalm.springcajeroapp.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity(name = "cola_tickets")
public class ColaTicket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idColaTicket;

	@Column(name = "nombre_cliente", length = 100)
	private String nombreCliente;

	@Column(name = "edad")
	private Integer edad;

	@Column(name = "fecha_inicio")
	private LocalDateTime fechaInicio;

	@Column(name = "fecha_fin")
	private LocalDateTime fechaFin;

	@Column(name = "estado")
	private Integer estado;
}
