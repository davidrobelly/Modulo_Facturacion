package Modelo;

public class Producto_Detalle {
	
	private int codigo;
	private String numSerie;
	private String color;
	private String estado;
	
	public Producto_Detalle() {
		super();
	}
	
	public Producto_Detalle(int codigo, String numSerie, String color, String estado) {
		super();
		this.codigo = codigo;
		this.numSerie = numSerie;
		this.color = color;
		this.estado = estado;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNumSerie() {
		return numSerie;
	}
	
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
