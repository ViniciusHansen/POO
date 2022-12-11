package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    static private Connection connection = null;

    static public Connection getConnection() {
        if (connection == null) {
            String url = "jdbc:postgresql://localhost:5432/catalogo";
            String username = "postgres";
            String password = "postgres";
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
