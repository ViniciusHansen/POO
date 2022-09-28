package negocio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import dados.Conteudo;
import dados.Episodio;
import dados.Filme;
import dados.Serie;
import dados.Usuario;

public class Sistema {
	private Usuario user =new Usuario();

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
	
	public Collection<String> exibirPorCategoria() {
		Map<Conteudo, String> cats = new HashMap<Conteudo, String>();
		
		for(Filme f : user.getFilmes())
			cats.put(f, f.getGenero());
		for(Serie s : user.getSeries())
			cats.put(s, s.getGenero());
		return cats.values();
			
	}
	
	public String exibirDescricao(Conteudo c) {
		return c.getDescricao();
	}
	
	public String xRay(Conteudo c) {
		return c.toString();
	}
	
}
