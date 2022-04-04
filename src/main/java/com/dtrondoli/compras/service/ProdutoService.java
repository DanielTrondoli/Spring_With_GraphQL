package com.dtrondoli.compras.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dtrondoli.compras.domain.Produto;
import com.dtrondoli.compras.repository.ProdutoRepository;

@Component
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepo;
	
	public Produto findById(Long id) {				
		return produtoRepo.findById(id).orElse(null);
	}
	
	public List<Produto> findAll() {
		 return produtoRepo.findAll();
	}
	
	@Transactional
	public Produto save(Produto c) {
		return produtoRepo.save(c);
	}
	
	@Transactional
	public boolean deleteById(Long id) {
		if(produtoRepo.findById(id).isPresent()) {
			produtoRepo.deleteById(id);
			return true;
		}
		
		return false;
	}
}
