package com.home.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.login.model.TblRole;

@Repository
public interface TblRolRepository extends JpaRepository<TblRole, Long> {

	TblRole findByName(String name);
}
