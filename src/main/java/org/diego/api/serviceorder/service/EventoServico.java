package org.diego.api.serviceorder.service;

import java.util.List;

import org.diego.api.serviceorder.dao.evento.EventoDao;
import org.diego.api.serviceorder.model.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoServico {

	@Autowired
	private EventoDao dao;

	/**
	 * Salva registro de um evento
	 * 
	 * @param {@link Evento}
	 */
	public void salvarEvento(Evento evento) {
		dao.save(evento);
	}

	public List<Evento> detalharEventos(long id) {
		return dao.findEventoByServico(id);
	}
}
