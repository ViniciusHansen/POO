package dados;

import java.util.List;

public class Usuario {
	private int id;
	private String dataNascimento, nome, senha;
	private List<Filme> filmes;
	private List<Serie> series;
	
	public void cadastrarFilme(Filme filme) {
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
		series.add(serie);
	}
	
	public boolean removerSerie(Serie serie) {
		int antes = series.size();
		series.remove(serie);
		if(antes == series.size())
			return false;
		return true;
	}
	
	public List<Filme> getFilmes() {
		return filmes;
	}
	
	public Filme getFilme(int x) {
		return filmes.get(x);
	}
	
	public List<Serie> getSeries() {
		return series;
	}
	
	public Serie getSerie(int x){
		return series.get(x);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDataNascimento() {
		return dataNascimento;
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
