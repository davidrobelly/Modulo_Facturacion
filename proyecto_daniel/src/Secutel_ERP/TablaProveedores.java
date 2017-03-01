package Secutel_ERP;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TablaProveedores extends AbstractTableModel{

	private final String[] titulo= {"Nombre","Ruc","Direccion","Descripcion"};
	ArrayList<Proveedor> lista = new ArrayList<>();
	
	public TablaProveedores() {
		super();
	}

	public TablaProveedores(ArrayList<Proveedor> lista) {
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
			return lista.get(x).getRuc();
		case 2:
			return lista.get(x).getDireccion();
		case 3:
			return lista.get(x).getDescripcion();	
		default:
			return null;
		}
	}
}
