package modelo_clases;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

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
	
	String sentencia;
	CallableStatement procedure;
	ResultSet result = null;
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
		conexion = new ConexionDB();
	}
	

	public Cliente(int idcliente, String nombre, String apellido, String cedula, String telefono, String correo, String direccion,
			String tipo, String estado) {
		super();
		this.setIdcliente(idcliente);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCedula(cedula);
		this.setTelefono(telefono);
		this.setCorreo(correo);
		this.setDireccion(direccion);
		this.setTipo(tipo);
		this.setEstado(estado);
		conexion = new ConexionDB();
	}


	public Cliente() {
		super();
		this.conexion = conexion;
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
	
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
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
		this.estado = estado;
	}
	
	//Metodos de cliente 

	public void ingresarCliente(Cliente cliente){
		conexion.conectar();
		try {
			sentencia = "call ingresarcliente(?,?,?,?,?,?,?)";
			procedure = conexion.conn.prepareCall(sentencia);
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
	
	public void modificarCliente(int term, Cliente cliente){
		 conexion.conectar();
			try {
				sentencia = "call modificarcliente(?,?,?,?,?,?,?,?,?)";
				procedure = conexion.conn.prepareCall(sentencia);
				procedure.setInt(1, cliente.getIdcliente());
				procedure.setString(2, cliente.getNombre());
				procedure.setString(3, cliente.getApellido());
				procedure.setString(4, cliente.getCedula());
				procedure.setString(5, cliente.getTelefono());
				procedure.setString(6, cliente.getCorreo());
				procedure.setString(7, cliente.getDireccion());
				procedure.setString(8, cliente.getTipo());
				procedure.setString(9, cliente.getEstado());
				procedure.execute();
				procedure.close();
				conexion.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	 }
	
	
	public ArrayList<Cliente> listaClientes(){
		 ArrayList<Cliente> lista = new ArrayList<>();
		 conexion = new ConexionDB();
		 conexion.conectar();
			try {
				sentencia = "call consultar_todos_clientes()";
				procedure = conexion.conn.prepareCall(sentencia);
				procedure.execute();
				result = (ResultSet) procedure.executeQuery();
				 while (result.next()) {
					 Cliente cliente = new Cliente();
					 cliente.setNombre(result.getString("nombre"));
					 cliente.setApellido(result.getString("apellido"));
					 cliente.setCedula(result.getString("cedula"));
					 cliente.setTelefono(result.getString("telefono"));
					 cliente.setCorreo(result.getString("correo"));
					 cliente.setDireccion(result.getString("direccion"));
					 cliente.setTipo(result.getString("tipo"));
					 cliente.setEstado(result.getString("estado"));
					 if (cliente.getNombre() != null) {
						 lista.add(cliente);
					}
	             }
				procedure.close();
				conexion.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return lista;
	}
	
	public Cliente obtenerClientexNombre (String nombre){
		Cliente cliente = new Cliente();
		conexion.conectar();
		try {
			sentencia = "call consultar_cliente_nombre(?)";
			procedure = conexion.conn.prepareCall(sentencia);
			procedure.setString(1, nombre);
			procedure.execute();
			result = (ResultSet) procedure.executeQuery();
			while (result.next()) {
				 cliente.setNombre(result.getString("nombre"));
				 cliente.setApellido(result.getString("apellido"));
				 cliente.setCedula(result.getString("cedula"));
				 cliente.setTelefono(result.getString("telefono"));
				 cliente.setCorreo(result.getString("correo"));
				 cliente.setDireccion(result.getString("direccion"));
				 cliente.setTipo(result.getString("tipo"));
				 cliente.setEstado(result.getString("estado"));
             }
			procedure.close();
			conexion.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente; 
	 }

	
	 
	 
	 public ArrayList<Cliente> listaClientexNombre(String nombre){
		 ArrayList<Cliente> lista = new ArrayList<>();
		 conexion = new ConexionDB();
		 conexion.conectar();
			try {
				sentencia = "call consultar_cliente_nombre(?)";
				procedure = conexion.conn.prepareCall(sentencia);
				procedure.setString(1, nombre);
				procedure.execute();
				result = (ResultSet) procedure.executeQuery();
				while (result.next()) {
					Cliente cliente = new Cliente();
					cliente.setNombre(result.getString("nombre"));
					 cliente.setApellido(result.getString("apellido"));
					 cliente.setCedula(result.getString("cedula"));
					 cliente.setTelefono(result.getString("telefono"));
					 cliente.setCorreo(result.getString("correo"));
					 cliente.setDireccion(result.getString("direccion"));
					 cliente.setTipo(result.getString("tipo"));
					 cliente.setEstado(result.getString("estado"));
					if (cliente.getNombre() != null) {
						lista.add(cliente);
					}
	             }
				procedure.close();
				conexion.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return lista;
	 }
	 
	 public ArrayList<Cliente> listaClientesxApellido(String apellido){
		 ArrayList<Cliente> lista = new ArrayList<>();
		 conexion = new ConexionDB();
		 conexion.conectar();
			try {
				sentencia = "call consultar_cliente_apellido(?)";
				procedure = conexion.conn.prepareCall(sentencia);
				procedure.setString(1, apellido);
				procedure.execute();
				result = (ResultSet) procedure.executeQuery();
				while (result.next()) {
					Cliente cliente = new Cliente();
					cliente.setNombre(result.getString("nombre"));
					 cliente.setApellido(result.getString("apellido"));
					 cliente.setCedula(result.getString("cedula"));
					 cliente.setTelefono(result.getString("telefono"));
					 cliente.setCorreo(result.getString("correo"));
					 cliente.setDireccion(result.getString("direccion"));
					 cliente.setTipo(result.getString("tipo"));
					 cliente.setEstado(result.getString("estado"));
					if (cliente.getNombre() != null) {
						lista.add(cliente);
					}
	             }
				procedure.close();
				conexion.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return lista;
	 }
	
	 public ArrayList<Cliente> listaClientesxCedula(String cedula){
		 ArrayList<Cliente> lista = new ArrayList<>();
		 conexion = new ConexionDB();
		 conexion.conectar();
			try {
				sentencia = "call consultar_cliente_cedula(?)";
				procedure = conexion.conn.prepareCall(sentencia);
				procedure.setString(1, cedula);
				procedure.execute();
				result = (ResultSet) procedure.executeQuery();
				while (result.next()) {
					Cliente cliente = new Cliente();
					cliente.setNombre(result.getString("nombre"));
					 cliente.setApellido(result.getString("apellido"));
					 cliente.setCedula(result.getString("cedula"));
					 cliente.setTelefono(result.getString("telefono"));
					 cliente.setCorreo(result.getString("correo"));
					 cliente.setDireccion(result.getString("direccion"));
					 cliente.setTipo(result.getString("tipo"));
					 cliente.setEstado(result.getString("estado"));
					if (cliente.getNombre() != null) {
						lista.add(cliente);
					}
	             }
				procedure.close();
				conexion.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return lista;
	 }

	 //con id
	 
	 public ArrayList<Cliente> listaClientexNombreid(String nombre){
		 ArrayList<Cliente> lista = new ArrayList<>();
		 conexion = new ConexionDB();
		 conexion.conectar();
			try {
				sentencia = "call consultar_cliente_nombre(?)";
				procedure = conexion.conn.prepareCall(sentencia);
				procedure.setString(1, nombre);
				procedure.execute();
				result = (ResultSet) procedure.executeQuery();
				while (result.next()) {
					 Cliente cliente = new Cliente();
					 cliente.setIdcliente(result.getInt("idcliente"));
					 cliente.setNombre(result.getString("nombre"));
					 cliente.setApellido(result.getString("apellido"));
					 cliente.setCedula(result.getString("cedula"));
					 cliente.setTelefono(result.getString("telefono"));
					 cliente.setCorreo(result.getString("correo"));
					 cliente.setDireccion(result.getString("direccion"));
					 cliente.setTipo(result.getString("tipo"));
					 cliente.setEstado(result.getString("estado"));
					if (cliente.getNombre() != null) {
						lista.add(cliente);
					}
	             }
				procedure.close();
				conexion.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return lista;
	 }
	 
	 public ArrayList<Cliente> listaClientesxApellidoid(String apellido){
		 ArrayList<Cliente> lista = new ArrayList<>();
		 conexion = new ConexionDB();
		 conexion.conectar();
			try {
				sentencia = "call consultar_cliente_apellido(?)";
				procedure = conexion.conn.prepareCall(sentencia);
				procedure.setString(1, apellido);
				procedure.execute();
				result = (ResultSet) procedure.executeQuery();
				while (result.next()) {
					 Cliente cliente = new Cliente();
					 cliente.setIdcliente(result.getInt("idcliente"));
					 cliente.setNombre(result.getString("nombre"));
					 cliente.setApellido(result.getString("apellido"));
					 cliente.setCedula(result.getString("cedula"));
					 cliente.setTelefono(result.getString("telefono"));
					 cliente.setCorreo(result.getString("correo"));
					 cliente.setDireccion(result.getString("direccion"));
					 cliente.setTipo(result.getString("tipo"));
					 cliente.setEstado(result.getString("estado"));
					if (cliente.getNombre() != null) {
						lista.add(cliente);
					}
	             }
				procedure.close();
				conexion.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return lista;
	 }
	
	 public ArrayList<Cliente> listaClientesxCedulaid(String cedula){
		 ArrayList<Cliente> lista = new ArrayList<>();
		 conexion = new ConexionDB();
		 conexion.conectar();
			try {
				sentencia = "call consultar_cliente_cedula(?)";
				procedure = conexion.conn.prepareCall(sentencia);
				procedure.setString(1, cedula);
				procedure.execute();
				result = (ResultSet) procedure.executeQuery();
				while (result.next()) {
					 Cliente cliente = new Cliente();
					 cliente.setIdcliente(result.getInt("idcliente"));
					 cliente.setNombre(result.getString("nombre"));
					 cliente.setApellido(result.getString("apellido"));
					 cliente.setCedula(result.getString("cedula"));
					 cliente.setTelefono(result.getString("telefono"));
					 cliente.setCorreo(result.getString("correo"));
					 cliente.setDireccion(result.getString("direccion"));
					 cliente.setTipo(result.getString("tipo"));
					 cliente.setEstado(result.getString("estado"));
					if (cliente.getNombre() != null) {
						lista.add(cliente);
					}
	             }
				procedure.close();
				conexion.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return lista;
	 }
}
