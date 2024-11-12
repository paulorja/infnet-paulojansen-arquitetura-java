package br.edu.infnet.paulojansen.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.paulojansen.model.domain.Reserva;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Long>{
	
}
