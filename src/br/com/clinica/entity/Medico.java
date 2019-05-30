package br.com.clinica.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@Column
	private String crm;

	@Column
	private String nome;

	@Column(name = "horario_atendimento")
	private String horarioAtendimento;

	@Column(name = "intervalo_atendimento")
	private String intervaloAtendimento;

	@Column
	private String celular;

	@Column
	private String email;

	@ManyToOne
	@JoinColumn(name = "codigo")
	private Especialidade especialidade;

	@ManyToMany(targetEntity = DiaAtendimento.class)
	private List<DiaAtendimento> diaAtendimento = new ArrayList<>();

	public Medico() {
	}

	public Integer getCodigo(){
		return codigo;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHorarioAtendimento() {
		return horarioAtendimento;
	}

	public void setHorarioAtendimento(String horarioAtendimento) {
		this.horarioAtendimento = horarioAtendimento;
	}

	public String getIntervaloAtendimento() {
		return intervaloAtendimento;
	}

	public void setIntervaloAtendimento(String intervaloAtendimento) {
		this.intervaloAtendimento = intervaloAtendimento;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public List<DiaAtendimento> getDiaAtendimento() {
		return diaAtendimento;
	}

	public void setDiaAtendimento(List<DiaAtendimento> diaAtendimento) {
		this.diaAtendimento = diaAtendimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crm == null) ? 0 : crm.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		if (crm == null) {
			if (other.crm != null)
				return false;
		} else if (!crm.equals(other.crm))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return crm + " - " + nome;
	}
}
