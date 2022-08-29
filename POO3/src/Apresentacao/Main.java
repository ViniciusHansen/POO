package Apresentacao;
import java.util.Scanner;
import Dados.Vet;
import dados.Veterinario;
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
	
	public void mostrarTodosVeterinarios() {
		for(int i=0;i<sistema.getQuantVeterinarios();i++) {
			Vet vet = sistema.getVeterinarios()[i];
			System.out.println(vet);
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
				  	a.mostrarAnimais();
				  	break;
			  case 3:
				    main.cadastrarVeterinario();
				    break;
			  case 4:
				    a.cadastrarEnderecoVeterinario();
				    break;
			  case 5:
				    a.cadastrarAnimal();
				    break;
			  case 6:
				    a.cadastrarDono();
				    break;
			  case 7:
				    a.cadastrarEnderecoDono();
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
