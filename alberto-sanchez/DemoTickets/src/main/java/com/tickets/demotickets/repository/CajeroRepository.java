package com.tickets.demotickets.repository;

import com.tickets.demotickets.model.Cajero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CajeroRepository extends CrudRepository<Cajero, Integer> {

    List<Cajero> findAllByEsExclusivoIsTrue();
    List<Cajero> findAllByEsNormalIsTrue();
    List<Cajero> findAllByEsPreferencialIsTrue();

    List<Cajero> findAllByEsExclusivoIsTrueOrEsNormalIsTrue();

}
