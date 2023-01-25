package negocio;

import java.util.ArrayList;
import java.util.List;

import dados.Cliente;
import dados.Conta;

public class SistemaGestao {
	private List<Cliente> clientes = new ArrayList<Cliente>();

	public void adicionarCliente(Cliente c) {
		clientes.add(c);
	}
	public void adicionarClienteOuro(Cliente c) {
		clientes.add(c);
	}
	public void adicionarConta(Cliente c, Conta conta) {
		c.adicionarConta(conta);
	}
	public float getTotalMensalidades() {
		float sum = 0;
		for(Cliente c : clientes)
			sum+=c.getMensalidade();
		return sum;
	}
	public float getTotalDescontos() {
		float sum = 0;
		for(Cliente c : clientes)
			sum+=c.getDescontos();
		return sum;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public Cliente getCliente(int x) {
		return clientes.get(x);
	}
}
