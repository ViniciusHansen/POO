package pkg;

import java.util.Random;


public class Fabrica {
	
	
	
	public int getRandomNumber(int min, int max) {
	    Random random = new Random();
	    return random.nextInt(max - min) + min;
	}
	
	
	public Veiculo fabricar() {
	    Random random = new Random();
		boolean car = random.nextBoolean();
		if(car == true) {
			Carro carro = new Carro();
			carro.setNumeroPortas(getRandomNumber(2, 4));
			int tipoCombustivel= getRandomNumber(0, 3);
			carro.setCombustivel(Combustivel.values()[tipoCombustivel]);
			int randomCor = getRandomNumber(0, 5);
			carro.setCor(Cor.values()[randomCor]);
			return carro;
		}
		else {
			Bicicleta bike = new Bicicleta();
			int numeroMarchas = getRandomNumber(0, 10);
			bike.setNumeroMarchas(numeroMarchas);
			int randomCor = getRandomNumber(0, 5);
			bike.setCor(Cor.values()[randomCor]);
			return bike;
		}
		
	}
	
	public static void main(String[] args) {
		Fabrica f = new Fabrica();
		while(true) {
			Veiculo veiculo = f.fabricar();
			System.out.println(veiculo.info());
		}
	}
}
