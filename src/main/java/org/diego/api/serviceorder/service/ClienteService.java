package org.diego.api.serviceorder.service;

import java.util.List;

import org.diego.api.serviceorder.dao.cliente.ClienteDao;
import org.diego.api.serviceorder.dto.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	ClienteDao clienteDao;

	/**
	 * Recupera cliente pelo id
	 * 
	 * @param id
	 * @return {@link Cliente}
	 */
	public Cliente getCliente(int id) {
		return clienteDao.findById(id).get();
	}

	/**
	 * Salva Cliente Novo
	 * 
	 * @param cliente
	 */
	public void saveCliente(Cliente cliente) {
		clienteDao.save(cliente);
	}

	public List<Cliente> listaClienteNome(String nome) {
		return clienteDao.findClienteByNome(nome);
	}
}
