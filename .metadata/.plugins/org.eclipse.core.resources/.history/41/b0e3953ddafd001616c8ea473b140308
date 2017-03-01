package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import pantallas.Ventana_Ingreso_Empleado;
import modelo_clases.Empleado;


public class Control_Ventana_Registro_Empleado implements ActionListener {

	Ventana_Ingreso_Empleado vista;
	Empleado empleado;

	public Control_Ventana_Registro_Empleado(Ventana_Ingreso_Empleado vista) {
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
			vista.txttelefono.setText(""); 
			vista.txtdireccion.setText(""); 
			vista.txtcedula.setText(""); 
			vista.txtedad.setText("");
			vista.txtapellido.setText("");
		}
		
		if (boton == vista.btnregistrar)
		{	

			if (vista.txtnombre.getText().equals("") || vista.txtdireccion.getText().equals("")
					|| vista.txttelefono.getText().equals("") || vista.txtcedula.getText().equals("")
					|| vista.txtedad.getText().equals("") || vista.txtapellido.equals("")) 
			{
				
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
			
			}
			
			if (vista.txtnombre.getText().length() >= 1 && vista.txtapellido.getText().length() >= 1
					&& vista.txtcedula.getText().length() == 10 && vista.txttelefono.getText().length() <= 10 &&
					vista.txtdireccion.getText().length() >= 1 ) 
			{
				if (Integer.parseInt(vista.txtedad.getText()) >= 18)
				{
				
				empleado = new Empleado (vista.txtnombre.getText(), vista.txtapellido.getText(), 
						vista.txtcedula.getText(), vista.txttelefono.getText(), vista.txtdireccion.getText(), 
						Integer.parseInt(vista.txtedad.getText()),(String) vista.cmbtipo.getSelectedItem());
				
				empleado.ingresarEmpleado(empleado);
			
				JOptionPane.showMessageDialog(null, "Registro Exitoso");
				
				vista.txtnombre.setText(""); 
				vista.txttelefono.setText(""); 
				vista.txtdireccion.setText(""); 
				vista.txtcedula.setText(""); 
				vista.txtedad.setText("");
				vista.txtapellido.setText("");
				}
				
				else {
					
					JOptionPane.showMessageDialog(null, "debe ser mayor de edad");
					vista.txtedad.setText("");
			}
			
			
			}
			
		}
		
	}

	
	
}
