package Vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Pantalla_Kardex extends JFrame{
	
	public ImageIcon ico_aplicacion;
	public JPanel pnl_central, pnl_botones;
	public JLabel lbl_tipo, lbl_fecha, lbl_producto, lbl_cantidad, lbl_preCompra, lbl_detalle;
	public JComboBox<String> cbx_tipo;
	public JTextField txt_fecha, txt_producto, txt_cantidad, txt_preCompra;
	public JTextArea txta_detalle;;
	public JButton btn_agregar;
	public JScrollPane scroll;
	
	public Pantalla_Kardex (){
		
		super("Kardex - Entradas y Salidas");
		setSize(400, 300);
		setLocation(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Icono de la Aplicacion
		ico_aplicacion = new ImageIcon("src/Imagenes/icono.gif");
		setIconImage(ico_aplicacion.getImage());
		
		//PANEL CENTRAL
		pnl_central = new JPanel();
		getContentPane().add(pnl_central, BorderLayout.NORTH);
		
		GridBagLayout gridCentral = new GridBagLayout();
		pnl_central.setLayout(gridCentral);
		
		GridBagConstraints gridConCentral = new GridBagConstraints();
		gridConCentral.fill = GridBagConstraints.BOTH;
		gridConCentral.insets = new Insets(3, 3, 3, 3);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 0;
		gridConCentral.gridheight = 1;
		gridConCentral.gridwidth = 1;
		lbl_tipo = new JLabel("Tipo : ");
		pnl_central.add(lbl_tipo);
		gridCentral.setConstraints(lbl_tipo, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 0;
		cbx_tipo = new JComboBox<String>();
		cbx_tipo.addItem("INGRESO");
		cbx_tipo.addItem("EGRESO");
		pnl_central.add(cbx_tipo);
		gridCentral.setConstraints(cbx_tipo, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 1;
		lbl_fecha = new JLabel("Fecha : ");
		pnl_central.add(lbl_fecha);
		gridCentral.setConstraints(lbl_fecha, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 1;
		txt_fecha = new JTextField(20);
		pnl_central.add(txt_fecha);
		gridCentral.setConstraints(txt_fecha, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 2;
		lbl_producto = new JLabel("Producto : ");
		pnl_central.add(lbl_producto);
		gridCentral.setConstraints(lbl_producto, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 2;
		txt_producto = new JTextField(20);
		pnl_central.add(txt_producto);
		gridCentral.setConstraints(txt_producto, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 3;
		lbl_cantidad = new JLabel("Cantidad : ");
		pnl_central.add(lbl_cantidad);
		gridCentral.setConstraints(lbl_cantidad, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 3;
		txt_cantidad = new JTextField(20);
		pnl_central.add(txt_cantidad);
		gridCentral.setConstraints(txt_cantidad, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 4;
		lbl_preCompra = new JLabel("Precio de Compra : ");
		pnl_central.add(lbl_preCompra);
		gridCentral.setConstraints(lbl_preCompra, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 4;
		txt_preCompra = new JTextField(20);
		pnl_central.add(txt_preCompra);
		gridCentral.setConstraints(txt_preCompra, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 5;
		lbl_detalle = new JLabel("Detalle : ");
		pnl_central.add(lbl_detalle);
		gridCentral.setConstraints(lbl_detalle, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 5;
		txta_detalle = new JTextArea(2, 5);
		txta_detalle.setLineWrap(true);
		txta_detalle.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(txta_detalle);		
		pnl_central.add(scroll);
		gridCentral.setConstraints(scroll, gridConCentral);
		
		//PANEL BOTONES
		pnl_botones = new JPanel(new GridLayout(1, 1));
		
		btn_agregar = new JButton("AGREGAR");
		
		pnl_botones.add(btn_agregar);	
		
		getContentPane().add(pnl_central, BorderLayout.CENTER);
		getContentPane().add(pnl_botones, BorderLayout.SOUTH);
		
		((JComponent)getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}
	

}
