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
}
