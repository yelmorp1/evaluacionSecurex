package pe.postulacion.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.postulacion.backend.model.entity.Postulante;
import pe.postulacion.backend.model.entity.Region;

public interface PostulanteRepository extends JpaRepository<Postulante, Long>{

	@Query("from Region")
	public List<Region> findAllRegiones();
}
