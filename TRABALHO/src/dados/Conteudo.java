package dados;

import java.awt.*;
import java.util.List;

public abstract class Conteudo {
	protected int id, ano;
	protected String titulo, genero, descricao;
	protected List<Ator> elencoPrincipal, elencoSecundario;
	public Conteudo(String t, String gen, String desc, int a){
		this.titulo = t;
		this.descricao = desc;
		this.ano = a;
		this.genero = gen;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public List<Ator> getElencoPrincipal() {
		return elencoPrincipal;
	}
	public void addToElencoPrincipal(Ator ator) {
		elencoPrincipal.add(ator);
	}
	public List<Ator> getElencoSecundario() {
		return elencoSecundario;
	}
	public void addToElencoSecundario(Ator ator) {
		elencoSecundario.add(ator);
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
		return String.format("Título: %s | Descrição: %s | Gênero: %s | Ano: %d | Elenco Principal: %s | " +
				"Elenco Secundário: %s", titulo, descricao, genero, ano, elencoPrincipal, elencoSecundario);
	}

	
}
