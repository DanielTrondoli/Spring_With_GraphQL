package com.dtrondoli.compras.graphql;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.dtrondoli.compras.domain.Produto;
import com.dtrondoli.compras.service.ProdutoService;

@Component
public class ProdutoGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {
	
	@Autowired
	private ProdutoService produtoService;
	
	public Produto produto(Long id) {				
		return produtoService.findById(id);
	}
	
	public List<Produto> produtos() {
		 return produtoService.findAll();
	}
	
	@Transactional
	public Produto saveProduto(ProdutoInput produto) {
		ModelMapper m = new ModelMapper();
		return produtoService.save(m.map(produto, Produto.class));
	}
	
	@Transactional
	public boolean deleteProduto(Long id) {
		return produtoService.deleteById(id);
	}
	
}
