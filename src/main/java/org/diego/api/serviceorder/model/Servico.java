package org.diego.api.serviceorder.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

import javax.persistence.*;

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
	private String defeito;
	private Date entrada;
	private Date entrega;
	private Character status;
	private String detalhe;

}
