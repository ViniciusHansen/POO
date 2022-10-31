package apresentacao;

import java.util.Scanner;

import dados.Contato;
import negocio.ListaTelefonica;

public class Main {
	private static Scanner s = new Scanner(System.in);
	private ListaTelefonica lt = new ListaTelefonica();
	
	public Contato novoContato() {
		Contato c = new Contato();
		System.out.println("nome:");
		c.setNome(s.next());
		System.out.println("tel:");
		c.setTelefone(s.next());
		return c;
	}
	
	public void adicionarContato(Contato c) {
		lt.adicionarContato(c);
	}
	
	public void removerContato() {
		System.out.println("escolha a inicial do contato a ser removido:");
		char inicial = s.next().toUpperCase().charAt(0);
		System.out.println(lt.buscarContatos(inicial));
		System.out.println("digite o numero da pessoa removida (1,2,3,...)");
		int escolha = Integer.valueOf(s.next());
		lt.removerContato(lt.buscarContatos(inicial).get(escolha));
	}
	
	
	public void exibirContato() {
		for(char i = 65; i < 91; i++) {
			if (lt.buscarContatos().get(i) != null) {
				System.out.println(i);
				
				for(Contato j: lt.buscarContatos(i)) {
					System.out.println(j.getNome() + " " + j.getTelefone());
				}
			}
		}
	}
	
	public void exibirContato(char letra) {
		if (lt.buscarContatos().get(letra) != null) {
			System.out.println(letra);
			
			for(Contato j: lt.buscarContatos(letra)) {
				System.out.println(j.getNome() + " " + j.getTelefone());
			}
		}
	}
	
	
	public static void main(String[] args) {
		Main main= new Main();
		
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
                    main.adicionarContato(main.novoContato());
                    break;
                case 2:
                    main.removerContato();
                    break;
                case 3:
                    main.exibirContato();
                    break;
                default:
                    break;
            }
        }
	}
	
}
