package br.edu.infnet.paulojansen.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;

import br.edu.infnet.paulojansen.model.domain.Passageiro;
import br.edu.infnet.paulojansen.model.service.PassageiroService;

@RestController
public class PassageiroController {
	
	@Autowired
	private PassageiroService passageiroService;
	
	@GetMapping(value = "/passageiros")	
	public Collection<Passageiro> obterLista() {
		return passageiroService.obterLista();
	}
	
	@GetMapping(value = "/passageiros/{id}")
	public Passageiro obterPorId(@PathVariable Long id) {
		return passageiroService.obterPorId(id);
	}
	
	@DeleteMapping(value = "/passageiros/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		passageiroService.excluir(id);
		return "Exclusão realizada com sucesso.";
	}
	
	@PatchMapping(value = "/passageiros/alterar")
	public ResponseEntity<Passageiro> alterar(@RequestParam Long id, @RequestParam String nome) {
		Passageiro passageiro = passageiroService.alterar(id, nome);
		return ResponseEntity.ok(passageiro);
	}
	
	//@GetMapping(value = "/buscar/passageiros/{nome}")
	//public List<Passageiro> obterPorNome(@PathVariable String nome){
	//	return passageiroService.obterPorNome(nome);
	//}	
	
}
