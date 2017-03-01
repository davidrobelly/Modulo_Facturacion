package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo_clases.Cliente;
import modelo_clases.Sucursal;
import pantallas.Ventana_Ingreso_Sucursal;

public class Control_Ventana_Registro_Sucursal implements ActionListener {
	
	Ventana_Ingreso_Sucursal vista;
	Sucursal sucursal;
	
	public Control_Ventana_Registro_Sucursal(Ventana_Ingreso_Sucursal vista) {
		super();
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object boton = e.getSource();
		
		if (boton == vista.btncancelar )
		{
			vista.dispose();
		}
	
		if (boton == vista.btnborrar)
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
			
			if (vista.txtnombre.getText().length() > 1 && vista.txtdireccion.getText().length() > 1
					&& vista.txtciudad.getText().length() > 1) 
			{
				sucursal = new Sucursal (vista.txtnombre.getText(), vista.txtdireccion.getText(),
						vista.txtciudad.getText());
				
				sucursal.ingresarSucursal(sucursal);
				
				JOptionPane.showMessageDialog(null, "Registro Exitoso");
				
				vista.txtnombre.setText(""); 
				vista.txtdireccion.setText(""); 
			}
		}
	}

}
