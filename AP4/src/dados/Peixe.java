package dados;

public class Peixe extends Animal {
	private float temperaturaIdeal;
	
	public float getTemperaturaIdeal() {
		return temperaturaIdeal;
	}

	public float calculaEspacoOcupado() {
		return this.altura * this.largura * this.comprimento;
	}
}
