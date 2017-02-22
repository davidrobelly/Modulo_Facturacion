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

import controles.Control_Consultar_Locales;
import controles.Control_Modif_Consultar_Locales;

public class Consultar_Local_Modificar extends JFrame{
	
	public JPanel panelNorte,panelCentro;
	public JRadioButton radioCiudad;
	public JTextField txtCiudad;
	public JButton btnCiudad;
	public ButtonGroup grupo;
	public Tabla_Locales locales;
	public JTable tableLocales;
	public JScrollPane scrollPro;
	
	GridBagLayout grid;
	GridBagConstraints con;
	
	Control_Modif_Consultar_Locales control;
	
	public Consultar_Local_Modificar() {
		
		initcomponents();
		ventana();
		
		control = new Control_Modif_Consultar_Locales(this);
		
		this.getContentPane().add(panelNorte, "North");
		this.getContentPane().add(panelCentro, "Center");
		
		
		panelNorte.setLayout(grid);
		con.weightx = 1;
		con.weighty = 1;
		con.anchor = GridBagConstraints.WEST;
		con.insets = new Insets(10, 5,10, 5);
		con.fill = GridBagConstraints.BOTH;
		
		buildConstraints(con, 0, 0, 1, 1);
		grid.setConstraints(radioCiudad, con);
		buildConstraints(con, 1, 0, 1, 1);
		grid.setConstraints(txtCiudad, con);
		buildConstraints(con, 2, 0, 1, 1);
		grid.setConstraints(btnCiudad, con);
		
		panelNorte.add(radioCiudad);
		panelNorte.add(txtCiudad);
		panelNorte.add(btnCiudad);
		
		grupo = new ButtonGroup();
		grupo.add(radioCiudad);
		
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
		
		
		//eventos
		tableLocales.addMouseListener(control);
		radioCiudad.addActionListener(control);
		btnCiudad.addActionListener(control);
		
	}
	
	protected void initcomponents() {
		
		grid = new GridBagLayout();
		con = new GridBagConstraints();
		
	
		locales = new Tabla_Locales();
		panelNorte = new JPanel();
		panelCentro = new JPanel();
		
		txtCiudad = new JTextField("", 10);
		txtCiudad.setEnabled(false);
		
		radioCiudad = new JRadioButton("Ciudad: ");
		
		btnCiudad = new JButton("Buscar");
		btnCiudad.setEnabled(false);
		
		//esta es la parte de tabla
		locales = new Tabla_Locales ();
		tableLocales = new JTable (locales);
		tableLocales.getTableHeader().setReorderingAllowed(false);
		scrollPro = new JScrollPane(tableLocales);
		
		panelNorte.setBorder(new TitledBorder(null, "Opciones de Busqueda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCentro.setBorder(new TitledBorder(null, "Locales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
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
