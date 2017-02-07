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

public class Ventana_Ingreso_Clientes extends JFrame{
	
	Control_Ventana_Registro_Cliente control;
	
	public JPanel PanelCentral, PanelBotones;
	public JButton btnregistrar, btncancelar, btnborrar;
	public JLabel lblnombre, lbldireccion, lbltelefono, lblcedula, lblestado, lbltipo, lblcorreo, lblapellido;
	public JTextField txtnombre, txtdireccion, txttelefono, txtcedula, txtcorreo, txtapellido;  
	public JComboBox cmbtipo, cmbestado;
	
	
	
	public Ventana_Ingreso_Clientes () {
		
		initcomponents ();
		ventana();
		control = new Control_Ventana_Registro_Cliente(this);
		
		PanelCentral.setLayout(new GridLayout(8,2));
		PanelBotones.setLayout(new GridLayout(0,3));
		
		//panel de Botones
		PanelBotones.add(btnregistrar);
		PanelBotones.add(btnborrar);
		PanelBotones.add(btncancelar);
		
		//panel de formulario
		PanelCentral.add(lblnombre);
		PanelCentral.add(txtnombre);
		PanelCentral.add(lblapellido);
		PanelCentral.add(txtapellido);
		PanelCentral.add(lblcedula);
		PanelCentral.add(txtcedula);
		PanelCentral.add(lbltelefono);
		PanelCentral.add(txttelefono);
		PanelCentral.add(lblcorreo);
		PanelCentral.add(txtcorreo);
		PanelCentral.add(lbldireccion);
		PanelCentral.add(txtdireccion);
		PanelCentral.add(lbltipo);
		PanelCentral.add(cmbtipo);
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
		this.setTitle("Registro de Clientes");
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500, 300);
		this.setLocation(500, 200);
		this.setResizable(false);
		
	}
	
	private void initcomponents () {
		
		PanelCentral = new JPanel();
		PanelBotones = new JPanel();
		
		Border bordejpanel = new TitledBorder(new EtchedBorder(), "Detalles del Cliente ");
		PanelCentral.setBorder(bordejpanel);
		
		Border bordejpane2 = new TitledBorder(new EtchedBorder(), "");
		PanelBotones.setBorder(bordejpane2);
		
		this.setBackground(Color.white);
		
		btnregistrar = new JButton("Registrar");
		btncancelar = new JButton("Cancelar");
		btnborrar = new JButton("Borrar");
		
		txtnombre = new JTextField();
		txtdireccion = new JTextField();
		txttelefono = new JTextField();
		txtcedula = new JTextField();
		txtcorreo = new JTextField();
		txtapellido = new JTextField();
		
		cmbestado = new JComboBox ();
		cmbestado.addItem("Activo");
		cmbestado.addItem("Inactivo");
		cmbestado.setEnabled(false);
		
		cmbtipo = new JComboBox ();
		cmbtipo.addItem("Minorista");
		cmbtipo.addItem("Mayorista");
		
		
		lblnombre = new JLabel("Nombre: ");
		lblcedula = new JLabel("Cédula: ");
		lbldireccion = new JLabel("Dirección: ");
		lbltelefono = new JLabel("Teléfono: ");
		lblcorreo = new JLabel("Correo: ");
		lbltipo = new JLabel ("Tipo: ");
		lblestado = new JLabel ("Estado: ");
		lblapellido = new JLabel("Apellido: ");
		
	}
	

}
