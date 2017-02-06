package Modelo;

import java.util.Date;

public class Kardex {
	
	private int codigo;
	private Date fecha;
	private int cantidad;
	private double valorCompra;
	private String tipo;
	private String detalle;
	
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
}
