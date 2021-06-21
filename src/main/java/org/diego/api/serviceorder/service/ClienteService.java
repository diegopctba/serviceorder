package org.diego.api.serviceorder.service;

import org.diego.api.serviceorder.dao.ClienteDao;
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
}
