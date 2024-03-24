package org.diego.api.serviceorder.service;

import java.util.List;
import java.util.Optional;

import org.diego.api.serviceorder.dao.cliente.ClienteDao;
import org.diego.api.serviceorder.dto.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	private ClienteDao clienteDao;

	public Optional<Cliente> getCliente(int id) {
		return clienteDao.findById(id);
	}

	public Cliente saveCliente(Cliente cliente) {
		if (existeCliente(cliente.getNome(), cliente.getNumDocumento())) {
			return null;
		}
		return clienteDao.saveAndFlush(cliente);
	}

	private boolean existeCliente(String nome, Long numDocumento) {
		List<Cliente> clientes = clienteDao.findByNomeOrDocumento(nome, numDocumento);
		return (clientes != null && !clientes.isEmpty());
	}

	public List<Cliente> listaClienteNome(String nome) {
		return clienteDao.findClienteByNome(nome);
	}
}
