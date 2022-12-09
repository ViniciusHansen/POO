package dados;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private int id;
	private String dataNascimento, nome, senha;
	private List<Conteudo> filmes = new ArrayList<>();
	private List<Conteudo> series = new ArrayList<>();

	public List<Conteudo> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Conteudo> filmes) {
		this.filmes = filmes;
	}

	public void setSeries(List<Conteudo> series) {
		this.series = series;
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
