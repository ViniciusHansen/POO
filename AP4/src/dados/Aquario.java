package dados;

public class Aquario extends Viveiro{
	private float altura;
	private float temperatura;
	
	public float calculaEspaco() {
		return this.comprimento * this.largura * this.altura;
	}
	
	public boolean adicionarAnimal(Peixe animal) {
		if(this.espacoDisponivel() < (animal.getArea()*0.7) || temperatura > animal.getTemperaturaIdeal()+3 || temperatura < animal.getTemperaturaIdeal()-3) {
			return false;
		}
		this.animais.add(animal);
		return true;
	}
}
