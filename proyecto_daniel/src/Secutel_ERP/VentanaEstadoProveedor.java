package Secutel_ERP;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class VentanaEstadoProveedor extends VentanaNuevoProveedor {

	JPanel panelActivar,panelDesactivar,panelsalir;
	JLabel listado,listadob;
	JButton activar,desactivar;
	TablaEstadoProveedor proveedoresA,proveedoresI;
	JTable tableProvA,tableProvI;
	JScrollPane scrollProvA,scrollProvB;
	ControladorEstadoProveedor controrlEP;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEstadoProveedor frame = new VentanaEstadoProveedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaEstadoProveedor() {
		setTitle("Estado Proveedor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 450, 500);
		controrlEP = new ControladorEstadoProveedor(this);
		panelActivar = new JPanel();
		panelActivar.setLayout(grid);
		panelActivar.setBorder(new TitledBorder(null, "Proveedores Activos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		listado = new JLabel("Lista Proveedores");
		buildConstraints(con, 0, 0, 1, 1);
		con.weighty = 0;
		con.insets = new Insets(5, 0, 5, 0);
		con.fill = GridBagConstraints.HORIZONTAL;
		grid.setConstraints(listado, con);
		panelActivar.add(listado);
		desactivar = new JButton("Dar de baja");
		desactivar.addActionListener(controrlEP);
		buildConstraints(con, 1, 0, 1, 1);
		grid.setConstraints(desactivar, con);
		panelActivar.add(desactivar);
		proveedoresA = new TablaEstadoProveedor();
        tableProvA  = new JTable(proveedoresA);
        tableProvA.addMouseListener(controrlEP);
        tableProvA.getTableHeader().setReorderingAllowed(false) ;
		scrollProvA = new JScrollPane(tableProvA);
		buildConstraints(con, 0, 1, 2, 1);
		con.fill = GridBagConstraints.BOTH;
		con.weighty = 1;
		grid.setConstraints(scrollProvA, con);
		panelActivar.add(scrollProvA);
		panelDesactivar = new JPanel();
		panelDesactivar.setLayout(grid);
		panelDesactivar.setBorder(new TitledBorder(null, "Proveedores Inactivos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		listadob = new JLabel("Lista Proveedores");
		buildConstraints(con, 0, 0, 1, 1);
		con.weighty = 0;
		con.fill = GridBagConstraints.HORIZONTAL;
		grid.setConstraints(listadob, con);
		panelDesactivar.add(listadob);
		activar = new JButton("Renovar");
		activar.addActionListener(controrlEP);
		buildConstraints(con, 1, 0, 1, 1);
		grid.setConstraints(activar, con);
		proveedoresI = new TablaEstadoProveedor();
        tableProvI  = new JTable(proveedoresI);
        tableProvI.addMouseListener(controrlEP);
        tableProvI.getTableHeader().setReorderingAllowed(false) ;
		scrollProvB = new JScrollPane(tableProvI);
		buildConstraints(con, 0, 1, 2, 1);
		con.fill = GridBagConstraints.BOTH;
		con.weighty = 1;
		grid.setConstraints(scrollProvB, con);
		panelDesactivar.add(scrollProvB);
		panelsalir = new JPanel();
		panelsalir.setLayout(grid);
		buildConstraints(con, 0, 0, 1, 1);
		grid.setConstraints(cerrar, con);
		panelsalir.add(cerrar);
		panelDesactivar.add(activar);
		contentPane.remove(formulario);
		contentPane.remove(botones);
		contentPane.remove(tabla);
		controrlEP.llenarActivos();
		controrlEP.llenarInactivos();
		buildConstraints(con, 0, 0, 1, 1);
		con.fill = GridBagConstraints.BOTH;
		grid.setConstraints(panelActivar, con);
		contentPane.add(panelActivar);
		buildConstraints(con, 0, 1, 1, 1);
		grid.setConstraints(panelDesactivar, con);
		contentPane.add(panelDesactivar);
		buildConstraints(con, 0, 2, 1, 1);
		con.weighty = 0;
		grid.setConstraints(panelsalir, con);
		contentPane.add(panelsalir);
	}
}
