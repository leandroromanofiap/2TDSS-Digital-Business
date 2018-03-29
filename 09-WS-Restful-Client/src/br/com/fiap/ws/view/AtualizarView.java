package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.to.Selecao;
import br.com.fiap.ws.service.SelecaoService;

public class AtualizarView {

	static SelecaoService selecaoService = new SelecaoService();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Selecao selecao = new Selecao();
		
		System.out.print("Informe o c�digo do pa�s: ");
		int codigo = scanner.nextInt();

		System.out.print("Digite o pa�s: ");
		selecao.setPais(scanner.next() + scanner.nextLine());
		
		System.out.print("Numero de mundiais: ");
		selecao.setNumeroMundiais(scanner.nextInt());
		
		System.out.print("Est� classificado? ");
		selecao.setClassificado(scanner.nextBoolean());

		try {
			selecaoService.atualizar(selecao, codigo);
			System.out.println("Atualizado!");
		} catch (Exception e) {
			e.printStackTrace();
		}

		scanner.close();

	}

}
