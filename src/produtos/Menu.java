package produtos;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import produtos.util.Cores;

public class Menu {

	public static void main(String[] args) {

		int opcao;

		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
					+ "\n\n*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                  Gen Skate ShoP                     ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar Produto                    ");
			System.out.println("            2 - Listar todos os Produtos             ");
			System.out.println("            3 - Buscar Produto por Número            ");
			System.out.println("            4 - Atualizar Dados do Produto           ");
			System.out.println("            5 - Apagar Produto                       ");
			System.out.println("            6 - Comprar                              ");
			System.out.println("            7 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");
			System.out.printf(Cores.TEXT_YELLOW_BRIGHT);

			try {
				opcao = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nDigite Valores Inteiros!" + Cores.TEXT_RESET);
				scanner.nextInt();
				opcao = 0;

			}

			if (opcao == 7) {
				System.out.println(
						Cores.TEXT_YELLOW_BOLD_BRIGHT + "\nGen Skate ShoP - O role do seu jeito!" + Cores.TEXT_RESET);
				sobre();
				scanner.close();
				System.exit(0);
			}

			switch (opcao) {

			case 1:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\nCadastrar Produto\n" + Cores.TEXT_RESET);

				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\nListar todas os Produtos"+ Cores.TEXT_RESET);

				keyPress();
				break;

			case 3:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\nConsultar dados do Produto - por número\n"
						+ Cores.TEXT_RESET);

				keyPress();
				break;

			case 4:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\nAtualizar dados do Produto\n" + Cores.TEXT_RESET);

				keyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\nApagar Produto\n" + Cores.TEXT_RESET);

				keyPress();
				break;

			case 6:

				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\nComprar\n" + Cores.TEXT_RESET);

				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nOpção Inválida!" + Cores.TEXT_RESET);
				keyPress();

			}
		}
	}

	public static void keyPress() {
		try {
			System.out.println("\n\nPressione Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}

	public static void sobre() {
		System.out.println(Cores.TEXT_YELLOW_BRIGHT + "\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Rubio Dainton");
		System.out.println("Rubio Dainton - rubiodaiton@gmail.com");
		System.out.println("https://github.com/Rubio01/projeto_final_bloco_01");
		System.out.println("*********************************************************" + Cores.TEXT_RESET);
	}

}
