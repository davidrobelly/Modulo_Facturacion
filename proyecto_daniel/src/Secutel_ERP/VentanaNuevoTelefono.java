package Secutel_ERP;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class VentanaNuevoTelefono extends VentanaNuevoProveedor {

	ControladorNuevoTelefono controlNT;
	JPanel datosTel;
	JLabel numeroTel;
	JTextField txtTel;
	
	
	public VentanaNuevoTelefono() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		controlNT = new ControladorNuevoTelefono(this);
		controlNT.venNT = this;
		elementos();
	}
	
	public VentanaNuevoTelefono(ControladorNuevoTelefono controlNT) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		this.controlNT = controlNT;
		this.controlNT.venNT = this;
		elementos();
	}
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaNuevoTelefono frame = new VentanaNuevoTelefono();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void elementos(){
		setTitle("Telefono");
		contentPane.removeAll();
		datosTel = new JPanel();
		datosTel.setLayout(grid);
		datosTel.setBorder(new TitledBorder(null, "Datos Telefono", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		buildConstraints(con, 0, 0, 1, 1);
		grid.setConstraints(datosTel, con);
		numeroTel = new JLabel("Ingrese numero:");
		buildConstraints(con, 0, 0, 1, 1);
		con.fill = GridBagConstraints.HORIZONTAL;
		grid.setConstraints(numeroTel, con);
		datosTel.add(numeroTel);
		txtTel = new JTextField("",15);
		txtTel.addKeyListener(controlNT);
		buildConstraints(con, 1, 0, 1, 1);
		grid.setConstraints(txtTel, con);
		datosTel.add(txtTel);
		registrar.removeActionListener(control);
		registrar.addActionListener(controlNT);
		registrar.setText("añadir");
		contentPane.add(datosTel);
		buildConstraints(con, 0, 2, 1, 1);
		grid.setConstraints(botones, con);
		botones.remove(registrarCon);
		contentPane.add(botones);
		
	}

}
