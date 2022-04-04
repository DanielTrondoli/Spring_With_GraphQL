package com.dtrondoli.compras.graphql;

public class ProdutoInput {	
	
	private Long id;
	private String nome;
	private Float valor;
	
	public ProdutoInput() {}
	
	public ProdutoInput(Long id, String nome, Float valor) {	
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}
}	
