package com.dtrondoli.compras.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.dtrondoli.compras.domain.Cliente;
import com.dtrondoli.compras.domain.Compra;
import com.dtrondoli.compras.service.CompraService;

@Component
public class ClienteResolver implements GraphQLResolver<Cliente>{
	
	@Autowired
	private CompraService compraServ;
	
	public List<Compra> todasCompras(Cliente c) {
		return compraServ.findAllByCliente(c);
	}
}
