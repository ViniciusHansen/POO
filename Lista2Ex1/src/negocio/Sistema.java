package negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dados.Pessoa;

public class Sistema {
	private Map<Integer,List<Pessoa>> p = new HashMap<Integer,List<Pessoa>>();
	

	public Map<Integer, List<Pessoa>> getPessoas() {
		return p;
	}

	public Sistema() {
		for(int i=1;i<=5;i++) {
			List<Pessoa> ps = new ArrayList<Pessoa>();
			p.put(i, ps);
		}
	}
	
	public void addPessoa(Pessoa pessoa) {
		int i = pessoa.getIdade();
		if(i>=1 && i<=12) {
			p.get(1).add(pessoa);//1-12
		}
		else if(i>=13 && i<= 18) {
			p.get(2).add(pessoa);//13-18
		}
		else if(i>=19 && i<= 25) {
			p.get(3).add(pessoa);//19-25
		}
		else if(i>=26 && i<= 59) {
			p.get(4).add(pessoa);//26-59
		}
		else if(i>=60) {
			p.get(5).add(pessoa);//60+
		}
	}
}
