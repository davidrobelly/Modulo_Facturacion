package Secutel_ERP;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.ResultSet;

public class Proveedor {
	private String nombre;
	private String direccion;
	private String ruc;
	private String descripcion;
	ConectBase conectar;
	String sentencia;
	CallableStatement proc;
	ResultSet result = null;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Proveedor() {
		super();
		conectar = new ConectBase();
	}

	public Proveedor(String nombre, String direccion, String ruc, String descripcion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.ruc = ruc;
		this.descripcion = descripcion;
		conectar = new ConectBase();
	}
	
	void ingresarProveedor(Proveedor pro){
		conectar.conectar();
		try {
			sentencia = "call insertarProveedor(?,?,?,?)";
			proc = conectar.conn.prepareCall(sentencia);
			proc.setString(1, pro.getNombre());
			proc.setString(2, pro.getDireccion());
			proc.setString(3, pro.getRuc());
			proc.setString(4, pro.getDescripcion());
			proc.execute();
			proc.close();
			conectar.cerrar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	ArrayList<Proveedor> listaProveedores(){
		 ArrayList<Proveedor> lista = new ArrayList<>();
		 conectar.conectar();
			try {
				sentencia = "call selectProveedores()";
				proc = conectar.conn.prepareCall(sentencia);
				proc.execute();
				result = (ResultSet) proc.executeQuery();
				 while (result.next()) {
					 Proveedor pro = new Proveedor();
					 pro.setNombre(result.getString("nombre"));
					 pro.setRuc(result.getString("ruc"));
					 pro.setDireccion(result.getString("direccion"));
					 pro.setDescripcion(result.getString("descripcion"));
					 if (pro.getNombre() != null) {
						 lista.add(pro);
					}
	             }
				proc.close();
				conectar.cerrar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return lista;
	}
	
	ArrayList<Proveedor> listaProveedoresInactivos(){
		 ArrayList<Proveedor> lista = new ArrayList<>();
		 conectar.conectar();
			try {
				sentencia = "call listaProveedoresInactivos()";
				proc = conectar.conn.prepareCall(sentencia);
				proc.execute();
				result = (ResultSet) proc.executeQuery();
				while (result.next()) {
					 Proveedor pro = new Proveedor();
					 pro.setNombre(result.getString("nombre"));
					 pro.setRuc(result.getString("ruc"));
					 pro.setDireccion(result.getString("direccion"));
					 pro.setDescripcion(result.getString("descripcion"));
					 if (pro.getNombre() != null) {
						 lista.add(pro);
					}
	             }
				proc.close();
				conectar.cerrar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return lista;
	 }
	
	 Proveedor obtenerProveedor(String nombre){
		Proveedor pro = new Proveedor();
		conectar.conectar();
		try {
			sentencia = "call selectProveedor(?)";
			proc = conectar.conn.prepareCall(sentencia);
			proc.setString(1, nombre);
			proc.execute();
			result = (ResultSet) proc.executeQuery();
			while (result.next()) {
                 pro.setNombre(result.getString("nombre"));
                 pro.setRuc(result.getString("ruc"));
                 pro.setDireccion(result.getString("direccion"));
                 pro.setDescripcion(result.getString("descripcion"));
             }
			proc.close();
			conectar.cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pro; 
	 }
	 
	 void modificarProveedor(String tem,Proveedor pro){
		 conectar.conectar();
			try {
				sentencia = "call modificarProveedor(?,?,?,?,?)";
				proc = conectar.conn.prepareCall(sentencia);
				proc.setString(1, pro.getNombre());
				proc.setString(2, pro.getDireccion());
				proc.setString(3, pro.getRuc());
				proc.setString(4, pro.getDescripcion());
				proc.setString(5, tem);
				proc.execute();
				proc.close();
				conectar.cerrar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	 }
	 
	 void activarProveedor(String ruc){
		 conectar.conectar();
			try {
				sentencia = "call activarProveedor(?)";
				proc = conectar.conn.prepareCall(sentencia);
				proc.setString(1, ruc);
				proc.execute();
				proc.close();
				conectar.cerrar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	 }
	 
	 void inactivarProveedor(String ruc){
		 conectar.conectar();
			try {
				sentencia = "call inactivarProveedor(?)";
				proc = conectar.conn.prepareCall(sentencia);
				proc.setString(1, ruc);
				proc.execute();
				proc.close();
				conectar.cerrar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	 }
	 
	 ArrayList<Proveedor> listaProveedoresxNombre(String nombre){
		 ArrayList<Proveedor> lista = new ArrayList<>();
		 conectar.conectar();
			try {
				sentencia = "call buscarProveedorxNombre(?)";
				proc = conectar.conn.prepareCall(sentencia);
				proc.setString(1, nombre);
				proc.execute();
				result = (ResultSet) proc.executeQuery();
				while (result.next()) {
					Proveedor pro = new Proveedor();
					pro.setNombre(result.getString("nombre"));
					pro.setRuc(result.getString("ruc"));
					pro.setDireccion(result.getString("direccion"));
					pro.setDescripcion(result.getString("descripcion"));
					if (pro.getNombre() != null) {
						lista.add(pro);
					}
	             }
				proc.close();
				conectar.cerrar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return lista;
	 }
	 
	 ArrayList<Proveedor> listaProveedoresxRuc(String ruc){
		 ArrayList<Proveedor> lista = new ArrayList<>();
		 conectar.conectar();
			try {
				sentencia = "call buscarProveedorxRuc(?)";
				proc = conectar.conn.prepareCall(sentencia);
				proc.setString(1, ruc);
				proc.execute();
				result = (ResultSet) proc.executeQuery();
				while (result.next()) {
					Proveedor pro = new Proveedor();
					pro.setNombre(result.getString("nombre"));
					pro.setRuc(result.getString("ruc"));
					pro.setDireccion(result.getString("direccion"));
					pro.setDescripcion(result.getString("descripcion"));
					if (pro.getNombre() != null) {
						lista.add(pro);
					}
	             }
				proc.close();
				conectar.cerrar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return lista;
	 }
	 
	 boolean obtenerNombreProveedor(String nombre){
		 boolean val = false;
		 String name ="";
		 conectar.conectar();
			try {
				sentencia = "call obtenerNombreProveedor(?)";
				proc = conectar.conn.prepareCall(sentencia);
				proc.setString(1, nombre);
				proc.execute();
				result = (ResultSet) proc.executeQuery();
				while (result.next()) {
					name = result.getString("nombre");
					if (name != null) {
						val = true;
					}else{
						val = false;
					}
	             }
				proc.close();
				conectar.cerrar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return val;
	 }
	 
	 boolean obtenerRucProveedor(String ruc){
		 boolean val = false;
		 String name ="";
		 conectar.conectar();
			try {
				sentencia = "call obtenerRucProveedor(?)";
				proc = conectar.conn.prepareCall(sentencia);
				proc.setString(1, ruc);
				proc.execute();
				result = (ResultSet) proc.executeQuery();
				while (result.next()) {
					name = result.getString("ruc");
					if (name != null) {
						val = true;
					}else{
						val = false;
					}
	             }
				proc.close();
				conectar.cerrar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return val;
	 }
	 
	 ArrayList<ContactoProveedor> listarContactosProveedor(String nom){
		 ArrayList<ContactoProveedor> lista = new ArrayList<>();
		 ContactoProveedor cont = new ContactoProveedor();
		 int id = cont.obtenerID(nom);
		 conectar.conectar();
			try {
				sentencia = "call obtenerContactoProveedor(?)";
				proc = conectar.conn.prepareCall(sentencia);
				proc.setInt(1, id);
				proc.execute();
				result = (ResultSet) proc.executeQuery();
				while (result.next()) {
					ContactoProveedor con = new ContactoProveedor();
					con.setNombre(result.getString("nombres"));
					con.setApellido(result.getString("apellidos"));
					con.setCedula(result.getString("cedula"));
					if (con.getCedula() != null) {
						lista.add(con);
					}
	             }
				proc.close();
				conectar.cerrar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return lista;
	 }
}