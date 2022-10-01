package negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import dados.Pessoa;

public class Sistema {
	private Map<String,List<Pessoa>> p = new HashMap<String,List<Pessoa>>();
	

	public Map<String, List<Pessoa>> getPessoas() {
		return p;
	}

	public Sistema() {
			List<Pessoa> ps = new ArrayList<Pessoa>();
			p.put("1-12", ps);
			p.put("13-18", ps);
			p.put("19-25", ps);
			p.put("26-59", ps);
			p.put("60+", ps);
	}
	
	public void addPessoa(Pessoa pessoa) {
		int i = pessoa.getIdade();
		if(i>=1 && i<=12) {
			p.get("1-12").add(pessoa);
			return;
		}
		if(i>=13 && i<= 18) {
			p.get("13-18").add(pessoa);
			return;
		}
		if(i>=19 && i<= 25) {
			p.get("19-25").add(pessoa);
			return;
		}
		if(i>=26 && i<= 59) {
			p.get("26-59").add(pessoa);
			return;
		}
		if(i>=60) {
			p.get("60+").add(pessoa);
			return;
		}
	}
}
