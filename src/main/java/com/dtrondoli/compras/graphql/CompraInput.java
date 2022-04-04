package com.dtrondoli.compras.graphql;

import java.util.Date;

public class CompraInput {	
	
	private Long id;
	private Integer qtd;
	private String status;	
	
	private Long clienteId;
	private Long produtoId;
	
	public CompraInput() {}

	public CompraInput(Long id, Integer qtd, String status, Long clienteId, Long produtoId) {	
		this.id = id;
		this.qtd = qtd;
		this.status = status;
		this.clienteId = clienteId;
		this.produtoId = produtoId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}
}	
