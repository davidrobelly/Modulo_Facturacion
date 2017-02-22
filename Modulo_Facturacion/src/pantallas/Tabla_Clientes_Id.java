package pantallas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo_clases.Cliente;

public class Tabla_Clientes_Id extends AbstractTableModel{

	private final String[] titulo= {"IdCliente","Nombre","Apellido","Nro Cedula", 
			"Telefono", "Correo", "Direccion", "Tipo", "Estado"};
	
	ArrayList<Cliente> lista = new ArrayList<>(); 
	
	public Tabla_Clientes_Id() {
		super();
	}

	public Tabla_Clientes_Id(ArrayList<Cliente> lista) {
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
			return lista.get(x).getIdcliente();
		case 1:
			return lista.get(x).getNombre();
		case 2:
			return lista.get(x).getApellido();
		case 3:
			return lista.get(x).getCedula();
		case 4:
			return lista.get(x).getTelefono();
		case 5:
			return lista.get(x).getCorreo();
		case 6:
			return lista.get(x).getDireccion();
		case 7:
			return lista.get(x).getTipo();
		case 8:
			return lista.get(x).getEstado();
		default:
			return null;
		}
	}

}
