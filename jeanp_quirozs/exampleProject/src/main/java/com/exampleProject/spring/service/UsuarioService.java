package com.exampleProject.spring.service;

import java.util.List;

import com.exampleProject.spring.models.Cajero;
import com.exampleProject.spring.models.CajeroExcl;
import com.exampleProject.spring.models.CajeroPref;
import com.exampleProject.spring.models.Usuario;

public interface UsuarioService {
	
	public List<Usuario> listarUsuarios(Usuario us);
	
	public void insertarUsuario(Usuario us);
	
	public Usuario obtenerUsuarioById(String id);
	
	public void modificarUsuario(Usuario us);
	
	public void eliminarUsuario(String id);
	
	public void asignarCajeroActivo(Usuario us);
	
	public List<Cajero> listarCajerosActivosNormal(Cajero c);
	
	public List<CajeroPref> listarCajerosActivosPref(CajeroPref cf);
	
	public List<CajeroExcl> listarCajerosActivosExcl(CajeroExcl ce);

}
