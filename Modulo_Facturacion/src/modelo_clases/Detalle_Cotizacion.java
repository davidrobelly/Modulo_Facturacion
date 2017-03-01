package modelo_clases;

import java.sql.CallableStatement;
import java.sql.SQLException;

import DBClases.ConexionDB;

public class Detalle_Cotizacion {
	
	public int idcotizacion;
	public int idproducto;
	public int cantidad;
	public int valor;
	public String codigo;                                                                                                                                                                                                                         
	ConexionDB conexion;
	
	
	public Detalle_Cotizacion(int idcotizacion, int idproducto, int cantidad, int valor) {
		super();
		this.idcotizacion = idcotizacion;
		this.idproducto = idproducto;
		this.cantidad = cantidad;
		this.valor = valor;
	}
	

	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public int getIdcotizacion() {
		return idcotizacion;
	}


	public void setIdcotizacion(int idcotizacion) {
		this.idcotizacion = idcotizacion;
	}


	public int getIdproducto() {
		return idproducto;
	}


	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}
	
	//metodos 
	
	public void ingresarDetalle(Detalle_Cotizacion detalle){
		conexion = new ConexionDB();
		conexion.conectar();
		try {
			String sentencia = "call ingresar_detalle_cotizacion(?,?,?,?,?)";
			CallableStatement procedure = conexion.conn.prepareCall(sentencia);
			procedure.setInt(1, detalle.getIdcotizacion());
			procedure.setString(2, detalle.getCodigo());
			procedure.setInt(3, detalle.getIdproducto());
			procedure.setInt(4, detalle.getCantidad());
			procedure.setDouble(5, detalle.getValor());
			procedure.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		conexion.cerrarConexion();
	}
	
	public void asignaridcliente () {
		conexion = new ConexionDB();
		conexion.conectar(); 
		
	}

}
