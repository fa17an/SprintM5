package m5abpro1.Model.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static Connection conn = null;
	
	private Conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prevencion_riesgos","abprom5","1234");
			
			if (conn != null) {
				System.out.println("Conexion exitosa");
			} else {
				System.out.println("Conexion fallida");
			}
		
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		
		if (conn == null) {
			new Conexion();
		}
		
		return conn;
	}
	
	
	
}
