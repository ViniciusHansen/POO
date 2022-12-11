package persistencia;


import dados.Serie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SerieDAO {

    private static SerieDAO instance = null;
    private Connection connection;

    public static SerieDAO getInstance() {
        if (instance == null)
            instance = new SerieDAO();
        return instance;
    }

    private SerieDAO() {
        this.connection = DataBaseConnection.getConnection();
    }

    public Serie carregar(int code) {
        ResultSet resultSet;
        Serie serie = null;
        String query = "select * from serie";
        try {
            PreparedStatement selectSerie = connection.prepareStatement(query);
            selectSerie.setInt(1, code);
            resultSet = selectSerie.executeQuery();
            if (resultSet.next()) {
                serie = new Serie();
                serie.setId(resultSet.getInt("SerieID"));
                serie.setAno(resultSet.getInt("ano"));
                serie.setTemporada(resultSet.getInt("temporada"));
                serie.setTitulo(resultSet.getString("titulo"));
                serie.setGenero(resultSet.getString("genero"));
                serie.setDescricao(resultSet.getString("descricao"));
                serie.setCapa(resultSet.getBytes("capa"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serie;
    }

    public List<Serie> listar() throws SQLException {
        List<Serie> series = new ArrayList<>();
        String query = "SELECT * FROM serie";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Serie serie = new Serie();
                serie.setId(resultSet.getInt("SerieID"));
                serie.setAno(resultSet.getInt("ano"));
                serie.setTemporada(resultSet.getInt("temporada"));
                serie.setTitulo(resultSet.getString("titulo"));
                serie.setGenero(resultSet.getString("genero"));
                serie.setDescricao(resultSet.getString("descricao"));
                serie.setCapa(resultSet.getBytes("capa"));
                series.add(serie);
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao listar Series");
        }
        return series;
    }

    public void inserir(Serie serie) throws SQLException {
        String query = "INSERT INTO serie(titulo, ano, temporada, genero, descricao, capa) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,serie.getTitulo());
            preparedStatement.setInt(2, serie.getAno());
            preparedStatement.setInt(3, serie.getTemporada());
            preparedStatement.setString(4, serie.getGenero());
            preparedStatement.setString(5, serie.getDescricao());
            preparedStatement.setBytes(6,serie.getCapaBytes());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir Serie no Banco de Dados");
        }
    }

    public void alterar(Serie serie) throws SQLException {
        String query = "UPDATE serie SET titulo=?, ano=?, temporada=?, genero=?, descricao=?, capa=? WHERE serieID=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,serie.getTitulo());
            preparedStatement.setInt(2, serie.getAno());
            preparedStatement.setInt(3, serie.getTemporada());
            preparedStatement.setString(4, serie.getGenero());
            preparedStatement.setString(5, serie.getDescricao());
            preparedStatement.setBytes(6,serie.getCapaBytes());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar o Serie no Banco de Dados");
        }
    }

    public void remover(Serie serie) throws SQLException {
        String query = "DELETE FROM serie WHERE serieID=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, serie.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar o Serie do Banco de Dados");
        }
    }
}
