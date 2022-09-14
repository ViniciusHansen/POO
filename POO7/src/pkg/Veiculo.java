package pkg;

abstract class Veiculo {
	protected Cor cor;
	
	
	public Cor getCor() {
		return cor;
	}


	public void setCor(Cor cor) {
		this.cor = cor;
	}


	public abstract String info();
}
