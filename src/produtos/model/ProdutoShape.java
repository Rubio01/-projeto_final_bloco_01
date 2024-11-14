package produtos.model;

public class ProdutoShape extends Produto {

	private String modalidade;

	public ProdutoShape(int numero, float tamanho, String marca, String nome, float preco, float saldoCaixa,
			String modalidade) {
		super(numero, tamanho, marca, nome, preco, saldoCaixa);

		this.modalidade = modalidade;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	@Override
	public void visualizar() {

		super.visualizar();
		System.out.println("Modalidade:" + this.modalidade);
	}
}
