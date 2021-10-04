package pe.postulacion.backend.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pe.postulacion.backend.model.entity.Postulante;
import pe.postulacion.backend.model.entity.Region;

public interface PostulanteService {

	public List<Postulante> findAll();
	
	public Page<Postulante> findAll(Pageable pageable);
	
	public Postulante findById(Long id);
	
	public Postulante save(Postulante postulante);
	
	public void delete(Long id);
	
	public List<Region> findAllRegiones();

}
