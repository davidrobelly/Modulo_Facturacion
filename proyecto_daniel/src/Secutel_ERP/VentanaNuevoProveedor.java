package Secutel_ERP;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class VentanaNuevoProveedor extends JFrame {
	JPanel contentPane,formulario,botones,tabla;
	JLabel lblnombre, lbldireccion, lbldescripcion, lblruc;
	JTextField txtnombre, txtdireccion, txtdescripcion, txtruc;
	JButton registrar,cerrar,registrarCon;
	TablaContactos	contactos;
	JTable tableCon;
	JScrollPane scrollCon;
	GridBagLayout grid;
	GridBagConstraints con;
	ControladorProveedor control;
	ControladorNuevoCProveedor controlContacto;
	ArrayList<ContactoProveedor> listaContactos = new ArrayList<>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaNuevoProveedor frame = new VentanaNuevoProveedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public VentanaNuevoProveedor() {
		setTitle("Nuevo Proveedor");
		setBounds(550, 100, 525, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		control = new ControladorProveedor(this);
		controlContacto = new ControladorNuevoCProveedor(this);
		grid = new GridBagLayout();
		con = new GridBagConstraints();
		
		contentPane = (JPanel) getContentPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(grid);
		
		formulario = new JPanel();
		formulario.setLayout(grid);
		formulario.setBorder(new TitledBorder(null, "Datos Proveedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		lblnombre 		= new JLabel("Nombre: ");
		con.weightx = 1;
		con.weighty = 1;
		con.anchor = GridBagConstraints.WEST;
		con.insets = new Insets(10, 0, 10, 0);
		
		buildConstraints(con, 0, 0, 1, 1);
		grid.setConstraints(lblnombre, con);
		
		lbldireccion 	= new JLabel("Direccion: ");
		buildConstraints(con, 0, 2, 1, 1);
		grid.setConstraints(lbldireccion, con);
		
		lbldescripcion 	= new JLabel("Descripcion: ");
		buildConstraints(con, 0, 3, 1, 1);
		grid.setConstraints(lbldescripcion, con);
		lblruc 			= new JLabel("Ruc: ");
		buildConstraints(con, 0, 1, 1, 1);
		grid.setConstraints(lblruc, con);
		txtnombre 	 = new JTextField("",20);
		con.anchor = GridBagConstraints.EAST;
		buildConstraints(con, 1, 0, 1, 1);
		grid.setConstraints(txtnombre, con);
		txtruc 		 = new JTextField("",20);
		txtruc.addKeyListener(control);
		buildConstraints(con, 1, 1, 1, 1);
		grid.setConstraints(txtruc, con);
		txtdireccion = new JTextField("",20);
		buildConstraints(con, 1, 2, 1, 1);
		grid.setConstraints(txtdireccion, con);
		txtdescripcion  = new JTextField("",20);
		buildConstraints(con, 1, 3, 1, 1);
		grid.setConstraints(txtdescripcion, con);
		formulario.add(lblnombre);
		formulario.add(txtnombre);
		formulario.add(lblruc);
		formulario.add(txtruc);
		formulario.add(lbldireccion);
		formulario.add(txtdireccion);
		formulario.add(lbldescripcion);
		formulario.add(txtdescripcion);
		
		botones = new JPanel();
		botones.setLayout(grid);
		registrar = new JButton("Registrar");
		registrar.addActionListener(control);
		
		con.anchor = GridBagConstraints.CENTER;
		con.insets = new Insets(5, 0, 5, 0);
		
		buildConstraints(con, 0, 0, 1, 1);
		grid.setConstraints(registrar, con);
		
		registrarCon = new JButton("Agregar Contacto");
		registrarCon.addActionListener(control);
		buildConstraints(con, 1, 0, 1, 1);
		grid.setConstraints(registrarCon, con);
		cerrar = new JButton("Salir");
		cerrar.addActionListener(control);
		buildConstraints(con, 2, 0, 1, 1);
		grid.setConstraints(cerrar, con);
		botones.add(registrar);
		botones.add(registrarCon);
		botones.add(cerrar);
		tabla = new JPanel();
		tabla.setLayout(grid);
		tabla.setBorder(new TitledBorder(null, "Contactos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contactos = new TablaContactos();
        tableCon  = new JTable(contactos);
        tableCon.getTableHeader().setReorderingAllowed(false) ;
		scrollCon = new JScrollPane(tableCon);
		buildConstraints(con, 0, 0, 1, 1);
		con.fill = GridBagConstraints.BOTH;
		con.weighty = 1;
		grid.setConstraints(scrollCon, con);
		tabla.add(scrollCon);
		buildConstraints(con, 0, 0, 1, 1);
		con.fill = GridBagConstraints.BOTH;
		con.insets = new Insets(0, 0, 0, 0);
		grid.setConstraints(formulario, con);
		buildConstraints(con, 0, 1, 1, 1);
		grid.setConstraints(botones, con);
		buildConstraints(con, 0, 2, 1, 1);
		grid.setConstraints(tabla, con);
		contentPane.add(formulario);
		contentPane.add(botones);
		contentPane.add(tabla);
	}
	void buildConstraints (GridBagConstraints gbc, int gx, int gy, int gw, int gh) {
		gbc.gridx 					= gx;
		gbc.gridy 					= gy;
		gbc.gridwidth 				= gw;
		gbc.gridheight 				= gh;
	}
}
