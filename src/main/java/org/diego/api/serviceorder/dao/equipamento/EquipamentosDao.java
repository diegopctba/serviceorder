package org.diego.api.serviceorder.dao.equipamento;

import java.util.List;

import org.diego.api.serviceorder.model.Equipamento;

public interface EquipamentosDao {

	public List<Equipamento> findByCliente(Integer cliente);

}
