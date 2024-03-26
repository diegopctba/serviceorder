package org.diego.api.serviceorder.controller;

import java.util.List;
import java.util.Optional;

import com.sun.istack.NotNull;
import org.diego.api.serviceorder.model.Cliente;
import org.diego.api.serviceorder.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController extends BasicController<Cliente> {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/cliente/{clienteId}")
	private ResponseEntity<Object> getClienteById(@PathVariable("clienteId") Integer clienteId) {
		return responseEntity(clienteService.getCliente(clienteId));
	}

	@PostMapping("/cliente")
	private ResponseEntity<Object> salvarCliente(@RequestBody Cliente cliente) {
		cliente = clienteService.saveCliente(cliente);
		return cliente == null ? responseStatus(HttpStatus.NOT_ACCEPTABLE, "Cliente já cadastrado") : responseSuccess(cliente);
	}

	@GetMapping("/cliente/")
	private List<Cliente> listaClienteNome(@RequestParam("nome") String nome) {
		return clienteService.listaClienteNome(nome);
	}

	@PutMapping("/cliente")
	private ResponseEntity<Object> atualizaCliente(@RequestBody Cliente cliente) {
		cliente = clienteService.atualizaCliente(cliente);
		return cliente == null ? responseStatus(HttpStatus.NOT_ACCEPTABLE, "Cliente não encontrado") : responseSuccess(cliente);
	}

	@DeleteMapping("/cliente/{clienteId}")
	private ResponseEntity<Object> removeCliente(@PathVariable("clienteId") Integer clienteId) {
		boolean clienteRemovido = clienteService.removeCliente(clienteId);
		return clienteRemovido ? responseSuccess("Cliente removido") : responseStatus(HttpStatus.NOT_ACCEPTABLE, "Cliente não removido");
	}

}
