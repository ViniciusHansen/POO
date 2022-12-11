package persistencia;

import dados.Episodio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EpisodioDAO {
    private static EpisodioDAO instance = null;
    private Connection connection;

    public static EpisodioDAO getInstance() {
        if (instance == null)
            instance = new EpisodioDAO();
        return instance;
    }

    private EpisodioDAO() {
        this.connection = DataBaseConnection.getConnection();
    }

    public Episodio carregar(int code) {
        ResultSet resultSet;
        Episodio episodio = null;
        String query = "select * from Episodio";
        try {
            PreparedStatement selectEpisodio = connection.prepareStatement(query);
            selectEpisodio.setInt(1, code);
            resultSet = selectEpisodio.executeQuery();
            if (resultSet.next()) {
                episodio = new Episodio();
                episodio.setId(resultSet.getInt("episodioID"));
                episodio.setNomeSerie(resultSet.getString("nome_serie"));
                episodio.setNumeroEpisodio(resultSet.getInt("numero_episodio"));
                episodio.setDuracao((resultSet.getInt("duracao")));
                episodio.setDescricao(resultSet.getString("descricao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return episodio;
    }

    public List<Episodio> listar() throws SQLException {
        List<Episodio> episodioes = new ArrayList<>();
        String query = "SELECT * FROM episodio";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Episodio episodio = new Episodio();
                episodio.setId(resultSet.getInt("episodioID"));
                episodio.setNomeSerie(resultSet.getString("nome_serie"));
                episodio.setNumeroEpisodio(resultSet.getInt("numero_episodio"));
                episodio.setDuracao((resultSet.getInt("duracao")));
                episodio.setDescricao(resultSet.getString("descricao"));
                episodioes.add(episodio);
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar Episodio");
        }
        return episodioes;
    }

    public void inserir(Episodio episodio) throws SQLException {
        String query = "INSERT INTO episodio(nome_serie, numero_episodio, duracao, descricao) VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, episodio.getNomeSerie());
            preparedStatement.setInt(2,episodio.getNumeroEpisodio());
            preparedStatement.setInt(3, episodio.getDuracao());
            preparedStatement.setString(4, episodio.getDescricao());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir Episodio no Banco de Dados");
        }
    }

    public void alterar(Episodio episodio) throws SQLException {
        String query = "UPDATE episodio SET nome_serie=?, numero_episodio=?, duracao=?, descricao=? WHERE episodioId=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, episodio.getNomeSerie());
            preparedStatement.setInt(2,episodio.getNumeroEpisodio());
            preparedStatement.setInt(3, episodio.getDuracao());
            preparedStatement.setString(4, episodio.getDescricao());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar o Episodio no Banco de Dados");
        }
    }

    public void remover(Episodio episodio) throws SQLException {
        String query = "DELETE FROM episodio WHERE episodioId=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, episodio.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar o Episodio do Banco de Dados");
        }
    }
}
