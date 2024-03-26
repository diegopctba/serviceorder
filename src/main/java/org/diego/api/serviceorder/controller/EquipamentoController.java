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
	private ResponseEntity<Object> getEquipamentoId(@PathVariable("id") Integer id) {
		return responseEntity(equipamentoService.getById(id));
	}

	@GetMapping("/equipamento/cliente/{clienteId}")
	private ResponseEntity<List<Equipamento>> getEquipamentoCliente(@PathVariable("clienteId") Integer clienteId) {
		List<Equipamento> equipamentos = equipamentoService.getPorCliente(clienteId);
		return (equipamentos != null && equipamentos.isEmpty())
				? responseListNoContent() : responseListSuccess(equipamentos);
	}

	@PostMapping("/equipamento")
	private ResponseEntity<Object> salvarEquipamento(@RequestBody Equipamento equipamento) {
		equipamento = equipamentoService.saveEquipamento(equipamento);
		return equipamento == null ? responseStatus(HttpStatus.NOT_ACCEPTABLE, "Equipamento já cadastrado") : responseSuccess(equipamento);
	}

	@DeleteMapping("/equipamento/{equipamentoId}")
	private ResponseEntity<Object> removeEquipamento(@PathVariable("equipamentoId") Integer equipamentoId) {
		boolean equipamentoRemovido = equipamentoService.removeEquipamento(equipamentoId);
		return equipamentoRemovido ? responseSuccess("Equipamento removido") : responseStatus(HttpStatus.NO_CONTENT, "Equipamento não encontrado");
	}

}
