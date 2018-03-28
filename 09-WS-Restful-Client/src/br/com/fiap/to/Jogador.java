package br.com.fiap.to;

public class Jogador {

	private int codigo;

	private String nome;

	private int numero;

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
