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
public class ClienteController extends BasicController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/cliente/{clienteId}")
	private ResponseEntity<Object> getClienteById(@PathVariable("clienteId") Integer clienteId) {
		Optional<Cliente> cliente = clienteService.getCliente(clienteId);
		return cliente.isEmpty() ? responseStatus(HttpStatus.NO_CONTENT, null) : responseSucess(cliente.get());
	}

	@PostMapping("/cliente")
	private ResponseEntity<Object> salvarCliente(@RequestBody Cliente cliente) {
		cliente = clienteService.saveCliente(cliente);
		return cliente == null ? responseStatus(HttpStatus.NOT_ACCEPTABLE, "Cliente já cadastrado") : responseSucess(cliente);
	}

	@GetMapping("/cliente")
	private List<Cliente> listaClienteNome(@RequestParam("nome") String nome) {
		return clienteService.listaClienteNome(nome);
	}

}
