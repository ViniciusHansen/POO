package dados;

public class ContaSalario extends ContaBancaria{
	private String cnpjEmpresa;
	 
	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}

	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}

	public boolean depositar(float valor, String cnpj) {
		if(!(cnpj.equals(cnpjEmpresa)))
			return false;
		float saldo = super.getSaldo();
		super.setSaldo(saldo+=valor);
		return true;
	}
}
