package dados;

public class ContaSalario extends ContaBancaria{
	private String cnpjEmpresa;
	
	public boolean depositar(float valor, String cnpj) {
		if(cnpj != this.cnpjEmpresa) {
			return false;
		}
		float saldo = super.getSaldo();
		super.setSaldo(saldo+=valor);
		return true;
	}
}
