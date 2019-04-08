import java.util.Scanner;

import campeonato.*;
import dao.*;
import implementacao.*;

public class InserindoDadosCampeonato {

	public static String header() {return "---------MENU---------";}

	public static void main(String[] args) {

		Scanner SC = new Scanner(System.in);
		int opcao = -1;

		while(opcao != 0){

			System.out.println(header());
			System.out.println("1 - Inserir");
			System.out.println("2 - Listar");
			System.out.println("\n0 - Sair");

			opcao = SC.nextInt();

			switch (opcao) {
			case 1:
					menuInserir();
				break;
			case 2:
					menuListar();
				break;
			default:
				System.out.println("Bye");
			break;
			}
		}
	}

	public static void menuInserir()
	{

		int opcao = -1, cod, codTime, timeA, timeB;
		String nome, dataNascimento, result, buffer;
		Scanner SC = new Scanner(System.in);

		System.out.println(header() + "\n1 - Jogador\n2 - Time\n3 - Jogo\n\n0 - Voltar");

		opcao = SC.nextInt();

		switch (opcao) {
			case 1:

				TimeDAO timedao = new TimeImpl();

				System.out.println("Digite o codigo do time:");
				cod = SC.nextInt();

				System.out.println("Digite o nome do time:");
				nome = SC.nextLine();
				buffer = SC.nextLine();

				System.out.println("Digite data fundacao do time:");
				String datafundacao = SC.nextLine();
				buffer = SC.nextLine();

				//Time t = new Time(cod, nome, datafundacao);
				//timedao.salvarTime(t);

			break;
			case 2:

				JogadorDAO jogadordao = new JogadorImpl();

				System.out.println("Digite o codigo do jogador:");
				cod = SC.nextInt();

				System.out.println("Digite o nome do jogador:");
				nome = SC.nextLine();
				buffer = SC.nextLine();

				System.out.println("Digite data de nascimento do jogador:");
				dataNascimento = SC.nextLine();
				buffer = SC.nextLine();

				System.out.println("Digite o codigo do time:");
				codTime = SC.nextInt();

				Jogador j = new Jogador(cod, nome, dataNascimento, codTime);
				jogadordao.salvarJogador(j);

			break;
			case 3:

				JogoDAO jogodao = new JogoImpl();

				System.out.println("Digite o codigo do jogo:");
				cod = SC.nextInt();

				System.out.println("Digite o resultado do jogo:");
				result = SC.nextLine();
				buffer = SC.nextLine();

				System.out.println("Digite o codigo do time A:");
				timeA = SC.nextInt();

				System.out.println("Digite o codigo do time B:");
				timeB = SC.nextInt();

				Jogo jg = new Jogo(cod, result, timeA, timeB);
				jogodao.salvarJogo(jg);

			break;
		}
		return;
	}


	public static void menuListar()
	{

		int opcao = -1;
		Scanner SC = new Scanner(System.in);

		System.out.println(header() + "\n1 - Jogadore(s)\n2 - Time(s)\n3 - Jogo(s)\n\n0 - Voltar");

		opcao = SC.nextInt();

		switch (opcao) {
			case 1:
				// imprimir todos os jogadores
			break;
			case 2:
				// imprimir todos os times
			break;
			case 3:
				// imprimir todos os jogos
			break;
		}
		return;
	}

}
