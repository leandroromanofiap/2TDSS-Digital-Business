package br.com.fiap.ws.view;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.Selecao;

public class ListaView {

	public static void main(String[] args) {

		Client client = new Client();

		WebResource resource = client.resource("http://localhost:8080/08-WS-Resful-Server-2/rest/selecao");

		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		if (response.getStatus() == 200) {
			Selecao[] vetor = response.getEntity(Selecao[].class);

			List<Selecao> lista = Arrays.asList(vetor);

			for (Selecao selecao : lista) {
				System.out.println(selecao.getPais());
				System.out.println(selecao.getNumeroMundiais());
				System.out.println("****************************");
			}
		}
	}

}
