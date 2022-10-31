package negocio;

import java.util.ArrayList;
import java.util.List;

import dados.Animal;
import dados.Aquario;
import dados.Peixe;
import dados.Viveiro;
import exceptions.SemEspaco;

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

	public boolean alocarAnimal(Animal animal, Viveiro viveiro) throws SemEspaco {
		if(viveiro instanceof Aquario) {
			if (viveiro.espacoDisponivel() < (animal.getArea() * 0.7) ||
					((Aquario) viveiro).getTemperatura() > ((Peixe) animal).getTemperaturaIdeal() + 3 ||
					((Aquario) viveiro).getTemperatura() < ((Peixe) animal).getTemperaturaIdeal() - 3)
				throw new SemEspaco("Sem espaço");
			else {
				viveiro.adicionarAnimal(animal);
				return true;
			}
		}
		else{
			if (viveiro.espacoDisponivel() < (animal.getArea() * 0.7))
				throw new SemEspaco("Sem espaço");
			else {
				viveiro.adicionarAnimal(animal);
				return true;
			}
		}
	}
	
	public ArrayList<Aquario> getSoAquarios(){
		ArrayList<Aquario> aquarios = new ArrayList<Aquario>();
		for(Viveiro viveiro : viveiros)
			if(viveiro instanceof Aquario)
				aquarios.add((Aquario) viveiro);
		return aquarios;
	}
	
	public ArrayList<Viveiro> getSoViveiros(){
		ArrayList<Viveiro> vs = new ArrayList<Viveiro>();
		for (Viveiro v : viveiros)
			if(!(v instanceof Aquario))
				vs.add(v);
		return vs;
	}
	
	
	
}
