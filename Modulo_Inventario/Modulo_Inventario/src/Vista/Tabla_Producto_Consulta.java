package Vista;

import Modelo.Producto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
	
	public class Tabla_Producto_Consulta extends AbstractTableModel{

		private final String[] titulo = {"Nombre","Marca","Modelo","Valor","Min","Max"};
		
		ArrayList<Producto> listaProductos = new ArrayList<>();
		
		public Tabla_Producto_Consulta() {
			super();
		}

		public Tabla_Producto_Consulta(ArrayList<Producto> lista) {
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
				return listaProductos.get(x).getNombre();
			case 1:
				return listaProductos.get(x).getMarca();
			case 2:
				return listaProductos.get(x).getModelo();
			case 3:
				return listaProductos.get(x).getValor();
			case 4:
				return listaProductos.get(x).getMinimo();
			case 5:
				return listaProductos.get(x).getMaximo();
			default:
				return null;
			}
		}
	}

	