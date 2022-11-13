package negocio;

import java.util.*;

import dados.Conteudo;
import dados.Episodio;
import dados.Filme;
import dados.Serie;
import dados.Usuario;

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

	public boolean cadastrarFilme(Usuario user,Filme f) {
		user.cadastrarFilme(f);
		return true;
	}
	
	public boolean deletarFilme(Usuario user, Filme f) {
		return user.removerFilme(f);
	}

	public List<Usuario> getUsers() {
		return users;
	}

	public boolean cadastrarSerie(Usuario user, Serie s) {
		user.cadastrarSerie(s);
		return true;
	}
	
	public boolean deletarSerie(Usuario user, Serie s) {
		return user.removerSerie(s);
	}
	
	public boolean cadastrarEpisodio(Serie s, Episodio ep) {
		s.cadastrarEpisodio(ep);
		return true;
	}
	
	public boolean deletarEpisodio(Serie s, Episodio ep) {
		return s.removerEpisodio(ep);
	}
	
	public List<Conteudo> exibirPorCategoria(Usuario user, String categoria) {
		List<Conteudo> filtro = new ArrayList<>();
		for(Conteudo c : user.getAllConteudo())
			if(c.getGenero().equals(categoria))
				filtro.add(c);
		return filtro;
			
	}

}
