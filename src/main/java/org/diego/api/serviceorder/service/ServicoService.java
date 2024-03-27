package org.diego.api.serviceorder.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.diego.api.serviceorder.dao.evento.EventoDao;
import org.diego.api.serviceorder.dao.servico.ServicoDao;
import org.diego.api.serviceorder.model.Cliente;
import org.diego.api.serviceorder.model.Equipamento;
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

	private ClienteService clienteService;

	private EquipamentoService equipamentoService;

	public Long criarServico(Servico servico) {
		Optional<Cliente> cliente = clienteService.getCliente(servico.getCliente().getId());
		Optional<Equipamento> equipamento = equipamentoService.getById(servico.getEquipamento().getId());
		if (!cliente.isPresent() || !equipamento.isPresent()) {
			return null;
		}
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

	public void atualizaServico(Servico servico) {
		servicoDao.updateServicoForId(servico.getStatus(), servico.getId());
		Evento evento = new Evento();
		evento.setServicoId(servico.getId());
		evento.setData(new Date(System.currentTimeMillis()));
		evento.setDescricao("Atualizacao ");
		evento.setDetalhes("Mudanca de status " + servico.getStatus());
		eventoDao.save(evento);
	}

	public Servico recuperaServicoId(long id) {
		return servicoDao.findById(id).get();
	}

}
