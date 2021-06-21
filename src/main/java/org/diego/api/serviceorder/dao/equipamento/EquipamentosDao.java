package org.diego.api.serviceorder.dao.equipamento;

import java.util.List;

import org.diego.api.serviceorder.dto.Equipamento;

public interface EquipamentosDao {

	public List<Equipamento> findByCliente(Integer cliente);

}
