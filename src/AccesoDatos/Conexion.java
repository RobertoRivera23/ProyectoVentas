package AccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private static final String URL = "jdbc:mariadb://localhost/";// no colocar puerto por que tira error
    private static final String DB = "fravemax";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static Connection connection;

    // constructor vacio
    Conexion() {
    }

    public static Connection getConexion() {
        if (connection == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                try {
                    //conetamos a la BD
                    connection = DriverManager.getConnection(URL + DB + "?userLegacyDatetimeCode=false&serverTimezone=UTC"
                            + "&user=" + USUARIO + "&password=" + PASSWORD);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al conectarse a la BD." + ex.getMessage());
                }
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "error al cargar los Drivers" + ex.getMessage());
            }
        }
        return connection;
    }
}
