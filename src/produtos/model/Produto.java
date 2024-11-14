package produtos.model;

import produtos.util.Cores;

public abstract class Produto {

	private float saldoCaixa;
	private int numero;
	private float tamanho;
	private String marca;
	private String nome;
	private float preco;

	public Produto(int numero, float tamanho, String marca, String nome, float preco, float saldoCaixa) {

		this.saldoCaixa = saldoCaixa;
		this.numero = numero;
		this.tamanho = tamanho;
		this.marca = marca;
		this.nome = nome;
		this.preco = preco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getTamanho() {
		return tamanho;
	}

	public void setTamanho(float tamanho) {
		this.tamanho = tamanho;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public float getSaldoCaixa() {
		return saldoCaixa;
	}

	public void setSaldoCaixa(float saldoCaixa) {
		this.saldoCaixa = saldoCaixa;
	}

	public boolean comprar(float valor) {

		if (this.getPreco() > valor) {
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nValor Insuficiente!" + Cores.TEXT_RESET);
			return false;
		} else {
			// falta implementar remoção do produto
			this.setSaldoCaixa(this.getSaldoCaixa() + valor);
			return true;
		}
	}

	public void visualizar() {

		System.out.println(Cores.TEXT_YELLOW_BOLD_BRIGHT + "\n**************************************");
		System.out.println("Dados do Produto:");
		System.out.println("**************************************" + Cores.TEXT_RESET);
		System.out.println("Número: " + this.numero);
		System.out.println("Nome : " + this.nome);
		System.out.println("Marca: " + this.marca);
		System.out.println("Tamanho: " + this.tamanho);
		System.out.println("Preço : " + this.preco);
	}

}
