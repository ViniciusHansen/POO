package pkg;

public class Fatoriais extends Gerador{


	void gerar(int n) {
		while(n>1) {
			n *= n-1;
			n--;
		}
		sequencia.add(n);
	}

}
