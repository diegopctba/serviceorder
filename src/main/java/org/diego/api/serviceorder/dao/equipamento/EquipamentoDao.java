package org.diego.api.serviceorder.dao.equipamento;

import java.util.List;

import org.diego.api.serviceorder.dto.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EquipamentoDao extends JpaRepository<Equipamento, Integer> {

	/**
	 * Pesquisa Equipamentos por cliente
	 * 
	 * @param id cliente
	 * @return {@link Equipamento}
	 */
	@Query("SELECT e FROM Equipamento e WHERE e.cliente.id = ?1")
	List<Equipamento> findAllByCliente(Integer id);

}
