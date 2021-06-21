package org.diego.api.serviceorder.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "DATA", name = "EVENTO")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evento_seq")
	@SequenceGenerator(name = "evento_seq", sequenceName = "SEQ_EVENTO", allocationSize = 1)
	private int id;
	private long servico_id;
	private Date data;
	private String descricao;
	private String detalhes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getServico_id() {
		return servico_id;
	}

	public void setServico_id(long servico_id) {
		this.servico_id = servico_id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

}
