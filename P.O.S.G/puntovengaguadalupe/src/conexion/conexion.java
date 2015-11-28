/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DEOCCIDENTE
 */
public class conexion {
        private static Connection cn = null;
   //private static String URL = "jdbc:mysql://localhost:3306/DBventasGuadalupe";
   private static String URL = "jdbc:mysql://localhost:8889/DBventasGuadalupe";
   //private static String usuario = "Administrador";
   //private static String contrasena ="Administrador1892014";
   private static String usuario = "root";
   private static String contrasena ="root";
   
   
   public static Connection getConexion() throws SQLException, ClassNotFoundException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        cn = (Connection) DriverManager.getConnection(URL, usuario, contrasena);
        return cn;
    }
}
