package pe.postulacion.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.postulacion.backend.model.entity.Postulante;
import pe.postulacion.backend.model.entity.Region;
import pe.postulacion.backend.repository.PostulanteRepository;

@Service
public class PostulanteServiceImpl implements PostulanteService {

	@Autowired
	private PostulanteRepository postulanteRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Postulante> findAll() {
		return (List<Postulante>) postulanteRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Postulante> findAll(Pageable pageable) {
		return postulanteRepository.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Postulante findById(Long id) {
		return postulanteRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Postulante save(Postulante Postulante) {
		return postulanteRepository.save(Postulante);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		postulanteRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Region> findAllRegiones() {
		return postulanteRepository.findAllRegiones();
	}

}
