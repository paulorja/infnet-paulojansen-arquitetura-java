package br.edu.infnet.paulojansen.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TReserva")
public class Reserva {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idPassageiro")
	@JsonBackReference
	private Passageiro passageiro;
	
	//@OneToOne(cascade = CascadeType.PERSIST)
	//@JoinColumn(name = "idPagamento")
	//private Pagamento pagamento;
	
	private String origem;
	private String destino;
	private float preco;
	
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Passageiro getPassageiro() {
		return passageiro;
	}
	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}
	//public Pagamento getPagamento() {
	//	return pagamento;
	//}
	//public void setPassageiro(Pagamento pagamento) {
	//	this.pagamento = pagamento;
	//}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
}
