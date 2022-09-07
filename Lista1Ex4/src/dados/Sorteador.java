package dados;

import java.util.Random;
import java.util.ArrayList;

public class Sorteador {
	ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	Random r = new Random();
	
	public Pessoa sortearProximo() {
		int escolhido = r.nextInt(9);
		Pessoa pessoaEscolhida = pessoas.get(escolhido);
		pessoas.remove(escolhido);
		return pessoaEscolhida;
	}

	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Random getR() {
		return r;
	}

	public void setR(Random r) {
		this.r = r;
	}
	
	
}
