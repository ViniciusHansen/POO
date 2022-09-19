package pkg;

public class NumerosPrimos extends Gerador {

	public void gerar(int n) {
		int i = 0;
		int num = 2;
		while(i<n) {
			if(primo(num)) {
				sequencia.add(num);
				i++;
			}
			num++;
		}
	}
	
	public boolean primo(int x ) {
		for (int i = 2; i < x; i++)
			if(x % i == 0) 
				return false;
		return true;
	}
}