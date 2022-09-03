package negocio;

import dados.Cidade;
import dados.Cliente;
import dados.Reserva;

public class ReservaPassagem {
	private Cidade[] cidades;
	private int quantCidades;
	private Cliente[] clientes;
	private int quantClientes;
	
	public ReservaPassagem(int quantClientes, int quantCidades) {
		clientes = new Cliente[quantClientes];
		cidades = new Cidade[quantCidades];
	}
	
	public void cadastrarCidade(Cidade cidade) {
		if (quantCidades > cidades.length) {
			return;
		}
		cidades[quantCidades] = cidade;
		quantCidades++;
	}
	public void cadastrarCliente(Cliente cliente) {
		if (quantClientes > clientes.length) {
			return;
		}
		clientes[quantClientes] = cliente;
		quantClientes++;
	}
	public void reservarIda(Cliente cliente, Reserva reserva) {
		cliente.reservarIda(reserva);
	}
	public void reservarVolta(Cliente cliente, Reserva ida, Reserva volta) {
		cliente.reservarVolta(ida, volta);
	}
	public Reserva[] getReservas(int cpfCliente) {
		for(int i=0;i<clientes.length;i++) {
			if(cpfCliente == Integer.valueOf(clientes[i].getCpf())) {
				return clientes[i].getReservas();
			}
		}
		return null;
	}

	public Cidade[] getCidades() {
		return cidades;
	}

	public Cliente[] getClientes() {
		return clientes;
	}
	
	public Cliente getCliente(int x) {
		return clientes[x];
	}

	public int getQuantClientes() {
		return quantClientes;
	}

}
