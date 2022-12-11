package negocio;

import dados.*;
import persistencia.FilmeDAO;
import persistencia.SerieDAO;
import persistencia.UsuarioDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    //private List<Usuario> users = new ArrayList<Usuario>();
    private UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
    private FilmeDAO filmeDAO = FilmeDAO.getInstance();
    private SerieDAO serieDAO = SerieDAO.getInstance();

    public void criaUsuario(String login, String senha, String nasc) throws SQLException {
        Usuario u = new Usuario();
        //u.setId(users.size());
        u.setNome(login);
        u.setSenha(senha);
        u.setDataNascimento(nasc);
        usuarioDAO.inserir(u);
        //users.add(u);
    }

    public void deletarUsuario(Usuario u) throws SQLException {
        usuarioDAO.remover(u);
        //users.remove(u);
    }

    public Usuario loginUsuario(String login, String senha) throws SQLException {
        List<Usuario> usuarios = usuarioDAO.listar();
        for (Usuario u : usuarios)
            if (u.getNome().equals(login) && u.getSenha().equals(senha))
                return u;
        return null;
    }

    public void cadastrarFilme(Usuario usuario, Filme filme) throws SQLException {
        filmeDAO.inserir(usuario, filme);
    }

    public void deletarFilme(Usuario usuario, Filme filme) throws SQLException {
        filmeDAO.remover(filme);
    }

    public void cadastrarSerie(Usuario usuario, Serie serie) throws SQLException {
        serieDAO.inserir(usuario,serie);
    }

    public void deletarSerie(Usuario usuario, Serie serie) throws SQLException {
        serieDAO.remover(serie);
    }

    public List<Conteudo> getAllConteudo(Usuario usuario) throws SQLException {
        List<Conteudo> all = new ArrayList<>();
        List<Conteudo> series = serieDAO.listar(usuario);
        List<Conteudo> filmes = filmeDAO.listar(usuario);
        all.addAll(filmes);
        all.addAll(series);
        return all;
    }

    public List<String> getAllCategorias(Usuario usuario) {
        List<Conteudo> series = usuario.getSeries();
        List<String> cats = new ArrayList<>();
        for (Conteudo c : getAllConteudo(usuario))
            if (!cats.contains(c.getGenero()))
                cats.add(c.getGenero());
        return cats;
    }


    public List<Usuario> getUsers() {
        return users;
    }


    public List<Conteudo> exibirPorCategoria(Usuario user, String categoria) {
        List<Conteudo> filtro = new ArrayList<>();
        for (Conteudo c : getAllConteudo(user))
            if (c.getGenero().equals(categoria))
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
        if (antes == episodios.size())
            return false;
        return true;
    }

    public List<Conteudo> getSeries(Usuario usuario) {
        return usuario.getSeries();
    }


    //ficava em usuario
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
