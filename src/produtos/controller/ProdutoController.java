package produtos.controller;

import java.util.ArrayList;


import produtos.model.Produto;
import produtos.util.Cores;

import produtos.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {
	
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	int numero = 0;
	

	@Override
	public void procurarPorNumero(int numero) {
		
		var produto = buscarNaCollection(numero);

		if (produto != null) {
			
			produto.visualizar();
		} else {
			System.out.println(
					Cores.TEXT_RED_BOLD_BRIGHT + "\nO produto " + numero + " não foi encontrado!" + Cores.TEXT_RESET);
		}
		
	}

	@Override
	public void listarTodos() {
		
		for (var produto : listaProdutos) {
			produto.visualizar();

		}

		
	}

	@Override
	public void cadastrar(Produto produto) {
		
		listaProdutos.add(produto);
		System.out.println("\n O produto número: " + produto.getNumero() + Cores.TEXT_GREEN_BOLD_BRIGHT
				+ " foi criado com sucesso!" + Cores.TEXT_RESET);
		
	}

	@Override
	public void atualizar(Produto produto) {
		
		var buscaProduto = buscarNaCollection(produto.getNumero());

		if (buscaProduto != null) {
			
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
			
			System.out.println("\nO produto número: " + produto.getNumero() + Cores.TEXT_GREEN_BOLD_BRIGHT
					+ " foi atualizado com sucesso!" + Cores.TEXT_RESET);

		} else {
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nO produto número: " + produto.getNumero()
					+ " não foi encontrado!" + Cores.TEXT_RESET);
		}
		
	}

	@Override
	public void deletar(int numero) {
		
		var produto = buscarNaCollection(numero);

		if (produto != null) {
			
			if (listaProdutos.remove(produto) == true)
				System.out.println("\nO produto número: " + numero + Cores.TEXT_GREEN_BOLD_BRIGHT
						+ " foi deletado com sucesso!" + Cores.TEXT_RESET);
		} else
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nO produto número " + numero + " não foi encontrado!"
					+ Cores.TEXT_RESET);
		
	}

	@Override
	public void comprar(int numero, float valor) {
		
		var produto = buscarNaCollection(numero);

		if (produto != null) {
			
			if (produto.comprar(valor) == true)
				listaProdutos.remove(produto);
				System.out.println("\nA compra do produto número: " + numero + Cores.TEXT_GREEN_BOLD_BRIGHT
						+ " foi efetuada com sucesso!" + Cores.TEXT_RESET);
		} else
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nO produto número: " + numero + " não foi encontrado!"
					+ Cores.TEXT_RESET);
		
	}
	public int gerarNumero() {
		return ++numero;
	}
	
	public Produto buscarNaCollection(int numero) {

		for (var produto : listaProdutos) {
			
			if (numero == produto.getNumero() ) {
				return produto;
			}
		}
		return null;

	}
	
	

	}
	
	


