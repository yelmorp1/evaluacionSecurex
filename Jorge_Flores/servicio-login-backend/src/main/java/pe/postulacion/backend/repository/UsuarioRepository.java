package pe.postulacion.backend.repository;

import org.springframework.data.repository.CrudRepository;

import pe.postulacion.backend.model.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	public Usuario findByUsername(String username);

}
