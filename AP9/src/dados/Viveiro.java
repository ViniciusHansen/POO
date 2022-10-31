package dados;

import java.util.ArrayList;

public class Viveiro {
	protected String nome;
	protected float comprimento;
	protected float largura;
	protected ArrayList<Animal> animais = new ArrayList<Animal>();
	
	
	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}

	public void setLargura(float largura) {
		this.largura = largura;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return "Viveiro [nome=" + nome + ", comprimento=" + comprimento + ", largura=" + largura + ", animais="
				+ animais + "]";
	}

	public float espacoTotal() {
		return this.comprimento * this.largura;
	}

	public String getNome() {
		return nome;
	}

	public float getComprimento() {
		return comprimento;
	}

	public float getLargura() {
		return largura;
	}

	public ArrayList<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(ArrayList<Animal> animais) {
		this.animais = animais;
	}

	public float espacoOcupado(){
		float espaco = this.espacoTotal();
		for(int i=0;i<animais.size();i++) {
			espaco -= animais.get(i).calculaEspacoOcupado();
		}
		return espaco;
	}
	public float espacoDisponivel(){
		return espacoTotal()-espacoOcupado();
	}

	public void adicionarAnimal(Animal animal) {
		//if(this.espacoDisponivel() < (animal.getArea()*0.7)) {
		this.animais.add(animal);
	}
}
