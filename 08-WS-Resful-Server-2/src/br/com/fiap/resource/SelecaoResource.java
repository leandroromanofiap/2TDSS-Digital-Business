package br.com.fiap.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.jpa.dao.SelecaoDAO;
import br.com.fiap.jpa.dao.impl.SelecaoDAOImpl;
import br.com.fiap.jpa.entity.Selecao;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

@Path("/selecao")
public class SelecaoResource {

	private SelecaoDAO selecaoDao;

	public SelecaoResource() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		selecaoDao = new SelecaoDAOImpl(em);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Selecao pesquisar(@PathParam(value = "id") int codigo) {
		return selecaoDao.pesquisar(codigo);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Selecao> listar() {
		return selecaoDao.listar();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Selecao selecao, @Context UriInfo uriInfo) {
		try {
			selecaoDao.inserir(selecao);
			selecaoDao.commit();

			UriBuilder builder = uriInfo.getAbsolutePathBuilder();
			builder.path(Integer.toString(selecao.getCodigo()));

			return Response.created(builder.build()).build();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Selecao selecao, @PathParam(value = "id") int codigo) {
		try {
			selecao.setCodigo(codigo);
			selecaoDao.atualizar(selecao);
			selecaoDao.commit();
		} catch (CommitException e) {
			return Response.serverError().build();
		}

		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response remover(@PathParam(value = "id") int codigo) {
		try {
			selecaoDao.remover(codigo);
			selecaoDao.commit();
		} catch (KeyNotFoundException | CommitException e) {
			return Response.serverError().build();
		}

		return Response.ok().build();
	}
}
