package modelo_clases;

import java.sql.CallableStatement;
import java.sql.SQLException;

import DBClases.ConexionDB;

public class Cliente {
	
	private int idcliente;
	private String nombre;
	private String apellido;
	private String cedula;
	private String telefono;
	private String correo;
	private String direccion;
	private String tipo;
	public String estado;
	
	ConexionDB conexion;
	
	
	public Cliente(String nombre, String apellido, String cedula, String telefono, String correo, String direccion,
			String tipo) {
		super();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCedula(cedula);
		this.setTelefono(telefono);
		this.setCorreo(correo);
		this.setDireccion(direccion);
		this.setTipo(tipo);
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getIdcliente() {
		return idcliente;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCedula() {
		return cedula;
	}
	
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = "a";
	}
	
	//Metodos de cliente 
	
	
	public void ingresarCliente(Cliente cliente){
		conexion = new ConexionDB();
		conexion.conectar();
		try {
			String sentencia = "call ingresarcliente(?,?,?,?,?,?,?)";
			CallableStatement procedure = conexion.conn.prepareCall(sentencia);
			procedure.setString(1, cliente.getNombre());
			procedure.setString(2, cliente.getApellido());
			procedure.setString(3, cliente.getCedula());
			procedure.setString(4, cliente.getTelefono());
			procedure.setString(5, cliente.getCorreo());
			procedure.setString(6, cliente.getDireccion());
			procedure.setString(7, cliente.getTipo());
			procedure.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		conexion.cerrarConexion();
	}
	
	

}
