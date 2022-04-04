package com.dtrondoli.compras.DTO;

public class CompraResumo {
	
	private Long compraID;
	private String cliente;
	private String produto;
	private int qtd;
	
	public CompraResumo(Long compraID, String cliente, String produto, int qtd) {		
		this.compraID = compraID;
		this.cliente = cliente;
		this.produto = produto;
		this.qtd = qtd;
	}

	public Long getCompraID() {
		return compraID;
	}

	public void setCompraID(Long compraID) {
		this.compraID = compraID;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
}
