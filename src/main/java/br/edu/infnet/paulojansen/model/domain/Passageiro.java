package br.edu.infnet.paulojansen.model.domain;

import java.util.List;

public class Passageiro {
	private String nome;
	private String cpf;
	private String email;
	private Endereco endereco;
	private List<Reserva> reservas;
	
	public Passageiro(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		
	}
	
	@Override
	public String toString() {
		return String.format("[%s] Passageiro %s cadastrado com sucesso! %s; Produtos: %d",
				cpf,
				nome,
				endereco,
				1 // reservas.size()
			);
		}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
