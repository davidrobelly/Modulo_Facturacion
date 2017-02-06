package Modelo;

public class Categoria {
	
	private int codigo;
	private String descripcion;
	private String estado;
	
	public Categoria() {
		super();
	}
	
	public Categoria(int codigo, String descripcion, String estado) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
