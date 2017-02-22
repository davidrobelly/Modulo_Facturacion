package pantallas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo_clases.Empleado;

public class Tabla_Empleados_Id extends AbstractTableModel{

	private final String[] titulo= {"IdEmpleado", "Nombre","Apellido","Cedula", 
			"Telefono", "Direccion", "Edad", "Tipo", "Estado"};
	
	ArrayList<Empleado> lista = new ArrayList<>(); 
	
	public Tabla_Empleados_Id() {
		super();
	}

	public Tabla_Empleados_Id(ArrayList<Empleado> lista) {
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
			return lista.get(x).getIdempleado();
		case 1:
			return lista.get(x).getNombre();
		case 2:
			return lista.get(x).getApellido();
		case 3:
			return lista.get(x).getCedula();
		case 4:
			return lista.get(x).getTelefono();
		case 5:
			return lista.get(x).getDireccion();
		case 6:
			return lista.get(x).getEdad();
		case 7:
			return lista.get(x).getTipo();
		case 8:
			return lista.get(x).getEstado();
		default:
			return null;
		}
	}

}
