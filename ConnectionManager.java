
package business.entity;
    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String URL = "jdbc:mysql://localhost:3306/BusinessEntity";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() throws SQLException {
        try {
            // Registro el driver JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

           
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa");
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado: " + e.getMessage());
            throw new SQLException("No se pudo cargar el driver JDBC de MySQL.", e);
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage()); 
            throw e; 
        }
    }
}


