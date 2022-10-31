package apresentacao;

import java.util.Scanner;

import dados.Animal;
import dados.Viveiro;
import exceptions.SemEspaco;
import negocio.Zoologico;

public class Main {
	
	public static void menu() {
		System.out.println("Menu:\n"
				+ "1) cadastrar viveiro \n"
				+ "2) cadastrar animais \n"
				+ "3) alocar animal \n"
				+ "4) mostrar viveiros \n"
				+ "5) mostrar aquarios \n"
				+ "0) sair");
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Zoologico z = new Zoologico();
		int opcao = -999;
		while (opcao != 0) {
			menu();
			opcao = scan.nextInt();
			switch(opcao) {
			case 1:
				Viveiro v = new Viveiro();
				System.out.println("Nome");
				v.setNome(scan.next());
				System.out.println("Comprimento:");
				v.setComprimento(scan.nextFloat());
				System.out.println("Largura:");
				v.setLargura(scan.nextFloat());
				z.cadastrarViveiro(v);
				break;
			case 2:
				Animal a = new Animal();
				System.out.println("nome:");
				a.setNome(scan.next());
				System.out.println("cor:");
				a.setCor(scan.next());
				System.out.println("especie:");
				a.setEspecia(scan.next());
				System.out.println("idade:");
				a.setIdade(scan.nextInt());
				System.out.println("Largura:");
				a.setLargura(scan.nextFloat());
				System.out.println("Comprimento:");
				a.setComprimento(scan.nextFloat());
				System.out.println("Altura:");
				a.setAltura(scan.nextFloat());
				z.cadastrarAnimais(a);
				break;
			case 3:
				Animal a2 = new Animal();
				System.out.println("nome:");
				a2.setNome(scan.next());
				System.out.println("cor:");
				a2.setCor(scan.next());
				System.out.println("especie:");
				a2.setEspecia(scan.next());
				System.out.println("idade:");
				a2.setIdade(scan.nextInt());
				System.out.println("Largura:");
				a2.setLargura(scan.nextFloat());
				System.out.println("Comprimento:");
				a2.setComprimento(scan.nextFloat());
				System.out.println("Altura:");
				a2.setAltura(scan.nextFloat());
				
				Viveiro v2 = new Viveiro();
				System.out.println("Nome");
				v2.setNome(scan.next());
				System.out.println("Comprimento:");
				v2.setComprimento(scan.nextFloat());
				System.out.println("Largura:");
				v2.setLargura(scan.nextFloat());
				
				try {
					z.alocarAnimal(a2, v2);
				} catch (SemEspaco e){
					System.out.println("Erro, Não existe espaço para o animal");
				}
				break;
			case 4:
				System.out.println(z.getSoViveiros());
				break;
			case 5:
				System.out.println(z.getSoAquarios());
				break;
			default:
				System.out.println("opcao invalida");
			}
		
		}
	scan.close();
	}
}
