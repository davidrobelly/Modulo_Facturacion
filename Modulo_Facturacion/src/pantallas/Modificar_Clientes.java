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

import controles.Control_Modificar_Clientes;
import controles.Control_Ventana_Registro_Cliente;

public class Modificar_Clientes extends JFrame{
	
	Control_Modificar_Clientes control;
	
	public JPanel PanelCentral, PanelBotones;
	public JButton btnmodificar, btnborrar;
	public JLabel lblnombre, lbldireccion, lbltelefono, 
				lblcedula, lblestado, lbltipo, 
				lblcorreo, lblapellido, lblid;
	public JTextField txtnombre, txtdireccion, 
	txttelefono, txtcedula, txtcorreo, txtapellido, txtid;  
	public JComboBox cmbtipo, cmbestado;
	
	
	
	public Modificar_Clientes () {
		
		initcomponents ();
		ventana();
		control = new Control_Modificar_Clientes(this);
		
		PanelCentral.setLayout(new GridLayout(9,2));
		PanelBotones.setLayout(new GridLayout(0,2));
		
		//panel de Botones
		PanelBotones.add(btnmodificar);
		PanelBotones.add(btnborrar);
		
		//panel de formulario
		PanelCentral.add(lblid);
		PanelCentral.add(txtid);
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
		btnmodificar.addActionListener(control);
		btnborrar.addActionListener(control);
	}
	
	private void ventana() {
		
		this.setLocationRelativeTo(null);
		this.pack();
		this.setTitle("Modificar datos de Clientes");
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
		
		btnmodificar = new JButton("Modificar");
		btnborrar = new JButton("Borrar");
		
		txtnombre = new JTextField();
		txtdireccion = new JTextField();
		txttelefono = new JTextField();
		txtcedula = new JTextField();
		txtcorreo = new JTextField();
		txtapellido = new JTextField();
		txtid = new JTextField();
		txtid.setEditable(false);
		
		cmbestado = new JComboBox ();
		cmbestado.addItem("Activo");
		cmbestado.addItem("Inactivo");
		
		cmbtipo = new JComboBox ();
		cmbtipo.addItem("Minorista");
		cmbtipo.addItem("Mayorista");
		
		
		lblnombre = new JLabel("Nombre: ");
		lblcedula = new JLabel("C�dula: ");
		lbldireccion = new JLabel("Direcci�n: ");
		lbltelefono = new JLabel("Tel�fono: ");
		lblcorreo = new JLabel("Correo: ");
		lbltipo = new JLabel ("Tipo: ");
		lblestado = new JLabel ("Estado: ");
		lblapellido = new JLabel("Apellido: ");
		lblid = new JLabel ("Id");
		
	}

}
