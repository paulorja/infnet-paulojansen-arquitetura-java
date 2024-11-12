package br.edu.infnet.paulojansen.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.paulojansen.model.domain.Passageiro;
import br.edu.infnet.paulojansen.model.domain.Reserva;
import br.edu.infnet.paulojansen.model.repository.ReservaRepository;

@Service
public class ReservaService {
	
	@Autowired
	private ReservaRepository reservaRepository;	
	
	private Map<String, Passageiro> mapaPassageiros = new HashMap<String, Passageiro>();
	
	public void incluir(Reserva reserva) {
		reservaRepository.save(reserva);
	}
	
	public Collection<Reserva> obterLista() {
		return (Collection<Reserva>) reservaRepository.findAll();
	}
	
	public Reserva obterPorId(Long id) {
		return reservaRepository.findById(id).orElse(null);
	}
	
	public void excluir(Long id) {
		reservaRepository.deleteById(id);		
	}
	
	public Reserva alterar(Long id, float preco) {
		Reserva reserva = reservaRepository.findById(id).orElse(null);
		reserva.setPreco(preco);
		return reservaRepository.save(reserva);
	}
}
