package pkg;

public class Carro extends Veiculo{
	private int numeroPortas;
	private Combustivel combustivel;
	
	public String info() {
		return "Cor: "+this.cor+" - Combustivel: "+this.combustivel+" - Número de portas: "+this.numeroPortas;
	}

	public int getNumeroPortas() {
		return numeroPortas;
	}

	public void setNumeroPortas(int numeroPortas) {
		this.numeroPortas = numeroPortas;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
}
