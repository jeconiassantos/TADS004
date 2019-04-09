import java.util.Scanner;
import java.util.List;

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

		System.out.println(header() + "\n1 - Time\n2 - Jogador\n3 - Jogo\n\n0 - Voltar");

		opcao = SC.nextInt();

		switch (opcao) {
			case 1:

				TimeDAO timedao = new TimeImpl();

				System.out.println("Digite o codigo do time:");
				cod = SC.nextInt();

				System.out.println("Digite o nome do time:");
				nome = SC.next();

				System.out.println("Digite data fundacao do time:");
				String datafundacao = SC.next();

				Time t = new Time(cod, nome, datafundacao);
				timedao.salvarTime(t);

			break;
			case 2:

				JogadorDAO jogadordao = new JogadorImpl();

				System.out.println("Digite o codigo do jogador:");
				cod = SC.nextInt();

				System.out.println("Digite o nome do jogador:");
				nome = SC.next();

				System.out.println("Digite data de nascimento do jogador:");
				dataNascimento = SC.next();

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
				result = SC.next();

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

		System.out.println(header() + "\n1 - Times(s)\n2 - Jogadore(s)\n3 - Jogo(s)\n\n0 - Voltar");

		opcao = SC.nextInt();

		switch (opcao) {
			case 1:
				TimeDAO timedao = new TimeImpl();
				List<Time> times = timedao.listarTodosTimes();

				for(int i = 0; i < times.size(); i++)
				{
					System.out.println( "["+i+"]-------\nCod:" 
								+ times.get(i).getCod() 
								+ "\nNome: " 
								+ times.get(i).getNome() 
								+ "\nDataFundacao: " 
								+ times.get(i).getDatafundacao() + "\n");
				}

			break;
			case 2:
				JogadorDAO jogador = new JogadorImpl();
				List<Jogador> jogadores = jogador.listarTodosJogadores();

				for(int i = 0; i < jogadores.size(); i++)
				{
					System.out.println("["+i+"]-------\nCod:" 
								+ jogadores.get(i).getCod() 
								+ "\nNome: " 
								+ jogadores.get(i).getNome() 
								+ "\nDataFundacao: " 
								+ jogadores.get(i).getDataNascimento() 
								+ "\nTime: " 
								+ jogadores.get(i).getTimecod() + "\n");
				}
			break;
			case 3:
				JogoDAO jogo = new JogoImpl();
				List<Jogo> jogos = jogo.listarTodosJogos();

				for(int i = 0; i < jogos.size(); i++)
				{
					System.out.println("["+i+"]-------\nCod:" 
								+ jogos.get(i).getCod() 
								+ "\nResultado: " 
								+ jogos.get(i).getResultado() 
								+ "\nTime A: " 
								+ jogos.get(i).getTimea()
								+ "\nTime B: " 
								+ jogos.get(i).getTimeb() + "\n");
				}
			break;
		}
		return;
	}

}
