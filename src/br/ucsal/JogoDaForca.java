package br.ucsal;
import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {

	public static void main(String[] args) {
		obterDados();

	}

	public static void obterDados() {

		Scanner in = new Scanner (System.in);
		String [] palavras = { "ABACAXI", "UNIVERSIDADE", "PALAVRA", "COMIDA", "PROFISSAO", "AMIGO", "CAVALEIRO"};
		String sorteada = random(palavras);
		char [] acertos = new char[sorteada.length()];
		int erro = 0;
		int feliz = 0;
		int qtd = 0;
		char [] usadas = new char [sorteada.length()];
		
		char letra = ' ';
		String desenho = " ";
		imprimir("=====Bem-Vindo(a) ao Jogo Da Forca!=====\n"); 
		desenho = bonequinho(erro);
		imprimir(desenho);
		
		imprimir("\n");
		
		while ( feliz < sorteada.length() && erro < 6) {
			// Resolvemos a maior parte dos problemas, o único que consegui identificar no momento é que o programa tá contando como acerto
			// mesmo que a pessoa digite a mesma letra várias vezes.

			letra= jogada(in);
			qtd = validar(letra,sorteada,acertos,usadas);
			if(qtd == 0) {
				erro++;
				desenho = bonequinho(erro);
				imprimir(desenho);
				estrategia(sorteada,acertos);
			} else if (qtd == -1) {
				imprimir("\nPalavra já digitada! Tente novamente...  :\n");
				desenho = bonequinho(erro);
				imprimir(desenho);
				estrategia(sorteada,acertos);
			}
			else {
					feliz += qtd;
					desenho = bonequinho(erro);
					imprimir(desenho);
					estrategia(sorteada,acertos);
				}
			}
			
		ganhouPerdeu(sorteada,feliz);
		
		
		in.close();
	}


	public static String random(String [] palavras) {
		// Esse método é responsável por retornar uma palavra aleatória que será usada como a palavra oculta do jogo.
		Random random = new Random();
		int indiceSorteado  = random.nextInt(palavras.length); // INDICE DA PALAVRA SORTEADA
		String palavraSorteada = palavras[indiceSorteado]; // VARIAVEL QUE GUARDA A PALAVRA QUE FOI SORTEADA
		return palavraSorteada;
	}

	public static char jogada (Scanner in) {
		// método que retorna uma letra que foi digitada pelo usuário
		imprimir("\nDigite uma letra :");
		char letra = in.next().toUpperCase().charAt(0);
		return letra;
	}

	public static int validar(char letra, String sorteada, char [] acertos, char [] usadas) {

		int placar = 0;
		for (int i = 0; i < sorteada.length(); i++) {
			if (letra == sorteada.charAt(i)) {
				if(letra != usadas[i]) {
				acertos[i] = 1;
				usadas[i] += letra;
				}else {
					placar = -1;
					return placar;
				}
				placar += 1;
			}
		}
		return placar;
	}

	public static char [] estrategia( String sorteada, char [] acertos) {
		/* esse método transforma todos os caracteres do vetor 'acertos' para a letra digitada se o valor for 1 ( se acertou )
		 * ou deixa como um underline se o valor for 0 ( se ainda não acertou )  */
		for (int i = 0; i < sorteada.length(); i++) {
			if (acertos[i] == 1) {
				imprimir(" " + sorteada.charAt(i) + " ");
			} else {
				imprimir(" _ ");
			}
		}
		return acertos;
	}

	public static void ganhouPerdeu (String sorteada, int feliz) {
		if ( feliz == sorteada.length()) {
			imprimir("\nParabéns, Você é um vencedor!!!");
		} else {
			imprimir("\nQue pena, não foi dessa vez...");
		}
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
