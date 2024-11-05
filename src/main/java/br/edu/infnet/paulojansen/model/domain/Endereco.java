package br.edu.infnet.paulojansen.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TEndereco")
public class Endereco {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String cep;
	
	@Override
	public String toString() {
		return "CEP: " + cep;
	}
	
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
