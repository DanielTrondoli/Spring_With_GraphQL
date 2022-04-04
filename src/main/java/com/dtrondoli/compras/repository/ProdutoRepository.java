package com.dtrondoli.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dtrondoli.compras.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
