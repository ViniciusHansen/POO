package Apresentacao;
import java.util.Scanner;

import Dados.Adress;
import Dados.Animal;
import Dados.Vet;
import negocio.SistemaPetShop;


public class Main {
	Scanner scan = new Scanner(System.in);
	SistemaPetShop sistema = new SistemaPetShop(10);
	
	public SistemaPetShop getSistema() {
		return sistema;
	}
	
	public int menu() {
		System.out.println("Menu\n"
				+ "1) mostrar veterinarios\n"
				+ "2) mostrar animais\n"
				+ "3) cadastrar veterinario\n"
				+ "4) cadastrar endereço do veterinario\n"
				+ "5) cadastrar animal\n"
				+ "6) cadastrar dono do animal\n"
				+ "7) cadastrar endereço do dono\n"
				+ "0) sair");
		return scan.nextInt();
	}
	
	private void cadastrarVeterinario() {
		Vet veterinario = new Vet(5);
		System.out.println("Nome do Vet: ");
		veterinario.setNome(scan.next());
		System.out.println("Salário do Vet: ");
		veterinario.setSalario(Float.valueOf(scan.next()));
		sistema.cadastrarVeterinario(veterinario);
	}
	
	private int mostrarAnimais() {
		mostrarTodosVeterinarios();
		System.out.println("Escolha um Veterianáio (pelo indice) para ver os animais que ele cuida:");
		int i = scan.nextInt();
		Vet vet = sistema.getVeterinarios()[i];
		for(int j=0;j<vet.getAnimaisLength();j++) {
			System.out.printf("Animal %i: %s", j, vet.getAnimais()[j].getNome());
		}
		return i;
	}
	
	private void mostrarTodosVeterinarios() {
		for(int i=0;i<sistema.getQuantVeterinarios();i++) {
			Vet vet = sistema.getVeterinarios()[i];
			System.out.println(vet);
		}
	}
	
	private void cadastrarEnderecoVet() {
		System.out.println("Veterinarios já cadastrados:");
		mostrarTodosVeterinarios();
		System.out.println("Escolha o índice do Vet que deseja cadastrar o endereço:");
		int i = scan.nextInt();
		Vet vet = sistema.getVeterinarios()[i];
		Adress temp = new Adress();
		System.out.println("rua:");
		temp.setRua(scan.next());
		System.out.println("número:");
		temp.setNumero(scan.next());
		System.out.println("bairro:");
		temp.setBairro(scan.next());
		System.out.println("cidade:");
		temp.setCidade(scan.next());
		System.out.println("cep:");
		temp.setCep(scan.next());
		vet.setAdress(temp);
	}
	
	private void cadastrarAnimal() {
		System.out.println("Veterinarios já cadastrados:");
		mostrarTodosVeterinarios();
		System.out.println("Escolha o índice do Vet que deseja cadastrar um novo animal:");
		int i = scan.nextInt();
		Vet vet = sistema.getVeterinarios()[i];
		if(vet.getQuantidadeAnimais() < 10) {
			System.out.println("nome:");
			Animal temp[] = new Animal[vet.getAnimaisLength()];
			temp[vet.getQuantidadeAnimais()].setNome(scan.next());
			System.out.println("espécie:");
			temp[vet.getQuantidadeAnimais()].setEspecie(scan.next());
			System.out.println("descrição:");
			temp[vet.getQuantidadeAnimais()].setDesc(scan.next());
			vet.setAnimais(temp);
		}
	}
	
	
	
	public static void main(String argv[]) {
		
		Main main = new Main();
		while (true) {
			int option = main.menu();
			switch(option) {
			  case 1:
				  	main.mostrarTodosVeterinarios();
				  	break;
			  case 2:
				  	main.mostrarAnimais();
				  	break;
			  case 3:
				    main.cadastrarVeterinario();
				    break;
			  case 4:
				    main.cadastrarEnderecoVet();
				    break;
			  case 5:
				    main.cadastrarAnimal();
				    break;
			  case 6:
				    main.cadastrarDono();
				    break;
			  case 7:
				    main.cadastrarEnderecoDono();
				    break;
			  case 0:
				    scan.close();
				    System.exit(0);
			  default:
			    System.out.println("opção inválida");
			}
		
		}
		
	}
	
}
