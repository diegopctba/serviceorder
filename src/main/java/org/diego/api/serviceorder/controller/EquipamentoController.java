package org.diego.api.serviceorder.controller;

import java.util.List;

import org.diego.api.serviceorder.dto.Equipamento;
import org.diego.api.serviceorder.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EquipamentoController {

	@Autowired
	EquipamentoService service;

	@GetMapping("/equipamento/{id}")
	private Equipamento getEquipamentoId(@PathVariable("id") Integer id) {
		return service.getById(id);
	}

	@GetMapping("/equipamento/cliente/{id}")
	private List<Equipamento> getEquipamentoCliente(@PathVariable("id") Integer id) {
		return service.getPorCliente(id);
	}
}
