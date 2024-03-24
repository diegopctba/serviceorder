package org.diego.api.serviceorder.controller;

import java.util.List;
import java.util.Optional;

import org.diego.api.serviceorder.dto.Equipamento;
import org.diego.api.serviceorder.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EquipamentoController extends BasicController {

	@Autowired
	private EquipamentoService equipamentoService;

	@GetMapping("/equipamento/{id}")
	private ResponseEntity<Object> getEquipamentoId(@PathVariable("id") Integer id) {
		Optional<Equipamento> equipamento = equipamentoService.getById(id);
		return equipamento.isEmpty() ? responseNoContent() : responseSucess(equipamento.get());
	}

	@GetMapping("/equipamento/cliente/{id}")
	private ResponseEntity<List<?>> getEquipamentoCliente(@PathVariable("id") Integer id) {
		List<Equipamento> equipamentos = equipamentoService.getPorCliente(id);
		return (equipamentos != null && equipamentos.isEmpty())
				? responseListNoContent() : responseListSucess(equipamentos);
	}
}
