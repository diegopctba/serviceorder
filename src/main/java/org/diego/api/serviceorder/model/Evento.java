package org.diego.api.serviceorder.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EVENTO")
@Getter
@Setter
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evento_seq")
	@SequenceGenerator(name = "evento_seq", sequenceName = "SEQ_EVENTO", allocationSize = 1)
	private int id;
	private long servicoId;
	private Date data;
	private String descricao;
	private String detalhes;

}
