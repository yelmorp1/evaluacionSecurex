package com.exampleProject.spring.models;

public class Usuario {
	
	private String id_usuario;
	private String user;
	private String pass;
	private String descripcion;
	private String estado;
	private String edad;
	private String clienteExcl;
	
	private String idCajero;
	private String usuario;
	private String excl;
	private String normal;
	private String atencionpref;
	private String claseBoot1;
	private String claseBoot2;
	private String claseBoot3;
	
	

	public Usuario() {

	}
	
	public Usuario(String id_usuario, String user, String pass, String descripcion, String estado, String edad,
			String clienteExcl, String idCajero, String usuario, String excl, String normal, String atencionpref) {
		super();
		this.id_usuario = id_usuario;
		this.user = user;
		this.pass = pass;
		this.descripcion = descripcion;
		this.estado = estado;
		this.edad = edad;
		this.clienteExcl = clienteExcl;
		this.idCajero = idCajero;
		this.usuario = usuario;
		this.excl = excl;
		this.normal = normal;
		this.atencionpref = atencionpref;
	}

	public String getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getClienteExcl() {
		return clienteExcl;
	}
	public void setClienteExcl(String clienteExcl) {
		this.clienteExcl = clienteExcl;
	}
	public String getIdCajero() {
		return idCajero;
	}
	public void setIdCajero(String idCajero) {
		this.idCajero = idCajero;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getExcl() {
		return excl;
	}
	public void setExcl(String excl) {
		this.excl = excl;
	}
	public String getNormal() {
		return normal;
	}
	public void setNormal(String normal) {
		this.normal = normal;
	}
	public String getAtencionpref() {
		return atencionpref;
	}
	public void setAtencionpref(String atencionpref) {
		this.atencionpref = atencionpref;
	}

	public String getClaseBoot1() {
		return claseBoot1;
	}

	public void setClaseBoot1(String claseBoot1) {
		this.claseBoot1 = claseBoot1;
	}

	public String getClaseBoot2() {
		return claseBoot2;
	}

	public void setClaseBoot2(String claseBoot2) {
		this.claseBoot2 = claseBoot2;
	}

	public String getClaseBoot3() {
		return claseBoot3;
	}

	public void setClaseBoot3(String claseBoot3) {
		this.claseBoot3 = claseBoot3;
	}


	
	
}
