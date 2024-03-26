package org.diego.api.serviceorder.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.diego.api.serviceorder.dao.equipamento.EquipamentoDao;
import org.diego.api.serviceorder.model.Equipamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EquipamentoService {

	@Autowired
	private EquipamentoDao equipamentoDao;

	public Optional<Equipamento> getById(Integer id) {
		return equipamentoDao.findById(id);
	}

	public List<Equipamento> getPorCliente(Integer id) {
		return equipamentoDao.findAllByCliente(id);
	}

	@Transactional
	public Equipamento saveEquipamento(Equipamento equipamento) {
		if (verificaEquipamento(equipamento)) {
			return null;
		}
		return equipamentoDao.saveAndFlush(equipamento);
	}

	private boolean verificaEquipamento(Equipamento equipamento) {
		Equipamento equipamentoOptional = equipamentoDao.findByClienteNumSerie(equipamento.getCliente().getId(), equipamento.getSerie());
		return equipamentoOptional != null && equipamentoOptional.getId() > 0;
	}

	public boolean removeEquipamento(int equipamentoId) {
		Optional<Equipamento> equipamento = getById(equipamentoId);
		if (equipamento.isPresent()) {
   			equipamentoDao.deleteById(equipamentoId);
			return true;
		}
		return false;
	}

	public void removeEquipamentoPorCliente(Integer clienteId) {
		List<Equipamento> equipamentosCliente = equipamentoDao.findAllByCliente(clienteId);
		if (equipamentosCliente != null && !equipamentosCliente.isEmpty()) {
			equipamentoDao.deleteAllById(equipamentosCliente.stream().map(Equipamento::getId).collect(Collectors.toList()));
		}
	}
}
