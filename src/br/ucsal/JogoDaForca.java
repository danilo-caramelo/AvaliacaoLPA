package br.ucsal;
import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {

	public static void main(String[] args) {
		obterDados();

	}

	public static void obterDados() {

		Scanner in = new Scanner (System.in);
		String [] palavras = {"ABACAXI", "UNIVERSIDADE", "PALAVRA", "COMIDA","PROFISSAO", "AMIGO", "CAVALEIRO"};
		String sorteada = random(palavras);
		char [] acertos = new char[sorteada.length()];
		int erro = 0;
		int feliz = 0;
		int qtd = 0;
		imprimir(sorteada);
		imprimir("\n");
		char letra = ' ';
		String desenho = " ";

		while ( feliz < sorteada.length() && erro < 6) {
			// Resolvemos a maior parte dos problemas, o �nico que consegui identificar no momento � que o programa t� contando como acerto
			// mesmo que a pessoa digite a mesma letra v�rias vezes.


			letra= jogada(in);
			qtd = validar(letra,sorteada,acertos);
			if(qtd == 0) {
				erro++;
				desenho = bonequinho(erro);
				System.out.println("Errou");
				imprimir(desenho);
			} else {
					feliz += qtd;
					System.out.println("Acertou");
				}
			}
			estrategia(sorteada,acertos);
		
		System.out.println("Acabou!");
		in.close();
	}


	public static String random(String [] palavras) {
		// Esse m�todo � respons�vel por retornar uma palavra aleat�ria que ser� usada como a palavra oculta do jogo.
		Random random = new Random();
		int indiceSorteado  = random.nextInt(palavras.length); // INDICE DA PALAVRA SORTEADA
		String palavraSorteada = palavras[indiceSorteado]; // VARIAVEL QUE GUARDA A PALAVRA QUE FOI SORTEADA
		return palavraSorteada;
	}

	public static char jogada (Scanner in) {
		// m�todo que retorna uma letra que foi digitada pelo usu�rio
		imprimir("\nDigite uma letra :");
		char letra = in.next().toUpperCase().charAt(0);
		return letra;
	}

	public static int validar(char letra, String sorteada, char [] acertos) {

		int placar = 0;
		for (int i = 0; i < sorteada.length(); i++) {
			if (letra == sorteada.charAt(i)) {
				acertos[i] = 1;
				placar += 1;
				
			}
		}
		return placar;
	}

	public static char [] estrategia( String sorteada, char [] acertos) {
		/* esse m�todo transforma todos os caracteres do vetor 'acertos' para a letra digitada se o valor for 1 ( se acertou )
		 * ou deixa como um underline se o valor for 0 ( se ainda n�o acertou )  */
		for (int i = 0; i < sorteada.length(); i++) {
			if (acertos[i] == 1) {
				imprimir(" " + sorteada.charAt(i) + " ");
			} else {
				imprimir(" _ ");
			}
		}
		return acertos;
	}

	public static void ganhouPerdeu () {

	}

	public static void imprimir(char [] vect) {
		imprimir("\n");
		for (int i = 0; i < vect.length; i++) {
			System.out.print(vect[i] + " ");
		}
		imprimir("\n");
	}


	public static void imprimir(String txt) {
		System.out.print(txt);
	}
	public static String bonequinho (int erros) {
		String[] desenhos = {"+-----+\n" +
				"  |   |\n" +
				"      |\n" +
				"      |\n" +
				"      |\n" +
				"      |\n" +
				"======== \n", "+-----+\n" +
						"  |   |\n" +
						"  O   |\n" +
						"      |\n" +
						"      |\n" +
						"      |\n" +
						"=========\n", "+-----+\n" +
								"  |   |\n" +
								"  O   |\n" +
								"  |   |\n" +
								"      |\n" +
								"      |\n" +
								"=========\n", "+-----+\n" +
										"  |   |\n" +
										"  O   |\n" +
										" /|   |\n" +
										"      |\n" +
										"      |\n" +
										"=========\n", "+-----+\n" +
												"  |   |\n" +
												"  O   |\n" +
												" /|\\  |\n" +
												"      |\n" +
												"      |\n" +
												"=========\n", "+-----+\n" +
														"  |   |\n" +
														"  O   |\n" +
														" /|\\  |\n" +
														" /    |\n" +
														"      |\n" +
														"=========\n", "+-----+\n" +
																"  |   |\n" +
																"  O   |\n" +
																" /|\\  |\n" +
																" / \\  |\n" +
																"      |\n" +
		"=========\n"};
		return desenhos[erros];
	}
}