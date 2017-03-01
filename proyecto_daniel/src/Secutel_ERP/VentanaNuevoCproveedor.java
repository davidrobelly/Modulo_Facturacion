package Secutel_ERP;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class VentanaNuevoCproveedor extends VentanaNuevoProveedor {

	ControladorNuevoCProveedor controlNCP;
	ControladorNuevoTelefono controlNT;
	JPanel panelDc,panelTel;
	JLabel nombreC,apellido,cedula,elegir;
	JTextField txtnombreC,txtapellido,txtcedula;
	TablaTelefonoContacto telefonos;
	JTable tableTel;
	JScrollPane scrollTel;
	ArrayList<TelefonoContacto> listaTel = new ArrayList<>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaNuevoCproveedor frame = new VentanaNuevoCproveedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaNuevoCproveedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		setTitle("Nuevo Contacto");
		controlNCP = new ControladorNuevoCProveedor(this);
		elementos();
		elegir = new JLabel("seleccione Proveedor");
		buildConstraints(con, 0, 3, 1, 1);
		con.anchor = GridBagConstraints.WEST;
		grid.setConstraints(elegir, con);
		panelDc.add(elegir);
	}
	public VentanaNuevoCproveedor(ControladorNuevoCProveedor control) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Nuevo Contacto");
		setBounds(100, 100, 450, 370);
		controlNCP = control;
		controlNCP.ingresoC = this;
		elementos();
	}
	void elementos(){
		controlNT = new ControladorNuevoTelefono(this);
		panelDc= new JPanel();
		panelDc.setLayout(grid);
		panelDc.setBorder(new TitledBorder(null, "Datos contacto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		nombreC = new JLabel("Nombre:");
		buildConstraints(con, 0, 0, 1, 1);
		con.fill = GridBagConstraints.HORIZONTAL;
		con.anchor = GridBagConstraints.WEST;
		grid.setConstraints(nombreC, con);
		panelDc.add(nombreC);
		txtnombreC = new JTextField("",20);
		txtnombreC.addKeyListener(controlNCP);
		buildConstraints(con, 1, 0, 1, 1);
		con.anchor = GridBagConstraints.EAST;
		grid.setConstraints(txtnombreC, con);
		panelDc.add(txtnombreC);
		apellido = new JLabel("Apellido:");
		buildConstraints(con, 0, 1, 1, 1);
		con.anchor = GridBagConstraints.WEST;
		grid.setConstraints(apellido, con);
		panelDc.add(apellido);
		txtapellido = new JTextField("",20);
		txtapellido.addKeyListener(controlNCP);
		buildConstraints(con, 1, 1, 1, 1);
		con.anchor = GridBagConstraints.EAST;
		grid.setConstraints(txtapellido, con);
		panelDc.add(txtapellido);
		cedula = new JLabel("Cedula:");
		buildConstraints(con, 0, 2, 1, 1);
		con.anchor = GridBagConstraints.WEST;
		grid.setConstraints(cedula, con);
		panelDc.add(cedula);
		txtcedula = new JTextField("",20);
		txtcedula.addKeyListener(controlNCP);
		buildConstraints(con, 1, 2, 1, 1);
		con.anchor = GridBagConstraints.EAST;
		grid.setConstraints(txtcedula, con);
		panelDc.add(txtcedula);
		registrar.removeActionListener(control);
		registrar.addActionListener(controlNCP);
		buildConstraints(con, 0, 0, 1, 1);
		con.fill = GridBagConstraints.BOTH;
		grid.setConstraints(panelDc, con);
		panelTel = new JPanel();
		panelTel.setLayout(grid);
		panelTel.setBorder(new TitledBorder(null, "Telefonos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		buildConstraints(con, 0, 2, 1, 1);
		grid.setConstraints(panelTel, con);
		telefonos = new TablaTelefonoContacto();
        tableTel  = new JTable(telefonos);
        tableTel.getTableHeader().setReorderingAllowed(false) ;
		scrollTel = new JScrollPane(tableTel);
		buildConstraints(con, 0, 0, 1, 1);
		//con.fill = GridBagConstraints.BOTH;
		//con.weighty = 1;
		grid.setConstraints(scrollTel, con);
		panelTel.add(scrollTel);
		contentPane.add(panelDc);
		contentPane.add(panelTel);
		registrarCon.setText("Agregar Telefono");
		registrarCon.removeActionListener(control);
		registrarCon.addActionListener(controlNCP);
		contentPane.remove(formulario);
		contentPane.remove(tabla);
	}
}
 