package com.exampleProject.spring.models;

public class CajeroExcl {
	
	private String idcajero;
	private String usuario;
	
	public CajeroExcl() {

	}
	
	public CajeroExcl(String idcajero, String usuario) {
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
