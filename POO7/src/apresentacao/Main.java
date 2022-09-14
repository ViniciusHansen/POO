package apresentacao;

import pkg.Fabrica;
import pkg.Veiculo;

public class Main {
	public static void main(String[] args) {
		Fabrica f = new Fabrica();
		while(true) {
			Veiculo veiculo = f.fabricar();
			System.out.println(veiculo.info());
		}
	}
}
