package pe.postulacion.backend.service;

import pe.postulacion.backend.model.entity.Usuario;

public interface UsuarioService {

	public Usuario findByUsername(String username);
}
