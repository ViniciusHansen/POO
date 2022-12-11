package dados;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Conteudo {
    protected int id, ano;
    protected String titulo, genero, descricao;
    protected List<Ator> elencoPrincipal = new ArrayList<>(); //tirar
    protected List<Ator> elencoSecundario = new ArrayList<>(); //tirar
    protected byte[] capa;

    public Icon getCapa() {
        if (capa == null)
            return null;
        ImageIcon icon = new ImageIcon(capa);
        Image img = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        Icon fim = new ImageIcon(img);
        return fim;
    }

    public byte[] getCapaBytes(){
        return this.capa;
    }

    public void setCapa(byte[] capa) {
        this.capa = capa;
    }

    public Conteudo(String t, String gen, String desc, int a) {
        this.titulo = t;
        this.descricao = desc;
        this.ano = a;
        this.genero = gen;
    }
    public Conteudo(){}
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

    public void setElencoPrincipal(List<Ator> elencoPrincipal) {
        this.elencoPrincipal = elencoPrincipal;
    }

    public void setElencoSecundario(List<Ator> elencoSecundario) {
        this.elencoSecundario = elencoSecundario;
    }

    public List<Ator> getElencoSecundario() {
        return elencoSecundario;
    }

    public int getId() {
        return id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getElenco1() {
        String elenco1 = new String();
        for (Ator a : elencoPrincipal)
            elenco1 += a.toString();
        return elenco1;
    }

    public String getElenco2() {
        String elenco2 = new String();
        for (Ator a : elencoSecundario)
            elenco2 += a.toString();
        return elenco2;
    }

}
