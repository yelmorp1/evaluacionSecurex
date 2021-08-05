package com.csandovalm.springcajeroapp.model;

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
@Entity(name = "cajeros")
public class Cajero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCajero;

	@Column(name = "nombre_cajero", length = 100)
	private String nombreCajero;

	@Column(name = "exclusivo")
	private Boolean exclusivo;

	@Column(name = "normal")
	private Boolean normal;

	@Column(name = "preferencial")
	private Boolean preferencial;

	@Column(name = "ticket")
	private Integer ticket;

	@Column(name = "cliente", length = 200)
	private String cliente;
	
	@Column(name = "estado")
	private Boolean estado;

}
