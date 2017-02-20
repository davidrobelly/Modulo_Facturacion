package Vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Pantalla_Cambio_Estado_Producto extends JFrame{
	
	public ImageIcon ico_aplicacion;
	public JPanel pnl_superior, pnl_central, pnl_botones;
	public JLabel lbl_marca, lbl_modelo;
	public JTextField txt_marca, txt_modelo;
	public JButton btn_buscarMarca, btn_buscarModelo, btn_activar, btn_desactivar;
	public Tabla_Producto_Estado estadoProducto;
	public JTable tabla;
	public JScrollPane scrollEstadoProducto;
	
	Pantalla_Cambio_Estado_Producto () {
		
		super("Producto - Cambio de Estado");
		setSize(500, 300);
		setLocation(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Icono de la Aplicacion
		ico_aplicacion = new ImageIcon("src/Imagenes/icono.gif");
		setIconImage(ico_aplicacion.getImage());
		
		//PANEL SUPERIOR
		pnl_superior = new JPanel();
		getContentPane().add(pnl_superior, BorderLayout.NORTH);
		
		GridBagLayout gridCentral = new GridBagLayout();
		pnl_superior.setLayout(gridCentral);
		
		GridBagConstraints gridConCentral = new GridBagConstraints();
		gridConCentral.fill = GridBagConstraints.BOTH;
		gridConCentral.insets = new Insets(3, 3, 3, 3);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 0;
		gridConCentral.gridheight = 1;
		gridConCentral.gridwidth = 1;
		lbl_marca = new JLabel("Marca : ");
		pnl_superior.add(lbl_marca);
		gridCentral.setConstraints(lbl_marca, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 0;
		txt_marca = new JTextField(20);
		pnl_superior.add(txt_marca);
		gridCentral.setConstraints(txt_marca, gridConCentral);

		gridConCentral.gridx = 2;
		gridConCentral.gridy = 0;
		btn_buscarMarca = new JButton("..");
		pnl_superior.add(btn_buscarMarca);
		gridCentral.setConstraints(btn_buscarMarca, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 1;
		lbl_modelo = new JLabel("Modelo : ");
		pnl_superior.add(lbl_modelo);
		gridCentral.setConstraints(lbl_modelo, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 1;
		txt_modelo = new JTextField(20);
		pnl_superior.add(txt_modelo);
		gridCentral.setConstraints(txt_modelo, gridConCentral);

		gridConCentral.gridx = 2;
		gridConCentral.gridy = 1;
		btn_buscarModelo = new JButton("..");
		pnl_superior.add(btn_buscarModelo);
		gridCentral.setConstraints(btn_buscarModelo, gridConCentral);
		
		//PANEL CENTRAL
		pnl_central = new JPanel();
		
		estadoProducto = new Tabla_Producto_Estado();
		tabla  = new JTable(estadoProducto);
		scrollEstadoProducto = new JScrollPane(tabla);
		pnl_central.add(scrollEstadoProducto);
		
		//PANEL BOTONES
		pnl_botones = new JPanel();
		
		btn_activar = new JButton("ACTIVAR");
		btn_desactivar = new JButton("DESACTIVAR");
		
		pnl_botones.add(btn_activar);
		pnl_botones.add(btn_desactivar);
		
		getContentPane().add(pnl_central, BorderLayout.CENTER);
		getContentPane().add(pnl_botones, BorderLayout.SOUTH);
		
		((JComponent)getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		

	}
	

}
