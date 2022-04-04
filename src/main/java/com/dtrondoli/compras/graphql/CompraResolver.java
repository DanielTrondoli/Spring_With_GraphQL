package com.dtrondoli.compras.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.dtrondoli.compras.domain.Cliente;
import com.dtrondoli.compras.domain.Compra;
import com.dtrondoli.compras.domain.Produto;
import com.dtrondoli.compras.service.ClienteService;
import com.dtrondoli.compras.service.ProdutoService;

@Component
public class CompraResolver implements GraphQLResolver<Compra>{
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService produtoService;
	
	public Cliente cliente(Compra c) {
		return clienteService.findById(c.getCliente().getId());
	}
	
	public Produto produto(Compra c) {
		return produtoService.findById(c.getCliente().getId());
	}
	
}
