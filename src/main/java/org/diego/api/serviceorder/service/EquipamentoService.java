package org.diego.api.serviceorder.service;

import java.util.List;

import org.diego.api.serviceorder.dao.equipamento.EquipamentoDao;
import org.diego.api.serviceorder.dto.Equipamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipamentoService {

	@Autowired
	private EquipamentoDao dao;

	/**
	 * Recupera equipamento pelo ID
	 * 
	 * @param id
	 * @return {@link Equipamento}
	 */
	public Equipamento getById(Integer id) {
		return dao.findById(id).get();
	}

	public List<Equipamento> getPorCliente(Integer id) {
		return dao.findAllByCliente(id);
		// return dao.findByCliente(id);
	}

}
