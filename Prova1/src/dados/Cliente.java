package dados;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String cpf, nome , endereco;
	protected List<Conta> contas = new ArrayList<Conta>();
	
	public void adicionarConta(Conta conta) {
		contas.add(conta);
	}
	public float getMensalidade() {
		float sum=0;
		for(Conta c : contas) {
			sum+=c.getValor()-c.getDesconto();
		}
		return sum;
	}
	public float getDescontos() {
		float sum=0;
		for(Conta c : contas)
			sum+=c.getDesconto();
		return sum;
	}
	
	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", endereco=" + endereco + "]";
	}
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
	public List<Conta> getContas() {
		return contas;
	}
	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	
}
