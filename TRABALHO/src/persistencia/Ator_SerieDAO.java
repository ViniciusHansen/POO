package persistencia;

import dados.Ator;
import dados.Serie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Ator_SerieDAO {
    private static Ator_SerieDAO instance = null;
    private Connection connection;
    private final SerieDAO serieDAO = SerieDAO.getInstance();

    public static Ator_SerieDAO getInstance() {
        if (instance == null)
            instance = new Ator_SerieDAO();
        return instance;
    }
    private Ator_SerieDAO(){
        this.connection = DataBaseConnection.getConnection();
    }
    public void inserirElencoPrincipal(Ator ator, Serie serie) throws SQLException{
        String query = "INSERT INTO ator_serie (atorID, serieID, elencoprimario, elencosecundario) values (?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,ator.getId());
            preparedStatement.setInt(2,serie.getId());
            preparedStatement.setBoolean(3,true);
            preparedStatement.setBoolean(4, false);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new SQLException("Erro ao associar Serie e Ator");
        }
    }
    public void inserirElencoSecundario(Ator ator, Serie serie) throws SQLException{
        String query = "INSERT INTO ator_serie (atorID, serieID, elencoprimario, elencosecundario) values (?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,ator.getId());
            preparedStatement.setInt(2,serie.getId());
            preparedStatement.setBoolean(3,false);
            preparedStatement.setBoolean(4, true);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new SQLException("Erro ao associar Serie e Ator");
        }
    }
    public List<Ator> exibirElencoPrincipal(Serie serie) throws SQLException{
        String query = "SELECT * FROM ator_serie WHERE serieID=? AND elencoprimario=true";
        List<Ator> elencoPrincipal = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,serie.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Ator ator = new Ator();
                ator.setId(resultSet.getInt("atorID"));
                ator.setNome(resultSet.getString("nome"));
                ator.setDataNascimento(resultSet.getString("dataNascimento"));
                ator.setSexo(resultSet.getString("sexo"));
                elencoPrincipal.add(ator);
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao exibir elenco");
        }
        return elencoPrincipal;
    }
    public List<Ator> exibirElencoSecundario(Serie serie) throws SQLException{
        String query = "SELECT * FROM ator_serie WHERE serieID=? AND elencoSecundario=true";
        List<Ator> elencoSecundario = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,serie.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Ator ator = new Ator();
                ator.setId(resultSet.getInt("atorID"));
                ator.setNome(resultSet.getString("nome"));
                ator.setDataNascimento(resultSet.getString("dataNascimento"));
                ator.setSexo(resultSet.getString("sexo"));
                elencoSecundario.add(ator);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao exibir elenco");
        }
        return elencoSecundario;
    }
}
