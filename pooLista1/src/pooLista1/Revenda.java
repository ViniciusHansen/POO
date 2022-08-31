package pooLista1;

public class Revenda {
	private String nome;
	private String rua;
	private String cnpj;
	private int numero;
	private String cidade;
	private int cep;
	
	public Revenda() {
		
	}
	public Revenda(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return "Revenda [nome=" + nome + ", cnpj=" + cnpj + "]";
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	
	public boolean equals(Object o) {
		Revenda r;
		if (!(o instanceof Revenda)) {
			return false;
		}
		r = (Revenda) o;
		if (cnpj.equals(r.getCnpj())) {
			return true;
		}
		return false;
	}
	
}
