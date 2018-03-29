package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.to.Selecao;
import br.com.fiap.ws.service.SelecaoService;

public class BuscarView {

	static SelecaoService selecaoService = new SelecaoService();
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		try {
			System.out.print("Digite o código da seleção: ");
			Selecao selecao = selecaoService.buscar(scanner.nextInt());
			
			System.out.println(selecao.getPais());
			System.out.println(selecao.getNumeroMundiais());
			System.out.println("***************************");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
