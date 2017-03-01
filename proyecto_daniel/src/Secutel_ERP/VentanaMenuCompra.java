package Secutel_ERP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


@SuppressWarnings("serial")
public class VentanaMenuCompra extends JFrame {

	JPanel contentPane;
	JMenuBar menuBar;
	JMenu proveedor,contacto,telefono,compra,opciones;
	JMenuItem nuevoPro,editarPro,estadoPro,consultaPro,reportesPro,nuevoCom,actualizar,reportesCom,
	salir,nuevoCon,editarCon,estadoCon,consultaCon,reportesCon,nuevoTel,editarTel,elimTel,reporteT,
	consultaCom;
	ControladorMenuCompra conMenCom;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenuCompra frame = new VentanaMenuCompra();
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
	public VentanaMenuCompra() {
		setTitle("Modulo Compra");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		conMenCom = new ControladorMenuCompra(this);
		contentPane =  (JPanel) this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		proveedor = new JMenu("Proveedor");
		menuBar.add(proveedor);
		
		nuevoPro = new JMenuItem("Nuevo");
		nuevoPro.addActionListener(conMenCom);
		proveedor.add(nuevoPro);
		
		editarPro = new JMenuItem("Modificar");
		editarPro.addActionListener(conMenCom);
		proveedor.add(editarPro);
		
		estadoPro = new JMenuItem("Estado");
		estadoPro.addActionListener(conMenCom);
		proveedor.add(estadoPro);
		
		consultaPro = new JMenuItem("Consulta");
		consultaPro.addActionListener(conMenCom);
		proveedor.add(consultaPro);
		
		reportesPro = new JMenuItem("Reportes");
		proveedor.add(reportesPro);
		
		contacto = new JMenu("Contactos");
		menuBar.add(contacto);
		
		nuevoCon = new JMenuItem("Nuevo");
		nuevoCon.addActionListener(conMenCom);
		contacto.add(nuevoCon);
		
		editarCon = new JMenuItem("Editar");
		editarCon.addActionListener(conMenCom);
		contacto.add(editarCon);
		
		estadoCon = new JMenuItem("Estado");
		estadoCon.addActionListener(conMenCom);
		contacto.add(estadoCon);
		
		consultaCon = new JMenuItem("Consulta");
		consultaCon.addActionListener(conMenCom);
		contacto.add(consultaCon);
		
		reportesCon = new JMenuItem("Reportes");
		contacto.add(reportesCon);
		
		telefono = new JMenu("Telefonos");
		menuBar.add(telefono);
		
		nuevoTel = new JMenuItem("Nuevo");
		nuevoTel.addActionListener(conMenCom);
		telefono.add(nuevoTel);
		
		editarTel = new JMenuItem("Editar");
		editarTel.addActionListener(conMenCom);
		telefono.add(editarTel);
		
		elimTel = new JMenuItem("Eliminar");
		elimTel.addActionListener(conMenCom);
		telefono.add(elimTel);
		
		reporteT = new JMenuItem("Reportes");
		telefono.add(reporteT);
		
		compra = new JMenu("Compra");
		menuBar.add(compra);
		
		nuevoCom = new JMenuItem("Nueva");
		compra.add(nuevoCom);
		
		actualizar = new JMenuItem("Actualizar");
		compra.add(actualizar);
		
		consultaCom = new JMenuItem("Consulta");
		compra.add(consultaCom);
		
		reportesCom = new JMenuItem("Reportes");
		compra.add(reportesCom);
		
		opciones = new JMenu("Opciones");
		menuBar.add(opciones);
		
		salir = new JMenuItem("Salir");
		salir.addActionListener(conMenCom);
		opciones.add(salir);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
	}

}
