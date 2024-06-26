package org.diego.api.serviceorder.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "EQUIPAMENTO")
@Getter
@Setter
public class Equipamento implements Serializable {

	private static final long serialVersionUID = 5825011073366179506L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equip_seq")
	@SequenceGenerator(name = "equip_seq", sequenceName = "SEQ_EQUIPAMENTO", allocationSize = 1)
	private int id;
	@ManyToOne
	private Cliente cliente;
	@Column(nullable = false, unique = true)
	private String serie;
	@Column(nullable = false)
	private String marca;
	private String modelo;
	private String descricao;

}
