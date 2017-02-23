package Tablas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Modelo.Producto;

@SuppressWarnings("serial")
public class Tabla_Producto_Estado extends AbstractTableModel{

	private final String[] titulo= {"Nombre","Marca","Modelo","Estado"};
	ArrayList<Producto> listaProductosEstados = new ArrayList<>();
	
	public Tabla_Producto_Estado() {
		super();
	}

	public Tabla_Producto_Estado(ArrayList<Producto> lista) {
		super();
		this.listaProductosEstados = lista;
	}
	
	public int getColumnCount() {
		return titulo.length;
	}
	
	public String getColumnName(int column) {
		return titulo[column];
	}
	
	public int getRowCount() {
		return listaProductosEstados.size();
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
			return listaProductosEstados.get(x).getNombre();
		case 1:
			return listaProductosEstados.get(x).getMarca();
		case 2:
			return listaProductosEstados.get(x).getModelo();
		case 3:
			return listaProductosEstados.get(x).getEstado();
		default:
			return null;
		}
	}



}
