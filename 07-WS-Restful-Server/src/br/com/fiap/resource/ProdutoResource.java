package br.com.fiap.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fiap.to.ProdutoTO;

@Path("/produto")
public class ProdutoResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProdutoTO> buscar() {

		List<ProdutoTO> produtos = new ArrayList<>();
		
		produtos.add(new ProdutoTO(1, "Produto1", "Descricao1", 99, true));
		produtos.add(new ProdutoTO(2, "Produto2", "Descricao2", 49, false));
		
		return produtos;
		
	}
	
}
