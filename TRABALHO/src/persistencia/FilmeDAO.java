package persistencia;


import dados.Filme;

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

    public Filme carregar(int code) {
        ResultSet resultSet;
        Filme filme = null;
        String query = "select * from Filme";
        try {
            PreparedStatement selectFilme = connection.prepareStatement(query);
            selectFilme.setInt(1, code);
            resultSet = selectFilme.executeQuery();
            if (resultSet.next()) {
                filme = new Filme();
                filme.setId(resultSet.getInt("FilmeID"));
                filme.setAno(resultSet.getInt("ano"));
                filme.setDuracao(resultSet.getInt("duracao"));
                filme.setTitulo(resultSet.getString("titulo"));
                filme.setGenero(resultSet.getString("genero"));
                filme.setDescricao(resultSet.getString("descricao"));
                filme.setCapa(resultSet.getBytes("capa"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filme;
    }

    public List<Filme> listar() throws SQLException {
        List<Filme> filmes = new ArrayList<>();
        String query = "SELECT * FROM filme";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Filme filme = new Filme();
                filme.setId(resultSet.getInt("FilmeID"));
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

    public void inserir(Filme filme) throws SQLException {
        String query = "INSERT INTO filme(titulo, ano, duracao, genero, descricao, capa) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,filme.getTitulo());
            preparedStatement.setInt(2, filme.getAno());
            preparedStatement.setInt(3, filme.getDuracao());
            preparedStatement.setString(4, filme.getGenero());
            preparedStatement.setString(5, filme.getDescricao());
            preparedStatement.setBytes(6,filme.getCapaBytes());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir Filme no Banco de Dados");
        }
    }

    public void alterar(Filme filme) throws SQLException {
        String query = "UPDATE filme SET titulo=?, ano=?, duracao=?, genero=?, descricao=?, capa=? WHERE filmeID=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,filme.getTitulo());
            preparedStatement.setInt(2, filme.getAno());
            preparedStatement.setInt(3, filme.getDuracao());
            preparedStatement.setString(4, filme.getGenero());
            preparedStatement.setString(5, filme.getDescricao());
            preparedStatement.setBytes(6,filme.getCapaBytes());
            preparedStatement.execute();
        } catch (SQLException e) {
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