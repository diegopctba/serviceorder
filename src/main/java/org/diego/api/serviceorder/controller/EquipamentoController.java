package org.diego.api.serviceorder.controller;

import java.util.List;

import org.diego.api.serviceorder.model.Equipamento;
import org.diego.api.serviceorder.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EquipamentoController extends BasicController<Equipamento> {

	@Autowired
	private EquipamentoService equipamentoService;

	@GetMapping("/equipamento/{id}")
	private ResponseEntity<Equipamento> getEquipamentoId(@PathVariable("id") Integer id) {
		return responseEntity(equipamentoService.getById(id));
	}

	@GetMapping("/equipamento/cliente/{clienteId}")
	private ResponseEntity<List<Equipamento>> getEquipamentoCliente(@PathVariable("clienteId") Integer clienteId) {
		List<Equipamento> equipamentos = equipamentoService.getPorCliente(clienteId);
		return (equipamentos != null && equipamentos.isEmpty())
				? responseListNoContent() : responseListSuccess(equipamentos);
	}

	@PostMapping("/equipamento")
	private ResponseEntity<Equipamento> salvarEquipamento(@RequestBody Equipamento equipamento) {
		equipamento = equipamentoService.saveEquipamento(equipamento);
		return equipamento == null ? responseStatus(HttpStatus.UNPROCESSABLE_ENTITY, null) : responseSuccess(equipamento);
	}

	@DeleteMapping("/equipamento/{equipamentoId}")
	private ResponseEntity<Equipamento> removeEquipamento(@PathVariable("equipamentoId") Integer equipamentoId) {
		boolean equipamentoRemovido = equipamentoService.removeEquipamento(equipamentoId);
		return equipamentoRemovido ? responseSuccess(null) : responseStatus(HttpStatus.UNPROCESSABLE_ENTITY, null);
	}

}
