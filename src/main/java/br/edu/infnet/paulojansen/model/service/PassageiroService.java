package br.edu.infnet.paulojansen.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.paulojansen.model.domain.Passageiro;

@Service
public class PassageiroService {
	
	private Map<String, Passageiro> mapaPassageiros = new HashMap<String, Passageiro>();
	
	public void incluir(Passageiro passageiro) {
		mapaPassageiros.put(passageiro.getCpf(), passageiro);
	}
	
	public Collection<Passageiro> obterLista() {
		return mapaPassageiros.values();
	}

}
