package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo_clases.Empleado;
import pantallas.Consultar_User;
import pantallas.Modificar_Empleados;
import pantallas.Tabla_User;
import pantallas.Ventana_Ingreso_Credenciales;

public class Control_Consulta_User implements ActionListener,KeyListener,MouseListener{

	final int limite = 10;
	Consultar_User vista;
	Empleado empleado;
	String nombre;
	String numero;
	Ventana_Ingreso_Credenciales modificar;
	
	
	public Control_Consulta_User (Consultar_User vista) {
		this.vista = vista;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		modificar = new Ventana_Ingreso_Credenciales();
		int fila = vista.tableEmpleado.rowAtPoint(e.getPoint());
		modificar.txtempleado.setText(vista.tableEmpleado.getValueAt(fila, 0).toString());
        modificar.txtempleado.setEditable(false);
 
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object boton = e.getSource();
		
		if(boton == vista.radioApellido)
		{
			vista.txtnombre.setEnabled(false);
			vista.txtnombre.setText("");
			vista.txtcedula.setEnabled(false);
			vista.txtcedula.setText("");
			vista.btncedula.setEnabled(false);
			vista.btnnombre.setEnabled(false);
			vista.txtapellido.setEnabled(true);
			vista.btnapellido.setEnabled(true);
			vista.txtapellido.setText("");
			Tabla_User tEmpleado = new Tabla_User();
			vista.tableEmpleado.setModel(tEmpleado);
			vista.tableEmpleado.updateUI();
		}
		
		if(boton == vista.radioNombre)
		{
			vista.txtapellido.setEnabled(false);
			vista.txtapellido.setText("");
			vista.btnapellido.setEnabled(false);
			vista.txtcedula.setEnabled(false);
			vista.txtcedula.setText("");
			vista.btncedula.setEnabled(false);
			vista.txtnombre.setEnabled(true);
			vista.btnnombre.setEnabled(true);
			vista.txtnombre.setText("");
			Tabla_User tEmpleado = new Tabla_User();
			vista.tableEmpleado.setModel(tEmpleado);
			vista.tableEmpleado.updateUI();
		}
		
		if(boton == vista.radioCedula)
		{
			vista.txtnombre.setEnabled(false);
			vista.txtnombre.setText("");
			vista.txtcedula.setEnabled(true);
			vista.txtcedula.setText("");
			vista.btncedula.setEnabled(true);
			vista.btnnombre.setEnabled(false);
			vista.txtapellido.setEnabled(false);
			vista.btnapellido.setEnabled(false);
			vista.txtapellido.setText("");
			Tabla_User tEmpleado = new Tabla_User();
			vista.tableEmpleado.setModel(tEmpleado);
			vista.tableEmpleado.updateUI();
		}
		
		if (boton == vista.btnnombre) {
			nombre = vista.txtnombre.getText();
			if ("".equals(nombre)) {
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
				vista.txtnombre.setText("");
			}else{
				empleado = new Empleado();
				ArrayList<Empleado> lisEmpleado = empleado.listaEmpleadoxNombreid(nombre);
				Tabla_User templeado = new Tabla_User(lisEmpleado);
				vista.tableEmpleado.removeAll();
				vista.tableEmpleado.setModel(templeado);
				vista.tableEmpleado.updateUI();
			}
		}
		
		if (boton == vista.btncedula) {
			numero = vista.txtcedula.getText();
			if ("".equals(numero)) {
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
				vista.txtcedula.setText("");
			}else{
				empleado = new Empleado();
				ArrayList<Empleado> lisEmpleado = empleado.listaEmpleadosxCedulaid(numero);
				Tabla_User templeado = new Tabla_User(lisEmpleado);
				vista.tableEmpleado.removeAll();
				vista.tableEmpleado.setModel(templeado);
				vista.tableEmpleado.updateUI();
			}
		}
		
		if (boton == vista.btnapellido) {
			nombre = vista.txtapellido.getText();
			if ("".equals(nombre)) {
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
				vista.txtapellido.setText("");
			}else{
				empleado = new Empleado();
				ArrayList<Empleado> lisEmpleado = empleado.listaEmpeladosxApellidoid(nombre);
				Tabla_User templeado = new Tabla_User(lisEmpleado);
				vista.tableEmpleado.removeAll();
				vista.tableEmpleado.setModel(templeado);
				vista.tableEmpleado.updateUI();
			}
		}
		
		if (boton == vista.btngenerar) 
			{
				empleado = new Empleado();
				ArrayList<Empleado> lisEmpleado = empleado.listaEmpleados();
				Tabla_User templeado = new Tabla_User(lisEmpleado);
				vista.tableEmpleado.removeAll();
				vista.tableEmpleado.setModel(templeado);
				vista.tableEmpleado.updateUI();
			}
		
	}

}
