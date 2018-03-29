package br.com.fiap.ws.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.Selecao;

public class SelecaoService {

	private Client client = Client.create();

	private static final String URL = "http://localhost:8080/08-WS-Resful-Server-2/rest/selecao";

	public List<Selecao> listar() throws Exception {
		WebResource resource = client.resource(URL);

		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		if (response.getStatus() == 200) {
			Selecao[] vetor = response.getEntity(Selecao[].class);
			return Arrays.asList(vetor);
		} else {
			throw new Exception("Erro: " + response.getStatus());
		}
	}

	public void cadastrar(Selecao selecao) throws Exception {
		WebResource resource = client.resource(URL);

		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, selecao);

		if (response.getStatus() != 201) {
			throw new Exception("Erro ao criar selecao: " + response.getStatus());
		}
	}

}
