package dados;

import java.util.Random;
import java.util.ArrayList;

public class Sorteador {
	ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	Random r = new Random();
	
	public Pessoa sortearProximo() {
		int escolhido = r.nextInt(pessoas.size()-1);
		Pessoa pessoaEscolhida = pessoas.get(escolhido);
		pessoas.remove(escolhido);
		return pessoaEscolhida;
	}

	public void addPessoa(Pessoa pessoa) {
		this.pessoas.add(pessoa) ;
	}	
	
}
