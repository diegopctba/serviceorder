package org.diego.api.serviceorder.service;

import java.util.List;
import java.util.Optional;

import org.diego.api.serviceorder.dao.equipamento.EquipamentoDao;
import org.diego.api.serviceorder.dto.Equipamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipamentoService {

	@Autowired
	private EquipamentoDao dao;


	public Optional<Equipamento> getById(Integer id) {
		return dao.findById(id);
	}

	public List<Equipamento> getPorCliente(Integer id) {
		return dao.findAllByCliente(id);
	}

}
