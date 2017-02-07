package modelo_clases;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

import DBClases.ConexionDB;

public class Factura {
	
	private String num_factura;
	private int local;
	private int cliente;
	private int vendedor;
	private Date fecha;
	private String estado;
	public int cantidad_total_productos;
	public double sub_total;
	public double iva;
	public double total_pagar;
	public double metodo_pago;
	ConexionDB conexion;
	
	public Factura(String num_factura, int local, int cliente, int vendedor, Date fecha, String estado,
			int cantidad_total_productos, double sub_total, double iva, double total_pagar, double metodo_pago) {
		super();
		this.setNum_factura(num_factura);
		this.setLocal(local);
		this.setCliente(cliente);
		this.setVendedor(vendedor);
		this.setFecha(fecha);
		this.setEstado(estado);
		this.setCantidad_total_productos(cantidad_total_productos);
		this.setSub_total(sub_total);
		this.setIva(iva);
		this.setTotal_pagar(total_pagar);
		this.setMetodo_pago(metodo_pago);
	}
	
	
	public String getNum_factura() {
		return num_factura;
	}
	public void setNum_factura(String num_factura) {
		this.num_factura = num_factura;
	}
	public int getLocal() {
		return local;
	}
	public void setLocal(int local) {
		this.local = local;
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
	public double getMetodo_pago() {
		return metodo_pago;
	}
	public void setMetodo_pago(double metodo_pago) {
		this.metodo_pago = metodo_pago;
	}
	
	
	//metodos
	
	public void ingresarFactura(Factura factura){
		conexion = new ConexionDB();
		conexion.conectar();
		try {
			String sentencia = "call ingresarfactura(?,?,?,?,?,?,?,?,?,?,?)";
			CallableStatement procedure = conexion.conn.prepareCall(sentencia);
			procedure.setString(1, factura.getNum_factura());
			procedure.setInt(2, factura.getLocal());
			procedure.setInt(3, factura.getCliente());
			procedure.setInt(4, factura.getVendedor());
			procedure.setDate(5, factura.getFecha());
			procedure.setString(6, factura.getEstado());
			procedure.setInt(7, factura.getCantidad_total_productos());
			procedure.setDouble(8, factura.getSub_total());
			procedure.setDouble(9, factura.getIva());
			procedure.setDouble(10, factura.getTotal_pagar());
			procedure.setDouble(11, factura.getMetodo_pago());
			procedure.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		conexion.cerrarConexion();
	}

}
