package org.diego.api.serviceorder.service;

import java.util.List;
import java.util.Optional;

import org.diego.api.serviceorder.dao.equipamento.EquipamentoDao;
import org.diego.api.serviceorder.model.Equipamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

	@Transactional
	public Equipamento saveEquipamento(Equipamento equipamento) {
		if (verificaEquipamento(equipamento)) {
			return null;
		}
		return dao.saveAndFlush(equipamento);
	}

	private boolean verificaEquipamento(Equipamento equipamento) {
		Equipamento equipamentoOptional = dao.findByClienteNumSerie(equipamento.getCliente().getId(), equipamento.getSerie());
		return equipamentoOptional != null && equipamentoOptional.getId() > 0;
	}

}
