package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.ws.service.SelecaoService;

public class RemoveView {

	static SelecaoService selecaoService = new SelecaoService();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Informe o código do país que será removido: ");
		int codigo = scanner.nextInt();

		try {
			selecaoService.remover(codigo);
			System.out.println("Removido!");
		} catch (Exception e) {
			e.printStackTrace();
		}

		scanner.close();

	}

}
