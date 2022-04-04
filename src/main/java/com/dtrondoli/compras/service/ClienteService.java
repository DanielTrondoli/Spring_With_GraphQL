package com.dtrondoli.compras.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dtrondoli.compras.domain.Cliente;
import com.dtrondoli.compras.repository.ClienteRepository;

@Component
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepo;
	
	public Cliente findById(Long id) {				
		return clienteRepo.findById(id).orElse(null);
	}
	
	public List<Cliente> findAll() {
		 return clienteRepo.findAll();
	}
	
	@Transactional
	public Cliente save(Cliente c) {
		return clienteRepo.save(c);
	}
	
	@Transactional
	public boolean deleteById(Long id) {
		if(clienteRepo.findById(id).isPresent()) {
			clienteRepo.deleteById(id);
			return true;
		}
		
		return false;
	}
}
