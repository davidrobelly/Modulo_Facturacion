package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controles.Control_Consulta_Clientes;

@SuppressWarnings("serial")
public class Consultar_Clientes extends JFrame{
	
	public JPanel contentPane, panelNorte,panelCentro, panelSur;
	public JRadioButton radioNombre,radioCedula, radioApellido;
	public JTextField txtnombre,txtcedula, txtapellido;
	public JButton btnnombre,btncedula, btnapellido, btngenrep, btnlimpiar, btngenerar;
	public ButtonGroup grupo;
	public Tabla_Clientes clientes;
	public JTable tableCliente;
	public JScrollPane scrollPro;
	public JLabel lbltexto;
	
	GridBagLayout grid;
	GridBagConstraints con;
	
	Control_Consulta_Clientes control;
	
	
	
	public Consultar_Clientes() {
		
		initcomponents();
		ventana();
		
		control = new Control_Consulta_Clientes(this);
		
		this.getContentPane().add(panelNorte, "North");
		this.getContentPane().add(panelCentro, "Center");
		this.getContentPane().add(panelSur, "South");
		
		
		panelNorte.setLayout(grid);
		con.weightx = 1;
		con.weighty = 1;
		con.anchor = GridBagConstraints.WEST;
		con.insets = new Insets(10, 5,10, 5);
		con.fill = GridBagConstraints.BOTH;
		
		buildConstraints(con, 0, 0, 1, 1);
		grid.setConstraints(radioNombre, con);
		buildConstraints(con, 1, 0, 1, 1);
		grid.setConstraints(txtnombre, con);
		buildConstraints(con, 2, 0, 1, 1);
		grid.setConstraints(btnnombre, con);
		
		buildConstraints(con, 0, 1, 1, 1);
		grid.setConstraints(radioCedula, con);
		buildConstraints(con, 1, 1, 1, 1);
		grid.setConstraints(txtcedula, con);
		buildConstraints(con, 2, 1, 1, 1);
		grid.setConstraints(btncedula, con);
		
		buildConstraints(con, 0, 2, 1, 1);
		grid.setConstraints(radioApellido, con);
		buildConstraints(con, 1, 2, 1, 1);
		grid.setConstraints(txtapellido, con);
		buildConstraints(con, 2, 2, 1, 1);
		grid.setConstraints(btnapellido, con);
		
		buildConstraints(con, 0, 3, 1, 1);
		grid.setConstraints(lbltexto, con);
		buildConstraints(con, 1, 3, 2, 1);
		grid.setConstraints(btngenerar, con);
		
		
		panelNorte.add(radioNombre);
		panelNorte.add(txtnombre);
		panelNorte.add(btnnombre);
		panelNorte.add(radioCedula);
		panelNorte.add(txtcedula);
		panelNorte.add(btncedula);
		panelNorte.add(radioApellido);
		panelNorte.add(txtapellido);
		panelNorte.add(btnapellido);
		panelNorte.add(lbltexto);
		panelNorte.add(btngenerar);
		
		grupo = new ButtonGroup();
		grupo.add(radioNombre);
		grupo.add(radioCedula);
		grupo.add(radioApellido);
		
		panelCentro.setLayout(grid);
		con.anchor = GridBagConstraints.CENTER;
		con.insets = new Insets(5, 5, 5, 5);
		con.fill = GridBagConstraints.BOTH;
		buildConstraints(con, 0, 1, 1, 1);
		
		grid.setConstraints(panelCentro, con);
        tableCliente.getTableHeader().setReorderingAllowed(false) ;
		scrollPro = new JScrollPane(tableCliente);
		buildConstraints(con, 0, 0, 1, 1);
		grid.setConstraints(scrollPro, con);
		panelCentro.add(scrollPro);
		
		con.insets = new Insets(10, 10, 10, 10);
		panelSur.setLayout(grid);
		
		
		buildConstraints(con, 0, 0, 1, 1);
		grid.setConstraints(btngenrep, con);
		buildConstraints(con, 1, 0, 1, 1);
		grid.setConstraints(btnlimpiar, con);
		panelSur.add(btngenrep);
		
		//eventos
		tableCliente.addMouseListener(control);
		radioNombre.addActionListener(control);
		radioCedula.addActionListener(control);
		radioApellido.addActionListener(control);
		btnnombre.addActionListener(control);
		btnapellido.addActionListener(control);
		btncedula.addActionListener(control);
		btngenerar.addActionListener(control);
		btnlimpiar.addActionListener(control);
		
	}
	
	private void initcomponents() {
		
		grid = new GridBagLayout();
		con = new GridBagConstraints();
		
		lbltexto = new JLabel("Lista de todos los Clientes");
		clientes = new Tabla_Clientes();
		contentPane = new JPanel();
		panelNorte = new JPanel();
		panelCentro = new JPanel();
		panelSur = new JPanel();
		
		txtnombre = new JTextField("", 10);
		txtnombre.setEnabled(false);
		txtcedula = new JTextField("", 10);
		txtcedula.setEnabled(false);
		txtapellido = new JTextField("", 10);
		txtapellido.setEnabled(false);
		
		radioNombre = new JRadioButton("Nombre: ");
		radioCedula = new JRadioButton("Cédula: ");
		radioApellido = new JRadioButton("Apellido: ");
		
		btnnombre = new JButton("Buscar");
		btnnombre.setEnabled(false);
		btncedula = new JButton("Buscar");
		btncedula.setEnabled(false);
		btnapellido = new JButton ("Buscar");
		btnapellido.setEnabled(false);
		btngenrep = new JButton ("Generar Reporte");
		btnlimpiar = new JButton ("Limpiar Tabla");
		btngenerar = new JButton ("Generar Lista");
		
		//esta es la parte de tabla
		clientes = new Tabla_Clientes ();
		tableCliente = new JTable (clientes);
		tableCliente.getTableHeader().setReorderingAllowed(false);
		scrollPro = new JScrollPane(tableCliente);
		
		panelNorte.setBorder(new TitledBorder(null, "Opciones de Busqueda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCentro.setBorder(new TitledBorder(null, "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSur.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
	}

	private void ventana() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setTitle("Consultar Clientes");
		this.setVisible(true);
		
		this.setBounds(100, 100, 600, 450);
		this.setResizable(false);
		
	}

	void buildConstraints (GridBagConstraints gbc, int gx, int gy, int gw, int gh) {
		gbc.gridx 					= gx;
		gbc.gridy 					= gy;
		gbc.gridwidth 				= gw;
		gbc.gridheight 				= gh;
	}


}
