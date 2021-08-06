package com.exampleProject.spring.models;

public class Cajero {
	
	private String idcajero;
	private String usuario;
	
	public Cajero() {

	}
	
	public Cajero(String idcajero, String usuario) {
		super();
		this.idcajero = idcajero;
		this.usuario = usuario;
	}

	public String getIdcajero() {
		return idcajero;
	}

	public void setIdcajero(String idcajero) {
		this.idcajero = idcajero;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
