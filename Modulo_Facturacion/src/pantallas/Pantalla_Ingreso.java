package pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controles.Control_PIngreso;

public class Pantalla_Ingreso extends JFrame {
	
	public ImageIcon ico_aplicacion;
	public JLabel lbl_logo, lbl_usuario, lbl_contraseña;
	public JTextField txt_usuario;
	public JPasswordField txt_contraseña;
	public JButton btn_ingresar, btn_cancelar;
	public JPanel pnl_logo, pnl_datos, pnl_botones;
	
	Control_PIngreso control;
	
	public Pantalla_Ingreso(){
		
		
		ventana();
		initcomponents();

		control = new Control_PIngreso (this);
		
		pnl_logo.add(lbl_logo);
		pnl_datos.add(lbl_usuario);
		pnl_datos.add(txt_usuario);
		pnl_datos.add(lbl_contraseña);
		pnl_datos.add(txt_contraseña);
		
		pnl_botones.add(btn_ingresar);
		pnl_botones.add(btn_cancelar);
		
		getContentPane().add(pnl_logo, BorderLayout.WEST);
		getContentPane().add(pnl_datos, BorderLayout.CENTER);
		getContentPane().add(pnl_botones, BorderLayout.SOUTH);
		
		((JComponent)getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 5));
		
		btn_ingresar.addActionListener(control);
		btn_cancelar.addActionListener(control);
	}

	private void ventana() {

		this.setLocationRelativeTo(null);
		this.pack();
		this.setTitle("Ingreso");
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 150);
		this.setLocation(500, 200);
		this.setResizable(false);
		
	}

	private void initcomponents() {
		
		ico_aplicacion = new ImageIcon("src/Imagenes/icono.gif");
		setIconImage(ico_aplicacion.getImage());
		
		pnl_logo = new JPanel();		
		pnl_datos = new JPanel(new GridLayout(2, 2, 5, 5));
		pnl_botones = new JPanel();
		
		lbl_logo = new JLabel(new ImageIcon("src/Imagenes/logo.png"));

		lbl_usuario = new JLabel("Usuario");
		lbl_contraseña = new JLabel("Contraseña");
		
		txt_usuario = new JTextField(5);
		txt_contraseña = new JPasswordField(5);
		
		btn_ingresar = new JButton("Ingresar");
		btn_cancelar = new JButton("Cancelar");
		
	}

	
	
	

}


