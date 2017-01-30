package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class Pantalla_Principal extends JFrame implements ActionListener{
	
	public ImageIcon ico_aplicacion;
	public JMenuBar barraMenu;
	public JMenu menuInventario, menuCompras, menuVentas, menuCerrarSesion, menuSalir;
	public JMenuItem menuItemParametrosInv, menuItemProcesosInv, menuItemReportesInv,
					 menuItemParametrosCom, menuItemProcesosCom, menuItemReportesCom,
					 menuItemParametrosVen, menuItemProcesosVen, menuItemReportesVen;
	public JSeparator separador;
	
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
		
		menuItemParametrosInv = new JMenuItem("Parametros", KeyEvent.VK_P);
		menuInventario.add(menuItemParametrosInv);
		
		menuItemProcesosInv = new JMenuItem("Procesos", KeyEvent.VK_R);
		menuItemProcesosInv.addActionListener(this);
		menuInventario.add(menuItemProcesosInv);
		
		menuItemReportesInv = new JMenuItem("Reportes", KeyEvent.VK_E);
		menuInventario.add(menuItemReportesInv);
		
		//Menu Compras
		menuCompras = new JMenu("Compras");
		menuCompras.setMnemonic(KeyEvent.VK_C);
		
		menuItemParametrosCom = new JMenuItem("Parametros", KeyEvent.VK_P);
		menuCompras.add(menuItemParametrosCom);
		
		menuItemProcesosCom = new JMenuItem("Procesos", KeyEvent.VK_R);
		menuCompras.add(menuItemProcesosCom);
		
		menuItemReportesCom = new JMenuItem("Reportes", KeyEvent.VK_E);
		menuCompras.add(menuItemReportesCom);
		
		//Menu de Ventas
		menuVentas = new JMenu("Ventas");
		menuVentas.setMnemonic(KeyEvent.VK_V);
		
		menuItemParametrosVen = new JMenuItem("Parametros", KeyEvent.VK_P);
		menuVentas.add(menuItemParametrosVen);
		
		menuItemProcesosVen = new JMenuItem("Procesos", KeyEvent.VK_R);
		menuVentas.add(menuItemProcesosVen);
		
		menuItemReportesVen = new JMenuItem("Reportes", KeyEvent.VK_E);
		menuVentas.add(menuItemReportesVen);
		
		//Menu Cerrar Sesion
		menuCerrarSesion = new JMenu("Cerrar-Sesion");
		menuCerrarSesion.setMnemonic(KeyEvent.VK_E);
		
//		separador.setPreferredSize(new Dimension(10, 10));		
		
		//Menu Salir
		menuSalir = new JMenu("Salir");
		menuSalir.setMnemonic(KeyEvent.VK_S);

		//Adicion de Menus
		barraMenu.add(menuInventario);
		barraMenu.add(menuCompras);
		barraMenu.add(menuVentas);
//		barraMenu.add(separador);
		barraMenu.add(menuCerrarSesion);
		barraMenu.add(menuSalir);
	}


	public void actionPerformed(ActionEvent evento) {
	
		if (evento.getSource() == menuItemProcesosInv){
			Pantalla_Ingreso_Inventario inventario;
			inventario = new Pantalla_Ingreso_Inventario();
			inventario.setVisible(true);
			
		}
		
	}	
	
	

}
