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
			// Resolvemos a maior parte dos problemas, o �nico que consegui identificar no momento � que o programa t� contando como acerto
			// mesmo que a pessoa digite a mesma letra v�rias vezes.

			letra= jogada(in);
			qtd = validar(letra,sorteada,acertos,usadas);
			if(qtd == 0) {
				erro++;
				desenho = bonequinho(erro);
				imprimir(desenho);
				estrategia(sorteada,acertos);
			} else if (qtd == -1) {
				imprimir("\nPalavra j� digitada! Tente novamente...  :\n");
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

	public static void ganhouPerdeu (String sorteada, int feliz) {
		if ( feliz == sorteada.length()) {
			imprimir("\nParab�ns, Voc� � um vencedor!!!");
		} else {
			imprimir("\nQue pena, n�o foi dessa vez...");
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
