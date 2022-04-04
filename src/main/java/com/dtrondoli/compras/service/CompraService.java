package com.dtrondoli.compras.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dtrondoli.compras.DTO.CompraResumo;
import com.dtrondoli.compras.domain.Cliente;
import com.dtrondoli.compras.domain.Compra;
import com.dtrondoli.compras.repository.CompraRepository;

@Component
public class CompraService {

	@Autowired
	private CompraRepository compraRepo;
	
	public Compra findById(Long id) {				
		return compraRepo.findById(id).orElse(null);
	}
	
	public List<Compra> findAll(Pageable page) {
		 return compraRepo.findAll(page).getContent();
	}
	
	@Transactional
	public Compra save(Compra c) {		
		return compraRepo.save(c);
	}
	
	@Transactional
	public boolean deleteById(Long id) {
		if(compraRepo.findById(id).isPresent()) {
			compraRepo.deleteById(id);
			return true;
		}
		
		return false;
	}

	public List<Compra> findAllByCliente(Cliente c) {
		return compraRepo.findAllByCliente(c);		
	}

	public List<CompraResumo> findAllComprasRelatorio() {		
		return compraRepo.findAllComprasRelatorio();
	}
}
