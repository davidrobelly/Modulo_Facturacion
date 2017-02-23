package Vista;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Pantalla_Principal extends JFrame implements ActionListener{
	
	public ImageIcon ico_aplicacion;
	public JMenuBar barraMenu;
	public JMenu menuInventario, menuCompras, menuVentas, menuOpciones, menuProcesosInv, menuReportesInv, menuProcesosCom, menuReportesCom,
				 menuProcesosVen, menuReportesVen;
	public JMenuItem menuItemProcesoIngPro, menuItemProcesoKardex, menuItemProcesoEstPro, menuItemProcesoModPro, 
					 menuItemReportCategoria, menuItemReportProProvee, menuItemReportStockPro,
					 menuItemCerrarSesion, menuItemSalir;
	
	public Pantalla_Principal(){
		
		super("Secutel - ERP");
		setSize(1000, 70);
		setLocation(100, 0);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ico_aplicacion = new ImageIcon("src/Imagenes/icono.gif");
		setIconImage(ico_aplicacion.getImage());
		
		crearMenu();
		
	}
	
	public void crearMenu(){	
		//Barra de Menu
		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		
		//Menu de Inventario
		menuInventario = new JMenu("Inventario");
		menuInventario.setMnemonic(KeyEvent.VK_I);
		
		menuProcesosInv = new JMenu("Procesos");
		menuInventario.add(menuProcesosInv);
		
		menuItemProcesoIngPro = new JMenuItem("Ingreso de Producto", KeyEvent.VK_I);
		menuProcesosInv.add(menuItemProcesoIngPro);
		menuItemProcesoIngPro.addActionListener(this);
		
		menuItemProcesoModPro = new JMenuItem("Modificacion de Producto", KeyEvent.VK_M);
		menuProcesosInv.add(menuItemProcesoModPro);
		menuItemProcesoModPro.addActionListener(this);
		
		menuItemProcesoKardex = new JMenuItem("Kardex - Entradas y Salidas", KeyEvent.VK_K);
		menuProcesosInv.add(menuItemProcesoKardex);
		menuItemProcesoKardex.addActionListener(this);
		
		menuItemProcesoEstPro = new JMenuItem("Camibio de Estado de Producto", KeyEvent.VK_E);
		menuProcesosInv.add(menuItemProcesoEstPro);
		menuItemProcesoEstPro.addActionListener(this);
		
		menuReportesInv = new JMenu("Reportes");
		menuInventario.add(menuReportesInv);
		
		menuItemReportCategoria = new JMenuItem("Reporte - Producto por Categoria", KeyEvent.VK_C);
		menuReportesInv.add(menuItemReportCategoria);
		
		menuItemReportProProvee = new JMenuItem("Reporte - Entrada de Productos", KeyEvent.VK_E);
		menuReportesInv.add(menuItemReportProProvee);
		
		menuItemReportProProvee = new JMenuItem("Reporte - Salida de Productos", KeyEvent.VK_A);
		menuReportesInv.add(menuItemReportProProvee);
		
		menuItemReportStockPro = new JMenuItem("Reporte - Stock de Productos", KeyEvent.VK_S);
		menuReportesInv.add(menuItemReportStockPro);
		
		//Menu Compras
		menuCompras = new JMenu("Compras");
		menuCompras.setMnemonic(KeyEvent.VK_C);
		
		menuProcesosCom = new JMenu("Procesos");
		menuCompras.add(menuProcesosCom);
		
		menuReportesCom = new JMenu("Reportes");
		menuCompras.add(menuReportesCom);
		
		//Menu de Ventas
		menuVentas = new JMenu("Ventas");
		menuVentas.setMnemonic(KeyEvent.VK_V);
		
		menuProcesosVen = new JMenu("Procesos");
		menuVentas.add(menuProcesosVen);
		
		menuReportesVen = new JMenu("Reportes");
		menuVentas.add(menuReportesVen);
		
		//Menu Opciones
		menuOpciones = new JMenu("Opciones");
		menuOpciones.setMnemonic(KeyEvent.VK_O);
		
		menuItemCerrarSesion = new JMenuItem("Cerrar Sesion", KeyEvent.VK_C);
		menuOpciones.add(menuItemCerrarSesion);		
		menuItemCerrarSesion.addActionListener(this);
		
		menuItemSalir = new JMenuItem("Salir", KeyEvent.VK_S);
		menuOpciones.add(menuItemSalir);
		menuItemSalir.addActionListener(this);

		//Adicion de Menus
		barraMenu.add(menuInventario);
		barraMenu.add(menuCompras);
		barraMenu.add(menuVentas);
		barraMenu.add(menuOpciones);
	}

	public void actionPerformed(ActionEvent evento) {
	
		if (evento.getSource() == menuItemProcesoIngPro){
			Pantalla_Producto inventario;
			inventario = new Pantalla_Producto();
			inventario.setVisible(true);	
		}
		
		if (evento.getSource() == menuItemProcesoKardex){
			Pantalla_Kardex kardex;
			kardex = new Pantalla_Kardex();
			kardex.setVisible(true);	
		}
		
		if (evento.getSource() == menuItemProcesoEstPro){
			Pantalla_Cambio_Estado_Producto cambioEstadoPro;
			cambioEstadoPro = new Pantalla_Cambio_Estado_Producto();
			cambioEstadoPro.setVisible(true);	
		}
		
		if (evento.getSource() == menuItemProcesoModPro){
			Pantalla_Modificar_Producto modProducto;
			modProducto = new Pantalla_Modificar_Producto();
			modProducto.setVisible(true);	
		}
		
		
		
		if (evento.getSource() == menuItemCerrarSesion) {
			Pantalla_Ingreso ingreso;
			ingreso = new Pantalla_Ingreso();
			ingreso.setVisible(true);	
			
			this.setVisible(false);
		}
		
		if (evento.getSource() == menuItemSalir) {
			this.setVisible(false);		
		}
		
	}	
	
	

}
