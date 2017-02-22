package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo_clases.Cliente;
import modelo_clases.Sucursal;
import pantallas.Modificar_Locales;

public class Control_Modificar_Locales implements ActionListener{

	Modificar_Locales vista;
	Sucursal local;
	String estado;
	

	public Control_Modificar_Locales(Modificar_Locales vista) {
		this.vista= vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object boton = e.getSource();
		
		if(boton == vista.btnborrar)
		{
			vista.txtnombre.setText("");
			vista.txtdireccion.setText("");
		}
		
		if (boton == vista.btnregistrar)
		{
			if (vista.txtnombre.getText().equals("") || vista.txtdireccion.getText().equals("")) 
			{
				
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
			}
			
			if (vista.txtnombre.getText().length() >= 3 && vista.txtdireccion.getText().length() >= 5) 
			{
				if( (String) vista.cmbestado.getSelectedItem() == "Inactivo")
				{
					estado = "i";
				}
				else 
				{
					estado ="a";
				}
				
				local = new Sucursal (vista.txtnombre.getText(), vista.txtdireccion.getText(), estado);
				
				//local.modificarLocal(term, local);
				
				JOptionPane.showMessageDialog(null, "Registro Exitoso");
				
				vista.txtnombre.setText("");  
				vista.txtdireccion.setText(""); 
			}
	
		}
	}

}
