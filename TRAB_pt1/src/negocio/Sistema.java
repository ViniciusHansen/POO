package negocio;

import dados.Conteudo;
import dados.Episodio;
import dados.Filme;
import dados.Serie;
import dados.Usuario;

public class Sistema {
	private Usuario user =new Usuario();

	/*+ cadastrarFilme(Filme): boolean
	+ cadastrarSerie(Serie): boolean
	+ cadastrarEp(Episodio): boolean
	+ deletarFilme(Filme): boolean
	+ deletarSerie(Serie): boolean
	+ deletarEp(Episodio): boolean
	+ exibirPorCategoria(): String
	+ exibirDescricao(Conteudo): String
	+ xRay(): String*/

	public boolean cadastrarFilme(Filme f) {
		user.cadastrarFilme(f);
		return true;
	}
	
	public boolean deletarFilme(Filme f) {
		return user.removerFilme(f);
	}

	public boolean cadastrarSerie(Serie s) {
		user.cadastrarSerie(s);
		return true;
	}
	
	public boolean deletarSerie(Serie s) {
		return user.removerSerie(s);
	}
	
	public boolean cadastrarEpisodio(Serie s, Episodio ep) {
		s.cadastrarEpisodio(ep);
		return true;
	}
	
	public boolean deletarEpisodio(Serie s, Episodio ep) {
		return s.removerEpisodio(ep);
	}
	
	public String exibirPorCategoria() {
		//to-do
	}
	
	public String exibirDescricao(Conteudo c) {
		return c.getDescricao();
	}
	
	public String xRay() {
		//to-do
	}
}
