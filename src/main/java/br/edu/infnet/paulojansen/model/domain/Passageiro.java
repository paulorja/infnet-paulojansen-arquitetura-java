package br.edu.infnet.paulojansen.model.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "passageiro")
	@JsonManagedReference
	private List<Reserva> reservas;
	
	public Passageiro() {
		reservas = new ArrayList<Reserva>();
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setProdutos(List<Reserva> reservas) {
		this.reservas = reservas;
	}

}
