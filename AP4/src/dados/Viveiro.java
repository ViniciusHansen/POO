package dados;

import java.util.ArrayList;

public class Viveiro {
	protected String nome;
	protected float comprimento;
	protected float largura;
	protected ArrayList<Animal> animais;
	
	
	public float calculaEspaco() {
		return this.comprimento * this.largura;
	}
	
	private float espacoOcupado() {
		return this.calculaEspaco() - this.espacoDisponivel();
	}
	
	public float espacoDisponivel(){
		float espaco = this.calculaEspaco();
		for(int i=0;i<animais.size();i++) {
			espaco -= animais.get(i).calculaEspacoOcupado();
		}
		return espaco;
	}

	public boolean adicionarAnimal(Animal animal) {
		if(this.espacoDisponivel() < (animal.getArea()*0.7)) {
			return false;
		}
		this.animais.add(animal);
		return true;
	}
}
