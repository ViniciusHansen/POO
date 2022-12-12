package persistencia;

import dados.Episodio;
import dados.Serie;

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

    public int selectNextID() throws SQLException {
        String query = "select nextval('episodioID');";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        try{
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            //throw new SQLException("Erro ao achar o próximo ID no banco");
        }
        return 0;
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
                episodio.setSerieID(resultSet.getInt("serieID"));
                episodio.setNumeroEpisodio(resultSet.getInt("numero_episodio"));
                episodio.setDuracao((resultSet.getInt("duracao")));
                episodio.setDescricao(resultSet.getString("descricao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return episodio;
    }

    public List<Episodio> listar(Serie serie) throws SQLException {
        List<Episodio> episodios = new ArrayList<>();
        String query = "SELECT * FROM episodio WHERE serieID=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,serie.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Episodio episodio = new Episodio();
                episodio.setId(resultSet.getInt("episodioID"));
                episodio.setSerieID(resultSet.getInt("serieID"));
                episodio.setNumeroEpisodio(resultSet.getInt("numero_episodio"));
                episodio.setDuracao((resultSet.getInt("duracao")));
                episodio.setDescricao(resultSet.getString("descricao"));
                episodios.add(episodio);
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar Episodios");
        }
        return episodios;
    }

    public Episodio procurar(Serie serie, int numeroEp) throws SQLException{
        String query = "SELECT * FROM episodio WHERE serieID=? AND numero_episodio=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,serie.getId());
            preparedStatement.setInt(2,numeroEp);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Episodio episodio = new Episodio();
                episodio.setId(resultSet.getInt("episodioID"));
                episodio.setSerieID(resultSet.getInt("serieID"));
                episodio.setNumeroEpisodio(resultSet.getInt("numero_episodio"));
                episodio.setDuracao((resultSet.getInt("duracao")));
                episodio.setDescricao(resultSet.getString("descricao"));
                return episodio;
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar Episodio");
        }
        return null;
    }

    public void inserir(Episodio episodio, Serie serie) throws SQLException {
        String query = "INSERT INTO episodio(episodioID, serieID, numero_episodio, duracao, descricao) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,this.selectNextID());
            preparedStatement.setInt(2, serie.getId());
            preparedStatement.setInt(3,episodio.getNumeroEpisodio());
            preparedStatement.setInt(4, episodio.getDuracao());
            preparedStatement.setString(5, episodio.getDescricao());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir Episodio no Banco de Dados");
        }
    }

    public void alterar(Episodio episodio, Serie serie) throws SQLException {
        String query = "UPDATE episodio SET serieID=?, numero_episodio=?, duracao=?, descricao=? WHERE episodioId=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, serie.getId());
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
            e.printStackTrace();
            throw new SQLException("Erro ao deletar o Episodio do Banco de Dados");
        }
    }
}
