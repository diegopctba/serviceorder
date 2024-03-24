package org.diego.api.serviceorder.controller;

import java.util.List;
import java.util.Optional;

import org.diego.api.serviceorder.dto.Cliente;
import org.diego.api.serviceorder.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/cliente/{clienteId}")
	private ResponseEntity<Cliente> getClienteById(@PathVariable("clienteId") Integer clienteId) {
		Optional<Cliente> cliente = clienteService.getCliente(clienteId);
		if (!cliente.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(cliente.get());
	}

	@PostMapping("/cliente")
	private ResponseEntity<Object> salvarCliente(@RequestBody Cliente cliente) {
		cliente = clienteService.saveCliente(cliente);
		if (cliente == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Cliente já cadastrado");
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(cliente);
	}

	@GetMapping("/cliente")
	private List<Cliente> listaClienteNome(@RequestParam("nome") String nome) {
		return clienteService.listaClienteNome(nome);
	}

}
