package dados;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class Conteudo {
	protected int id, ano;
	protected String titulo, genero, descricao;
	protected List<Ator> elencoPrincipal = new ArrayList<>();
	protected List<Ator> elencoSecundario = new ArrayList<>();

	public Icon getCapa(){
		Icon icon = new ImageIcon(capa);
		return icon;
	}

	public void setCapa(byte[] capa) {
		this.capa = capa;
	}

	protected byte[] capa;
	public Conteudo(String t, String gen, String desc, int a){
		this.titulo = t;
		this.descricao = desc;
		this.ano = a;
		this.genero = gen;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getGenero() {
		return genero;
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

	public String toString() {
		return String.format("Título: %s | Descrição: %s | Gênero: %s | Ano: %d | Elenco Principal: %s | " +
				"Elenco Secundário: %s", titulo, descricao, genero, ano, elencoPrincipal, elencoSecundario);
	}
}
