package dados;

public class ContaCorrente extends ContaBancaria{
	
	public boolean depositar(float valor) {
		float saldo = super.getSaldo();
		this.setSaldo(saldo+=valor);
		return true;
	}
}
