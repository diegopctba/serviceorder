package org.diego.api.serviceorder.dao;

import org.diego.api.serviceorder.dto.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoDao extends JpaRepository<Servico, Long> {

}
