package negocio;

import java.util.ArrayList;

import dados.Animal;
import dados.Aquario;
import dados.Viveiro;

public class Zoologico {
	private ArrayList<Viveiro> viveiros = new ArrayList<Viveiro>();
	private ArrayList<Animal> animais = new ArrayList<Animal>();
	
	public void cadastrarViveiro(Viveiro viveiro) {
		viveiros.add(viveiro);
	}
	
	
	public String toString() {
		return "Zoologico [viveiros=" + viveiros + "]";
	}

	public void cadastrarAnimais(Animal animal) {
		animais.add(animal);
	}

	public boolean alocarAnimal(Animal animal, Viveiro viveiro) {
		if(viveiro.adicionarAnimal(animal) == false)
			return false;
		else
			return true;
	}
	
	public ArrayList<Aquario> getSoAquarios(){
		ArrayList<Aquario> aquarios = new ArrayList<Aquario>();
		for(Viveiro viveiro : viveiros)
			if(viveiro instanceof Aquario)
				aquarios.add((Aquario) viveiro);
		return aquarios;
	}
	
	public ArrayList<Viveiro> getSoViveiros(){
		return viveiros;
	}
	
	
	
}
