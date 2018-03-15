package br.com.fiap.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import br.com.fiap.jpa.dao.ProdutoDAO;
import br.com.fiap.jpa.dao.impl.ProdutoDAOImpl;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;
import br.com.fiap.to.ProdutoTO;

@Path("/produto")
public class ProdutoResource {

	private ProdutoDAO produtoDao;

	public ProdutoResource() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		produtoDao = new ProdutoDAOImpl(em);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProdutoTO> listar() {
		return produtoDao.listar();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(ProdutoTO produto, @Context UriInfo uriInfo) {
		try {
			produtoDao.inserir(produto);
			produtoDao.commit();
			
			UriBuilder builder = uriInfo.getAbsolutePathBuilder();
			builder.path(Integer.toString(produto.getCodigo()));
			
			return Response.created(builder.build()).build();
		} catch (CommitException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
	}

}
