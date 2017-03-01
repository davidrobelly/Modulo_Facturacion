package Secutel_ERP;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;


@SuppressWarnings("serial")
public class VentanaModificarProvedor extends VentanaNuevoProveedor {

	JPanel panelBuscar,panelEditarContacto;
	JLabel empresa;
	JButton buscar;
	ControladorModificarProveedor controlmod;
	String rucBuscar = "";
	String nomBuscar = "";
	ArrayList<ContactoProveedor> listaConPro;
	TablaEditarContacto	contactosEd;
	JTable tableConEd;
	JScrollPane scrollConEd;
	JCheckBox checkBox;
	DefaultCellEditor editorCelda;
	ControladorBuscarProveedor controlBP;
	ControladorNuevoCProveedor controlNCP;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaModificarProvedor frame = new VentanaModificarProvedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaModificarProvedor() {
		setTitle("Modificar Proveedor");
		setBounds(500, 150, 450, 510);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.removeAll();
		listaConPro = new ArrayList<>();
		controlNCP = new ControladorNuevoCProveedor(this);
		controlBP = new ControladorBuscarProveedor(this);
		controlmod = new ControladorModificarProveedor(this);
		panelBuscar = new JPanel();
		panelBuscar.setLayout(grid);
		empresa = new JLabel("Elegir Proveedor:");
		con.anchor = GridBagConstraints.WEST;
		buildConstraints(con, 0, 0, 1, 1);
		grid.setConstraints(empresa, con);
		panelBuscar.add(empresa);
		buscar = new JButton("buscar");
		buscar.addActionListener(controlmod);
		con.anchor = GridBagConstraints.EAST;
		buildConstraints(con, 2, 0, 1, 1);
		con.fill = GridBagConstraints.HORIZONTAL;
		grid.setConstraints(buscar, con);
		panelBuscar.add(buscar);
		registrar.setText("Actualizar");
		registrar.removeActionListener(control);
		registrar.addActionListener(controlmod);
		registrar.setEnabled(false);
		buildConstraints(con, 0, 0, 1, 1);
		grid.setConstraints(panelBuscar, con);
		contentPane.add(panelBuscar);
		buildConstraints(con, 0, 1, 1, 1);
		grid.setConstraints(formulario, con);
		contentPane.add(formulario);
		panelEditarContacto = new JPanel();
		panelEditarContacto.setLayout(grid);
		panelEditarContacto.setBorder(new TitledBorder(null, "Contactos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		checkBox = new JCheckBox();
		editorCelda = new DefaultCellEditor(checkBox);
		contactosEd = new TablaEditarContacto();
        tableConEd  = new JTable(contactosEd);
        tableConEd.getColumnModel().getColumn(3).setCellEditor(editorCelda);
        tableConEd.addMouseListener(controlmod);
        //tableConEd.setDefaultRenderer(tableConEd.getColumnClass(3), render);
        tableConEd.getTableHeader().setReorderingAllowed(false) ;
		scrollConEd = new JScrollPane(tableConEd);
		buildConstraints(con, 0, 0, 1, 1);
		con.fill = GridBagConstraints.BOTH;
		con.weighty = 1;
		grid.setConstraints(scrollConEd, con);
		panelEditarContacto.add(scrollConEd);
		buildConstraints(con, 0, 2, 1, 1);
		grid.setConstraints(panelEditarContacto, con);
		contentPane.add(panelEditarContacto);
		buildConstraints(con, 0, 3, 1, 1);
		grid.setConstraints(botones, con);
		registrarCon.removeActionListener(control);
		registrarCon.addActionListener(controlmod);
		registrarCon.setEnabled(false);
		contentPane.add(botones);
	}

}
