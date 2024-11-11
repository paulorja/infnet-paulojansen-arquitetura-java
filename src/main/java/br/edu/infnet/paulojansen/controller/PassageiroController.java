package br.edu.infnet.paulojansen.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.paulojansen.model.domain.Passageiro;
import br.edu.infnet.paulojansen.model.service.PassageiroService;

@RestController
public class PassageiroController {
	
	@Autowired
	private PassageiroService passageiroService;
	
	@GetMapping(value = "/lista/passageiros")	
	public Collection<Passageiro> obterLista() {
		return passageiroService.obterLista();
	}
	
	@GetMapping(value = "/passageiros/{id}")
	public Passageiro obterPorId(@PathVariable Long id) {
		return passageiroService.obterPorId(id);
	}
	
	//@GetMapping(value = "/buscar/passageiros/{nome}")
	//public List<Passageiro> obterPorNome(@PathVariable String nome){
	//	return passageiroService.obterPorNome(nome);
	//}	
	
}
