package dados;

public class Conta {
	private String nome;
	private float valor, desconto;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public float getDesconto() {
		return desconto;
	}
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	@Override
	public String toString() {
		return "Conta [nome=" + nome + ", valor=" + valor + ", desconto=" + desconto + "]";
	}
	
}
