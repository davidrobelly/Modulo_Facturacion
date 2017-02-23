package Vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Modelo.Producto;
import Tablas.Tabla_Producto_Modificar;

@SuppressWarnings("serial")
public class Pantalla_Modificar_Producto extends JFrame implements ActionListener, MouseListener{
	
	public ImageIcon ico_aplicacion;
	public JPanel pnl_datos, pnl_tabla, pnl_botones;
	public JLabel lbl_categoria, lbl_nombre, lbl_marca, lbl_modelo, lbl_valor,
	  			  lbl_minimo, lbl_maximo, lbl_serie, lbl_color, lbl_codProducto;
	public JTextField txt_categoria, txt_nombre, txt_marca, txt_modelo, txt_valor, txt_minimo, 
	  				  txt_maximo, txt_serie, txt_color, txt_codProducto;
	public JButton btn_actualizar, btn_limpiar, btn_buscarMarca, btn_buscarModelo;
	public JTable tabla;
	public JScrollPane scrollProducto;
	
	public Producto producto;
	public Tabla_Producto_Modificar modificarProducto;
	
//	public final int limite = 10;
	
	public int codProducto;

	public Pantalla_Modificar_Producto (){
		
		super("Producto - Modificar");
		setSize(500, 600);
		setLocation(400, 25);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Icono de la Aplicacion
		ico_aplicacion = new ImageIcon("src/Imagenes/icono.gif");
		setIconImage(ico_aplicacion.getImage());
		
		pnl_datos = new JPanel();
		getContentPane().add(pnl_datos, BorderLayout.NORTH);
		
		GridBagLayout gridCentral = new GridBagLayout();
		pnl_datos.setLayout(gridCentral);
		
		GridBagConstraints gridConCentral = new GridBagConstraints();
		gridConCentral.fill = GridBagConstraints.BOTH;
		gridConCentral.insets = new Insets(3, 3, 3, 3);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 0;
		gridConCentral.gridheight = 1;
		gridConCentral.gridwidth = 1;
		lbl_categoria = new JLabel("Categoria : ");
		pnl_datos.add(lbl_categoria);
		gridCentral.setConstraints(lbl_categoria, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 0;
		txt_categoria = new JTextField(20);
		pnl_datos.add(txt_categoria);
		gridCentral.setConstraints(txt_categoria, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 1;
		gridConCentral.gridheight = 1;
		gridConCentral.gridwidth = 1;
		lbl_nombre= new JLabel("Nombre : ");
		pnl_datos.add(lbl_nombre);
		gridCentral.setConstraints(lbl_nombre, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 1;
		txt_nombre = new JTextField(20);
		pnl_datos.add(txt_nombre);
		gridCentral.setConstraints(txt_nombre, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 2;
		lbl_marca = new JLabel("Marca : ");
		pnl_datos.add(lbl_marca);
		gridCentral.setConstraints(lbl_marca, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 2;
		txt_marca = new JTextField(20);
		pnl_datos.add(txt_marca);
		gridCentral.setConstraints(txt_marca, gridConCentral);

		gridConCentral.gridx = 2;
		gridConCentral.gridy = 2;
		btn_buscarMarca = new JButton(new ImageIcon("src/Imagenes/buscarP.jpeg"));
		btn_buscarMarca.setBorder(null);
		btn_buscarMarca.addActionListener(this);
		pnl_datos.add(btn_buscarMarca);
		gridCentral.setConstraints(btn_buscarMarca, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 3;
		lbl_modelo = new JLabel("Modelo : ");
		pnl_datos.add(lbl_modelo);
		gridCentral.setConstraints(lbl_modelo, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 3;
		txt_modelo = new JTextField(20);
		pnl_datos.add(txt_modelo);
		gridCentral.setConstraints(txt_modelo, gridConCentral);

		gridConCentral.gridx = 2;
		gridConCentral.gridy = 3;
		btn_buscarModelo = new JButton(new ImageIcon("src/Imagenes/buscarP.jpeg"));
		btn_buscarModelo.setBorder(null);
		pnl_datos.add(btn_buscarModelo);
		gridCentral.setConstraints(btn_buscarModelo, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 4;
		lbl_valor = new JLabel("Precio : ");
		pnl_datos.add(lbl_valor);
		gridCentral.setConstraints(lbl_valor, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 4;
		txt_valor = new JTextField(20);
		pnl_datos.add(txt_valor);
		gridCentral.setConstraints(txt_valor, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 5;
		lbl_minimo = new JLabel("Minimo : ");
		pnl_datos.add(lbl_minimo);
		gridCentral.setConstraints(lbl_minimo, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 5;
		txt_minimo = new JTextField(20);
		pnl_datos.add(txt_minimo);
		gridCentral.setConstraints(txt_minimo, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 6;
		lbl_maximo = new JLabel("Maximo : ");
		pnl_datos.add(lbl_maximo);
		gridCentral.setConstraints(lbl_maximo, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 6;
		txt_maximo = new JTextField(20);
		pnl_datos.add(txt_maximo);
		gridCentral.setConstraints(txt_maximo, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 7;
		lbl_serie = new JLabel("Serie : ");
		pnl_datos.add(lbl_serie);
		gridCentral.setConstraints(lbl_serie, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 7;
		txt_serie = new JTextField(20);
		pnl_datos.add(txt_serie);
		gridCentral.setConstraints(txt_serie, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 8;
		lbl_color = new JLabel("Color : ");
		pnl_datos.add(lbl_color);
		gridCentral.setConstraints(lbl_color, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 8;
		txt_color = new JTextField(20);
		pnl_datos.add(txt_color);
		gridCentral.setConstraints(txt_color, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 9;
		lbl_codProducto = new JLabel("Codigo Producto : ");
		pnl_datos.add(lbl_codProducto);
		gridCentral.setConstraints(lbl_codProducto, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 9;
		txt_codProducto = new JTextField(20);
		pnl_datos.add(txt_codProducto);
		gridCentral.setConstraints(txt_codProducto, gridConCentral);
		
		//PANEL CENTRAL
		pnl_tabla = new JPanel();
		
		modificarProducto = new Tabla_Producto_Modificar();
		tabla  = new JTable(modificarProducto);
		tabla.addMouseListener(this);
		tabla.getTableHeader().setReorderingAllowed(false);
		scrollProducto = new JScrollPane(tabla);
		pnl_tabla.add(scrollProducto);
		
		//PANEL BOTONES
		pnl_botones = new JPanel();
		
		btn_actualizar = new JButton(new ImageIcon("src/Imagenes/activar.jpeg"));
		btn_actualizar.setBorder(null);
		btn_actualizar.addActionListener(this);
		btn_limpiar = new JButton(new ImageIcon("src/Imagenes/limpiar.jpeg"));
		btn_limpiar.addActionListener(this);
		btn_limpiar.setBorder(null);
		
		pnl_botones.add(btn_actualizar);
		pnl_botones.add(btn_limpiar);
		
		getContentPane().add(pnl_tabla, BorderLayout.CENTER);
		getContentPane().add(pnl_botones, BorderLayout.SOUTH);
		
		((JComponent)getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
	}

	public void limpiarPantalla(){
		
		txt_codProducto.setText("");
		txt_categoria.setText("");
		txt_nombre.setText("");
		txt_marca.setText("");
		txt_modelo.setText("");
		txt_valor.setText("");
		txt_minimo.setText("");
		txt_maximo.setText("");
//		txt_serie.setText("");
//		txt_color.setText("");
		tabla.setModel(modificarProducto);
	}
	
	public void anchoColumnaTabla(){
		
		tabla.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(20);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(20);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(20);
		tabla.getColumnModel().getColumn(4).setPreferredWidth(20);
		tabla.getColumnModel().getColumn(5).setPreferredWidth(20);
		tabla.getColumnModel().getColumn(6).setPreferredWidth(20);
		tabla.getColumnModel().getColumn(7).setPreferredWidth(20);
//		tabla.getColumnModel().getColumn(8).setPreferredWidth(20);
//		tabla.getColumnModel().getColumn(9).setPreferredWidth(20);
		
	}
	
	public void actionPerformed(ActionEvent evento) {
		
		if (evento.getSource() == btn_buscarMarca) {
			
			String marca;
			marca = txt_marca.getText();
			
			if ("".equals(marca)){
				JOptionPane.showMessageDialog(null, "Llenar el campo de busqueda");
				txt_marca.setText("");
			} else{
				Producto producto = new Producto();
				ArrayList<Producto> listaProductoMarca = producto.listarProductosxMarcaCodigo(marca);
				Tabla_Producto_Modificar tablaProMarca= new Tabla_Producto_Modificar(listaProductoMarca);
				tabla.removeAll();
				tabla.setModel(tablaProMarca);
				tabla.updateUI();
			}

		}
		
		if(evento.getSource() == btn_actualizar){	
			if (txt_categoria.getText().equals("") || txt_nombre.getText().equals("") 
					|| txt_marca.getText().equals("") || txt_modelo.getText().equals("")
					|| txt_valor.getText().equals("") || txt_minimo.getText().equals("")
					|| txt_maximo.getText().equals("") || txt_codProducto.getText().equals("")){
				
				JOptionPane.showMessageDialog(null, "Llenar todos los campos");
			}else{
				
				producto = new Producto (Integer.parseInt(txt_codProducto.getText()), txt_categoria.getText(), txt_nombre.getText(), txt_marca.getText(), txt_modelo.getText(),
						Double.parseDouble(txt_valor.getText()), Integer.parseInt(txt_minimo.getText()), Integer.parseInt(txt_maximo.getText()));

				codProducto = Integer.parseInt(txt_codProducto.getText());

				producto.modificarProducto(codProducto, producto);

				JOptionPane.showMessageDialog(null, "Modificacion Realizada");
				
				limpiarPantalla();
			}
		}
		
		if(evento.getSource() == btn_limpiar){			
			
			limpiarPantalla();
			
		}
		
	}

	public void mouseClicked(MouseEvent evento) {
		
		int fila = tabla.rowAtPoint(evento.getPoint());

		txt_codProducto.setText(tabla.getValueAt(fila, 0).toString());
        txt_categoria.setText(tabla.getValueAt(fila, 1).toString());
        txt_nombre.setText(tabla.getValueAt(fila, 2).toString());
        txt_marca.setText(tabla.getValueAt(fila, 3).toString());
        txt_modelo.setText(tabla.getValueAt(fila, 4).toString());
        txt_valor.setText(tabla.getValueAt(fila, 5).toString());
        txt_minimo.setText(tabla.getValueAt(fila, 6).toString());
        txt_maximo.setText(tabla.getValueAt(fila, 7).toString());
//        txt_serie.setText(tabla.getValueAt(fila, 8).toString());
//        txt_color.setText(tabla.getValueAt(fila, 9).toString());
      
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
