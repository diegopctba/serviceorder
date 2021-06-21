package org.diego.api.serviceorder.dao;

import org.diego.api.serviceorder.dto.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends JpaRepository<Cliente, Integer> {

}
