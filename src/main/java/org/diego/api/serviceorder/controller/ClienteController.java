package org.diego.api.serviceorder.controller;

import java.util.List;

import org.diego.api.serviceorder.dto.Cliente;
import org.diego.api.serviceorder.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	/**
	 * Obtem dados do cliente pelo ID
	 * 
	 * @param id
	 * @return Cliente
	 */
	@GetMapping("/cliente/{id}")
	private Cliente getClienteById(@PathVariable("id") Integer id) {
		System.out.println("cliente " + id);
		return clienteService.getCliente(id);
	}

	/**
	 * Salva dados de cliente
	 * 
	 * @param cliente
	 */
	@PostMapping("/cliente")
	private int salvarCliente(@RequestBody Cliente cliente) {
		clienteService.saveCliente(cliente);
		return cliente.getId();
	}

	@GetMapping("/cliente")
	private List<Cliente> listaClienteNome(@RequestParam("nome") String nome) {
		return clienteService.listaClienteNome(nome);
	}

}
