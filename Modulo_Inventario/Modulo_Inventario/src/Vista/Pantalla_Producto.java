package Vista;

import java.awt.BorderLayout;  
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Modelo.Producto;

@SuppressWarnings("serial")
public class Pantalla_Producto extends JFrame implements ActionListener, MouseListener{
	
	public ImageIcon ico_aplicacion;
	public JPanel pnl_datos, pnl_datGenPro, pnl_datEspePro, pnl_tabla, pnl_botones;
	public JLabel lbl_categoria, lbl_nombre, lbl_marca, lbl_modelo, lbl_valor,
				  lbl_minimo, lbl_maximo, lbl_existencia, lbl_serie, lbl_color, lbl_detalle;
	public JComboBox<String> cbx_categoria;
	public JTextField txt_nombre, txt_marca, txt_modelo, txt_valor, txt_minimo, 
					  txt_maximo, txt_existencia, txt_serie, txt_color;
	public JTextArea txta_detalle;
	public JButton btn_agregar, btn_actualizar, btn_limpiar, btn_salir, btn_buscarMarca, 
				   btn_buscarModelo, btn_buscarNumSerie, btn_buscarColor;
	public Tabla_Producto_Consulta jtproducto;
	public JTable tabla;
	public JScrollPane scrollProductoEstado;

