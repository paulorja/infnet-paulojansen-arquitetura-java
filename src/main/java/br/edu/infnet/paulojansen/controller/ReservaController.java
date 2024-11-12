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
import br.edu.infnet.paulojansen.model.domain.Reserva;
import br.edu.infnet.paulojansen.model.service.PassageiroService;
import br.edu.infnet.paulojansen.model.service.ReservaService;

@RestController
public class ReservaController {
	
	@Autowired
	private ReservaService reservaService;
	
	@GetMapping(value = "/reservas")	
	public Collection<Reserva> obterLista() {
		return reservaService.obterLista();
	}
	
	@GetMapping(value = "/reservas/{id}")
	public Reserva obterPorId(@PathVariable Long id) {
		return reservaService.obterPorId(id);
	}
	
	@DeleteMapping(value = "/reservas/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		reservaService.excluir(id);
		return "Exclusão realizada com sucesso.";
	}
	
	@PatchMapping(value = "/reservas/alterar")
	public ResponseEntity<Reserva> alterar(@RequestParam Long id, @RequestParam float preco) {
		Reserva reserva = reservaService.alterar(id, preco);
		return ResponseEntity.ok(reserva);
	}
}
