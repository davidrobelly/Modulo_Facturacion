package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo_clases.Cliente;
import modelo_clases.Empleado;
import pantallas.Consultar_Clientes;
import pantallas.Consultar_Empleados;
import pantallas.Modificar_Clientes;
import pantallas.Modificar_Empleados;
import pantallas.Tabla_Clientes;
import pantallas.Tabla_Empleados;
import pantallas.Ventana_Ingreso_Empleado;

public class Control_Consulta_Empleados implements ActionListener,KeyListener,MouseListener{

	final int limite = 10;
	Consultar_Empleados vista;
	Ventana_Ingreso_Empleado modificar;
	Empleado empleado;
	String nombre;
	String numero;
	
	public Control_Consulta_Empleados (Consultar_Empleados vista)
	{
		this.vista=vista;
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
			Tabla_Empleados tEmpleado = new Tabla_Empleados();
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
			Tabla_Empleados tEmpleado = new Tabla_Empleados();
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
			Tabla_Empleados tEmpleado = new Tabla_Empleados();
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
				ArrayList<Empleado> lisEmpleado = empleado.listaEmpleadoxNombre(nombre);
				Tabla_Empleados templeado = new Tabla_Empleados(lisEmpleado);
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
				ArrayList<Empleado> lisEmpleado = empleado.listaEmpleadosxCedula(numero);
				Tabla_Empleados templeado = new Tabla_Empleados(lisEmpleado);
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
				ArrayList<Empleado> lisEmpleado = empleado.listaEmpeladosxApellido(nombre);
				Tabla_Empleados templeado = new Tabla_Empleados(lisEmpleado);
				vista.tableEmpleado.removeAll();
				vista.tableEmpleado.setModel(templeado);
				vista.tableEmpleado.updateUI();
			}
		}
		
		if (boton == vista.btngenerar) 
			{
				empleado = new Empleado();
				ArrayList<Empleado> lisEmpleado = empleado.listaEmpleados();
				Tabla_Empleados templeado = new Tabla_Empleados(lisEmpleado);
				vista.tableEmpleado.removeAll();
				vista.tableEmpleado.setModel(templeado);
				vista.tableEmpleado.updateUI();
			}
		
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		modificar = new Ventana_Ingreso_Empleado();
		int fila = vista.tableEmpleado.rowAtPoint(e.getPoint());
        modificar.txtnombre.setText(vista.tableEmpleado.getValueAt(fila, 0).toString());
        modificar.txtapellido.setText(vista.tableEmpleado.getValueAt(fila, 1).toString());
        modificar.txtcedula.setText(vista.tableEmpleado.getValueAt(fila, 2).toString());
        modificar.txttelefono.setText(vista.tableEmpleado.getValueAt(fila, 3).toString());
        modificar.txtedad.setText(vista.tableEmpleado.getValueAt(fila, 4).toString());
        modificar.txtdireccion.setText(vista.tableEmpleado.getValueAt(fila, 5).toString());
        modificar.cmbtipo.setSelectedItem(vista.tableEmpleado.getValueAt(fila, 6).toString());
        
        String valor = vista.tableEmpleado.getValueAt(fila, 7).toString();
        
        if (valor.equals("i"))
        {
        	modificar.cmbestado.setSelectedItem("Inactivo");
        }
        else {
    		modificar.cmbestado.setSelectedItem("Activo");
    	}
        
        modificar.setTitle("Datos del Empleado");
        modificar.txtapellido.setEditable(false);
        modificar.txtnombre.setEditable(false);
        modificar.txtcedula.setEditable(false);
        modificar.txtedad.setEditable(false);
        modificar.txttelefono.setEditable(false);
        modificar.txtdireccion.setEditable(false);
        modificar.cmbestado.setEnabled(false);
        modificar.cmbtipo.setEnabled(false);
       
        modificar.PanelBotones.removeAll();
		
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		
		
	}



	@Override
	public void mousePressed(MouseEvent arg0) {
		
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}



	@Override
	public void keyPressed(KeyEvent arg0) {
		
		
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		if (limite == vista.txtcedula.getText().length()){
		     e.consume();
		}
		char caracter = e.getKeyChar();
		if(Character.isDigit(caracter)){
		}else{
			e.consume();
		}
		
	}


}
