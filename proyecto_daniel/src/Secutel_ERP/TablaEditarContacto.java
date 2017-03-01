package Secutel_ERP;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TablaEditarContacto extends AbstractTableModel{
	
	private final String[] titulo= {"Nombre","Apellido","Nro Cedula","Eliminar"};
	ArrayList<ContactoProveedor> lista = new ArrayList<>();
	boolean valor = false;
	
	public TablaEditarContacto() {
		super();
	}

	public TablaEditarContacto(ArrayList<ContactoProveedor> lista) {
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
	public void setValueAt(Object value, int row, int col){
		valor = (boolean) value;
	    fireTableCellUpdated(row, col);
	}

	@Override
	public Object getValueAt(int x, int y) {
		switch (y) {
		case 0:
			return lista.get(x).getNombre();
		case 1:
			return lista.get(x).getApellido();
		case 2:
			return lista.get(x).getCedula();
		case 3:
			return valor;
		default:
			return null;
		}
	}
}
