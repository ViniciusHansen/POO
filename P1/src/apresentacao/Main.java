package apresentacao;

import java.util.Scanner;

import dados.Cliente;
import dados.ClientePremium;
import dados.Conta;
import negocio.SistemaGestao;

public class Main {
	private SistemaGestao sistema = new SistemaGestao();
	private static Scanner s = new Scanner(System.in);
	
	public void cadastrarCliente() {
		Cliente c = new Cliente();
		System.out.println("Nome:");
		c.setNome(s.next());
		System.out.println("Endereço:");
		c.setEndereco(s.next());
		System.out.println("CPF:");
		c.setCpf(s.next());
		sistema.adicionarCliente(c);
	}
	public void cadastrarClienteOuro() {
		ClientePremium c = new ClientePremium();
		System.out.println("Nome:");
		c.setNome(s.next());
		System.out.println("Endereço:");
		c.setEndereco(s.next());
		System.out.println("CPF:");
		c.setCpf(s.next());
		System.out.println("Desconto adicional:");
		c.setDescontoBonus(Float.valueOf(s.next()));
		sistema.adicionarCliente(c);
	}
	public void cadastrarConta() {
		System.out.println("Escolha o cliente (pelo numero do Index):");
		mostrarClientes();
		int index = Integer.valueOf(s.next());
		Cliente c = sistema.getCliente(index);
		Conta temp = new Conta();
		System.out.println("Nome da conta:");
		temp.setNome(s.next());
		System.out.println("Valor:");
		temp.setValor(Float.valueOf(s.next()));
		System.out.println("Desconto:");
		float desconto = Float.valueOf(s.next());
		if(c instanceof ClientePremium) {
			desconto -= ((ClientePremium) c).getDescontoBonus();
		}
		temp.setDesconto(desconto);
		sistema.adicionarConta(c, temp);
	}
	public void mostrarClientes() {
		for(int i=0;i<sistema.getClientes().size();i++) {
			System.out.println("Index: "+i +"  "+sistema.getCliente(i));
		}
		//for(Cliente c : sistema.getClientes())
		//	System.out.println(c);
	}
	public void mostrarTotalMensalidades() {
		float valor = 0;
		for(Cliente c : sistema.getClientes())
			valor+=c.getMensalidade();
		System.out.println("Total Mensalidades:");
		System.out.println(valor);
	}
	public void mostrarTotalDescontos() {
		float valor = 0;
		for(Cliente c : sistema.getClientes())
			valor+=c.getDescontos();
		System.out.println("Total Descontos:");
		System.out.println(valor);
	}
	public void menu() {
		System.out.println("Menu:\n"
				+ "1) Cadastrar Cliente \n"
				+ "2) Cadastrar Cliente Premium \n"
				+ "3) Cadastrar Conta \n"
				+ "4) Mostrar Clientes \n"
				+ "5) Mostrar valor total das mensalidades \n"
				+ "6) Mostrar valor total dos descontos \n"
				+ "0) Sair");
	}
	public static void main(String[] args) {
		Main main = new Main();
		int opcao =-99999;
		
		while(opcao!=0) {
			main.menu();
			opcao = Integer.valueOf(s.next());
			
			switch (opcao) {
			case 1:
				main.cadastrarCliente();
				break;
			case 2:
				main.cadastrarClienteOuro();
				break;
			case 3:
				main.cadastrarConta();
				break;
			case 4:
				main.mostrarClientes();
				break;
			case 5:
				main.mostrarTotalMensalidades();
				break;
			case 6:
				main.mostrarTotalDescontos();
				break;
			default:
				System.out.println("Opção Inválida");
				break;
			}
		}
	}
}
