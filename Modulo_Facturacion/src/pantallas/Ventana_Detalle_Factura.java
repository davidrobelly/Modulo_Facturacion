package pantallas;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controles.Control_Ventana_Detalle_Factura;



public class Ventana_Detalle_Factura extends JFrame{
	
	Control_Ventana_Detalle_Factura control;
	
	public JPanel PanelCentral, PanelBotones;
	public JLabel lblcotizacion, lblproducto, lblvalor, lblcantidad;
	public JTextField txtfactura, txtproducto, txtvalor, txtcantidad;
	public JButton btnregistrar, btnlimpiar, btnbuscar;
	
	
	public Ventana_Detalle_Factura () {
		
		initcomponents();
		ventana();
		control = new Control_Ventana_Detalle_Factura(this);
		
		PanelCentral.setLayout(new GridLayout(4,2));
		PanelBotones.setLayout(new GridLayout(0,3));
		
		PanelCentral.add(lblcotizacion);
		PanelCentral.add(txtfactura);
		PanelCentral.add(lblproducto);
		PanelCentral.add(txtproducto);
		PanelCentral.add(lblcantidad);
		PanelCentral.add(txtcantidad);
		PanelCentral.add(lblvalor);
		PanelCentral.add(txtvalor);
		
		PanelBotones.add(btnregistrar);
		PanelBotones.add(btnlimpiar);
		PanelBotones.add(btnbuscar);
		
		this.getContentPane().add(PanelCentral, "Center");
		this.getContentPane().add(PanelBotones, "South");
		
		btnregistrar.addActionListener(control);
		btnlimpiar.addActionListener(control);
		btnbuscar.addActionListener(control);
		
	}


	private void ventana() {
		this.setLocationRelativeTo(null);
		this.pack();
		this.setTitle("Detalles de Factura");
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500, 180);
		this.setLocation(100, 200);
		this.setResizable(false);
		
	}


	private void initcomponents() {
		
		PanelCentral = new JPanel();
		PanelBotones = new JPanel();
		
		this.setBackground(Color.white);
		
		lblcotizacion = new JLabel ("cód. factura: ");
		lblproducto = new JLabel ("cód. producto: ");
		lblvalor = new JLabel ("valor: ");
		lblcantidad = new JLabel ("cantidad: ");
		
		txtfactura = new JTextField ();
		txtfactura.setEditable(false);
		txtproducto = new JTextField ();
		txtvalor = new JTextField ();
		txtcantidad = new JTextField ();
		
		btnregistrar = new JButton ("registrar");
		btnlimpiar = new JButton ("Limpiar");
		btnbuscar = new JButton("Buscar Prod.");
		
		Border bordejpanel = new TitledBorder(new EtchedBorder(), "Ingrese el detalle");
		PanelCentral.setBorder(bordejpanel);
		
		Border bordejpane2 = new TitledBorder(new EtchedBorder(), "");
		PanelBotones.setBorder(bordejpane2);
		
		
		
	}

}

