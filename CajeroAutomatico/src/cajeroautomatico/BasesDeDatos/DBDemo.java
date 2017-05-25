/**
 * DBDemo.java
 * Clase de prueba de conexion para la base de datos en mysql.
 *
 */
package cajeroautomatico.BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBDemo {

    public static void pruebaConexion() {
        Connection c = getConexion();
        if(c != null){
            System.out.println("Listo, conectado");
        }
    }
    
    public static Connection getConexion(){
        //primero hay que verificar que si esta el controlador de la base de datos
        Connection connection = null;
        try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		return null;
	}
	try {
		connection = DriverManager
		.getConnection("jdbc:mysql://localhost:3306/mydb","root", "");

	} catch (SQLException e) {
		return null;
	}
        return connection;
    }
}
