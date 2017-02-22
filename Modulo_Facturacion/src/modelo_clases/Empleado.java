package modelo_clases;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import DBClases.ConexionDB;

public class Empleado {

	private int idempleado;
	private String nombre;
	private String apellido;
	private String cedula;
	private String telefono;
	private String direccion;
	private int edad;
	private String tipo;
	public String estado; 
	ConexionDB conexion;
	
	String sentencia;
	CallableStatement procedure;
	ResultSet result = null;
	
	
	
	public Empleado(String nombre, String apellido, String cedula, String telefono, String direccion, int edad,
			String tipo) {
		super();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCedula(cedula);
		this.setTelefono(telefono);
		this.setDireccion(direccion);
		this.setEdad(edad);
		this.setTipo(tipo);
		conexion = new ConexionDB();
	}
	
	public Empleado(int idempleado, String nombre, String apellido, String cedula, String telefono, String direccion, int edad,
			String tipo, String estado) {
		super();
		this.setIdempleado(idempleado);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCedula(cedula);
		this.setTelefono(telefono);
		this.setDireccion(direccion);
		this.setEdad(edad);
		this.setTipo(tipo);
		this.setEstado(estado);
		conexion = new ConexionDB();
	}

	
	public Empleado() {
		super();
		this.conexion= conexion;
	}
	
	
	public Empleado(int idempleado, String nombre, String apellido, String cedula) {
		super();
		this.setIdempleado(idempleado);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCedula(cedula);
		conexion = new ConexionDB();
	}


	public Empleado(String nombre, String apellido, String cedula, String telefono, String direccion, int edad,
			String tipo, String estado) {
		super();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCedula(cedula);
		this.setTelefono(telefono);
		this.setDireccion(direccion);
		this.setEdad(edad);
		this.setTipo(tipo);
		this.setEstado(estado);
		conexion = new ConexionDB();
	}

	


	public int getIdempleado() {
		return idempleado;
	}


