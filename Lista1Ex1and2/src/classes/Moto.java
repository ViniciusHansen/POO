package classes;

import java.util.Objects;

public class Moto {
	private String fabricante;
	private String modelo;
	private String placa;
	private String cor;
	
	public Moto() {
		
	}
	public Moto(String placa) {
		this.placa=placa;
	}
	
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}

	public String toString() {
		return "Moto [fabricante=" + fabricante + ", modelo=" + modelo + ", placa=" + placa + ", cor=" + cor + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moto other = (Moto) obj;
		return Objects.equals(cor, other.cor) && Objects.equals(fabricante, other.fabricante)
				&& Objects.equals(modelo, other.modelo) && Objects.equals(placa, other.placa);
	}
	
	
}
