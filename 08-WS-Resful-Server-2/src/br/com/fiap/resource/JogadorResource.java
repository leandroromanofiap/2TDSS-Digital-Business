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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.jpa.dao.JogadorDAO;
import br.com.fiap.jpa.dao.impl.JogadorDAOImpl;
import br.com.fiap.jpa.entity.Jogador;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

@Path("/jogador")
public class JogadorResource {

	private JogadorDAO dao;

	public JogadorResource() {
		super();
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new JogadorDAOImpl(em);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Jogador> listar() {
		return dao.listar();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Jogador pesquisar(@PathParam(value = "id") int codigo) {
		return dao.pesquisar(codigo);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Jogador jogador, @Context UriInfo uriInfo) {
		try {
			dao.inserir(jogador);
			dao.commit();

			UriBuilder builder = uriInfo.getAbsolutePathBuilder();
			builder.path(Integer.toString(jogador.getCodigo()));

			return Response.created(builder.build()).build();
		} catch (CommitException e) {
			return Response.serverError().build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response atualizar(Jogador jogador, @PathParam(value = "id") int codigo) {
		try {
			jogador.setCodigo(codigo);
			dao.atualizar(jogador);
			dao.commit();

			return Response.ok().build();
		} catch (CommitException e) {
			return Response.serverError().build();
		}
	}

	@DELETE
	@Path("/{id}")
	public void remover(@PathParam(value = "id") int codigo) {
		try {
			dao.remover(codigo);
			dao.commit();
		} catch (KeyNotFoundException | CommitException e) {
			throw new WebApplicationException(e.getMessage());
		}
	}
}
