package dados;

public class Reserva {
	private int numReserva;
	private String dataVoo;
	private String horaVoo;
	private float preco;
	private String classeVoo;
	private boolean idaEvolta;
	private int poltrona;
	private Cidade origem;
	private Cidade destino;
	private Reserva volta;
	
	
	public int getNumReserva() {
		return numReserva;
	}


	public void setNumReserva(int numReserva) {
		this.numReserva = numReserva;
	}


	public String getDataVoo() {
		return dataVoo;
	}


	public void setDataVoo(String dataVoo) {
		this.dataVoo = dataVoo;
	}


	public String getHoraVoo() {
		return horaVoo;
	}


	public void setHoraVoo(String horaVoo) {
		this.horaVoo = horaVoo;
	}


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}


	public String getClasseVoo() {
		return classeVoo;
	}


	public void setClasseVoo(String classeVoo) {
		this.classeVoo = classeVoo;
	}


	public boolean isIdaEvolta() {
		return idaEvolta;
	}


	public void setIdaEvolta(boolean idaEvolta) {
		this.idaEvolta = idaEvolta;
	}


	public int getPoltrona() {
		return poltrona;
	}


	public void setPoltrona(int poltrona) {
		this.poltrona = poltrona;
	}


	public Cidade getOrigem() {
		return origem;
	}


	public void setOrigem(Cidade origem) {
		this.origem = origem;
	}


	public Cidade getDestino() {
		return destino;
	}


	public void setDestino(Cidade destino) {
		this.destino = destino;
	}


	public Reserva getVolta() {
		return volta;
	}


	public void setVolta(Reserva volta) {
		this.volta = volta;
	}


	public String toString() {
		return "Reserva [numReserva=" + numReserva + ", dataVoo=" + dataVoo + ", horaVoo=" + horaVoo + ", preco="
				+ preco + ", classeVoo=" + classeVoo + ", idaEvolta=" + idaEvolta + ", poltrona=" + poltrona + "]";
	}
	
}
