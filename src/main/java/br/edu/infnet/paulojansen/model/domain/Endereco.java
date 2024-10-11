package br.edu.infnet.paulojansen.model.domain;

public class Endereco {
	private String cep;
	
	@Override
	public String toString() {
		return "CEP: " + cep;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
