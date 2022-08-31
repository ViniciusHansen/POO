package dados;

public class Cliente {
	private String cpf;
	private String nome;
	private String endereco;
	private String telefone;
	private Reserva reservas[] = new Reserva[10];
	private int quantidadeReservas=0;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Reserva[] getReservas() {
		return reservas;
	}
	public void reservarIda(Reserva reserva) {
		if(quantidadeReservas<reservas.length) {
			reservas[quantidadeReservas] = reserva;
			quantidadeReservas++;
		}
	}
	
	public void reservarVolta(Reserva ida, Reserva volta) {
		if(quantidadeReservas<reservas.length) {
			reservas[quantidadeReservas] = volta;
			quantidadeReservas++;
			ida.setVolta(volta);
		}	
	}
	
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + "]";
	}
	
	
}
