package persistencia;

import dados.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private static UsuarioDAO instance = null;
    private PreparedStatement selectUsuario;
    private PreparedStatement insertUsuario;
    private Connection connection;

    public static UsuarioDAO getInstance() {
        if (instance == null)
            instance = new UsuarioDAO();
        return instance;
    }

    private UsuarioDAO() {
        Connection connection = DataBaseConnection.getConnection();
    }

    public Usuario carregar(int code) {
        ResultSet resultSet;
        Usuario usuario = null;
        String query = "select * from Usuario";
        try {
            PreparedStatement selectUsuario = connection.prepareStatement(query);
            selectUsuario.setInt(1, code);
            resultSet = selectUsuario.executeQuery();
            if (resultSet.next()) {
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

    public List<Usuario> listar() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query ="SELECT * FROM usuario";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("UsuarioID"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setDataNascimento(resultSet.getString("dataNascimento"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar Usuario");
        }
        return usuarios;
    }

    public void inserir(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuario(nome, senha, dataNascimento) VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getSenha());
            preparedStatement.setString(3, usuario.getDataNascimento());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir Usuario no Banco de Dados");
        }
    }

    public void alterar(Usuario usuario) throws SQLException {
        String query = "UPDATE usuario SET nome=?, senha=?, dataNascimento=? WHERE usuarioID=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getSenha());
            preparedStatement.setString(3, usuario.getDataNascimento());
            preparedStatement.setInt(4, usuario.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar o Usuario no Banco de Dados");
        }
    }

    public void remover(Usuario usuario) throws SQLException {
        String query = "DELETE FROM usuario WHERE usuarioID=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, usuario.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar o Usuario no Banco de Dados");
        }
    }
}
