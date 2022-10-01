package main;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

import dados.Pessoa;
import negocio.Sistema;

public class Main {
	private static Scanner s;
	private Sistema st = new Sistema();
	
	public void menu() {
		System.out.println("Menu:\n"
				+ "1) adicionar pessoa\n"
				+ "-1) sair do programa\n");
	}
	
	public Pessoa cadastrarPessoa() {
		Pessoa temp = new Pessoa();
		System.out.println("Nome:");
		temp.setNome(s.next());
		System.out.println("Cidade:");
		temp.setCidade(s.next());
		System.out.println("CPF:");
		temp.setCpf(s.next());
		System.out.println("Idade:");
		temp.setIdade(Integer.valueOf(s.next()));
		return temp;
	}
	
	public void addPessoa(Pessoa pessoa) {
		st.addPessoa(pessoa);
	}
	
	public void mostrarPessoas() {
		System.out.println(st.getPessoas());
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		
		try {
			s = new Scanner(new File("pessoas.txt"));
		}
		catch (FileNotFoundException e) {
			s = new Scanner(System.in);
		}
		
		int valor;
		
		while (true) {
			main.menu();
			valor = Integer.valueOf(s.next());
			if(valor == -1)
				break;
			main.addPessoa(main.cadastrarPessoa());
			main.mostrarPessoas();
		}
	}
}