	public Pantalla_Producto (){
		
		super("Producto");
		setSize(800,500);
		setLocation(400,25);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Icono de la Aplicacion
		ico_aplicacion = new ImageIcon("src/Imagenes/icono.gif");
		setIconImage(ico_aplicacion.getImage());
		
		pnl_datos = new JPanel(new GridLayout(1, 2));
		
		//PANELES SUPERIORES
		//Panel Datos Generales Producto
		pnl_datGenPro = new JPanel();
		pnl_datGenPro.setBorder(new TitledBorder("Datos Generales del Producto"));
		pnl_datos.add(pnl_datGenPro);
		
		GridBagLayout gridSuperior1 = new GridBagLayout();
		pnl_datGenPro.setLayout(gridSuperior1);
		
		GridBagConstraints gridConSuperior1 = new GridBagConstraints();
		gridConSuperior1.fill = GridBagConstraints.BOTH;
		gridConSuperior1.insets = new Insets(3, 3, 3, 3);
		
		gridConSuperior1.gridx = 0;
		gridConSuperior1.gridy = 0;
		gridConSuperior1.gridheight = 1;
		gridConSuperior1.gridwidth = 1;
		lbl_categoria = new JLabel("Categoria :");
		pnl_datGenPro.add(lbl_categoria);
		gridSuperior1.setConstraints(lbl_categoria, gridConSuperior1);
	
		gridConSuperior1.gridx = 1;
		gridConSuperior1.gridy = 0;
		cbx_categoria = new JComboBox<String>();
		cbx_categoria.addItem("CIRCUITO CERRADO TV");
		cbx_categoria.addItem("ALARMA CONTRAINCENDIO");
		cbx_categoria.addItem("CABLES");
		cbx_categoria.addItem("ACCESORIOS");
		pnl_datGenPro.add(cbx_categoria);
		gridSuperior1.setConstraints(cbx_categoria, gridConSuperior1);
		
		gridConSuperior1.gridx = 0;
		gridConSuperior1.gridy = 1;
		lbl_nombre = new JLabel("Nombre :");
		pnl_datGenPro.add(lbl_nombre);
		gridSuperior1.setConstraints(lbl_nombre, gridConSuperior1);
		
		gridConSuperior1.gridx = 1;
		gridConSuperior1.gridy = 1;
		txt_nombre = new JTextField(20);
		pnl_datGenPro.add(txt_nombre);
		gridSuperior1.setConstraints(txt_nombre, gridConSuperior1);
		
		gridConSuperior1.gridx = 0;
		gridConSuperior1.gridy = 2;
		lbl_marca = new JLabel("Marca : ");
		pnl_datGenPro.add(lbl_marca);
		gridSuperior1.setConstraints(lbl_marca, gridConSuperior1);
		
		gridConSuperior1.gridx = 1;
		gridConSuperior1.gridy = 2;
		txt_marca = new JTextField(20);
		pnl_datGenPro.add(txt_marca);
		gridSuperior1.setConstraints(txt_marca, gridConSuperior1);

		gridConSuperior1.gridx = 2;
		gridConSuperior1.gridy = 2;
		btn_buscarMarca = new JButton("..");
		btn_buscarMarca.addActionListener(this);
		pnl_datGenPro.add(btn_buscarMarca);
		gridSuperior1.setConstraints(btn_buscarMarca, gridConSuperior1);
		
		gridConSuperior1.gridx = 0;
		gridConSuperior1.gridy = 3;
		lbl_modelo = new JLabel("Modelo : ");
		pnl_datGenPro.add(lbl_modelo);
		gridSuperior1.setConstraints(lbl_modelo, gridConSuperior1);
		
		gridConSuperior1.gridx = 1;
		gridConSuperior1.gridy = 3;
		txt_modelo = new JTextField(20);
		pnl_datGenPro.add(txt_modelo);
		gridSuperior1.setConstraints(txt_modelo, gridConSuperior1);

		gridConSuperior1.gridx = 2;
		gridConSuperior1.gridy = 3;
		btn_buscarModelo = new JButton("..");
		pnl_datGenPro.add(btn_buscarModelo);
		gridSuperior1.setConstraints(btn_buscarModelo, gridConSuperior1);
		
		gridConSuperior1.gridx = 0;
		gridConSuperior1.gridy = 4;
		lbl_valor = new JLabel("P. V. P : ");
		pnl_datGenPro.add(lbl_valor);
		gridSuperior1.setConstraints(lbl_valor, gridConSuperior1);
		
		gridConSuperior1.gridx = 1;
		gridConSuperior1.gridy = 4;
		txt_valor = new JTextField(20);
		pnl_datGenPro.add(txt_valor);
		gridSuperior1.setConstraints(txt_valor, gridConSuperior1);
		
		gridConSuperior1.gridx = 0;
		gridConSuperior1.gridy = 5;
		lbl_minimo = new JLabel("Minimo : ");
		pnl_datGenPro.add(lbl_minimo);
		gridSuperior1.setConstraints(lbl_minimo, gridConSuperior1);
		
		gridConSuperior1.gridx = 1;
		gridConSuperior1.gridy = 5;
		txt_minimo = new JTextField(20);
		pnl_datGenPro.add(txt_minimo);
		gridSuperior1.setConstraints(txt_minimo, gridConSuperior1);
		
		gridConSuperior1.gridx = 0;
		gridConSuperior1.gridy = 6;
		lbl_maximo = new JLabel("Maximo : ");
		pnl_datGenPro.add(lbl_maximo);
		gridSuperior1.setConstraints(lbl_maximo, gridConSuperior1);
		
		gridConSuperior1.gridx = 1;
		gridConSuperior1.gridy = 6;
		txt_maximo = new JTextField(20);
		pnl_datGenPro.add(txt_maximo);
		gridSuperior1.setConstraints(txt_maximo, gridConSuperior1);
			
		gridConSuperior1.gridx = 0;
		gridConSuperior1.gridy = 7;
		lbl_existencia = new JLabel("Existencia : ");
		pnl_datGenPro.add(lbl_existencia);
		gridSuperior1.setConstraints(lbl_existencia, gridConSuperior1);
		
		gridConSuperior1.gridx = 1;
		gridConSuperior1.gridy = 7;
		txt_existencia = new JTextField(20);
		txt_existencia.setEnabled(false);
		pnl_datGenPro.add(txt_existencia);
		gridSuperior1.setConstraints(txt_existencia, gridConSuperior1);
		
		//Panel Datos Especificos Producto
		pnl_datEspePro = new JPanel();
		pnl_datEspePro.setBorder(new TitledBorder("Datos Especificos del Producto"));
		pnl_datos.add(pnl_datEspePro);
		
		GridBagLayout gridSuperior2 = new GridBagLayout();
		pnl_datEspePro.setSize(getMinimumSize());
		pnl_datEspePro.setLayout(gridSuperior2);
		
		GridBagConstraints gridConSuperior2 = new GridBagConstraints();
		gridConSuperior2.fill = GridBagConstraints.BOTH;
		gridConSuperior2.insets = new Insets(3, 3, 3, 3);
	
		gridConSuperior2.gridx = 0;
		gridConSuperior2.gridy = 0;
		gridConSuperior2.gridheight = 1;
		gridConSuperior2.gridwidth = 1;
		lbl_serie = new JLabel("N� de Serie :");
		pnl_datEspePro.add(lbl_serie);
		gridSuperior2.setConstraints(lbl_serie, gridConSuperior2);
		
		gridConSuperior2.gridx = 1;
		gridConSuperior2.gridy = 0;
		txt_serie = new JTextField(20);
		pnl_datEspePro.add(txt_serie);
		gridSuperior2.setConstraints(txt_serie, gridConSuperior2);
		
		gridConSuperior2.gridx = 2;
		gridConSuperior2.gridy = 0;
		btn_buscarNumSerie = new JButton("..");
		pnl_datEspePro.add(btn_buscarNumSerie);
		gridSuperior2.setConstraints(btn_buscarNumSerie, gridConSuperior2);
		
		gridConSuperior2.gridx = 0;
		gridConSuperior2.gridy = 1;
		lbl_color = new JLabel("Color :");
		pnl_datEspePro.add(lbl_color);
		gridSuperior2.setConstraints(lbl_color, gridConSuperior2);
		
		gridConSuperior2.gridx = 1;
		gridConSuperior2.gridy = 1;
		txt_color = new JTextField(20);
		pnl_datEspePro.add(txt_color);
		gridSuperior2.setConstraints(txt_color, gridConSuperior2);
		
		gridConSuperior2.gridx = 2;
		gridConSuperior2.gridy = 1;
		btn_buscarColor = new JButton("..");
		pnl_datEspePro.add(btn_buscarColor);
		gridSuperior2.setConstraints(btn_buscarColor, gridConSuperior2);
		
		gridConSuperior2.gridx = 0;
		gridConSuperior2.gridy = 2;
		lbl_detalle = new JLabel("Detalle :");
		pnl_datEspePro.add(lbl_detalle);
		gridSuperior2.setConstraints(lbl_detalle, gridConSuperior2);
		
		gridConSuperior2.gridx = 1;
		gridConSuperior2.gridy = 2;
		txta_detalle = new JTextArea(10, 5);
		txta_detalle.setLineWrap(true);
		txta_detalle.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(txta_detalle);		
		pnl_datEspePro.add(scroll);
		gridSuperior2.setConstraints(scroll, gridConSuperior2);
		
		//PANEL TABLA
		pnl_tabla = new JPanel();
		
		jtproducto = new Tabla_Producto_Consulta();
		tabla  = new JTable(jtproducto);
		tabla.addMouseListener(this);
		tabla.getTableHeader().setReorderingAllowed(false);
		scrollProductoEstado = new JScrollPane(tabla);
		pnl_tabla.add(scrollProductoEstado);
		
		anchoColumnaTabla();
		
		pnl_datos.add(pnl_tabla);
		
		//PANEL BOTONES
		pnl_botones = new JPanel();
		pnl_botones.setLayout(new GridLayout(1, 4, 10, 10));
		
		btn_agregar = new JButton("AGREGAR");
		btn_agregar.addActionListener(this);
		btn_actualizar = new JButton("MODIFICAR");
		btn_limpiar = new JButton("LIMPIAR");
		btn_salir = new JButton("SALIR");
		btn_salir.addActionListener(this);
		
		pnl_botones.add(btn_agregar);
		pnl_botones.add(btn_actualizar);
		pnl_botones.add(btn_limpiar);
		pnl_botones.add(btn_salir);	
		
		getContentPane().add(pnl_datos, BorderLayout.NORTH);
		getContentPane().add(pnl_tabla, BorderLayout.CENTER);
		getContentPane().add(pnl_botones, BorderLayout.SOUTH);
		
		((JComponent)getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
	}
	
	public void limpiarPantalla(){
		
		txt_nombre.setText("");
		txt_marca.setText("");
		txt_modelo.setText("");
		txt_valor.setText("");
		txt_minimo.setText("");
		txt_maximo.setText("");
		
	}
	
	public void anchoColumnaTabla(){
		
		tabla.getColumnModel().getColumn(0).setPreferredWidth(70);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(70);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(70);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(30);
		
	}

	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getSource() == btn_agregar){	
			
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
			
			Producto producto = new Producto(categoria, nombre, marca, modelo, valor, minimo, maximo);

			producto.ingresarProducto(producto);
			JOptionPane.showMessageDialog(null, "Registro exitoso");			
			limpiarPantalla();
			
		}
		
