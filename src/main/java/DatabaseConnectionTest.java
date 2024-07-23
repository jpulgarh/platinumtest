import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {

    private static Connection connection;

    @BeforeAll
    public static void setUp() throws SQLException {
        connection = DatabaseConnection.getConnection();
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    public void testGetPersonas() throws SQLException {
        ResultSet resultSet = DatabaseConnection.getPersonas();
        assertNotNull(resultSet);

        int count = 0;
        while (resultSet.next()) {
            count++;
            System.out.println("rut: " + resultSet.getInt("rut") + ", Nombre: " + resultSet.getString("nombre"));
        }
        assertTrue(count > 0);
    }

    @Test
    public void testGetEjecutivos() throws SQLException {
        ResultSet resultSet = DatabaseConnection.getEjecutivos();
        assertNotNull(resultSet);

        int count = 0;
        while (resultSet.next()) {
            count++;
            System.out.println("rut: " + resultSet.getInt("rut") + ", Nombre: " + resultSet.getString("nombre"));
        }
        assertTrue(count > 0);
    }

    @Test
    public void testInsertUsuario() throws SQLException {
        int result = DatabaseConnection.insertUsuario("testuser", "testpassword");
        assertTrue(result > 0);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM usuario WHERE nombre_usuario = 'testuser'");
        assertTrue(resultSet.next());
    }
}