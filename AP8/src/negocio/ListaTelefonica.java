package negocio;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

import dados.Contato;

public class ListaTelefonica {
	private Map<Character, List<Contato>> contatos = new HashMap<Character, List<Contato>>();
	
	 public ListaTelefonica() {
		 for (char i = 65; i < 91; i++) {
			 List<Contato> lista = new LinkedList<Contato>();
	         contatos.put(i, lista);
		 }
	 }
	
	public void adicionarContato(Contato c) {	
		contatos.get(c.getNome().toUpperCase().charAt(0)).add(c);
	}
	
	public void removerContato(Contato c) {
		contatos.get(c.getNome().toUpperCase().charAt(0)).remove(c);
	}
	
	public Map<Character, List<Contato>> getContatos() {
		return contatos;
	}

	public void setContatos(Map<Character, List<Contato>> contatos) {
		this.contatos = contatos;
	}

	public List<Contato> buscarContatos(char letra){
		return contatos.get(letra);
	}
	
	public Map<Character,List<Contato>> buscarContatos(){
		return contatos;
	}
	
	

	@Override
	public String toString() {
		return "ListaTelefonica [contatos=" + contatos + "]";
	}
	
}
