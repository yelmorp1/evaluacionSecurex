package com.home.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.login.model.TblUsuario;

@Repository
public interface TblUsuarioRepository extends JpaRepository<TblUsuario, Long>{
	
	TblUsuario findByUsername(String username);

}
