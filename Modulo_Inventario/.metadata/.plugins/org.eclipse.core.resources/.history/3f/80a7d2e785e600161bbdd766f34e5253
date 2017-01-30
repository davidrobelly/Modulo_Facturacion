package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BDProducto {
	
	Connection conexion;
	Statement stmtSQL;
	
	public void conectar () {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(ex.getMessage());
		}
		try {
			conexion = DriverManager.getConnection (
					"jdbc:mysql://localhost/secutel-erp?" +
					"user=root&password=1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		try {
			stmtSQL = conexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	

}
