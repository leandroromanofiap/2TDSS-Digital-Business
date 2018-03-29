package br.com.fiap.ws.view;

import java.util.List;

import br.com.fiap.to.Selecao;
import br.com.fiap.ws.service.SelecaoService;

public class ListaView {

	static SelecaoService selecaoService = new SelecaoService();
	
	public static void main(String[] args) {
		List<Selecao> listaSelecao;
		try {
			listaSelecao = selecaoService.listar();
			
			for (Selecao selecao : listaSelecao) {
				System.out.println(selecao.getPais());
				System.out.println(selecao.getNumeroMundiais());
				System.out.println("***************************");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
