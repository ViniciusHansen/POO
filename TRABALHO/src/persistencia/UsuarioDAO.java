package persistencia;

import dados.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private static UsuarioDAO instance = null;
    private PreparedStatement selectUsuario;
    private  PreparedStatement insertUsuario;

    public static UsuarioDAO getInstance(){
        if(instance == null)
            instance = new UsuarioDAO();
        return instance;
    }

    private UsuarioDAO(){
        Connection connection = DataBaseConnection.getConnection();
        try{
            selectUsuario = connection.prepareStatement("select * from Usuario");
            insertUsuario = connection.prepareStatement("insert into Usuario (id, dataNascimento, nome, senha) values (?,?,?,?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario load(int code){
        ResultSet resultSet ;
        Usuario usuario = null;
        try{
            selectUsuario.setInt(1, code);
            resultSet = selectUsuario.executeQuery();
            if ( resultSet.next()){
                usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setDataNascimento(resultSet.getString("dataNascimento"));
                usuario.setSenha((resultSet.getString("senha")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
