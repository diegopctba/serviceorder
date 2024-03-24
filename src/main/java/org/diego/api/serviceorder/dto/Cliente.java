package org.diego.api.serviceorder.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTE")
@Getter
@Setter
public class Cliente implements Serializable {

	private static final long serialVersionUID = -8942472352903415108L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
	@SequenceGenerator(name = "cliente_seq", sequenceName = "SEQ_CLIENTE", allocationSize = 1)
	private int id;
	private String nome;
	private String telefone;
	private String endereco;
	private String cidade;
	private String uf;
	private String email;
	@Column(nullable = false, unique = true)
	private Long numDocumento;

}
