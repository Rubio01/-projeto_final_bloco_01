package produtos.model;

public class ProdutoShape extends Produto {

	private String modalidade;

	public ProdutoShape(int numero, String marca, String nome, float preco,
			String modalidade) {
		super(numero,  marca, nome, preco);

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
