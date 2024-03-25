package org.diego.api.serviceorder.controller;

import java.util.List;
import java.util.Optional;

import org.diego.api.serviceorder.dto.Equipamento;
import org.diego.api.serviceorder.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EquipamentoController extends BasicController {

	@Autowired
	private EquipamentoService equipamentoService;

	@GetMapping("/equipamento/{id}")
	private ResponseEntity<Object> getEquipamentoId(@PathVariable("id") Integer id) {
		Optional<Equipamento> equipamento = equipamentoService.getById(id);
		return equipamento.isEmpty() ? responseNoContent() : responseSucess(equipamento.get());
	}

	@GetMapping("/equipamento/cliente/{clienteId}")
	private ResponseEntity<List<?>> getEquipamentoCliente(@PathVariable("clienteId") Integer clienteId) {
		List<Equipamento> equipamentos = equipamentoService.getPorCliente(clienteId);
		return (equipamentos != null && equipamentos.isEmpty())
				? responseListNoContent() : responseListSucess(equipamentos);
	}

	@PostMapping("/equipamento")
	private ResponseEntity<Object> salvarEquipamento(@RequestBody Equipamento equipamento) {
		equipamento = equipamentoService.saveEquipamento(equipamento);
		return equipamento == null ? responseStatus(HttpStatus.NOT_ACCEPTABLE, "Equipamento já cadastrado") : responseSucess(equipamento);
	}


}
