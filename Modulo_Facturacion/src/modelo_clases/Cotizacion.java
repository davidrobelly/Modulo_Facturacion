package modelo_clases;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

import DBClases.ConexionDB;

public class Cotizacion {
	
	private String codigo;
	private int cliente;
	private int vendedor;
	private Date fecha;
	private Date vigencia;
	private String estado;
	public int cantidad_total_productos;
	public double sub_total;
	public double iva;
	public double total_pagar;
	ConexionDB conexion;
	
	
	
	public Cotizacion(String codigo, int cliente, int vendedor, Date fecha, Date vigencia, String estado, int cantidad_total_productos,
			double sub_total, double iva, double total_pagar) {
		super();
		this.setCodigo(codigo);
		this.setCliente(cliente);
		this.setVendedor(vendedor);
		this.setFecha(fecha);
		this.setVigencia(vigencia);
		this.setEstado(estado);
		this.setCantidad_total_productos(cantidad_total_productos);
		this.setSub_total(sub_total);
		this.setIva(iva);
		this.setTotal_pagar(total_pagar);
	}
	
	
	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public int getCliente() {
		return cliente;
	}
	
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	
	public int getVendedor() {
		return vendedor;
	}
	
	public void setVendedor(int vendedor) {
		this.vendedor = vendedor;
	}
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Date getVigencia() {
		return vigencia;
	}
	
	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int getCantidad_total_productos() {
		return cantidad_total_productos;
	}
	
	public void setCantidad_total_productos(int cantidad_total_productos) {
		this.cantidad_total_productos = cantidad_total_productos;
	}
	
	public double getSub_total() {
		return sub_total;
	}
	
	public void setSub_total(double sub_total) {
		this.sub_total = sub_total;
	}
	
	public double getIva() {
		return iva;
	}
	
	public void setIva(double iva) {
		this.iva = iva;
	}
	
	public double getTotal_pagar() {
		return total_pagar;
	}
	
	public void setTotal_pagar(double total_pagar) {
		this.total_pagar = total_pagar;
	}
	
	
	//metodos de cotizacion
	
	public void ingresarFactura(Cotizacion cotizacion){
		conexion = new ConexionDB();
		conexion.conectar();
		try {
			String sentencia = "call ingresarcotizacion(?,?,?,?,?,?,?,?,?,?)";
			CallableStatement procedure = conexion.conn.prepareCall(sentencia);
			procedure.setString(1, cotizacion.getCodigo());
			procedure.setInt(1, cotizacion.getCliente());
			procedure.setInt(2, cotizacion.getVendedor());
			procedure.setDate(3, cotizacion.getFecha());
			procedure.setDate(4, cotizacion.getVigencia());
			procedure.setString(5, cotizacion.getEstado());
			procedure.setInt(6, cotizacion.getCantidad_total_productos());
			procedure.setDouble(7, cotizacion.getSub_total());
			procedure.setDouble(8, cotizacion.getIva());
			procedure.setDouble(9, cotizacion.getTotal_pagar());
			procedure.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		conexion.cerrarConexion();
	}

}
