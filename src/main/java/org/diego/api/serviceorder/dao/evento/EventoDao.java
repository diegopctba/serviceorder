package org.diego.api.serviceorder.dao.evento;

import java.util.List;

import org.diego.api.serviceorder.dto.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventoDao extends JpaRepository<Evento, Integer> {

	@Query("SELECT e FROM Evento e WHERE e.servicoId = ?1")
	List<Evento> findEventoByServico(long id);

}
