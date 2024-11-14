package produtos;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import produtos.controller.ProdutoController;

import produtos.model.ProdutoOutros;
import produtos.model.ProdutoShape;
import produtos.util.Cores;

public class Menu {

	public static void main(String[] args) {

		int opcao, numero, tipo;
		float preco, valor;
		String marca, nome, modalidade;

		Scanner scanner = new Scanner(System.in);
		ProdutoController produto = new ProdutoController();

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

				System.out.println("Digite o nome do Produto: ");
				scanner.skip("\\R?");
				nome = scanner.nextLine();

				do {
					System.out.println("Digite o tipo do produto (1-Shape ou 2-Outros):");
					tipo = scanner.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite a marca :");
				scanner.skip("\\R?");
				marca = scanner.nextLine();

				System.out.println("Digite o preço do Produto(R$):");
				preco = scanner.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite a modalidade (Long / Vert/ Street):");
					scanner.skip("\\R?");
					modalidade = scanner.nextLine();
					

					produto.cadastrar(new ProdutoShape(produto.gerarNumero(), nome, marca, preco, modalidade));

				}

				case 2 -> {

					produto.cadastrar(new ProdutoOutros(produto.gerarNumero(), nome, marca, preco));
				}
				}

				keyPress();
				break;

			case 2:

				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\nListar todas os Produtos" + Cores.TEXT_RESET);
				produto.listarTodos();
				keyPress();
				break;

			case 3:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\nConsultar dados do Produto - por número\n"
						+ Cores.TEXT_RESET);

				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "Digite o número do produto: ");
				numero = scanner.nextInt();
				produto.procurarPorNumero(numero);

				keyPress();
				break;

			case 4:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\nAtualizar dados do Produto\n" + Cores.TEXT_RESET);

				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "Digite o número do Produto: ");
				numero = scanner.nextInt();

				var buscaProduto = produto.buscarNaCollection(numero);
				if (buscaProduto != null) {
		
					System.out.println("Digite o nome do Produto: ");
					scanner.skip("\\R?");
					nome = scanner.nextLine();

					do {
						System.out.println("Digite o tipo do produto (1-Shape ou 2-Outros):");
						tipo = scanner.nextInt();
					} while (tipo < 1 && tipo > 2);

					System.out.println("Digite a marca :");
					scanner.skip("\\R?");
					marca = scanner.nextLine();

					System.out.println("Digite o preço do Produto(R$):");
					preco = scanner.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite a modalidade (Long / Vert/ Street):");
						scanner.skip("\\R?");
						modalidade = scanner.nextLine();

						produto.atualizar(new ProdutoShape(numero, nome, marca, preco, modalidade));

					}

					case 2 -> {

						produto.atualizar(new ProdutoOutros(numero, nome, marca, preco));
					}
					}

				} else {
					System.out.println("A Conta não foi encontrada!");
				}

				keyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\nApagar Produto\n" + Cores.TEXT_RESET);

				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "Digite o número do Produto: ");
				numero = scanner.nextInt();
				produto.deletar(numero);

				keyPress();
				break;

			case 6:

				System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\nComprar\n" + Cores.TEXT_RESET); //Método comprar incompleto

				System.out.println(Cores.TEXT_YELLOW_BRIGHT + "Digite o número do Produto para compra: ");
				numero = scanner.nextInt();

				do {
					System.out.println("Faça o pagamento: ");
					valor = scanner.nextFloat();

				} while (valor <= 0);
				produto.comprar(numero, valor);

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
