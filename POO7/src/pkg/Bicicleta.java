package pkg;

public class Bicicleta extends Veiculo{
	private int numeroMarchas;
	
	public String info() {
		return "Cor: "+this.cor+" - Marchas: "+this.numeroMarchas;
	}

	public int getNumeroMarchas() {
		return numeroMarchas;
	}

	public void setNumeroMarchas(int numeroMarchas) {
		this.numeroMarchas = numeroMarchas;
	}
}
