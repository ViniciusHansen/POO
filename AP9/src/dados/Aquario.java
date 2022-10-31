package dados;

public class Aquario extends Viveiro{
	private float altura;
	private float temperatura;
	
	public float calculaEspaco() {
		return this.comprimento * this.largura * this.altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getAltura() {
		return altura;
	}

	public float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

}
