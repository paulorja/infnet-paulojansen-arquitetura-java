package br.edu.infnet.paulojansen.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.edu.infnet.paulojansen.model.domain.Passageiro;
import br.edu.infnet.paulojansen.model.domain.Reserva;
import br.edu.infnet.paulojansen.model.service.PassageiroService;
import jakarta.validation.Valid;

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
	
	@PostMapping(value = "/passageiros")
	public ResponseEntity<String> incluir(@RequestBody @Valid Passageiro passageiro) {
		passageiroService.incluir(passageiro);
		return ResponseEntity.status(HttpStatus.CREATED).body("Passageiro cadastrado!");
	}
	
	@DeleteMapping(value = "/passageiros/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		passageiroService.excluir(id);
		return "Exclusão realizada com sucesso.";
	}
	
	@PatchMapping(value = "/passageiros/alterar")
	public ResponseEntity<Passageiro> alterar(@RequestParam Long id, @RequestParam String nome, @RequestParam String cpf, @RequestParam String email) {
		Passageiro passageiro = passageiroService.alterar(id, nome, cpf, email);
		return ResponseEntity.ok(passageiro);
	}
}