		if(evento.getSource() == btn_buscarMarca){
			
			String marca;
			marca = txt_marca.getText();
			
			if ("".equals(marca)){
				JOptionPane.showMessageDialog(null, "Llenar el campo de busqueda");
				txt_marca.setText("");				
			}else{
				Producto producto = new Producto();
				ArrayList<Producto> listaProductoMarca = producto.listarProductosxMarca(marca);
				Tabla_Producto_Consulta tablaProMarca = new Tabla_Producto_Consulta(listaProductoMarca);
				tabla.removeAll();
				tabla.setModel(tablaProMarca);
				tabla.updateUI();
			}
		
		}
		
		if(evento.getSource() == btn_actualizar){			

		}
		
		if(evento.getSource() == btn_limpiar){			
			
			limpiarPantalla();
			
		}
		
		if(evento.getSource() == btn_salir){

		}
		
		
	}
	
	public void mouseClicked(MouseEvent evento) {
		
		int fila = tabla.rowAtPoint(evento.getPoint());
        txt_nombre.setText(tabla.getValueAt(fila, 0).toString());
        txt_marca.setText(tabla.getValueAt(fila, 1).toString());
        txt_modelo.setText(tabla.getValueAt(fila, 2).toString());
        txt_valor.setText(tabla.getValueAt(fila, 3).toString());
        
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}


}
