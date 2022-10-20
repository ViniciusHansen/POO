package pkg;

public class Abundantes extends Gerador {

	public void gerar(int n) {
		int i = 0;
		int num = 2;
		while(i < n) {
			if(abundante(num)) {
				sequencia.add(num);
				i++;
			}
			num++;
		}
	}
	
	public boolean abundante(int x) {
		int soma = 0;
		
		for(int i=1; i < x; i++)
			if(x % i == 0)
				soma += i;

		if (x > soma)
			return false;
		else
			return true;
			
	}

}