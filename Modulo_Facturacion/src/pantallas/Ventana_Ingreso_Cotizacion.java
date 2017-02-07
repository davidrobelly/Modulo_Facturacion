package pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controles.Control_Ventana_Cotizacion;
import modelo_clases.Detalle_Cotizacion;

public class Ventana_Ingreso_Cotizacion extends JFrame {
	
	public JPanel PanelCentral, PanelBotones, PanelDetalle;
	public JButton btnagregardetalle, btnregistrar, btnlimpiar, btngenerar;
	public JLabel lblcliente, lblvendedor, lblfecha, lblvigencia, lblestado, lblcantidad, lblsubtotal, lbliva, lbltotal, lblcodigo;
	public JTextField txtcliente, txtvendedor, txtfecha, txtvigencia, 
			txtcantidad, txtsubtotal, txtiva, txttotal, txtcodigo;
	public JTable tabledetalle;
	public JComboBox cmbestado;
	
	Control_Ventana_Cotizacion control;
	
	Object [] data = new Object [5];
	
	public Ventana_Ingreso_Cotizacion () {
		
		initcomponents ();
		ventana();
		control = new Control_Ventana_Cotizacion(this);
		
		PanelCentral.setLayout(new GridLayout(5,4));
		PanelBotones.setLayout(new GridLayout(0,4));
		PanelDetalle.setLayout(new GridLayout(0,1));
		
		PanelCentral.add(lblcodigo);
		PanelCentral.add(txtcodigo);
		PanelCentral.add(lblestado);
		PanelCentral.add(cmbestado);
		PanelCentral.add(lblcliente);
		PanelCentral.add(txtcliente);
		PanelCentral.add(lblvendedor);
		PanelCentral.add(txtvendedor);
		PanelCentral.add(lblfecha);
		PanelCentral.add(txtfecha);
		PanelCentral.add(lblvigencia);
		PanelCentral.add(txtvigencia);
		PanelCentral.add(lblcantidad);
		PanelCentral.add(txtcantidad);
		PanelCentral.add(lblsubtotal);
		PanelCentral.add(txtsubtotal);
		PanelCentral.add(lbliva);
		PanelCentral.add(txtiva);
		PanelCentral.add(lbltotal);
		PanelCentral.add(txttotal);
		
		
		
		PanelBotones.add(btnagregardetalle);
		PanelBotones.add(btnregistrar);
		PanelBotones.add(btnlimpiar);
		PanelBotones.add(btngenerar);
		
		
		this.getContentPane().add(PanelCentral, "North");
		this.getContentPane().add(PanelBotones, "Center");
		this.getContentPane().add(PanelDetalle, "South");
		
		btngenerar.addActionListener(control);
		btnregistrar.addActionListener(control);
		btnagregardetalle.addActionListener(control);
		btnlimpiar.addActionListener(control);
		
		
		//tabla de datos
		DefaultTableModel dtm= new DefaultTableModel();
		final JTable table = new JTable(dtm);
		
		//insertamos las columnas
		dtm.addColumn("N°");
		dtm.addColumn("Producto");
		dtm.addColumn("Cantidad");
		dtm.addColumn("Valor");
		
		//insertamos el contenido
		for(int row = 0; row < 10; row++) { 
			for(int column = 0; column < 5; column++) { 
			data[column] = "Celda " + row + "," + column; 
			} 
			dtm.addRow(data); 
			}
		
		//se define el tamaño 
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));

		//Creamos un JscrollPane y le agregamos la JTable 
		JScrollPane scrollPane = new JScrollPane(table);

		//Agregamos el JScrollPane al contenedor 
		PanelDetalle.add(scrollPane, BorderLayout.CENTER);

		//manejamos la salida 
		addWindowListener(new WindowAdapter() { 
		public void windowClosing(WindowEvent e) { 
		System.exit(0); 
		} 
		}); 
		}
		

	private void ventana() {
		
		this.setLocationRelativeTo(null);
		this.pack();
		this.setTitle("Cotizacion");
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500, 330);
		this.setLocation(500, 200);
		this.setResizable(false);
		
	}

	private void initcomponents() {
		
		PanelCentral = new JPanel();
		PanelBotones = new JPanel();
		PanelDetalle = new JPanel();
		
		this.setBackground(Color.white);
		
		btnagregardetalle = new JButton("Agr. Producto");
		btnregistrar = new JButton("Registrar");
		btnlimpiar = new JButton("Limpiar");
		btngenerar = new JButton("Generar");
		
		lblcliente = new JLabel ("Cliente: ");
		lblvendedor = new JLabel ("Vendedor: ");
		lblfecha = new JLabel ("Fecha: ");
		lblvigencia = new JLabel ("Vigencia: ");
		lblestado = new JLabel ("Estado: ");
		lblcantidad = new JLabel ("Cantidad: ");
		lblsubtotal = new JLabel ("Sub Total: ");
		lbliva = new JLabel ("IVA: ");
		lbltotal = new JLabel ("Total: ");
		lblcodigo = new JLabel ("Codigo: ");
		
		cmbestado = new JComboBox ();
		cmbestado.addItem("Pendiente");
		cmbestado.addItem("Anulada");
		cmbestado.addItem("Aprobada");
		
		
		
		
		txtcliente = new JTextField();
		txtvendedor = new JTextField();
		txtfecha = new JTextField();
		txtvigencia = new JTextField();
		txttotal = new JTextField();
		txttotal.setEditable(false);
		txtcantidad = new JTextField();
		txtcantidad.setEditable(false);
		txtsubtotal = new JTextField();
		txtsubtotal.setEditable(false);
		txtiva = new JTextField();
		txtiva.setEditable(false);
		txtcodigo = new JTextField();
		
		Border bordejpanel = new TitledBorder(new EtchedBorder(), "Detalle de la Cotizacion");
		PanelCentral.setBorder(bordejpanel);
		
		Border bordejpane2 = new TitledBorder(new EtchedBorder(), "");
		PanelBotones.setBorder(bordejpane2);
		
		Border bordejpane3 = new TitledBorder(new EtchedBorder(), "Detalle de Productos: ");
		PanelDetalle.setBorder(bordejpane3);
	

		
	}

}