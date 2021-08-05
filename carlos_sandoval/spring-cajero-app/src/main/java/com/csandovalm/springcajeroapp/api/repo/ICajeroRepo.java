package com.csandovalm.springcajeroapp.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.csandovalm.springcajeroapp.model.Cajero;

public interface ICajeroRepo extends JpaRepository<Cajero, Integer> {

	@Query("SELECT ca FROM cajeros ca WHERE ca.exclusivo = true and ca.estado = false")
	List<Cajero> findAllCajerosExclusivosActivos();

	@Query("SELECT ca FROM cajeros ca WHERE ca.preferencial = true and ca.estado = false")
	List<Cajero> findAllCajerosPreferencialesActivos();

	@Query("SELECT ca FROM cajeros ca WHERE ca.normal = true and ca.estado = false")
	List<Cajero> findAllCajerosNormalesActivos();

	@Query("SELECT ca FROM cajeros ca WHERE ca.ticket = :id")
	Cajero findCajeroByTicket(int id);
}
