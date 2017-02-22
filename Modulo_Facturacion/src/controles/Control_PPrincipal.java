package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import pantallas.Consulta_Modificar_Clientes;
import pantallas.Consulta_Modificar_Empleados;
import pantallas.Consultar_Clientes;
import pantallas.Consultar_Empleados;
import pantallas.Consultar_Local_Modificar;
import pantallas.Consultar_Locales;
import pantallas.Consultar_User;
import pantallas.Modificar_Clientes;
import pantallas.Pantalla_Ingreso;
import pantallas.Pantalla_Principal;
import pantallas.Ventana_Ingreso_Clientes;
import pantallas.Ventana_Ingreso_Credenciales;
import pantallas.Ventana_Ingreso_Empleado;
import pantallas.Ventana_Ingreso_Sucursal;

public class Control_PPrincipal implements ActionListener{

	Pantalla_Principal vista;
	
	
	public Control_PPrincipal (Pantalla_Principal vista)
	{
		this.vista = vista;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object boton = e.getSource();
		
		//clientes
		
		if (boton == vista.menuRegCliente)
		{
			Ventana_Ingreso_Clientes cliente = new Ventana_Ingreso_Clientes();
		}
		
		if (boton == vista.menuConsulCliente)
		{
			Consultar_Clientes cliente = new Consultar_Clientes();
		}
		
		if (boton == vista.menuModifCliente)
		{
			Consulta_Modificar_Clientes cliente = new Consulta_Modificar_Clientes();
		}
		
		//empleados
		
		if (boton == vista.menuRegEmpleado)
		{
			Ventana_Ingreso_Empleado cliente = new Ventana_Ingreso_Empleado();
		}
		
		if (boton == vista.menuConsulEmpleado)
		{
			Consultar_Empleados cliente = new Consultar_Empleados();
		}
		
		if (boton == vista.menuModifEmpleado)
		{
			Consulta_Modificar_Empleados cliente = new Consulta_Modificar_Empleados();
		}
		
		if (boton == vista.menuUser)
		{
			Consultar_User cliente = new Consultar_User();
		}
		
		//locales
		
		if (boton == vista.menuRegLocal)
		{
			Ventana_Ingreso_Sucursal cliente = new Ventana_Ingreso_Sucursal();
		}
		
		if (boton == vista.menuConsulLocal)
		{
			Consultar_Locales cliente = new Consultar_Locales();
		}
		
		if (boton == vista.menuModifLocal)
		{
			Consultar_Local_Modificar cliente = new Consultar_Local_Modificar();
		}
		
		//otros
		
		if (boton == vista.menuCerrar)
		{
			Pantalla_Ingreso cliente = new Pantalla_Ingreso ();
			vista.dispose();
		}
		
		if (boton == vista.menuSalirSistema)
		{
			vista.dispose();
			JOptionPane.showMessageDialog(null, "Usted ha salido del sistema");
		}
	}

}
