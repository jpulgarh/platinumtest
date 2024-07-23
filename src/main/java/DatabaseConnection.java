import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/Cuentas_clientes";
    private static final String USER = "jp";
    private static final String PASSWORD = "4r1c42012";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static ResultSet getPersonas() throws SQLException {
        String query = "SELECT * FROM persona";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public static ResultSet getEjecutivos() throws SQLException {
        String query = "SELECT * FROM ejecutivo";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public static int insertUsuario(String nombreUsuario, String password) throws SQLException {
        String query = "INSERT INTO usuario (nombre_usuario, password) VALUES ('" + nombreUsuario + "', '" + password + "')";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
    }
}
