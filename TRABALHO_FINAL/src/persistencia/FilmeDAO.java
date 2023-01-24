package persistencia;


import dados.Conteudo;
import dados.Filme;
import dados.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {

    private static FilmeDAO instance = null;
    private Connection connection;

    public static FilmeDAO getInstance() {
        if (instance == null)
            instance = new FilmeDAO();
        return instance;
    }

    private FilmeDAO() {
        this.connection = DataBaseConnection.getConnection();
    }

    public int selectNextID() throws SQLException {
        String query = "select nextval('filmeID');";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            //throw new SQLException("Erro ao achar o próximo ID no banco");
        }
        return 0;
    }

    public Filme carregar(int code) {
        ResultSet resultSet;
        Filme filme = null;
        String query = "select * from filme where filmeID=?;";
        try {
            PreparedStatement selectFilme = connection.prepareStatement(query);
            selectFilme.setInt(1, code);
            resultSet = selectFilme.executeQuery();
            if (resultSet.next()) {
                filme = new Filme();
                filme.setId(code);
                filme.setAno(resultSet.getInt("ano"));
                filme.setDuracao(resultSet.getInt("duracao"));
                filme.setTitulo(resultSet.getString("titulo"));
                filme.setGenero(resultSet.getString("genero"));
                filme.setDescricao(resultSet.getString("descricao"));
                filme.setCapa(resultSet.getBytes("capa"));
                filme.setUsuarioID(resultSet.getInt("usuarioID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filme;
    }

    public List<Conteudo> listar(Usuario usuario) throws SQLException {
        List<Conteudo> filmes = new ArrayList<>();
        String query = "SELECT * FROM filme WHERE usuarioID=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, usuario.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Filme filme = new Filme();
                filme.setId(resultSet.getInt("filmeID"));
                filme.setAno(resultSet.getInt("ano"));
                filme.setDuracao(resultSet.getInt("duracao"));
                filme.setTitulo(resultSet.getString("titulo"));
                filme.setGenero(resultSet.getString("genero"));
                filme.setDescricao(resultSet.getString("descricao"));
                filme.setCapa(resultSet.getBytes("capa"));
                filmes.add(filme);
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao listar Filmes");
        }
        return filmes;
    }

    public void inserir(Usuario usuario, Filme filme) throws SQLException {
        String query = "INSERT INTO filme(filmeID, titulo, ano, duracao, genero, descricao, capa, usuarioID) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, this.selectNextID());
            preparedStatement.setString(2, filme.getTitulo());
            preparedStatement.setInt(3, filme.getAno());
            preparedStatement.setInt(4, filme.getDuracao());
            preparedStatement.setString(5, filme.getGenero());
            preparedStatement.setString(6, filme.getDescricao());
            preparedStatement.setBytes(7, filme.getCapaBytes());
            preparedStatement.setInt(8, usuario.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao inserir Filme no Banco de Dados");
        }
    }

    public void alterar(Filme filme) throws SQLException {
        String query = "UPDATE filme SET titulo=?, ano=?, duracao=?, genero=?, descricao=?, capa=?, usuarioID=? WHERE filmeID=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, filme.getTitulo());
            preparedStatement.setInt(2, filme.getAno());
            preparedStatement.setInt(3, filme.getDuracao());
            preparedStatement.setString(4, filme.getGenero());
            preparedStatement.setString(5, filme.getDescricao());
            preparedStatement.setBytes(6, filme.getCapaBytes());
            preparedStatement.setInt(7, filme.getUsuarioID());
            preparedStatement.setInt(8, filme.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao atualizar o Filme no Banco de Dados");
        }
    }

    public void remover(Filme filme) throws SQLException {
        String query = "DELETE FROM filme WHERE filmeID=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, filme.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar o Filme do Banco de Dados");
        }
    }
}
