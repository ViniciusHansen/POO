package negocio;

import dados.*;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Usuario> users = new ArrayList<Usuario>();

	public void criaUsuario(String login, String senha, String nasc){
		Usuario u = new Usuario();
		u.setId(users.size());
		u.setNome(login);
		u.setSenha(senha);
        u.setDataNascimento(nasc);
		users.add(u);
	}

	public void deletarUsuario(Usuario u){
		users.remove(u);
	}

	public Usuario loginUsuario(String login, String senha){
		for(Usuario u : users)
			if(u.getNome().equals(login) && u.getSenha().equals(senha))
				return u;
		return null;
	}

	public void cadastrarFilme(Usuario usuario, Filme filme) {
		List<Conteudo> filmes = usuario.getFilmes();
		filme.setId(filmes.size());
		filmes.add(filme);
		usuario.setFilmes(filmes);
	}
	public boolean deletarFilme(Usuario usuario, Filme filme) {
		List<Conteudo> filmes = usuario.getFilmes();
		int antes = filmes.size();
		filmes.remove(filme);
		usuario.setFilmes(filmes);
		if(antes == filmes.size())
			return false;
		return true;
	}
	public void cadastrarSerie(Usuario usuario, Serie serie) {
		List<Conteudo> series = usuario.getSeries();
		serie.setId(series.size());
		series.add(serie);
		usuario.setSeries(series);
	}
	public boolean deletarSerie(Usuario usuario, Serie serie) {
		List<Conteudo> series = usuario.getSeries();
		int antes = series.size();
		series.remove(serie);
		usuario.setSeries(series);
		if(antes == series.size())
			return false;
		return true;
	}
	public List<Conteudo> getAllConteudo(Usuario usuario){
		List<Conteudo> all = new ArrayList<>();
		List<Conteudo> series = usuario.getSeries();
		List<Conteudo> filmes = usuario.getFilmes();
		all.addAll(filmes);
		all.addAll(series);
		return all;
	}
	public List<String> getAllCategorias(Usuario usuario){
		List<Conteudo> series = usuario.getSeries();
		List<String> cats = new ArrayList<>();
		for(Conteudo c : getAllConteudo(usuario))
			if(!cats.contains(c.getGenero()))
				cats.add(c.getGenero());
		return cats;
	}


	public List<Usuario> getUsers() {
		return users;
	}


	public List<Conteudo> exibirPorCategoria(Usuario user, String categoria) {
		List<Conteudo> filtro = new ArrayList<>();
		for(Conteudo c : getAllConteudo(user))
			if(c.getGenero().equals(categoria))
				filtro.add(c);
		return filtro;
			
	}

	public void addToElencoPrincipal(Conteudo conteudo, Ator ator) {
		List<Ator> elencoPrincipal = conteudo.getElencoPrincipal();
		elencoPrincipal.add(ator);
		conteudo.setElencoPrincipal(elencoPrincipal);
	}
	public void addToElencoSecundario(Conteudo conteudo, Ator ator) {
		List<Ator> elencoSecundario = conteudo.getElencoSecundario();
		elencoSecundario.add(ator);
		conteudo.setElencoSecundario(elencoSecundario);
	}

	public void cadastrarEpisodio(Serie serie, Episodio ep) {
		List<Episodio> episodios = serie.getEpisodios();
		episodios.add(ep);
		serie.setEpisodios(episodios);
	}

	public boolean deletarEpisodio(Serie serie, Episodio ep) {
		List<Episodio> episodios = serie.getEpisodios();
		int antes = episodios.size();
		episodios.remove(ep);
		serie.setEpisodios(episodios);
		if(antes == episodios.size())
			return false;
		return true;
	}

	public List<Conteudo> getSeries(Usuario usuario){
		return usuario.getSeries();
	}
}
