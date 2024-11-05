package br.edu.infnet.paulojansen.model.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TPassageiro")
public class Passageiro {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome;
	private String cpf;
	private String email;
	//private Endereco endereco;
	//private List<Reserva> reservas;
	
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
				//endereco,
				1 // reservas.size()
			);
		}
	
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
	
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

	//public Endereco getEndereco() {
	//	return endereco;
	//}

	//public void setEndereco(Endereco endereco) {
	//	this.endereco = endereco;
	//}
}
