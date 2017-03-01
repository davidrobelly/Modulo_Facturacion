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
			vista.txtciudad.setText("");
		}
		
		if (boton == vista.btnregistrar)
		{
			if (vista.txtnombre.getText().equals("") || vista.txtdireccion.getText().equals("")
					|| vista.txtciudad.getText().equals("")) 
			{
				
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
			}
			
			if (vista.txtnombre.getText().length() >= 1 && vista.txtdireccion.getText().length() >= 1
					&& vista.txtciudad.getText().length() >= 1) 
			{
				if( (String) vista.cmbestado.getSelectedItem() == "Inactivo")
				{
					estado = "i";
				}
				else 
				{
					estado ="a";
				}
				
				local = new Sucursal (Integer.parseInt(vista.txtid.getText()), vista.txtnombre.getText(), 
						vista.txtdireccion.getText(), vista.txtciudad.getText(), estado);
				
				int term = Integer.parseInt(vista.txtid.getText());
				
				local.modificarSucursal(term, local);
				
				JOptionPane.showMessageDialog(null, "Registro Exitoso");
				
				vista.txtnombre.setText("");  
				vista.txtdireccion.setText(""); 
				vista.txtciudad.setText(""); 
			}
	
		}
	}

}
