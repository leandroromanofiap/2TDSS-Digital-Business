package br.com.fiap.jsf.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.ws.service.SelecaoService;
import br.com.fiap.ws.to.Selecao;

@ManagedBean
public class SelecaoBean {

	private Selecao selecao;
	
	@PostConstruct
	private void init() {
		selecao = new Selecao();
	}
	
	public void cadastrar() {
		System.out.println("chamou o cadastro.");
		
		SelecaoService service = new SelecaoService();
		
		try {
			service.cadastrar(selecao);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("Erro ao tentar cadastrar.");
		}
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}
	
}
