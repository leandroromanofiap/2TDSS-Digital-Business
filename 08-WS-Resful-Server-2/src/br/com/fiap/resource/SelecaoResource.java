package br.com.fiap.resource;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fia.entity.Selecao;
import br.com.fiap.jpa.dao.SelecaoDAO;
import br.com.fiap.jpa.dao.impl.SelecaoDAOImpl;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

@Path("/selecao")
public class SelecaoResource {

	private SelecaoDAO selecaoDao;

	public SelecaoResource(SelecaoDAO selecaoDao) {
		super();
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		selecaoDao = new SelecaoDAOImpl(em);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Selecao pesquisar(@PathParam(value = "id") int codigo) {
		return selecaoDao.pesquisar(codigo);
	}

}
