package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import Persistencia.Conexion;

public class Kardex extends Conexion{
	
	private int codigo;
	private String tipo;
	private Date fecha;
	private int codigoProducto;
	private int cantidad;
	private double valorCompra;
	private String detalle;
	
	Conexion conectar;
	String sentencia;
	java.sql.CallableStatement procedimiento;
	ResultSet resultado;
	
	public Kardex() {
		super();
	}
	
	public Kardex(int codigo, Date fecha, int cantidad, double valorCompra, String tipo, String detalle) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.valorCompra = valorCompra;
		this.tipo = tipo;
		this.detalle = detalle;
	}
	
	public Kardex(String tipo, Date fecha, int codigoProducto, int cantidad, double valorCompra, String detalle) {
		super();
		this.tipo = tipo;
		this.fecha = fecha;
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
		this.valorCompra = valorCompra;
		this.detalle = detalle;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getValorCompra() {
		return valorCompra;
	}
	
	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getDetalle() {
		return detalle;
	}
	
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}	
	
	public void ingresarKardex(Kardex kardex){		
			
			conectar.conectar();
			try {
				sentencia = "call ingresarproducto(?,?,?,?,?,?,?)";
				
				procedimiento = conectar.conn.prepareCall(sentencia);
				procedimiento.setString(1, kardex.getTipo());
				procedimiento.setDate(2, (java.sql.Date) kardex.getFecha());
				procedimiento.setInt(3, kardex.getCodigoProducto());
				procedimiento.setInt(4, kardex.getCantidad());
				procedimiento.setDouble(5, kardex.getValorCompra());
				procedimiento.setString(6, kardex.getDetalle());
				procedimiento.execute();
				procedimiento.close();
				conectar.cerrar();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
