package Tablas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Modelo.Producto;

@SuppressWarnings("serial")
public class Tabla_Producto_Modificar extends AbstractTableModel{
	
	private final String[] titulo = {"Codigo", "Categoria","Nombre","Marca","Modelo","Valor", "Minimo", "Maximo"};
	
	ArrayList<Producto> listaProductos = new ArrayList<>();
	
	public Tabla_Producto_Modificar() {
		super();
	}

	public Tabla_Producto_Modificar(ArrayList<Producto> lista) {
		super();
		this.listaProductos = lista;
	}
	
	public int getColumnCount() {
		return titulo.length;
	}
	
	public String getColumnName(int column) {
		return titulo[column];
	}
	
	public int getRowCount() {
		return listaProductos.size();
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}

	public Object getValueAt(int x, int y) {
		switch (y) {
		case 0:
			return listaProductos.get(x).getCodigo();
		case 1:
			return listaProductos.get(x).getCategoria();
		case 2:
			return listaProductos.get(x).getNombre();
		case 3:
			return listaProductos.get(x).getMarca();
		case 4:
			return listaProductos.get(x).getModelo();
		case 5:
			return listaProductos.get(x).getValor();
		case 6:
			return listaProductos.get(x).getMinimo();
		case 7:
			return listaProductos.get(x).getMaximo();
		default:
			return null;
		}
	}

}
