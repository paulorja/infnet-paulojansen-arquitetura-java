package br.edu.infnet.paulojansen.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TPagamento")
public class Pagamento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Enumerated(EnumType.STRING)
    private StatusPagamento status;
	
	@Enumerated(EnumType.STRING)
    private MetodoPagamento metodo_pagamento;
	
	private float valor;
	
	public StatusPagamento getStatus() { return status; }
    public void setStatus(StatusPagamento status) { this.status = status; }
	    
    public MetodoPagamento getMetodoPagamento() { return metodo_pagamento; }
    public void setStatus(MetodoPagamento metodo_pagamento) { this.metodo_pagamento = metodo_pagamento; }

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
}
