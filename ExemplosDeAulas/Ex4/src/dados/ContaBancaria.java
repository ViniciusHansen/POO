package dados;

public class ContaBancaria {
	private String cpf;
	private float saldo;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public float sacar(float valor) {
		this.saldo -= valor;
		return this.saldo;
	}
	
	public String gerarExtrato() {
		return "CPF do dono: "+this.cpf+"\nSaldo: "+this.saldo;
	}
}
