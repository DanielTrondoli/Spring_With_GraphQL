package com.dtrondoli.compras.graphql;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.dtrondoli.compras.domain.Cliente;
import com.dtrondoli.compras.service.ClienteService;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {
	
	@Autowired
	private ClienteService clienteService;
	
	public Cliente cliente(Long id) {				
		return clienteService.findById(id);
	}
	
	public List<Cliente> clientes() {
		 return clienteService.findAll();
	}
	
	@Transactional
	public Cliente saveCliente(ClienteInput cliente) {
		ModelMapper m = new ModelMapper();
		return clienteService.save(m.map(cliente, Cliente.class));
	}
	
	@Transactional
	public boolean deleteCliente(Long id) {
		return clienteService.deleteById(id);
	}
	
}
