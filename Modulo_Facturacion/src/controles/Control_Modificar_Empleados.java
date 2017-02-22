package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo_clases.Cliente;
import modelo_clases.Empleado;
import pantallas.Modificar_Clientes;
import pantallas.Modificar_Empleados;

public class Control_Modificar_Empleados implements ActionListener{
	
	Modificar_Empleados vista;
	Empleado empleado;
	int term;
	String estado;
	
	public Control_Modificar_Empleados (Modificar_Empleados vista)
	{
		this.vista= vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object boton = e.getSource();
		
		if(boton == vista.btnborrar)
		{
			vista.txtid.setText("");
			vista.txtapellido.setText("");
			vista.txtnombre.setText("");
			vista.txtcedula.setText("");
			vista.txttelefono.setText("");
			vista.txtdireccion.setText("");
			vista.txtedad.setText("");
			
		}
	
		
		if (boton == vista.btnmodificar)
		{
			if (vista.txtnombre.getText().equals("") || vista.txtapellido.getText().equals("") || 
					vista.txtdireccion.getText().equals("")
					|| vista.txttelefono.getText().equals("") || vista.txtcedula.getText().equals("")
					|| vista.txtedad.getText().equals("")|| vista.txtid.getText().equals("")) 
			{
				
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
			}
			
			if (vista.txtnombre.getText().length() >= 1 && vista.txtapellido.getText().length() >= 1 &&
					vista.txtdireccion.getText().length() >= 1
					&& vista.txttelefono.getText().length() <= 10 && vista.txtcedula.getText().length() == 10
					&& vista.txtedad.getText().length() >= 1) 
			{
				if( (String) vista.cmbestado.getSelectedItem() == "Inactivo")
				{
					estado = "i";
				}
				else 
				{
					estado ="a";
				}
				
				empleado = new Empleado (Integer.parseInt(vista.txtid.getText()), 
						vista.txtnombre.getText(),vista.txtapellido.getText(), vista.txtcedula.getText()
						,vista.txttelefono.getText(), vista.txtdireccion.getText(),
						Integer.parseInt(vista.txtedad.getText()) ,(String) vista.cmbtipo.getSelectedItem(), estado);
				
				term = Integer.parseInt(vista.txtid.getText());
				empleado.modificarEmpleado(term, empleado);
				
				JOptionPane.showMessageDialog(null, "Registro Exitoso");
				
				vista.txtid.setText("");
				vista.txtnombre.setText(""); 
				vista.txttelefono.setText(""); 
				vista.txtdireccion.setText(""); 
				vista.txtcedula.setText(""); 
				vista.txtedad.setText(""); 
				vista.txtapellido.setText("");
			}
	
		}
		
		
	}

}
