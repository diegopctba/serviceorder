package org.diego.api.serviceorder.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICO")
@Setter
@Getter
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servico_seq")
	@SequenceGenerator(name = "servico_seq", sequenceName = "SEQ_SERVICO", allocationSize = 1)
	private long id;
	@ManyToOne
	private Cliente cliente;
	@ManyToOne
	private Equipamento equipamento;
	@ManyToOne
	private Tecnico tecnico;
	private String defeito;
	private Date entrada;
	private Date entrega;
	private char status;

}
