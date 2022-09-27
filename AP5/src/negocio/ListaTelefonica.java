package negocio;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import dados.Contato;

public class ListaTelefonica {
	private Map<Character, List<Contato>> contatos = new HashMap<Character, List<Contato>>();
	
	public void adicionarContato(Contato c) {
        contatos.get(c.getNome().toUpperCase().charAt(0)).add(c);
	}
	
	public void removerContato(Contato c) {
		contatos.get(c.getNome().toUpperCase().charAt(0)).remove(c);
	}
	
	public List<Contato> buscarContatos(char letra){
		return contatos.get(letra);
	}
	
	public Map<Character,List<Contato>> buscarContatos(){
		return contatos;
	}
}
