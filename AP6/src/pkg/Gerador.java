package pkg;

import java.util.List;

public abstract class Gerador {
	protected List<Integer> sequencia;
	
	public List<Integer> getSequencia() {
		return sequencia;
	}

	abstract void gerar(int n);
	
	
	
}
