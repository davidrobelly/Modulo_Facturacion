package pantallas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import controles.Control_PPrincipal;

public class Pantalla_Principal extends JFrame {
	
	public ImageIcon ico_aplicacion;
	public JMenuBar barraMenu;
	public JMenu menuInventario, menuCompras, menuVentas, menuCerrarSesion, menuSalir, menuCliente, menuEmpleado
					,menuLocal;
	public JMenuItem menuItemParametrosInv, menuItemProcesosInv, menuItemReportesInv,
					 menuItemParametrosCom, menuItemProcesosCom, menuItemReportesCom,
					 menuItemParametrosVen, menuItemProcesosVen, menuItemReportesVen,
					 menuRegCliente, menuConsulCliente, menuModifCliente,
					 menuRegEmpleado, menuConsulEmpleado, menuModifEmpleado, menuUser,
					 menuCerrar, menuSalirSistema,
					 menuRegLocal, menuConsulLocal, menuModifLocal;
					
	public JSeparator separador;
	
	Control_PPrincipal control;
	
	public Pantalla_Principal(){
		
		ventana();
		initcomponents();
		
		control = new Control_PPrincipal (this);
		
		//Barra de Menu
		
		setIconImage(ico_aplicacion.getImage());
		setJMenuBar(barraMenu);
				
		//Menu de Inventario
				
		menuInventario.setMnemonic(KeyEvent.VK_I);
		menuInventario.add(menuItemParametrosInv);
		menuInventario.add(menuItemProcesosInv);
		menuInventario.add(menuItemReportesInv);
				
		//Menu Compras
				
		menuCompras.setMnemonic(KeyEvent.VK_C);
		menuCompras.add(menuItemParametrosCom);
		menuCompras.add(menuItemProcesosCom);
		menuCompras.add(menuItemReportesCom);
				
		//Menu de Ventas
				
		menuVentas.setMnemonic(KeyEvent.VK_V);
		menuVentas.add(menuItemParametrosVen);
		menuVentas.add(menuItemProcesosVen);
		menuVentas.add(menuItemReportesVen);
				
		//Menu Cerrar Sesion
				
		menuCerrarSesion.setMnemonic(KeyEvent.VK_E);
		menuCerrarSesion.add(menuCerrar);
				
		//Menu Salir
				
		menuSalir.setMnemonic(KeyEvent.VK_S);
		menuSalir.add(menuSalirSistema);
		
		//Menu Cliente
		menuCliente.setMnemonic(KeyEvent.VK_V);
		menuCliente.add(menuRegCliente);
		menuCliente.add(menuConsulCliente);
		menuCliente.add(menuModifCliente);
		
		//Menu Empleado
		menuEmpleado.setMnemonic(KeyEvent.VK_V);
		menuEmpleado.add(menuRegEmpleado);
		menuEmpleado.add(menuConsulEmpleado);
		menuEmpleado.add(menuModifEmpleado);
		menuEmpleado.add(menuUser);
		
		//Menu Locales
		menuLocal.setMnemonic(KeyEvent.VK_V);
		menuLocal.add(menuRegLocal);
		menuLocal.add(menuConsulLocal);
		menuLocal.add(menuModifLocal);

		//Adicion de Menus
		barraMenu.add(menuInventario);
		barraMenu.add(menuCompras);
		barraMenu.add(menuVentas);
		barraMenu.add(menuCliente);
		barraMenu.add(menuEmpleado);
		barraMenu.add(menuLocal);
		barraMenu.add(menuCerrarSesion);
		barraMenu.add(menuSalir);
		
		
		//adicion de eventos
		menuRegCliente.addActionListener(control);
		menuConsulCliente.addActionListener(control);
		menuModifCliente.addActionListener(control);
		menuRegEmpleado.addActionListener(control);
		menuConsulEmpleado.addActionListener(control);
		menuModifEmpleado.addActionListener(control);
		menuUser.addActionListener(control);
		menuRegLocal.addActionListener(control);
		menuConsulLocal.addActionListener(control);
		menuModifLocal.addActionListener(control);
		menuCerrar.addActionListener(control);
		menuSalirSistema.addActionListener(control);
	}
	
	private void initcomponents() {
		
		ico_aplicacion = new ImageIcon("src/Imagenes/icono.gif");
		
		barraMenu = new JMenuBar();
		
		menuInventario = new JMenu("Inventario");
		menuInventario.setEnabled(false);
		menuItemParametrosInv = new JMenuItem("Parametros", KeyEvent.VK_P);
		menuItemProcesosInv = new JMenuItem("Procesos", KeyEvent.VK_R);
		menuItemReportesInv = new JMenuItem("Reportes", KeyEvent.VK_E);
		
		menuCompras = new JMenu("Compras");
		menuCompras.setEnabled(false);
		menuItemParametrosCom = new JMenuItem("Parametros", KeyEvent.VK_P);
		menuItemProcesosCom = new JMenuItem("Procesos", KeyEvent.VK_R);
		menuItemReportesCom = new JMenuItem("Reportes", KeyEvent.VK_E);
		
		menuVentas = new JMenu("Ventas");
		menuItemProcesosVen = new JMenuItem("Procesos", KeyEvent.VK_R);
		menuItemReportesVen = new JMenuItem("Reportes", KeyEvent.VK_E);
		menuItemParametrosVen = new JMenuItem("Parametros", KeyEvent.VK_P);
		
		menuCliente = new JMenu("Clientes");
		menuRegCliente = new JMenuItem("Registrar", KeyEvent.VK_P);
		menuConsulCliente = new JMenuItem("Consultar", KeyEvent.VK_R);
		menuModifCliente = new JMenuItem("Modificar", KeyEvent.VK_E);
		
		menuEmpleado = new JMenu("Empleados");
		menuRegEmpleado = new JMenuItem("Registrar", KeyEvent.VK_P);
		menuConsulEmpleado = new JMenuItem("Consultar", KeyEvent.VK_R);
		menuModifEmpleado = new JMenuItem("Modificar", KeyEvent.VK_E);
		menuUser = new JMenuItem ("Ingresar Credenciales", KeyEvent.VK_R);
		
		menuCerrarSesion = new JMenu("Cerrar-Sesion");
		menuCerrar = new JMenuItem("Cambiar de usuario", KeyEvent.VK_P);
		
		menuSalir = new JMenu("Salir");
		menuSalirSistema = new JMenuItem("Salir del Sistema",KeyEvent.VK_R);
		
		menuLocal = new JMenu ("Locales");
		menuRegLocal = new JMenuItem ("Registrar Local", KeyEvent.VK_P);
		menuConsulLocal = new JMenuItem ("Consultar Locales" , KeyEvent.VK_R);
		menuModifLocal = new JMenuItem ("Modificar Locales" , KeyEvent.VK_E);
	}

	private void ventana() {
		
		this.setSize(1000, 70);
		this.setLocation(100, 50);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	

}
