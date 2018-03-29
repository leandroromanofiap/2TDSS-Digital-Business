package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.to.Selecao;
import br.com.fiap.ws.service.SelecaoService;

public class CadastroView {

	static SelecaoService selecaoService = new SelecaoService();
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		Selecao selecao = new Selecao();
		
		selecao.setPais(scanner.nextLine());
		selecao.setNumeroMundiais(scanner.nextInt());
		selecao.setClassificado(scanner.nextBoolean());
		
		try {
			selecaoService.cadastrar(selecao);
			System.out.println("Cadastrado!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		scanner.close();
	}
	
}
