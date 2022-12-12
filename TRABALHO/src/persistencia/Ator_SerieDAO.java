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
        String queryid = "SELECT atorID FROM ator_serie WHERE serieID=? AND elencoprimario=true";
        String queryAtor = "SELECT * FROM ator WHERE atorID=?";
        List<Ator> elencoPrincipal = new ArrayList<>();
        List<Integer> atoresIDs = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(queryid);
            preparedStatement.setInt(1,serie.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                atoresIDs.add(resultSet.getInt("atorID"));
            }
            for(int atorID : atoresIDs) {
                PreparedStatement ator = connection.prepareStatement(queryAtor);
                ator.setInt(1, atorID);
                ResultSet resultado = ator.executeQuery();
                while(resultado.next()){
                    Ator novoAtor = new Ator();
                    novoAtor.setId(atorID);
                    novoAtor.setNome(resultado.getString("nome"));
                    novoAtor.setDataNascimento(resultado.getString("dataNascimento"));
                    novoAtor.setSexo(resultado.getString("sexo"));
                    elencoPrincipal.add(novoAtor);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao exibir elenco");
        }
        return elencoPrincipal;
    }
    public List<Ator> exibirElencoSecundario(Serie serie) throws SQLException{
        String queryid = "SELECT atorID FROM ator_serie WHERE serieID=? AND elencosecundario=true";
        String queryAtor = "SELECT * FROM ator WHERE atorID=?";
        List<Ator> elencoSecundario = new ArrayList<>();
        List<Integer> atoresIDs = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(queryid);
            preparedStatement.setInt(1,serie.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                atoresIDs.add(resultSet.getInt("atorID"));
            }
            for(int atorID : atoresIDs) {
                PreparedStatement ator = connection.prepareStatement(queryAtor);
                ator.setInt(1, atorID);
                ResultSet resultado = ator.executeQuery();
                while(resultado.next()){
                    Ator novoAtor = new Ator();
                    novoAtor.setId(atorID);
                    novoAtor.setNome(resultado.getString("nome"));
                    novoAtor.setDataNascimento(resultado.getString("dataNascimento"));
                    novoAtor.setSexo(resultado.getString("sexo"));
                    elencoSecundario.add(novoAtor);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao exibir elenco");
        }
        return elencoSecundario;
    }
}
