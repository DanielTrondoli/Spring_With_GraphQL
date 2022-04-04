package com.dtrondoli.compras.graphql;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.dtrondoli.compras.DTO.CompraResumo;
import com.dtrondoli.compras.domain.Compra;
import com.dtrondoli.compras.service.ClienteService;
import com.dtrondoli.compras.service.CompraService;
import com.dtrondoli.compras.service.ProdutoService;

@Component
public class CompraGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {
	
	@Autowired
	private CompraService compraService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService produtoService;
	
	public Compra compra(Long id) {				
		return compraService.findById(id);
	}
	
	public List<Compra> compras(int page, int size) {
		 PageRequest of = PageRequest.of(page, size);
		 return compraService.findAll(of);
	}
	
	public List<CompraResumo> getComprasRelatorio(){
		return compraService.findAllComprasRelatorio();
	}
	
	@Transactional
	public Compra saveCompra(CompraInput compra) {
		
		ModelMapper m = new ModelMapper();
		Compra c = compraService.save(m.map(compra, Compra.class));		
		c.setCliente(clienteService.findById(compra.getClienteId()));
		c.setProduto(produtoService.findById(compra.getProdutoId()));
		c.setData(new Date());
		
		return compraService.save(c);
	}
	
	@Transactional
	public boolean deleteCompra(Long id) {
		return compraService.deleteById(id);
	}
	
}
