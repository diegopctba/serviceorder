package org.diego.api.serviceorder.dao.equipamento;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.diego.api.serviceorder.model.Equipamento;

public class EquipamentosDaoImp implements EquipamentosDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Equipamento> findByCliente(Integer cliente) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Equipamento> query = cb.createQuery(Equipamento.class);
		Root<Equipamento> equipamento = query.from(Equipamento.class);
		Path<Integer> clientePath = equipamento.get("cliente.id");
		query.select(equipamento).where(cb.equal(clientePath, cliente));
		return entityManager.createQuery(query).getResultList();
	}

}
