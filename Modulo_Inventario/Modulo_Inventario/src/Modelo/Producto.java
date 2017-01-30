package Modelo;

public class Producto {
	
	private int codigo;
	private String nombre;
	private String marca;
	private String modelo;
	private double valor;
	private int minimo;
	private int maximo;
	private int existencia;
	private String estado;
	
	public Producto() {
		super();
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
}
