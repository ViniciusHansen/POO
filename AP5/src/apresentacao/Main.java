package apresentacao;

import java.util.Scanner;

import dados.Contato;
import negocio.ListaTelefonica;

public class Main {
	private static Scanner s = new Scanner(System.in);
	private ListaTelefonica lt = new ListaTelefonica();
	
	public Contato novoContato() {
		
	}
	
	public void adicionarContato() {
		
	}
	
	public void removerContato() {
		
	}
	
	public void exibirContatos() {
		
	}
	
	public void exibirContatos(char letra) {
		
	}
	
	public static void main(String[] args) {
		int opcao = -1;

        while (opcao != 0) {

            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar um contato");
            System.out.println("2 - Remover um contato");
            System.out.println("3 - Mostrar todos os contatos");
            System.out.println("0 - Sair");

            opcao = s.nextInt();

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    Contato contato = novoContato();
                    lt.adicionaContato(contato);
                    break;
                case 2:
                    removerContato();
                    break;
                case 3:
                    exibirContatos();
                    break;
                default:
                    break;
            }
        }
	}
	
}
