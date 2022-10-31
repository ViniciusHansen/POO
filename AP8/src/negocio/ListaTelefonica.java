package negocio;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

import dados.Contato;
import persistencia.ContatoDAO;

public class ListaTelefonica {
	private ContatoDAO contatos = new ContatoDAO();

	public void adicionarContato(Contato c) {
		contatos.insert(c);
	}
	
	public void removerContato(Contato c) {
		contatos.delete(c);
	}
	
	public ContatoDAO getContatos() {
		return contatos;
	}

	public void setContatos(ContatoDAO contatos) {
		this.contatos = contatos;
	}

	public List<Contato> buscarContatos(char letra){
		return contatos.getALL().get(letra);
	}
	
	public Map<Character,List<Contato>> buscarContatos(){
		return contatos.getALL();
	}
	
	

	@Override
	public String toString() {
		return "ListaTelefonica [contatos=" + contatos + "]";
	}
	
}
