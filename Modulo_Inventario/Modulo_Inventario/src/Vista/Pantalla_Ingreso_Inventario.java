package Vista;

import java.awt.BorderLayout; 
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Pantalla_Ingreso_Inventario extends JFrame{
	
	public ImageIcon ico_aplicacion;
	public JPanel pnl_datos, pnl_imagen, pnl_botones, pnl_lista;
	public JLabel lbl_imagen, lbl_categoria, lbl_nombre, lbl_marca, lbl_modelo, lbl_serie,
				  lbl_color, lbl_valor;
	public JTextField txt_nombre, txt_marca, txt_modelo, txt_serie, txt_color,
					  txt_valor;
	public JComboBox<String> cbx_categoria;
	public JButton btn_agregar, btn_quitar, btn_buscar, btn_modificar, btn_limpiar, btn_salir;
	
	public Pantalla_Ingreso_Inventario (){
		
		super("Ingreso de Inventario");
		setSize(500, 400);
		setLocation(400,100);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Icono de la Aplicacion
		ico_aplicacion = new ImageIcon("src/Imagenes/icono.gif");
		setIconImage(ico_aplicacion.getImage());
		
		pnl_datos = new JPanel();
		pnl_datos.setBorder(new TitledBorder("Detalles del Producto"));
		pnl_datos.setLayout(new GridLayout(7, 2, 10, 10));
		
		lbl_categoria = new JLabel("Categoria :");
		lbl_nombre = new JLabel("Nombre :");
		lbl_marca = new JLabel("Marca :");
		lbl_modelo = new JLabel("Modelo :");
		lbl_serie = new JLabel("Numero de serie :");
		lbl_color = new JLabel("Color :");
		lbl_valor = new JLabel("P.V.P :");
		
		cbx_categoria = new JComboBox<String>();
		cbx_categoria.addItem("CIRCUITO CERRADO TV");
		cbx_categoria.addItem("ALARMA CONTRAINCENDIO");
		cbx_categoria.addItem("CABLES");
		cbx_categoria.addItem("ACCESORIOS");
		
		txt_nombre = new JTextField();
		txt_marca = new JTextField();
		txt_modelo = new JTextField();
		txt_serie = new JTextField();
		txt_color = new JTextField();
		txt_valor = new JTextField();
		
		pnl_datos.add(lbl_categoria);
		pnl_datos.add(cbx_categoria);
		pnl_datos.add(lbl_nombre);
		pnl_datos.add(txt_nombre);
		pnl_datos.add(lbl_marca);
		pnl_datos.add(txt_marca);
		pnl_datos.add(lbl_modelo);
		pnl_datos.add(txt_modelo);
		pnl_datos.add(lbl_serie);
		pnl_datos.add(txt_serie);
		pnl_datos.add(lbl_color);
		pnl_datos.add(txt_color);
		pnl_datos.add(lbl_valor);
		pnl_datos.add(txt_valor);

		
		pnl_botones = new JPanel();
		pnl_botones.setLayout(new GridLayout(2, 3, 10, 10));
		
		btn_agregar = new JButton("AGREGAR");
		btn_quitar = new JButton("QUITAR");
		btn_buscar = new JButton("BUSCAR");
		btn_modificar = new JButton("MODIFICAR");
		btn_limpiar = new JButton("LIMPIAR");
		btn_salir = new JButton("SALIR");
		
		pnl_botones.add(btn_agregar);
		pnl_botones.add(btn_quitar);
		pnl_botones.add(btn_buscar);
		pnl_botones.add(btn_modificar);
		pnl_botones.add(btn_limpiar);
		pnl_botones.add(btn_salir);		
		
		
//		getContentPane().add(pnl_imagen, BorderLayout.WEST);
		getContentPane().add(pnl_datos, BorderLayout.CENTER);
		getContentPane().add(pnl_botones, BorderLayout.SOUTH);
//		getContentPane().add(pnl_lista, BorderLayout.SOUTH);
		
		((JComponent)getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		
	}

}
