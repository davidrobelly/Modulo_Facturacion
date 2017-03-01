package pantallas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo_clases.Producto;

public class Tabla_Productos extends AbstractTableModel{

	private final String[] titulo= {"Cóodigo","Categoria","Nombre","Marca", 
			"Modelo", "Valor", "Mínimo", "Máximo", "Existencia", "Estado"};
	
	ArrayList<Producto> lista = new ArrayList<>(); 
	
	public Tabla_Productos() {
		super();
	}

	public Tabla_Productos(ArrayList<Producto> lista) {
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
			return lista.get(x).getCodigo();
		case 1:
			return lista.get(x).getCategoria();
		case 2:
			return lista.get(x).getNombre();
		case 3:
			return lista.get(x).getMarca();
		case 4:
			return lista.get(x).getModelo();
		case 5:
			return lista.get(x).getValor();
		case 6:
			return lista.get(x).getMinimo();
		case 7:
			return lista.get(x).getMaximo();
		case 8:
			return lista.get(x).getExistencia();
		case 9:
			return lista.get(x).getEstado();
		default:
			return null;
		}
	}

}
