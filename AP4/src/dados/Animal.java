package dados;

public class Animal {
	private String nome;
	private String cor;
	private String especia;
	private int idade;
	protected float largura;
	protected float comprimento;
	protected float altura;
	
	public float getArea() {
		return this.largura * this.comprimento;
	}
	
	public float calculaEspacoOcupado() {
		return this.largura * this.comprimento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setEspecia(String especia) {
		this.especia = especia;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setLargura(float largura) {
		this.largura = largura;
	}

	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}
}
