package org.diego.api.serviceorder.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EQUIPAMENTO")
/**
 * Equipamento
 *
 */
public class Equipamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5825011073366179506L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equip_seq")
	@SequenceGenerator(name = "equip_seq", sequenceName = "SEQ_EQUIPAMENTO", allocationSize = 1)
	private int id;
	@ManyToOne
	private Cliente cliente;
	// private int cliente_id;
	private String serie;
	private String marca;
	private String modelo;
	private String descricao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	/*
	 * public Cliente getCliente() { return cliente; }
	 * 
	 * public void setCliente(Cliente cliente) { this.cliente = cliente; }
	 */

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/*
	 * public int getCliente_id() { return cliente_id; }
	 * 
	 * public void setCliente_id(int cliente_id) { this.cliente_id = cliente_id; }
	 */

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
