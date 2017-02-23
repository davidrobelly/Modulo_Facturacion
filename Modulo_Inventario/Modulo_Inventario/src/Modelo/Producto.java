package Modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.util.ArrayList;

import Persistencia.Conexion;

public class Producto {
	
	private int codigo;
	private String categoria;
	private String nombre;
	private String marca;
	private String modelo;
	private double valor;
	private int minimo;
	private int maximo;
	private int existencia;
	private String estado;
	
	Conexion conectar;
	String sentencia;
	CallableStatement procedimiento;
	ResultSet resultado = null;
	
	public Producto() {
		super();
		conectar = new Conexion();
	}

	public Producto(String marca) {
		super();
		this.marca = marca;
		conectar = new Conexion();
	}

	public Producto(String nombre, String marca, String modelo, double valor) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.modelo = modelo;
		this.valor = valor;
	}

	public Producto(String nombre, String marca, String modelo) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.modelo = modelo;
	}

	public Producto(String nombre, String marca, String modelo, int minimo) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.modelo = modelo;
		this.minimo = minimo;
	}

	public Producto(String nombre, String marca, String modelo, String estado) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.modelo = modelo;
		this.estado = estado;
	}

	public Producto(int codigo, String nombre, String marca, String modelo, double valor, int minimo, int maximo,
			int existencia, String estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.marca = marca;
		this.modelo = modelo;
		this.valor = valor;
		this.minimo = minimo;
		this.maximo = maximo;
		this.existencia = existencia;
		this.estado = estado;
	}	
	
	
	
	public Producto(String categoria, String nombre, String marca, String modelo, double valor, int minimo,
			int maximo) {
		super();
		this.categoria = categoria;
		this.nombre = nombre;
		this.marca = marca;
		this.modelo = modelo;
		this.valor = valor;
		this.minimo = minimo;
		this.maximo = maximo;
		conectar = new Conexion();
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public int getMinimo() {
		return minimo;
	}
	
	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}
	
	public int getMaximo() {
		return maximo;
	}
	
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}
	
	public int getExistencia() {
		return existencia;
	}
	
	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void ingresarProducto(Producto producto){		
		
		conectar.conectar();
		try {
			sentencia = "call ingresarproducto(?,?,?,?,?,?,?)";
			
			procedimiento = conectar.conn.prepareCall(sentencia);
			procedimiento.setString(1, producto.getCategoria());
			procedimiento.setString(2, producto.getNombre());
			procedimiento.setString(3, producto.getMarca());
			procedimiento.setString(4, producto.getModelo());
			procedimiento.setDouble(5, producto.getValor());
			procedimiento.setInt(6, producto.getMinimo());
			procedimiento.setInt(7, producto.getMaximo());
			procedimiento.execute();
			procedimiento.close();
			conectar.cerrar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modificarProducto(String categoria,String nombre,String marca,String modelo,double valor,int minimo,int maximo){
		 conectar.conectar();
			try {
				sentencia = "call modificarProveedor(?,?,?,?,?,?,?)";
				procedimiento = conectar.conn.prepareCall(sentencia);
				procedimiento.setString(1, categoria);
				procedimiento.setString(2, nombre);
				procedimiento.setString(3, marca);
				procedimiento.setString(4, modelo);
				procedimiento.setDouble(5, valor);
				procedimiento.setInt(6, minimo);
				procedimiento.setInt(7, maximo);
				procedimiento.execute();
				procedimiento.close();
				conectar.cerrar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	 }
	
	public Producto consultarProdXMarca(String marca){
		Producto producto = new Producto();
		conectar.conectar();
		try {
			sentencia = "call consultarproducto(?)";
			procedimiento = conectar.conn.prepareCall(sentencia);
			procedimiento.setString(1, marca);
			procedimiento.execute();
			resultado = (ResultSet) procedimiento.executeQuery();
			while (resultado.next()) {
                 producto.setNombre(resultado.getString("nombre"));
                 producto.setMarca(resultado.getString("marca"));
                 producto.setModelo(resultado.getString("modelo"));
                 producto.setValor(resultado.getDouble("valor"));
             }
			procedimiento.close();
			conectar.cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producto; 
	 }
	
	public Producto consultarProdXModelo(String modelo){
		Producto producto = new Producto();
		conectar.conectar();
		try {
			sentencia = "call consultarproducto(?)";
			procedimiento = conectar.conn.prepareCall(sentencia);
			procedimiento.setString(1, modelo);
			procedimiento.execute();
			resultado = (ResultSet) procedimiento.executeQuery();
			while (resultado.next()) {
                 producto.setNombre(resultado.getString("nombre"));
                 producto.setMarca(resultado.getString("marca"));
                 producto.setModelo(resultado.getString("modelo"));
                 producto.setValor(resultado.getDouble("valor"));
             }
			procedimiento.close();
			conectar.cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producto; 
	 }
	
	public ArrayList<Producto> listarProductosxMarca(String marca){
		 ArrayList<Producto> listaProMarca = new ArrayList<>();
		 conectar.conectar();
			try {
				sentencia = "call consultarproducto(?)";
				procedimiento = conectar.conn.prepareCall(sentencia);
				procedimiento.setString(1, marca);
				procedimiento.execute();
				resultado = (ResultSet) procedimiento.executeQuery();
				while (resultado.next()) {
					Producto producto = new Producto();
					producto.setNombre(resultado.getString("nombre"));
					producto.setMarca(resultado.getString("marca"));
					producto.setModelo(resultado.getString("modelo"));
					producto.setValor(resultado.getDouble("valor"));
					if (producto.getNombre() != null) {
						listaProMarca.add(producto);
					}
	             }
				procedimiento.close();
				conectar.cerrar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return listaProMarca;
	 }
	

}
