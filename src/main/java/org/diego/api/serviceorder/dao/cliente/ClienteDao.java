package org.diego.api.serviceorder.dao.cliente;

import java.util.List;

import org.diego.api.serviceorder.dto.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteDao extends JpaRepository<Cliente, Integer> {

	@Query("SELECT c FROM Cliente c WHERE c.nome = ?1")
	public List<Cliente> findClienteByNome(String nome);

}
