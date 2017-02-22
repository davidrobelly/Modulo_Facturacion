package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo_clases.Cliente;
import pantallas.Modificar_Clientes;

public class Control_Modificar_Clientes implements ActionListener{
	
	Modificar_Clientes vista;
	Cliente cliente;
	int term;
	String estado;
	
	public Control_Modificar_Clientes (Modificar_Clientes vista)
	{
		this.vista= vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object boton = e.getSource();
		
		if(boton == vista.btnborrar)
		{
			vista.txtapellido.setText("");
			vista.txtnombre.setText("");
			vista.txtcedula.setText("");
			vista.txttelefono.setText("");
			vista.txtdireccion.setText("");
			vista.txtcorreo.setText("");
			
		}
	
		
		if (boton == vista.btnmodificar)
		{
			if (vista.txtnombre.getText().equals("") || vista.txtapellido.getText().equals("") || 
					vista.txtdireccion.getText().equals("")
					|| vista.txttelefono.getText().equals("") || vista.txtcedula.getText().equals("")
					|| vista.txtcorreo.getText().equals("")) 
			{
				
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
			}
			
			if (vista.txtnombre.getText().length() >= 1 && vista.txtapellido.getText().length() >= 1 &&
					vista.txtdireccion.getText().length() >= 1
					&& vista.txttelefono.getText().length() <= 10 && vista.txtcedula.getText().length() == 10
					&& vista.txtcorreo.getText().length() >= 1) 
			{
				if( (String) vista.cmbestado.getSelectedItem() == "Inactivo")
				{
					estado = "i";
				}
				else 
				{
					estado ="a";
				}
				
				cliente = new Cliente (Integer.parseInt(vista.txtid.getText()), vista.txtnombre.getText(), vista.txtapellido.getText(), vista.txtcedula.getText()
						,vista.txttelefono.getText() ,vista.txtcorreo.getText() ,
						vista.txtdireccion.getText(),(String) vista.cmbtipo.getSelectedItem(), estado);
				
				term = Integer.parseInt(vista.txtid.getText());
				cliente.modificarCliente(term, cliente);
				
				JOptionPane.showMessageDialog(null, "Registro Exitoso");
				
				vista.txtid.setText("");
				vista.txtnombre.setText(""); 
				vista.txttelefono.setText(""); 
				vista.txtdireccion.setText(""); 
				vista.txtcedula.setText(""); 
				vista.txtcorreo.setText(""); 
				vista.txtapellido.setText("");
			}
	
		}
		
		
	}
	
	

}
