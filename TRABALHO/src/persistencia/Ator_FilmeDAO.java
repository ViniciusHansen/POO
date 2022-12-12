package persistencia;

import dados.Ator;
import dados.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Ator_FilmeDAO {
    private static Ator_FilmeDAO instance = null;
    private Connection connection;

    public static Ator_FilmeDAO getInstance() {
        if (instance == null)
            instance = new Ator_FilmeDAO();
        return instance;
    }
    private Ator_FilmeDAO(){
        this.connection = DataBaseConnection.getConnection();
    }
    public void inserirElencoPrincipal(Ator ator, Filme filme) throws SQLException{
        String query = "INSERT INTO ator_filme (atorID, filmeID, elencoprimario, elencosecundario) values (?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,ator.getId());
            preparedStatement.setInt(2,filme.getId());
            preparedStatement.setBoolean(3,true);
            preparedStatement.setBoolean(4, false);
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            throw new SQLException("Erro ao associar Filme e Ator");
        }
    }
    public void inserirElencoSecundario(Ator ator, Filme filme) throws SQLException{
        String query = "INSERT INTO ator_filme (atorID, filmeID, elencoprimario, elencosecundario) values (?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,ator.getId());
            preparedStatement.setInt(2,filme.getId());
            preparedStatement.setBoolean(3,false);
            preparedStatement.setBoolean(4, true);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new SQLException("Erro ao associar Filme e Ator");
        }
    }
    public List<Ator> exibirElencoPrincipal(Filme filme) throws SQLException{
        String query = "SELECT * FROM ator_filme WHERE filmeID=? AND elencoprimario=true";
        List<Ator> elencoPrincipal = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, filme.getId());
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
            e.printStackTrace();
            throw new SQLException("Erro ao exibir elenco");
        }
        return elencoPrincipal;
    }
    public List<Ator> exibirElencoSecundario(Filme filme) throws SQLException{
        String query = "SELECT * FROM ator_filme WHERE filmeID=? AND elencoSecundario=true";
        List<Ator> elencoSecundario = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, filme.getId());
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
