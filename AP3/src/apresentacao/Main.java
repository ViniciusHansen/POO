package apresentacao;

import java.util.Scanner;

import dados.Cidade;
import dados.Cliente;
import dados.Reserva;
import negocio.ReservaPassagem;

public class Main {
	private Scanner scan = new Scanner(System.in);
	ReservaPassagem reserva = new ReservaPassagem(5,5);
	
	private Cliente cadastrarCliente() {
		System.out.println("Entre com os dados do Cliente:");
		Cliente temp = new Cliente();
		System.out.println("Nome:");
		temp.setNome(scan.next());
		System.out.println("Telefone:");
		temp.setTelefone(scan.next());
		System.out.println("Endereço:");
		temp.setEndereco(scan.next());
		System.out.println("CPF:");
		temp.setCpf(scan.next());
		reserva.cadastrarCliente(temp);
		return temp;
	}
	private void cadastrarCidade() {
		System.out.println("Entre com os dados da cidade:");
		Cidade temp = new Cidade();
		System.out.println("Nome:");
		temp.setNome(scan.next());
		System.out.println("estado:");
		temp.setEstado(scan.next());
		reserva.cadastrarCidade(temp);
	}
	private void mostrarReservas() {
		Cliente[] clientes = reserva.getClientes();
		for(int i=0;i<clientes.length;i++) {
			Reserva[] reservas = clientes[i].getReservas();
			for(int j=0;j<reservas.length;j++) {
				System.out.println("Número da reserva"+reservas[j].getNumReserva());
				System.out.println("cliente: "+i+" reserva: "+j);
			}
		}
	}
	
	private Reserva cadastrarPassagem() {
		Reserva passagem = new Reserva();
		System.out.println("escreva o numero da passagem");
		passagem.setNumReserva(Integer.valueOf(scan.next()));
		return passagem;
	}
	
	private void reservarIda() {
		Cliente client = cadastrarCliente();
		Reserva pass = cadastrarPassagem();
		reserva.reservarIda(client, pass);
		
	}
	private void reservarVolta() {
		Cliente client = cadastrarCliente();
		System.out.println("Passagem de IDA:");
		Reserva ida = cadastrarPassagem();
		System.out.println("Passagem de VOLTA:");
		Reserva volta = cadastrarPassagem();

		reserva.reservarVolta(client, ida, volta);
	}
	
	public int menu() {
		System.out.println("Menu\n"
				+ "1) cadastrar cliente\n"
				+ "2) cadastrar cidade\n"
				+ "3) mostrar reservas\n"
				+ "4) reservar ida\n"
				+ "5) reservar volta\n"
				+ "0) sair");
		return Integer.valueOf(scan.nextLine());
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		while (true) {
			int option = main.menu();
			switch(option) {
			  case 1:
				  	main.cadastrarCliente();
				  	break;
			  case 2:
				  	main.cadastrarCidade();
				  	break;
			  case 3:
				    main.mostrarReservas();
				    break;
			  case 4:
				    main.reservarIda();
				    break;
			  case 5:
				    main.reservarVolta();
				    break;
			  case 0:
				    System.exit(0);
			  default:
			    System.out.println("opção inválida");
			}
		
		}
	}
	
}
