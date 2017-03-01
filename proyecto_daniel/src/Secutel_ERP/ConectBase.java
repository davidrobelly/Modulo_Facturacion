package Secutel_ERP;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConectBase {

	Connection conn = null;
	private String usu;
	private String pass;
	private String bd;
	private String url;
	
	public void conectar () {
		leerArchivo();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url,usu,pass);
		} 
		catch (SQLException ex) {
			System.out.println("hubo un problema al intentar conectarse a la base de datos: "+bd);
		}
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	public void cerrar() throws SQLException{
		conn.close();
	}
	private void leerArchivo() {
		  try {
		   Properties propiedades = new Properties();
		   propiedades.load(new FileInputStream("D:/eclipse/Secutel-ERP/proyecto_daniel/src/archivo.properties"));
		   usu = propiedades.getProperty("usu");
		   pass = propiedades.getProperty("pass");
		   bd = propiedades.getProperty("bd");
		   url = propiedades.getProperty("url")+bd;
		  } catch (FileNotFoundException e) {
		   System.out.println("Error, El archivo no exite");
		  } catch (IOException e) {
		   System.out.println("Error, No se puede leer el archivo");
		  }
	}
	
}
