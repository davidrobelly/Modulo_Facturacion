package Vista;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Modelo.Producto;

@SuppressWarnings("serial")
public class Pantalla_Ingreso_Inventario extends JFrame implements ActionListener{
	
	public ImageIcon ico_aplicacion;
	public JPanel pnl_botones, pnl_infoIroducto, pnl_botonesBuscar;
	public JLabel lbl_imagen, lbl_categoria, lbl_nombre, lbl_marca, lbl_modelo, lbl_serie,
				  lbl_color, lbl_valor, lbl_minimo, lbl_maximo, lbl_existencia;
	public JTextField txt_nombre, txt_marca, txt_modelo, txt_serie, txt_color,
					  txt_valor, txt_minimo, txt_maximo, txt_categoria;
	public JComboBox<String> cbx_categoria;
	public JButton btn_agregar, btn_actualizar, btn_limpiar, btn_salir;
	JButton [] btn_buscarBotones;
	

	Producto producto;
	
	public Pantalla_Ingreso_Inventario (){
		
		super("Producto");
//		setSize(500,400);
		setLocation(400,100);
//		setVisible(true);
//		this.setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Icono de la Aplicacion
		ico_aplicacion = new ImageIcon("src/Imagenes/icono.gif");
		setIconImage(ico_aplicacion.getImage());
		

		btn_buscarBotones = new JButton[8];
		
		pnl_infoIroducto = new JPanel();
		pnl_infoIroducto.setBorder(new TitledBorder("Detalles del Producto"));
		pnl_infoIroducto.setLayout(new GridLayout(10, 2, 10, 10));
		
		lbl_categoria = new JLabel("Categoria :");
		lbl_nombre = new JLabel("Nombre :");
		lbl_marca = new JLabel("Marca :");
		lbl_modelo = new JLabel("Modelo :");
		lbl_valor = new JLabel("P.V.P :");
		lbl_serie = new JLabel("Numero de serie :");
		lbl_color = new JLabel("Color :");
		lbl_minimo = new JLabel("Minimo :");
		lbl_maximo = new JLabel("Maximo :");
		
		cbx_categoria = new JComboBox<String>();
		cbx_categoria.addItem("CIRCUITO CERRADO TV");
		cbx_categoria.addItem("ALARMA CONTRAINCENDIO");
		cbx_categoria.addItem("CABLES");
		cbx_categoria.addItem("ACCESORIOS");
		
		txt_categoria = new JTextField();
		txt_nombre = new JTextField();
		txt_marca = new JTextField();
		txt_modelo = new JTextField();
		txt_valor = new JTextField();
		txt_serie = new JTextField();
		txt_color = new JTextField();
		txt_minimo = new JTextField();
		txt_maximo = new JTextField();		
		
		pnl_infoIroducto.add(lbl_categoria);
//		pnl_infoIroducto.add(txt_categoria);
		pnl_infoIroducto.add(cbx_categoria);
		pnl_infoIroducto.add(lbl_nombre);
		pnl_infoIroducto.add(txt_nombre);
		pnl_infoIroducto.add(lbl_marca);
		pnl_infoIroducto.add(txt_marca);
		pnl_infoIroducto.add(lbl_modelo);
		pnl_infoIroducto.add(txt_modelo);
		pnl_infoIroducto.add(lbl_valor);
		pnl_infoIroducto.add(txt_valor);
		pnl_infoIroducto.add(lbl_serie);
		pnl_infoIroducto.add(txt_serie);
		pnl_infoIroducto.add(lbl_color);
		pnl_infoIroducto.add(txt_color);
		pnl_infoIroducto.add(lbl_minimo);
		pnl_infoIroducto.add(txt_minimo);
		pnl_infoIroducto.add(lbl_maximo);
		pnl_infoIroducto.add(txt_maximo);
		

		cargarBotonesBuscar();
		
		pnl_botones = new JPanel();
		pnl_botones.setLayout(new GridLayout(1, 6, 5, 5));
		
		btn_agregar = new JButton(new ImageIcon("src/Imagenes/agregar.JPG"));
		btn_agregar.setBorder(null);
		btn_agregar.addActionListener(this);
		btn_actualizar = new JButton(new ImageIcon("src/Imagenes/agregar.JPG"));
		btn_actualizar.setBorder(null);
		btn_limpiar = new JButton(new ImageIcon("src/Imagenes/agregar.JPG"));
		btn_limpiar.setBorder(null);
		btn_salir = new JButton(new ImageIcon("src/Imagenes/agregar.JPG"));
		btn_salir.setBorder(null);
		btn_salir.addActionListener(this);
		
		pnl_botones.add(btn_agregar);
		pnl_botones.add(btn_actualizar);
		pnl_botones.add(btn_limpiar);
		pnl_botones.add(btn_salir);		
		
//		getContentPane().add(pnl_imagen, BorderLayout.WEST);
		getContentPane().add(pnl_infoIroducto, BorderLayout.CENTER);
		getContentPane().add(pnl_botones, BorderLayout.SOUTH);
//		getContentPane().add(pnl_lista, BorderLayout.SOUTH);
		
		pack();
		((JComponent)getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
	}
	
	public void cargarBotonesBuscar(){
		pnl_botonesBuscar = new JPanel(new GridLayout(8, 1, 10, 10));
		pnl_botonesBuscar.setBackground(Color.WHITE);
		getContentPane().add(pnl_botonesBuscar, BorderLayout.EAST);
		for (int i = 0; i < btn_buscarBotones.length; i++) {
			btn_buscarBotones[i] = new JButton("..");
//			btn_buscar[i].setIcon(carta);
			pnl_botonesBuscar.add(btn_buscarBotones[i]);
		}
	}
	
	public void limpiarPantalla(){
		
		txt_nombre.setText("");
		txt_marca.setText("");
		txt_modelo.setText("");
		txt_valor.setText("");
		txt_minimo.setText("");
		txt_maximo.setText("");
		
	}

	public void actionPerformed(ActionEvent evento) {
		
		String categoria, nombre, marca, modelo;
		double valor;
		int minimo, maximo;
		
		categoria = (String) cbx_categoria.getSelectedItem();
		nombre = txt_nombre.getText();
		marca = txt_marca.getText();
		modelo = txt_modelo.getText();
		valor = Double.parseDouble(txt_valor.getText());
		minimo = Integer.parseInt(txt_minimo.getText());
		maximo = Integer.parseInt(txt_maximo.getText());
		
		if(evento.getSource() == btn_agregar){		
			
			Producto producto = new Producto(categoria, nombre, marca, modelo, valor, minimo, maximo);

			producto.ingresarProducto(producto);
			JOptionPane.showMessageDialog(null, "Registro exitoso");			
			limpiarPantalla();
			
		}
		
		if(evento.getSource() == btn_actualizar){
			

			Producto producto = new Producto();
			
			producto.modificarProducto(categoria, nombre, marca, modelo, valor, minimo, maximo);
			limpiarPantalla();
			
		}
		
		if(evento.getSource() == btn_limpiar){			
			
			limpiarPantalla();
			
		}
		
		if(evento.getSource() == btn_salir){
//			this.setVisible(false);
		}
	}


}
