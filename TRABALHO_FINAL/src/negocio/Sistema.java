package negocio;

import dados.*;
import persistencia.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
    private FilmeDAO filmeDAO = FilmeDAO.getInstance();
    private SerieDAO serieDAO = SerieDAO.getInstance();
    private EpisodioDAO episodioDAO = EpisodioDAO.getInstance();
    private Ator_FilmeDAO atorFilmeDAO = Ator_FilmeDAO.getInstance();
    private Ator_SerieDAO atorSerieDAO = Ator_SerieDAO.getInstance();
    private AtorDAO atorDAO = AtorDAO.getInstance();

    public void criaUsuario(String login, String senha, String nasc) throws SQLException {
        Usuario u = new Usuario();
        u.setNome(login);
        u.setSenha(senha);
        u.setDataNascimento(nasc);
        usuarioDAO.inserir(u);
    }

    public void deletarUsuario(Usuario u) throws SQLException {
        usuarioDAO.remover(u);
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

    public void deletarFilme(Filme filme) throws SQLException {
        filmeDAO.remover(filme);
    }

    public void cadastrarSerie(Usuario usuario, Serie serie) throws SQLException {
        serieDAO.inserir(usuario, serie);
    }

    public void deletarSerie(Serie serie) throws SQLException {
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

    public List<String> getAllCategorias(Usuario usuario) throws SQLException {
        List<String> cats = new ArrayList<>();
        for (Conteudo c : getAllConteudo(usuario))
            if (!cats.contains(c.getGenero()))
                cats.add(c.getGenero());
        return cats;
    }


    public List<Usuario> getUsers() throws SQLException {
        return usuarioDAO.listar();
    }


    public List<Conteudo> exibirPorCategoria(Usuario user, String categoria) throws SQLException {
        List<Conteudo> filtro = new ArrayList<>();
        for (Conteudo c : getAllConteudo(user))
            if (c.getGenero().equals(categoria))
                filtro.add(c);
        return filtro;

    }

    public void addToElencoPrincipal(Conteudo conteudo, Ator a) throws SQLException {
        int id = atorDAO.inserir(a);
        Ator ator = atorDAO.carregar(id);
        if (conteudo instanceof Filme)
            atorFilmeDAO.inserirElencoPrincipal(ator, (Filme) conteudo);
        else
            atorSerieDAO.inserirElencoPrincipal(ator, (Serie) conteudo);
    }

    public void addToElencoSecundario(Conteudo conteudo, Ator a) throws SQLException {
        int id = atorDAO.inserir(a);
        Ator ator = atorDAO.carregar(id);
        if (conteudo instanceof Filme)
            atorFilmeDAO.inserirElencoSecundario(ator, (Filme) conteudo);
        else
            atorSerieDAO.inserirElencoSecundario(ator, (Serie) conteudo);
    }

    public void cadastrarEpisodio(Serie serie, Episodio episodio) throws SQLException {
        episodioDAO.inserir(episodio, serie);
    }

    public void deletarEpisodio(Episodio episodio) throws SQLException {
        episodioDAO.remover(episodio);
    }

    public List<Conteudo> getSeries(Usuario usuario) throws SQLException {
        return serieDAO.listar(usuario);
    }

    public List<Conteudo> getFilmes(Usuario usuario) throws SQLException {
        return filmeDAO.listar(usuario);
    }

    public List<Ator> getElencoPrincipal(Filme filme) throws SQLException {
        return atorFilmeDAO.exibirElencoPrincipal(filme);
    }

    public List<Ator> getElencoPrincipal(Serie serie) throws SQLException {
        return atorSerieDAO.exibirElencoPrincipal(serie);
    }

    public List<Ator> getElencoSecundario(Filme filme) throws SQLException {
        return atorFilmeDAO.exibirElencoSecundario(filme);
    }

    public List<Ator> getElencoSecundario(Serie serie) throws SQLException {
        return atorSerieDAO.exibirElencoSecundario(serie);
    }

    public String getElencoPrincipalString(Filme filme) throws SQLException {
        String elenco1 = "";
        for (Ator ator : atorFilmeDAO.exibirElencoPrincipal(filme))
            elenco1 += ator.toString();
        return elenco1;
    }

    public String getElencoPrincipalString(Serie serie) throws SQLException {
        String elenco1 = "";
        for (Ator ator : atorSerieDAO.exibirElencoPrincipal(serie))
            elenco1 += ator.toString();
        return elenco1;
    }

    public String getElencoSecundarioString(Filme filme) throws SQLException {
        String elenco2 = "";
        for (Ator ator : atorFilmeDAO.exibirElencoSecundario(filme))
            elenco2 += ator.toString();
        return elenco2;
    }

    public String getElencoSecundarioString(Serie serie) throws SQLException {
        String elenco2 = "";
        for (Ator ator : atorSerieDAO.exibirElencoSecundario(serie))
            elenco2 += ator.toString();
        return elenco2;
    }

    public Episodio getEpisodio(Serie serie, int numeroEp) throws SQLException {
        return episodioDAO.procurar(serie, numeroEp);
    }

    public String getEpisodiosString(Serie serie) throws SQLException {
        String eps = "";
        for (Episodio e : episodioDAO.listar(serie))
            eps += e.toString();
        return eps;
    }


    public String descricaoString(Conteudo conteudo) throws SQLException {
        if (conteudo instanceof Serie) {
            Serie serie = (Serie) conteudo;
            return String.format("• Título: %s \n• Temporada: %d  \n• Descrição: %s \n• Gênero: %s \n• Ano: %d \n\n‣ Episódios: %s \n\n‣ Elenco Principal: %s \n\n‣" +
                            " Elenco Secundário: %s\n", serie.getTitulo(), serie.getTemporada(), serie.getDescricao(),
                    serie.getGenero(), serie.getAno(), this.getEpisodiosString(serie), this.getElencoPrincipalString(serie),
                    this.getElencoSecundarioString(serie));
        } else {
            Filme filme = (Filme) conteudo;
            return String.format("• Título: %s \n• Descrição: %s \n• Gênero: %s \n• Ano: %d \n• Duração: %d minutos \n\n‣ Elenco Principal: %s \n\n‣" +
                            " Elenco Secundário: %s", filme.getTitulo(), filme.getDescricao(), filme.getGenero(), filme.getAno(),
                    filme.getDuracao(), this.getElencoPrincipalString(filme), this.getElencoSecundarioString(filme));
        }
    }
}
