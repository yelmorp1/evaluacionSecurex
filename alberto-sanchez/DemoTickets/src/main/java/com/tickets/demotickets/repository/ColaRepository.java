package com.tickets.demotickets.repository;

import com.tickets.demotickets.model.Cola;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface ColaRepository extends CrudRepository<Cola, Integer> {

    int deleteByFechaHoraIngresoIsLessThanEqual(Date fechaHora);
}
