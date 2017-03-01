package DBClases;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import modelo_clases.Cliente;

@SuppressWarnings("unused")
public class ConexionDB {

	public Connection conn = null;
	public String usu;
	public String pass;
	public String bd;
	public String url;
	
	public void conectar () {
		leerArchivo();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url,usu,pass);
			//System.out.println("conexion a base de datos exitosa");
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
	
	public void cerrarConexion()  {
	  	try {
		   conn.close();
		   //System.out.println ("Conexion cerrada exitosamente.");  
		}catch (SQLException  ex) {
			                                
		}
	}
	
	private void leerArchivo() {
		  try {
		   
		//Creamos un Objeto de tipo Properties//
		   Properties propiedades = new Properties();
		    
		   //Cargamos el archivo desde la ruta especificada//
		   
		   InputStream pin = getClass().getClassLoader().getResourceAsStream("archivo.properties");
		   propiedades.load(pin);
		   
		   //Obtenemos los parametros definidos en el archivo//
		   usu = propiedades.getProperty("usu");
		   pass = propiedades.getProperty("pass");
		   bd = propiedades.getProperty("bd");
		   url = propiedades.getProperty("url")+bd;
		   //Imprimimos los valores// 
		  } catch (FileNotFoundException e) {
		  
			  System.out.println("Error, El archivo no existe");
		  } catch (IOException e) {
			  System.out.println("Error, No se puede leer el archivo");
		  
		  }
	}
	
}
