package br.com.clinica.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dia_atendimento")
public class DiaAtendimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer codigo;

	@Column 
	private String nome;

	public DiaAtendimento() {
	}

	public DiaAtendimento(Integer codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
