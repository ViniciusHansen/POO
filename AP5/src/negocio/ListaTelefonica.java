package negocio;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import dados.Contato;

public class ListaTelefonica {
	private List<Contato> contatos = new ArrayList<Contato>();
	
	public void adicionarContato(Contato c) {
		contatos.add(c);
	}
	
	public void removerContato(Contato c) {
		contatos.remove(c);
	}
	
	public List<Contato> buscarContato(char letra){
		List<Contato> cs = new ArrayList<Contato>();
		for(Contato c : contatos)
			if(c.getNome().charAt(0) == letra)
				cs.add(c);
		return cs;
	}
	
	public Map<Character,List<Contato>> buscarContato(){
		Map<Character,List<Contato>> cs = new HashMap<Character,List<Contato>>();
		for(Contato c : contatos)
	}
}
