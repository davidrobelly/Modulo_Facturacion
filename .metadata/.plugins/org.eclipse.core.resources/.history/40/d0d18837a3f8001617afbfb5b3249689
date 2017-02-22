package pantallas;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controles.Control_Modificar_Locales;
import controles.Control_Ventana_Registro_Sucursal;

public class Modificar_Locales extends JFrame {

	Control_Modificar_Locales control;
	
	public JPanel PanelCentral, PanelBotones;
	public JButton btnregistrar, btnborrar;
	public JLabel lblnombre, lbldireccion, lblciudad, lblestado;
	public JTextField txtnombre, txtdireccion, txtciudad;  
	public JComboBox cmbestado;
	
	public Modificar_Locales () {
		
		initcomponents ();
		ventana();
		control = new Control_Modificar_Locales(this);
		
		PanelCentral.setLayout(new GridLayout(4,2));
		PanelBotones.setLayout(new GridLayout(0,2));
		
		//panel de Botones
		PanelBotones.add(btnregistrar);
		PanelBotones.add(btnborrar);
		
		//panel de formulario
		PanelCentral.add(lblnombre);
		PanelCentral.add(txtnombre);
		PanelCentral.add(lbldireccion);
		PanelCentral.add(txtdireccion);
		PanelCentral.add(lblciudad);
		PanelCentral.add(txtciudad);
		PanelCentral.add(lblestado);
		PanelCentral.add(cmbestado);
		
		this.getContentPane().add(PanelCentral, "Center");
		this.getContentPane().add(PanelBotones, "South");

		//eventos
		btnregistrar.addActionListener(control);
		btnborrar.addActionListener(control);
	}
	
	private void ventana() {
		
		this.setLocationRelativeTo(null);
		this.pack();
		this.setTitle("Modificar Local");
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500, 180);
		this.setLocation(500, 200);
		this.setResizable(false);
		
	}
	
	private void initcomponents () {
		
		PanelCentral = new JPanel();
		PanelBotones = new JPanel();
		
		Border bordejpanel = new TitledBorder(new EtchedBorder(), "Detalles de la Sucursal ");
		PanelCentral.setBorder(bordejpanel);
		
		Border bordejpane2 = new TitledBorder(new EtchedBorder(), "");
		PanelBotones.setBorder(bordejpane2);
		
		this.setBackground(Color.white);
		
		btnregistrar = new JButton("Modificar");
		btnborrar = new JButton("Borrar");
		
		txtnombre = new JTextField();
		txtdireccion = new JTextField();
		txtciudad = new JTextField();
		
		cmbestado = new JComboBox ();
		cmbestado.addItem("Activo");
		cmbestado.addItem("Inactivo");
		
		
		lblnombre = new JLabel("Nombre: ");
		lbldireccion = new JLabel("Direccion: ");
		lblestado = new JLabel ("Estado: ");
		lblciudad = new JLabel ("Ciudad");
		
	}

}
