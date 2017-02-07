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

import controles.Control_Ventana_Registro_Cliente;
import controles.Control_Ventana_Registro_Sucursal;

public class Ventana_Ingreso_Sucursal extends JFrame {

	Control_Ventana_Registro_Sucursal control;
	
	public JPanel PanelCentral, PanelBotones;
	public JButton btnregistrar, btncancelar, btnborrar;
	public JLabel lblnombre, lbldireccion, lblestado;
	public JTextField txtnombre, txtdireccion, txttelefono, txtcedula, txtcorreo;  
	public JComboBox cmbestado;
	
	public Ventana_Ingreso_Sucursal () {
		
		initcomponents ();
		ventana();
		control = new Control_Ventana_Registro_Sucursal(this);
		
		PanelCentral.setLayout(new GridLayout(3,2));
		PanelBotones.setLayout(new GridLayout(0,3));
		
		//panel de Botones
		PanelBotones.add(btnregistrar);
		PanelBotones.add(btnborrar);
		PanelBotones.add(btncancelar);
		
		//panel de formulario
		PanelCentral.add(lblnombre);
		PanelCentral.add(txtnombre);
		PanelCentral.add(lbldireccion);
		PanelCentral.add(txtdireccion);
		PanelCentral.add(lblestado);
		PanelCentral.add(cmbestado);
		
		this.getContentPane().add(PanelCentral, "Center");
		this.getContentPane().add(PanelBotones, "South");

		//eventos
		btnregistrar.addActionListener(control);
		btncancelar.addActionListener(control);
		btnborrar.addActionListener(control);
	}
	
	private void ventana() {
		
		this.setLocationRelativeTo(null);
		this.pack();
		this.setTitle("Registro de Sucursales");
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
		
		btnregistrar = new JButton("Registrar");
		btncancelar = new JButton("Cancelar");
		btnborrar = new JButton("Borrar");
		
		txtnombre = new JTextField();
		txtdireccion = new JTextField();
		
		cmbestado = new JComboBox ();
		cmbestado.addItem("Activo");
		cmbestado.addItem("Inactivo");
		cmbestado.setEnabled(false);
		
		
		lblnombre = new JLabel("Nombre: ");
		lbldireccion = new JLabel("Direccion: ");
		lblestado = new JLabel ("Estado: ");
		
	}
	
}