	public void setIdempleado(int idempleado) {
		this.idempleado = idempleado;
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
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
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
	
	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	
	//metodos de empleado
	
	

	public void ingresarEmpleado(Empleado empleado){
		conexion = new ConexionDB();
		conexion.conectar();
		try {
			sentencia = "call ingresarempleado(?,?,?,?,?,?,?)";
			procedure = conexion.conn.prepareCall(sentencia);
			procedure.setString(1, empleado.getNombre());
			procedure.setString(2, empleado.getApellido());
			procedure.setString(3, empleado.getCedula());
			procedure.setString(4, empleado.getTelefono());
			procedure.setString(5, empleado.getDireccion());
			procedure.setInt(6, empleado.getEdad());
			procedure.setString(7, empleado.getTipo());
			procedure.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		conexion.cerrarConexion();
	}
	
	
	public void modificarEmpleado(int term, Empleado empleado){
		 conexion.conectar();
			try {
				sentencia = "call modificarempleado(?,?,?,?,?,?,?,?,?)";
				procedure = conexion.conn.prepareCall(sentencia);
				
				procedure.setInt(1, empleado.getIdempleado());
				procedure.setString(2, empleado.getNombre());
				procedure.setString(3, empleado.getApellido());
				procedure.setString(4, empleado.getCedula());
				procedure.setString(5, empleado.getTelefono());
				procedure.setString(6, empleado.getDireccion());
				procedure.setInt(7, empleado.getEdad());
				procedure.setString(8, empleado.getTipo());
				procedure.setString(9, empleado.getEstado());
				procedure.execute();
				procedure.close();
				conexion.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	 }

	public ArrayList<Empleado> listaEmpleados(){
		 ArrayList<Empleado> lista = new ArrayList<>();
		 conexion = new ConexionDB();
		 conexion.conectar();
			try {
				sentencia = "call consultar_todos_empleados()";
				procedure = conexion.conn.prepareCall(sentencia);
				procedure.execute();
				result = (ResultSet) procedure.executeQuery();
				 while (result.next()) {
					 Empleado empleado = new Empleado();
					 empleado.setNombre(result.getString("nombre"));
					 empleado.setApellido(result.getString("apellido"));
					 empleado.setCedula(result.getString("cedula"));
					 empleado.setTelefono(result.getString("telefono"));
					 empleado.setDireccion(result.getString("direccion"));
					 empleado.setEdad(result.getInt("edad"));
					 empleado.setTipo(result.getString("tipo"));
					 empleado.setEstado(result.getString("estado"));
					 if (empleado.getNombre() != null) {
						 lista.add(empleado);
					}
	             }
				procedure.close();
				conexion.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return lista;
	}
	

	
	 
	 
	//sin id
	 public ArrayList<Empleado> listaEmpleadoxNombre(String nombre){
		 ArrayList<Empleado> lista = new ArrayList<>();
		 conexion = new ConexionDB();
		 conexion.conectar();
			try {
				sentencia = "call consultar_empleado_nombre(?)";
				procedure = conexion.conn.prepareCall(sentencia);
				procedure.setString(1, nombre);
				procedure.execute();
				result = (ResultSet) procedure.executeQuery();
				while (result.next()) {
					Empleado empleado = new Empleado();
					 empleado.setNombre(result.getString("nombre"));
					 empleado.setApellido(result.getString("apellido"));
					 empleado.setCedula(result.getString("cedula"));
					 empleado.setTelefono(result.getString("telefono"));
					 empleado.setDireccion(result.getString("direccion"));
					 empleado.setEdad(result.getInt("edad"));
					 empleado.setTipo(result.getString("tipo"));
					 empleado.setEstado(result.getString("estado"));
					if (empleado.getNombre() != null) {
						lista.add(empleado);
					}
	             }
				procedure.close();
				conexion.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return lista;
	 }
	 
	 public ArrayList<Empleado> listaEmpeladosxApellido(String apellido){
		 ArrayList<Empleado> lista = new ArrayList<>();
		 conexion = new ConexionDB();
		 conexion.conectar();
			try {
				sentencia = "call consultar_empleado_apellido(?)";
				procedure = conexion.conn.prepareCall(sentencia);
				procedure.setString(1, apellido);
				procedure.execute();
				result = (ResultSet) procedure.executeQuery();
				while (result.next()) {
					Empleado empleado = new Empleado();
					 empleado.setNombre(result.getString("nombre"));
					 empleado.setApellido(result.getString("apellido"));
					 empleado.setCedula(result.getString("cedula"));
					 empleado.setTelefono(result.getString("telefono"));
					 empleado.setDireccion(result.getString("direccion"));
					 empleado.setEdad(result.getInt("edad"));
					 empleado.setTipo(result.getString("tipo"));
					 empleado.setEstado(result.getString("estado"));
					if (empleado.getNombre() != null) {
						lista.add(empleado);
					}
	             }
				procedure.close();
				conexion.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return lista;
	 }
	
	 public ArrayList<Empleado> listaEmpleadosxCedula(String cedula){
		 ArrayList<Empleado> lista = new ArrayList<>();
		 conexion = new ConexionDB();
		 conexion.conectar();
			try {
				sentencia = "call consultar_empleado_cedula(?)";
				procedure = conexion.conn.prepareCall(sentencia);
				procedure.setString(1, cedula);
				procedure.execute();
				result = (ResultSet) procedure.executeQuery();
				while (result.next()) {
					Empleado empleado = new Empleado();
					 empleado.setNombre(result.getString("nombre"));
					 empleado.setApellido(result.getString("apellido"));
					 empleado.setCedula(result.getString("cedula"));
					 empleado.setTelefono(result.getString("telefono"));
					 empleado.setDireccion(result.getString("direccion"));
					 empleado.setEdad(result.getInt("edad"));
					 empleado.setTipo(result.getString("tipo"));
					 empleado.setEstado(result.getString("estado"));
					if (empleado.getNombre() != null) {
						lista.add(empleado);
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
		 public ArrayList<Empleado> listaEmpleadoxNombreid(String nombre){
			 ArrayList<Empleado> lista = new ArrayList<>();
			 conexion = new ConexionDB();
			 conexion.conectar();
				try {
					sentencia = "call consultar_empleado_nombre(?)";
					procedure = conexion.conn.prepareCall(sentencia);
					procedure.setString(1, nombre);
					procedure.execute();
					result = (ResultSet) procedure.executeQuery();
					while (result.next()) {
						 Empleado empleado = new Empleado();
						 empleado.setIdempleado(result.getInt("idempleado"));
						 empleado.setNombre(result.getString("nombre"));
						 empleado.setApellido(result.getString("apellido"));
						 empleado.setCedula(result.getString("cedula"));
						 empleado.setTelefono(result.getString("telefono"));
						 empleado.setDireccion(result.getString("direccion"));
						 empleado.setEdad(result.getInt("edad"));
						 empleado.setTipo(result.getString("tipo"));
						 empleado.setEstado(result.getString("estado"));
						if (empleado.getNombre() != null) {
							lista.add(empleado);
						}
		             }
					procedure.close();
					conexion.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 return lista;
		 }
		 
		 public ArrayList<Empleado> listaEmpeladosxApellidoid(String apellido){
			 ArrayList<Empleado> lista = new ArrayList<>();
			 conexion = new ConexionDB();
			 conexion.conectar();
				try {
					sentencia = "call consultar_empleado_apellido(?)";
					procedure = conexion.conn.prepareCall(sentencia);
					procedure.setString(1, apellido);
					procedure.execute();
					result = (ResultSet) procedure.executeQuery();
					while (result.next()) {
						 Empleado empleado = new Empleado();
						 empleado.setIdempleado(result.getInt("idempleado"));
						 empleado.setNombre(result.getString("nombre"));
						 empleado.setApellido(result.getString("apellido"));
						 empleado.setCedula(result.getString("cedula"));
						 empleado.setTelefono(result.getString("telefono"));
						 empleado.setDireccion(result.getString("direccion"));
						 empleado.setEdad(result.getInt("edad"));
						 empleado.setTipo(result.getString("tipo"));
						 empleado.setEstado(result.getString("estado"));
						if (empleado.getNombre() != null) {
							lista.add(empleado);
						}
		             }
					procedure.close();
					conexion.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 return lista;
		 }
		
		 public ArrayList<Empleado> listaEmpleadosxCedulaid(String cedula){
			 ArrayList<Empleado> lista = new ArrayList<>();
			 conexion = new ConexionDB();
			 conexion.conectar();
				try {
					sentencia = "call consultar_empleado_cedula(?)";
					procedure = conexion.conn.prepareCall(sentencia);
					procedure.setString(1, cedula);
					procedure.execute();
					result = (ResultSet) procedure.executeQuery();
					while (result.next()) {
						 Empleado empleado = new Empleado();
						 empleado.setIdempleado(result.getInt("idempleado"));
						 empleado.setNombre(result.getString("nombre"));
						 empleado.setApellido(result.getString("apellido"));
						 empleado.setCedula(result.getString("cedula"));
						 empleado.setTelefono(result.getString("telefono"));
						 empleado.setDireccion(result.getString("direccion"));
						 empleado.setEdad(result.getInt("edad"));
						 empleado.setTipo(result.getString("tipo"));
						 empleado.setEstado(result.getString("estado"));
						if (empleado.getNombre() != null) {
							lista.add(empleado);
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
