package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo_clases.Credenciales;
import modelo_clases.Sucursal;
import pantallas.Ventana_Ingreso_Credenciales;
import pantallas.Ventana_Ingreso_Empleado;
import pantallas.Ventana_Ingreso_Sucursal;

public class Control_Ventana_Registro_Credenciales  implements ActionListener{

	Ventana_Ingreso_Credenciales vista;
	Credenciales credencial;
	
	public Control_Ventana_Registro_Credenciales(Ventana_Ingreso_Credenciales vista) {
		super();
		this.vista = vista;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
	Object boton = e.getSource();
		
		if (boton == vista.btncancelar )
		{
			vista.dispose();
		}
	
		if (boton == vista.btnborrar)
			{
				vista.txtuser.setText(""); 
				vista.txtkey.setText(""); 
			}
		
		if (boton == vista.btnregistrar)
		{
			if (vista.txtuser.getText() == "" || vista.txtkey.getText() == "")
			{
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
				vista.txtuser.setText("");
				vista.txtkey.setText("");
			}
			
			if(vista.txtuser.getText().length() > 1 && vista.txtkey.getText().length() > 1) 
			{
				credencial = new Credenciales (Integer.parseInt(vista.txtempleado.getText()), 
												vista.txtuser.getText(), 
												vista.txtkey.getText());
				
				credencial.ingresarCredenciales(credencial);
				JOptionPane.showMessageDialog(null, "Registro Exitoso");
				
				vista.txtuser.setText("");
				vista.txtkey.setText("");
				vista.dispose();
			}
		}
	}

}
