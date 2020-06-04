package br.ucsal;

import java.util.Scanner;

public class JogoLpa {


	public static void main(String[] args) {
		onStarted();

	}

	public static void onStarted() {
		Scanner in = new Scanner (System.in);
		switch (obterMenu(in)) {
		case 1:
			jogoDaForca(in);
			break;
		case 2:
			campoMinado();
			break;
		case 3:
			batalhaNaval();
			break;
		default:
			imprimir("Valor Incorreto!");
			break;
		}

	}

	public static int obterMenu(Scanner in) {

		int escolha = 0;
		imprimir("---- Seja bem-vindo(a) ! ----\n");
		imprimir("[1] Jogo da Forca\n"
				+ "[2] Campo Minado\n"
				+ "[3] Batalha Naval\n"
				+ "Faça sua escolha :");
		escolha = in.nextInt();
		return escolha;
	}

	public static void jogoDaForca (Scanner in) {
		// código do jogo da forca
	}

	public static void campoMinado () {
		// código do campo minado 
	}
	public static void batalhaNaval () {
		// código do batalha naval 
	}

	public static void imprimir(String txt) {
		System.out.print(txt);
	}

}
