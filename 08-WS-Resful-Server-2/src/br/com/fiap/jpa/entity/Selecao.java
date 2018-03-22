package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_SELECAO")
@SequenceGenerator(name="selecao", sequenceName="SQ_T_SELECAO", allocationSize = 1)
public class Selecao {

	@Id
	@GeneratedValue(generator="selecao",strategy=GenerationType.SEQUENCE)
	@Column
	private int codigo;
	
	@Column
	private String pais;
	
	@Column
	private boolean isClassificado;
	
	@Column
	private int numeroMundiais;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public boolean isClassificado() {
		return isClassificado;
	}

	public void setClassificado(boolean classificado) {
		this.isClassificado = classificado;
	}

	public int getNumeroMundiais() {
		return numeroMundiais;
	}

	public void setNumeroMundiais(int numeroMundiais) {
		this.numeroMundiais = numeroMundiais;
	}
	
	
}
