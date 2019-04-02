import java.util.Scanner;

import campeonato.Time;
import dao.TimeDAO;
import implementacao.TimeImpl;

public class InserindoDadosCampeonato {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Scanner dados = new Scanner(System.in);
		TimeDAO timedao = new TimeImpl();

		int opcao = -1;

		while(opcao != 0){
			System.out.println("-------MENU---------");
			System.out.println("0 - Sair");
			System.out.println("1 - Inserir Time");
			System.out.println("2 - Inserir Jogador");
			System.out.println("3 - Inserir Jogo");

			switch (opcao) {
			case 1:
				System.out.println("Digite o codigo do time");
				int cod = dados.nextInt();
				dados = new Scanner(System.in);
				System.out.println("Digite o nome do time");
				String nomeTime = dados.nextLine();
				System.out.println("Digite data fundação do time");
				String datafundacao = dados.nextLine();
				Time t = new Time(cod,nomeTime, datafundacao);
				timedao.salvarTime(t);
				break;
			case 2:
				//Código Inserir jogador
				break;
			case 3:
				//Código Inserir jogo
				break;
			}

			opcao = sc.nextInt();
		}
	}

}
