package Secutel_ERP;

import java.sql.CallableStatement;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

public class TelefonoContacto {

	ContactoProveedor contacto;
	String numero;
	ConectBase conectar;
	String sentencia;
	CallableStatement proc;
	ResultSet result = null;
	
	public ContactoProveedor getContacto() {
		return contacto;
	}
	public void setContacto(ContactoProveedor contacto) {
		this.contacto = contacto;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public TelefonoContacto() {
		super();
		conectar = new ConectBase();
	}
	
	public TelefonoContacto(String numero) {
		super();
		this.numero = numero;
		conectar = new ConectBase();
	}
	public TelefonoContacto(ContactoProveedor contacto) {
		super();
		this.contacto = contacto;
	}
	public TelefonoContacto(ContactoProveedor contacto, String numero) {
		super();
		this.contacto = contacto;
		this.numero = numero;
	}
	void buscarTelefono(String numero){
		conectar.conectar();
		try {
			sentencia = "call buscarTelefono(?)";
			proc = conectar.conn.prepareCall(sentencia);
			proc.setString(1, numero);
			proc.execute();
			result = (ResultSet) proc.executeQuery();
			while (result.next()) {
				setNumero(result.getString("numero"));
            }
			if (getNumero() == null) {
				setNumero("");
			}
			proc.close();
			conectar.cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	int obtenerID(String cedula){
		conectar.conectar();
		int id = 0;
		try {
			sentencia = "call ObtenerIDContacto(?)";
			proc = conectar.conn.prepareCall(sentencia);
			proc.setString(1, cedula);
			proc.execute();
			result = (ResultSet) proc.executeQuery(); 
			while (result.next()) {
				id = result.getInt("idcontacto_proveedor");
            }
			proc.close();
			conectar.cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	void insertarTelefono(TelefonoContacto tel,String cedula){
		int id = 0;
		id = obtenerID(cedula);
		try {
			conectar.conectar();
			sentencia = "call insertarTelefono(?,?)";
			proc = conectar.conn.prepareCall(sentencia);
			proc.setInt(1, id);
			proc.setString(2, tel.getNumero());
			proc.execute();
			proc.close();
			conectar.cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}