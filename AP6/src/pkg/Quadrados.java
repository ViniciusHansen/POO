package pkg;

public class Quadrados extends Gerador{
	
	void gerar(int n) {
		for(int i=0;i<n;i++)
			sequencia.add(i*i);
	}
}
