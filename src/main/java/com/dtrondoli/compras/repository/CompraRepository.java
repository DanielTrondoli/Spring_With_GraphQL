package com.dtrondoli.compras.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dtrondoli.compras.DTO.CompraResumo;
import com.dtrondoli.compras.domain.Cliente;
import com.dtrondoli.compras.domain.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

	List<Compra> findAllByCliente(Cliente c);
	
	@Query("select new com.dtrondoli.compras.DTO.CompraResumo(c.id, cli.nome, p.nome, c.qtd) from Compra c inner join c.cliente cli inner join c.produto p ")
	List<CompraResumo> findAllComprasRelatorio();

}
