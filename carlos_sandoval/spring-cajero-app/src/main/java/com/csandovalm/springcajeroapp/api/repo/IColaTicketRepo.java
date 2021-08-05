package com.csandovalm.springcajeroapp.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.csandovalm.springcajeroapp.model.ColaTicket;


public interface IColaTicketRepo extends JpaRepository<ColaTicket, Integer> {

	@Query("SELECT ct FROM cola_tickets ct WHERE ct.estado = 1")
	List<ColaTicket> findAllByEnEspera();
	
	@Query("SELECT ct FROM cola_tickets ct WHERE ct.estado = 2")
	List<ColaTicket> findAllByAtendiendo();

}
