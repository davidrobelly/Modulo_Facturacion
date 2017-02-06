package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Pantalla_PruebaLayout extends JFrame{
	
	JLabel lbl_titulo, lbl_categoria, lbl_nombre, lbl_existencia;
	JComboBox<String> cbx_categoria;
	JTextField txt_nombre, txt_existencia;
	JButton btn_nuevo, btn_modificar, btn_eliminar, btn_limpiar, btn_imprimir, btn_salir;	
	JPanel pnl_datos, pnl_botones, pnl_botonesBuscar;
	JButton [] btn_buscar;
//	ImageIcon carta;
	
	Border NOline, empty, paneEdge;
	
	Pantalla_PruebaLayout(){
		
		super("Ingreso Producto");
		setSize(300, 200);
		setLocation(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setResizable(false);
		
		
//		blackline = BorderFactory.createLineBorder(Color.black);
//		TitledBorder title1;
//		title1 = BorderFactory.createTitledBorder(blackline, "title");
//		title1.setTitleJustification(TitledBorder.CENTER);
//		pnl_datos.setBorder(title1);

		btn_buscar = new JButton[3];
//		carta = new JButton("direccion donde este la imagen");
		lbl_titulo = new JLabel();
		
		NOline = BorderFactory.createLineBorder(null);
		
		TitledBorder titulo;
		titulo = BorderFactory.createTitledBorder(NOline, "Detalle de Productos");
		titulo.setTitleJustification(TitledBorder.CENTER);
		titulo.setTitleColor(Color.MAGENTA);
		lbl_titulo.setBorder(titulo);
		
		pnl_datos = new JPanel(new GridLayout(3, 2, 5, 10));
		
		lbl_categoria = new JLabel("Categoria");
		lbl_nombre = new JLabel("Nombre");
		lbl_existencia = new JLabel("Existencia");
		
		cbx_categoria = new JComboBox<>();
		cbx_categoria.addItem("Tipo 1");
		cbx_categoria.addItem("Tipo 2");
		cbx_categoria.addItem("Tipo 3");
		cbx_categoria.addItem("Tipo 4");
		
		txt_nombre = new JTextField();
		txt_existencia = new JTextField();
		txt_existencia.setEnabled(false);
		
//		btn_buscarCategoria = new JButton("..");
//		btn_buscarNombre = new JButton("..");
//		btn_buscarExistencia = new JButton("..");
//		btn_buscarExistencia.setEnabled(false);
		
		pnl_datos.add(lbl_categoria);
		pnl_datos.add(cbx_categoria);
//		pnl_datos.add(btn_buscarCategoria);
		pnl_datos.add(lbl_nombre);
		pnl_datos.add(txt_nombre);
//		pnl_datos.add(btn_buscarNombre);
		pnl_datos.add(lbl_existencia);
		pnl_datos.add(txt_existencia);
//		pnl_datos.add(btn_buscarExistencia);
		
		
		
		pnl_botones = new JPanel(new GridLayout(1, 6, 5, 10));
		cargarBotonesBuscar();
		btn_nuevo = new JButton("..");
		btn_modificar = new JButton("..");
		btn_eliminar = new JButton("..");
		btn_imprimir = new JButton("..");
		btn_limpiar = new JButton("..");
		btn_salir = new JButton("..");		
		
		pnl_botones.add(btn_nuevo);
		pnl_botones.add(btn_modificar);
		pnl_botones.add(btn_eliminar);
		pnl_botones.add(btn_imprimir);
		pnl_botones.add(btn_limpiar);
		pnl_botones.add(btn_salir);
		
//		lbl_titulo.add(pnl_datos);
//		lbl_titulo.add(pnl_botonesBuscar);
		
		getContentPane().add(lbl_titulo, BorderLayout.NORTH);
		getContentPane().add(pnl_datos, BorderLayout.CENTER);
		getContentPane().add(pnl_botones, BorderLayout.SOUTH);
		
//		pack();
		
		((JComponent)getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 15));

	}

	public void cargarBotonesBuscar(){
		pnl_botonesBuscar = new JPanel(new GridLayout(3, 1, 10, 10));
		pnl_botonesBuscar.setBackground(Color.WHITE);
		getContentPane().add(pnl_botonesBuscar, BorderLayout.EAST);
		for (int i = 0; i < btn_buscar.length; i++) {
			btn_buscar[i] = new JButton("..");
//			btn_buscar[i].setIcon(carta);
			pnl_botonesBuscar.add(btn_buscar[i]);
		}
	}

	public static void main(String[] args) {

		new Pantalla_PruebaLayout();
	}

}
