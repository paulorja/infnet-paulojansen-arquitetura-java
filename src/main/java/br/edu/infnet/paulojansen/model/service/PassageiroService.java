package br.edu.infnet.paulojansen.model.service;

import java.util.ArrayList;
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
	
	@Autowired
	private PassageiroRepository passageiroRepository;	
	
	private Map<String, Passageiro> mapaPassageiros = new HashMap<String, Passageiro>();
	
	public void incluir(Passageiro passageiro) {
		passageiroRepository.save(passageiro);
		//mapaPassageiros.put(passageiro.getCpf(), passageiro);
	}
	
	public Collection<Passageiro> obterLista() {
		//List<Passageiro>  passageiros = new ArrayList<>();
		//passageiroRepository.findAll().forEach(passageiros::add);
		//return passageiros;
		return (Collection<Passageiro>) passageiroRepository.findAll();
	}
	
	public Passageiro obterPorId(Long id) {
		return passageiroRepository.findById(id).orElse(null);
	}
	
	public void excluir(Long id) {
		passageiroRepository.deleteById(id);		
	}
	
	public Passageiro alterar(Long id, String nome, String cpf, String email) {
		Passageiro passageiro = passageiroRepository.findById(id).orElse(null);
		passageiro.setNome(nome);
		passageiro.setCpf(cpf);
		passageiro.setEmail(email);
		return passageiroRepository.save(passageiro);
	}



	//public List<Passageiro> obterPorNome(String nome) {
	//	return passageiroRepository.findByNomeContaining(nome);
	//}

}
