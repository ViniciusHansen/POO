package dados;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private int id;
	private String dataNascimento, nome, senha;
	private List<Conteudo> filmes = new ArrayList<>();
	private List<Conteudo> series = new ArrayList<>();
	
	public void cadastrarFilme(Filme filme) {
		filme.setId(filmes.size());
		filmes.add(filme);
	}
	public boolean removerFilme(Filme filme) {
		int antes = filmes.size();
		filmes.remove(filme);
		if(antes == filmes.size())
			return false;
		return true;
	}
	public void cadastrarSerie(Serie serie) {
		serie.setId(series.size());
		series.add(serie);
	}
	public boolean removerSerie(Serie serie) {
		int antes = series.size();
		series.remove(serie);
		if(antes == series.size())
			return false;
		return true;
	}
	public List<Conteudo> getAllConteudo(){
		List<Conteudo> all = new ArrayList<>();
		all.addAll(filmes);
		all.addAll(series);
		return all;
	}
	public List<String> getAllCategorias(){
		List<String> cats = new ArrayList<>();
		for(Conteudo c : getAllConteudo())
			if(!cats.contains(c.getGenero()))
				cats.add(c.getGenero());
		return cats;
	}

	public List<Conteudo> getSeries() {
		return series;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String toString() {
		return "Usuario [id=" + id + ", dataNascimento=" + dataNascimento + ", nome=" + nome + ", senha=" + senha
				+ ", filmes=" + filmes + ", series=" + series + "]";
	}

	
}
