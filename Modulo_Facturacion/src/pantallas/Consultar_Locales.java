package pantallas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.border.TitledBorder;

import controles.Control_Consulta_Clientes;
import controles.Control_Consultar_Locales;

public class Consultar_Locales extends JFrame{
	
	public JPanel panelNorte,panelCentro, panelSur;
	public JRadioButton radiociudad;
	public JTextField txtciudad;
	public JButton btnciudad, btngenrep, btngenerar;
	public ButtonGroup grupo;
	public Tabla_Locales locales;
	public JTable tableLocales;
	public JScrollPane scrollPro;
	public JLabel lbltexto;
	
	GridBagLayout grid;
	GridBagConstraints con;
	
	Control_Consultar_Locales control;
	
	public Consultar_Locales() {
		
		initcomponents();
		ventana();
		
		control = new Control_Consultar_Locales(this);
		
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
		grid.setConstraints(radiociudad, con);
		buildConstraints(con, 1, 0, 1, 1);
		grid.setConstraints(txtciudad, con);
		buildConstraints(con, 2, 0, 1, 1);
		grid.setConstraints(btnciudad, con);
		
		buildConstraints(con, 0, 3, 1, 1);
		grid.setConstraints(lbltexto, con);
		buildConstraints(con, 1, 3, 2, 1);
		grid.setConstraints(btngenerar, con);
		
		
		panelNorte.add(radiociudad);
		panelNorte.add(txtciudad);
		panelNorte.add(btnciudad);
		panelNorte.add(lbltexto);
		panelNorte.add(btngenerar);
		
		grupo = new ButtonGroup();
		grupo.add(radiociudad);
		
		panelCentro.setLayout(grid);
		con.anchor = GridBagConstraints.CENTER;
		con.insets = new Insets(5, 5, 5, 5);
		con.fill = GridBagConstraints.BOTH;
		buildConstraints(con, 0, 1, 1, 1);
		
		grid.setConstraints(panelCentro, con);
        tableLocales.getTableHeader().setReorderingAllowed(false) ;
		scrollPro = new JScrollPane(tableLocales);
		buildConstraints(con, 0, 0, 1, 1);
		grid.setConstraints(scrollPro, con);
		panelCentro.add(scrollPro);
		
		con.insets = new Insets(10, 10, 10, 10);
		panelSur.setLayout(grid);
		
		
		buildConstraints(con, 0, 0, 1, 1);
		grid.setConstraints(btngenrep, con);
		panelSur.add(btngenrep);
		
		//eventos
		tableLocales.addMouseListener(control);
		radiociudad.addActionListener(control);
		btnciudad.addActionListener(control);
		btngenerar.addActionListener(control);
		
	}
	
	protected void initcomponents() {
		
		grid = new GridBagLayout();
		con = new GridBagConstraints();
		
		lbltexto = new JLabel("Lista de todos los Locales");
		locales = new Tabla_Locales();
		panelNorte = new JPanel();
		panelCentro = new JPanel();
		panelSur = new JPanel();
		
		txtciudad = new JTextField("", 10);
		txtciudad.setEnabled(false);
		
		radiociudad = new JRadioButton("ciudad: ");
		
		btnciudad = new JButton("Buscar");
		btnciudad.setEnabled(false);
		btngenrep = new JButton ("Generar Reporte");
		btngenerar = new JButton ("Generar Lista");
		
		//esta es la parte de tabla
		locales = new Tabla_Locales ();
		tableLocales = new JTable (locales);
		tableLocales.getTableHeader().setReorderingAllowed(false);
		scrollPro = new JScrollPane(tableLocales);
		
		panelNorte.setBorder(new TitledBorder(null, "Opciones de Busqueda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCentro.setBorder(new TitledBorder(null, "Locales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSur.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
	}

	protected void ventana() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setTitle("Consultar Locales");
		this.setVisible(true);
		this.setBounds(115, 115, 600, 450);
		this.setResizable(false);
		
	}

	void buildConstraints (GridBagConstraints gbc, int gx, int gy, int gw, int gh) {
		gbc.gridx 					= gx;
		gbc.gridy 					= gy;
		gbc.gridwidth 				= gw;
		gbc.gridheight 				= gh;
	}

}
