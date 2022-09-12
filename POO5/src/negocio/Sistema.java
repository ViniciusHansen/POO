package negocio;

import dados.ContaBancaria;
import java.util.ArrayList;

public class Sistema {
	ArrayList<ContaBancaria> contas;
	//ContaBancaria[] contas;
	private int quantidade;
	
	public Sistema() {
	
	}
	
	public void CadastrarConta(ContaBancaria conta) {
		contas.add(conta);
	}
	
	
	
}
