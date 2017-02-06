package Vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Pantalla_Consulta_Producto extends JFrame{
		
		public ImageIcon ico_aplicacion;
		public JTable productos;
		public JScrollPane scroll_productos; 
//		public hhh;
		
		public Pantalla_Consulta_Producto(){
			
			super("Consulta de Productos");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setVisible(true);
	        
			productos = new JTable();
			scroll_productos= new JScrollPane();

			DefaultTableModel dtmEjemplo = new DefaultTableModel(getFilas(),getColumnas());
			productos.setModel(dtmEjemplo);
			scroll_productos.add(productos);
			this.add(scroll_productos);				
			scroll_productos.setViewportView(productos);  
			
			pack();

	        //Icono de la Aplicacion
			ico_aplicacion = new ImageIcon("src/Imagenes/icono.gif");
			setIconImage(ico_aplicacion.getImage());

	        

	    }
		
		private String[] getColumnas(){
			String nombreColumnas[]=new String[]{"Nombre", "Marca", "Modelo", "Precio"};
			return nombreColumnas;
			}
		
		private Object[][] getFilas(){
			Object fila[][]=new Object[][] {{"Camara", "Samsung", "R45", 45}, {"Cable",  "Fibra optica", "E56", 25.4}, {"Camara", "HP", "Optica", 140.80}};
		return fila;
		}
		
		
	    
		
		public static void main(String[] args) {
			
			new Pantalla_Consulta_Producto();

		}

}
