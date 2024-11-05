package br.edu.infnet.paulojansen.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.paulojansen.model.domain.Passageiro;
import br.edu.infnet.paulojansen.model.repository.PassageiroRepository;

@Service
public class PassageiroService {
	
    //private final PassageiroRepository passageiroRepository;

    //@Autowired
    //public PassageiroService(PassageiroRepository passageiroRepository) {
    //    this.passageiroRepository = passageiroRepository;
    //}
	
	//@Autowired
	//private PassageiroRepository passageiroRepository;	
	
	private Map<String, Passageiro> mapaPassageiros = new HashMap<String, Passageiro>();
	
	public void incluir(Passageiro passageiro) {
		//passageiroRepository.save(passageiro);
		mapaPassageiros.put(passageiro.getCpf(), passageiro);
	}
	
	public Collection<Passageiro> obterLista() {
		return mapaPassageiros.values();
	}

}
