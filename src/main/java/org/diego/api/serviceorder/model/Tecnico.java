package org.diego.api.serviceorder.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TECNICO")
@Getter
@Setter
public class Tecnico {

	@Id
	private int matricula;
	private String nome;

}
