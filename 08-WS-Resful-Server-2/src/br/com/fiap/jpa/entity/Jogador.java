package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_JOGADOR")
@SequenceGenerator(name = "jogador", sequenceName = "SQ_T_JOGADOR", allocationSize = 1)
public class Jogador {

	@Id
	@GeneratedValue(generator = "jogador", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_jogador")
	private int codigo;

	@Column(name = "nm_jogador", nullable = false)
	private String nome;

	@Column(name = "num_jogador", nullable = false)
	private int numero;

	@Column
	private boolean titular;

	public Jogador() {
		super();
	}

	public Jogador(String nome, int numero, boolean titular) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.titular = titular;
	}
	
	public Jogador(int codigo, String nome, int numero, boolean titular) {
		this(nome, numero,titular);
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isTitular() {
		return titular;
	}

	public void setTitular(boolean titular) {
		this.titular = titular;
	}
	
}
