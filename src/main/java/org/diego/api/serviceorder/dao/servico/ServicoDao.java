package org.diego.api.serviceorder.dao.servico;

import java.util.List;

import org.diego.api.serviceorder.dto.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ServicoDao extends JpaRepository<Servico, Long> {

	@Modifying
	@Transactional
	@Query("UPDATE Servico s SET s.status = :status, s.tecnico.matricula = :tecnico WHERE s.id = :id")
	public void updateServicoForId(@Param("status") char status, @Param("tecnico") int tecnico, @Param("id") long id);

	@Query("SELECT s FROM Servico s WHERE s.status = 'P' AND s.tecnico.matricula = :id")
	public List<Servico> findAllByPendenteTecnico(int id);

}
