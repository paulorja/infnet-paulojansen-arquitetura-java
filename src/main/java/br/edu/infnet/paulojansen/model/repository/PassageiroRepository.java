package br.edu.infnet.paulojansen.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.paulojansen.model.domain.Passageiro;

@Repository
public interface PassageiroRepository extends CrudRepository<Passageiro, Long>{

}
