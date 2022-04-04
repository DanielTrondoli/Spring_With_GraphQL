package com.dtrondoli.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dtrondoli.compras.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
