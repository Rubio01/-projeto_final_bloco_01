package produtos.model;

import produtos.util.Cores;

public abstract class Produto {

	
	private int numero;
	
	private String marca;
	private String nome;
	private float preco;

	public Produto(int numero,   String marca, String nome, float preco) {

		
		this.numero = numero;
		
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

	

	public boolean comprar(float valor) {

		if (this.getPreco() > valor) {
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nValor Insuficiente!" + Cores.TEXT_RESET);
			return false;
		} else {
			
			
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
		System.out.println("Preço : " + this.preco);
	}

}
