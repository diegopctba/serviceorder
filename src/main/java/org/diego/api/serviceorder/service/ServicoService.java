package org.diego.api.serviceorder.service;

import java.sql.Date;
import java.util.List;

import org.diego.api.serviceorder.dao.evento.EventoDao;
import org.diego.api.serviceorder.dao.servico.ServicoDao;
import org.diego.api.serviceorder.model.Evento;
import org.diego.api.serviceorder.model.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

	@Autowired
	private ServicoDao servicoDao;

	@Autowired
	private EventoDao eventoDao;

	/**
	 * Cria um serviço novo
	 * 
	 * @param {@link Servico}
	 * @return id
	 */
	public long criarServico(Servico servico) {
		long id = servicoDao.save(servico).getId();
		if (id > 0) {
			Evento evento = new Evento();
			evento.setData(new Date(System.currentTimeMillis()));
			evento.setDescricao("ABERTURA DE SERVICO");
			evento.setDetalhes(servico.getDefeito());
			evento.setServicoId(id);
			eventoDao.save(evento);
		}
		return id;
	}

	/**
	 * Atualiza status do servico
	 * 
	 * @param {@link Servico}
	 */
	public void atualizaServico(Servico servico) {
		servicoDao.updateServicoForId(servico.getStatus(), servico.getTecnico().getMatricula(), servico.getId());
		Evento evento = new Evento();
		evento.setServicoId(servico.getId());
		evento.setData(new Date(System.currentTimeMillis()));
		evento.setDescricao("Atualizacao ");
		evento.setDetalhes("Mudanca de status " + servico.getStatus());
		eventoDao.save(evento);
	}

	/**
	 * Recupera um servico pelo ID
	 * 
	 * @param id
	 * @return {@link Servico}
	 */
	public Servico recuperaServicoId(long id) {
		return servicoDao.findById(id).get();
	}

	public List<Servico> recuperarServicosPendentesTecnico(int id) {
		return servicoDao.findAllByPendenteTecnico(id);
	}
}
