import java.util.Scanner;

import campeonato.*;
import dao.*;
import implementacao.*;

public class InserindoDadosCampeonato {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Scanner dados = new Scanner(System.in);
		TimeDAO timedao = new TimeImpl();
		JogadorDAO jogadordao = new JogadorImpl();
		JogoDAO jogodao = new JogoImpl();

		int opcao = -1, cod, codTime, timeA, timeB;
		String nome, dataNascimento, result;

		while(opcao != 0){

			System.out.println("-------MENU---------");
			System.out.println("1 - Inserir Time");
			System.out.println("2 - Inserir Jogador");
			System.out.println("3 - Inserir Jogo");
			System.out.println("0 - Sair");

			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Digite o codigo do time:");
				cod = dados.nextInt();
				dados = new Scanner(System.in);
				System.out.println("Digite o nome do time:");
				nome = dados.nextLine();
				System.out.println("Digite data fundacao do time:");
				String datafundacao = dados.nextLine();
				Time t = new Time(cod, nome, datafundacao);
				timedao.salvarTime(t);
				break;
			case 2:
				System.out.println("Digite o codigo do jogador:");
				cod = dados.nextInt();
				dados = new Scanner(System.in);
				System.out.println("Digite o nome do jogador:");
				nome = dados.nextLine();
				System.out.println("Digite data de nascimento do jogador:");
				dataNascimento = dados.nextLine();
				System.out.println("Digite o codigo do time:");
				codTime = dados.nextInt();
				Jogador j = new Jogador(cod, nome, dataNascimento, codTime);
				jogadordao.salvarJogador(j);
				break;
			case 3:
				System.out.println("Digite o codigo do jogo:");
				cod = dados.nextInt();
				dados = new Scanner(System.in);
				System.out.println("Digite o resultado do jogo:");
				result = dados.nextLine();
				System.out.println("Digite o codigo do time A:");
				timeA = dados.nextInt();
				System.out.println("Digite o codigo do time B:");
				timeB = dados.nextInt();
				Jogo jg = new Jogo(cod, result, timeA, timeB);
				jogodao.salvarJogo(jg);
				break;
			default: 
				System.out.println("Bye");
			break;
			}
		}
	}

}
