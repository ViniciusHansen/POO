package negocio;

import dados.ContaBancaria;
import dados.ContaCorrente;
import dados.ContaSalario;

import java.util.ArrayList;

public class Sistema {
	ArrayList<ContaBancaria> contas;
	
	public Sistema() {
	
	}
	
	public void CadastrarConta(ContaBancaria conta) {
		contas.add(conta);
	}
	
	public void realizarSaque(ContaBancaria conta, float valor) {
		conta.sacar(valor);
	}
	
	public void realizarDeposito(ContaCorrente conta, float valor) {
		conta.depositar(valor);
	}
	
	public boolean realizarDeposito(ContaSalario conta, float valor, String cnpj) {
		return conta.depositar(valor, cnpj);
	}

	public ArrayList<ContaBancaria> getContas() {
		return contas;
	}
	
	public ArrayList<ContaCorrente> getContasCorrentes(){
		ArrayList<ContaCorrente> contasCorrentes = new ArrayList<ContaCorrente>();
		for(ContaBancaria conta : contas)
			if (conta instanceof ContaCorrente)
				contasCorrentes.add((ContaCorrente) conta);
		return contasCorrentes;
	}
	
	public ArrayList<ContaSalario> getContasSalario(){
		ArrayList<ContaSalario> contasSalario = new ArrayList<ContaSalario>();
		for(ContaBancaria conta : contas)
			if (conta instanceof ContaSalario)
				contasSalario.add((ContaSalario) conta);
		return contasSalario;
	}
	
	public String obterExtrato(ContaBancaria conta) {
		return conta.gerarExtrato();
	}
}
	
	
	
	
	
