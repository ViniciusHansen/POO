package dados;

import negocio.Sistema;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public abstract class Conteudo {
    protected int id;
    protected int ano;
    protected int usuarioID;
    protected String titulo, genero, descricao;
    protected byte[] capa;

    public Conteudo(String t, String gen, String desc, int a) {
        this.titulo = t;
        this.descricao = desc;
        this.ano = a;
        this.genero = gen;
    }

    public Conteudo() {
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public Icon getCapa() {
        if (capa == null)
            return null;
        ImageIcon icon = new ImageIcon(capa);
        Image img = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        Icon fim = new ImageIcon(img);
        return fim;
    }

    public void setCapa(byte[] capa) {
        this.capa = capa;
    }

    public byte[] getCapaBytes() {
        return this.capa;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
       Sistema sistema = new Sistema();
        try {
            return sistema.descricaoString(this);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}
