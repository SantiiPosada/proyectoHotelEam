package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author mateo gomez y santiago posada <santi.posdada.3075@eam.edu.co>
 */
public class Conexion {

    public static Connection getConnection() {
        Connection con = null;
        try {
            //Cargamos el driver
            Class.forName("com.mysql.jdbc.Driver");
            String db = "jdbc:mysql://localhost:3306/hotelAguaBlanca?useSSL=false";
            String user = "root";
            String password = "S1005073214";//Ingmateo1336
            //AGREGAR LIBRERIA JDBC
            con = DriverManager.getConnection(db, user, password);
        } catch (ClassNotFoundException ex) {
            System.err.println("Hubo un error al buscar la clase");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");
        }
        return con;
    }
}
