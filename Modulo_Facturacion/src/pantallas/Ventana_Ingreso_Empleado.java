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

import controles.Control_Ventana_Registro_Empleado;

@SuppressWarnings("serial")
public class Ventana_Ingreso_Empleado extends JFrame {

Control_Ventana_Registro_Empleado control;
	
	public JPanel PanelCentral, PanelBotones;
	public JButton btnregistrar, btncancelar, btnborrar;
	public JLabel lblnombre, lbldireccion, lbltelefono, lblcedula, lblestado, lbltipo, lblfecha, lblapellido;  
	public JTextField txtfecha, txtnombre, txttelefono, txtcedula, txtdireccion, txtapellido;
	public JComboBox<String> cmbtipo, cmbestado;
	

	
	public Ventana_Ingreso_Empleado () {
		
		initcomponents ();
		ventana();
		control = new Control_Ventana_Registro_Empleado(this);
		
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
		PanelCentral.add(lbldireccion);
		PanelCentral.add(txtdireccion);
		PanelCentral.add(lbltelefono);
		PanelCentral.add(txttelefono);
		PanelCentral.add(lblfecha);
		PanelCentral.add(txtfecha);
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
		this.setTitle("Registro de Empleados");
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500, 300);
		this.setLocation(500, 200);
		this.setResizable(false);
		
	}
	
	private void initcomponents () {
		
		PanelCentral = new JPanel();
		PanelBotones = new JPanel();
		
		Border bordejpanel = new TitledBorder(new EtchedBorder(), "Detalles del Empleado ");
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
		txtfecha = new JTextField();
		txtapellido = new JTextField();
		
		
		cmbestado = new JComboBox<String>();
		cmbestado.addItem("Activo");
		cmbestado.addItem("Inactivo");
		cmbestado.setEnabled(false);
		
		cmbtipo = new JComboBox<String> ();
		cmbtipo.addItem("Vendedor");
		cmbtipo.addItem("Administrador");
		
		
		lblnombre = new JLabel("Nombre: ");
		lblcedula = new JLabel("Cédula: ");
		lbldireccion = new JLabel("Teléfono: ");
		lbltelefono = new JLabel("Dirección: ");
		lblfecha = new JLabel("Edad: ");
		lbltipo = new JLabel ("Tipo: ");
		lblestado = new JLabel ("Estado: ");
		lblapellido = new JLabel ("Apellido: ");
		
	}
	
	
}
