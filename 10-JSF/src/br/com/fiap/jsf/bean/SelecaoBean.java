package br.com.fiap.jsf.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.ws.service.SelecaoService;
import br.com.fiap.ws.to.Selecao;

@ManagedBean
public class SelecaoBean {

	private Selecao selecao;
	private SelecaoService service;
	
	@PostConstruct
	private void init() {
		selecao = new Selecao();
		service = new SelecaoService();
	}
	
	public void cadastrar() {
		try {
			service.cadastrar(selecao);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}
	
}
