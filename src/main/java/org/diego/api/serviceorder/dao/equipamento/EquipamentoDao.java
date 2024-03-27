package org.diego.api.serviceorder.dao.equipamento;

import java.util.List;

import org.diego.api.serviceorder.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EquipamentoDao extends JpaRepository<Equipamento, Integer> {

	@Query("SELECT e FROM Equipamento e WHERE e.cliente.id = ?1")
	List<Equipamento> findAllByCliente(Integer id);

	@Query("SELECT e FROM Equipamento e WHERE e.cliente.id = ?1 AND e.serie = ?2")
    Equipamento findByClienteNumSerie(Integer id, String serie);
}
