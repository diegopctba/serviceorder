package org.diego.api.serviceorder.controller;

import java.sql.Date;
import java.util.List;

import org.diego.api.serviceorder.model.Evento;
import org.diego.api.serviceorder.model.Servico;
import org.diego.api.serviceorder.service.EventoServico;
import org.diego.api.serviceorder.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicoController extends BasicController<Servico> {

	@Autowired
	private ServicoService servicos;

	@Autowired
	private EventoServico eventos;

	@PostMapping("/servico")
	private ResponseEntity<Object> criarServico(@RequestBody Servico servico) {
		Long servicoId = servicos.criarServico(servico);
		return servicoId == null ? responseStatus(HttpStatus.NOT_ACCEPTABLE, "Cliente ou equipamento não cadastrado") : responseSuccess(servicoId);
	}

	@PutMapping("/servico")
	private void atualizarServico(@RequestBody Servico servico) {
		servicos.atualizaServico(servico);
	}

	@GetMapping("/servico/{id}")
	private Servico buscarServico(@PathVariable long id) {
		return servicos.recuperaServicoId(id);
	}

	@GetMapping("/servico/eventos/{id}")
	private List<Evento> detalharEventos(@PathVariable long id) {
		return eventos.detalharEventos(id);
	}

	@PutMapping("/servico/evento/{id}")
	private void adicionarEvento(@PathVariable long id, @RequestBody Evento evento) {
		if (evento != null) {
			evento.setServicoId(id);
			evento.setData(new Date(System.currentTimeMillis()));
			eventos.salvarEvento(evento);
		}
	}

}
