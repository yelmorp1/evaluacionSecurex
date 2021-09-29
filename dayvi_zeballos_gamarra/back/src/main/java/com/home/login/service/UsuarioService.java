package com.home.login.service;

import java.util.List;

import com.home.login.model.TblRole;
import com.home.login.model.TblUsuario;
import com.home.login.request.ReqRole;
import com.home.login.request.ReqRoleToUsuario;
import com.home.login.request.ReqUsuario;

public interface UsuarioService {

	TblUsuario saveUsuario(ReqUsuario usuario);
	TblRole saveRol(ReqRole rol);
	void addRoleToUsuario (String username, String rolName);
	TblUsuario getUser(String username);
	List<TblUsuario> getUsers();
}
