package org.diego.api.serviceorder.controller;

import java.sql.Date;
import java.util.List;

import org.diego.api.serviceorder.dto.Evento;
import org.diego.api.serviceorder.dto.Servico;
import org.diego.api.serviceorder.service.EventoServico;
import org.diego.api.serviceorder.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicoController {

	@Autowired
	private ServicoService servicos;

	@Autowired
	private EventoServico eventos;

	/**
	 * Cria servico
	 * 
	 * @param servico
	 * @return id
	 */
	@PostMapping("/servico")
	private long criarServico(@RequestBody Servico servico) {
		return servicos.criarServico(servico);
	}

	/**
	 * Atualiza um servico
	 * 
	 * @param servico
	 */
	@PutMapping("/servico")
	private void atualizarServico(@RequestBody Servico servico) {
		System.out.println("atualizando servico");
		servicos.atualizaServico(servico);
	}

	/**
	 * Recupera um servico pelo id
	 * 
	 * @param id
	 * @return {@link Servico}
	 */
	@GetMapping("/servico/{id}")
	private Servico buscarServico(@PathVariable long id) {
		return servicos.recuperaServicoId(id);
	}

	/**
	 * Lista eventos de um serviço
	 * 
	 * @param id
	 * @return {@link Evento}
	 */
	@GetMapping("/servico/eventos/{id}")
	private List<Evento> detalharEventos(@PathVariable long id) {
		return eventos.detalharEventos(id);
	}

	/**
	 * Adicionar evento a um servico
	 * 
	 * @param id
	 * @param {@link Evento}
	 */
	@PutMapping("/servico/evento/{id}")
	private void adicionarEvento(@PathVariable long id, @RequestBody Evento evento) {
		if (evento != null) {
			evento.setServico_id(id);
			evento.setData(new Date(System.currentTimeMillis()));
			eventos.salvarEvento(evento);
		}
	}
}
