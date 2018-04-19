package br.com.fiap.jsf.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

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

	public void salvar() {
		FacesMessage msg;

		try {
			if (selecao.getCodigo() == 0)
				service.cadastrar(selecao);
			else
				service.atualizar(selecao, selecao.getCodigo());
			
			msg = new FacesMessage("Sucesso!");
		} catch (Exception ex) {
			ex.printStackTrace();
			msg = new FacesMessage("Erro ao cadastrar.");
		}

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public List<Selecao> getSelecoes() {
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void deletar(int id) {
		FacesMessage msg;
		
		try {
			service.remover(id);
			msg = new FacesMessage("Seleção removida.");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao remover seleção.");
		}
		
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}
}
