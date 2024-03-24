package org.diego.api.serviceorder.dao.cliente;

import java.util.List;

import org.diego.api.serviceorder.dto.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteDao extends JpaRepository<Cliente, Integer> {

	@Query("SELECT c FROM Cliente c WHERE c.nome = ?1")
	List<Cliente> findClienteByNome(String nome);

	@Query("SELECT c FROM Cliente c WHERE c.nome = ?1 AND c.numDocumento = ?2")
	List<Cliente> findByNomeOrDocumento(String nome, Long numDocumento);
}
