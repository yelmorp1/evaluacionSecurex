package com.exampleProject.spring.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleProject.spring.dao.UsuarioDao;
import com.exampleProject.spring.models.Cajero;
import com.exampleProject.spring.models.CajeroExcl;
import com.exampleProject.spring.models.CajeroPref;
import com.exampleProject.spring.models.Usuario;
import com.exampleProject.spring.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioDao dao;

	public List<Usuario> listarUsuarios(Usuario us) {

		return dao.listarUsuarios(us);
	}

	public void insertarUsuario(Usuario us) {
		dao.insertarUsuario(us);
		
	}

	public Usuario obtenerUsuarioById(String id) {
		return dao.obtenerUsuarioById(id);
	}

	public void modificarUsuario(Usuario us) {
		dao.modificarUsuario(us);
		
	}

	public void eliminarUsuario(String id) {
		dao.eliminarUsuario(id);
	}

	public void asignarCajeroActivo(Usuario us) {
		dao.asignarCajeroActivo(us);
	}
	
	public List<Cajero> listarCajerosActivosNormal(Cajero c) {

		return dao.listarCajerosActivosNormal(c);
	}
	
	public List<CajeroPref> listarCajerosActivosPref(CajeroPref cf) {

		return dao.listarCajerosActivosPref(cf);
	}
	
	public List<CajeroExcl> listarCajerosActivosExcl(CajeroExcl ce) {

		return dao.listarCajerosActivosExcl(ce);
	}


}
