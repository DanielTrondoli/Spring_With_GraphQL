package com.dtrondoli.compras.graphql;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.dtrondoli.compras.domain.Produto;

@Component
public class ProdutoResolver implements GraphQLResolver<Produto>{
	
	public String valorReais(Produto p) {
		return String.format("R$: %.2f ", p.getValor());
	}

}
