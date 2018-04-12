package br.com.fiap.jsf.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {

	private String usuario;
	
	private String senha;
	
	public void logar() {
		if ("FIAP".equals(getUsuario()) && "FIAP2018".equals(getSenha())) {
			System.out.println("Logado com sucesso.");
		} else {
			System.out.println("Erro ao logar.");
		}
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
