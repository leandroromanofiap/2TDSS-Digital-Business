package br.com.fiap.jsf.bean;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.to.Paciente;
import br.com.fiap.ws.service.PacienteService;

@ManagedBean
public class PacienteBean {

	private Paciente paciente;
	private PacienteService service;

	@PostConstruct
	public void init() {
		paciente = new Paciente();
		paciente.setDataNascimento(Calendar.getInstance());
		service = new PacienteService();
	}

	public List<Paciente> getPacientes() {
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void salvar() {
		FacesMessage msg;

		try {
			service.cadastrar(paciente);

			msg = new FacesMessage("Sucesso!");
		} catch (Exception ex) {
			ex.printStackTrace();
			msg = new FacesMessage("Erro ao cadastrar.");
		}

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void atualizar() {
		FacesMessage msg;

		try {
			service.atualizar(paciente, paciente.getCodigo());

			msg = new FacesMessage("Atualizado com sucesso!");
		} catch (Exception ex) {
			ex.printStackTrace();
			msg = new FacesMessage("Erro ao atualizar.");
		}

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void deletar(int codigo) {
		FacesMessage msg;

		try {
			service.remover(codigo);
			msg = new FacesMessage("Paciente removido.");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao remover paciente");
		}

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
