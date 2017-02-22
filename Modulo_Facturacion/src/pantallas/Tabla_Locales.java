package pantallas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo_clases.Sucursal;

public class Tabla_Locales extends AbstractTableModel{

	private final String[] titulo= {"Nombre","Direccion","Ciudad","Estado"};
	
	ArrayList<Sucursal> lista = new ArrayList<>(); 
	
	public Tabla_Locales() {
		super();
	}

	public Tabla_Locales(ArrayList<Sucursal> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getColumnCount() {
		return titulo.length;
	}
	@Override
	public String getColumnName(int column) {
		return titulo[column];
	}
	@Override
	public int getRowCount() {
		return lista.size();
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public Object getValueAt(int x, int y) {
		switch (y) {
		case 0:
			return lista.get(x).getNombre();
		case 1:
			return lista.get(x).getDireccion();
		case 2:
			return lista.get(x).getCiudad();
		case 3:
			return lista.get(x).getEstado();
		default:
			return null;
		}
	}

}
