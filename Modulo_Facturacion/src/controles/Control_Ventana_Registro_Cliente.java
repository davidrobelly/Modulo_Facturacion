package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import modelo_clases.Cliente;
import pantallas.Pantalla_Principal;
import pantallas.Ventana_Ingreso_Clientes;

public class Control_Ventana_Registro_Cliente implements ActionListener {
	
	Ventana_Ingreso_Clientes vista;
	Cliente cliente;

	public Control_Ventana_Registro_Cliente(Ventana_Ingreso_Clientes vista) {
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
			vista.txtapellido.setText(""); 
			vista.txttelefono.setText(""); 
			vista.txtdireccion.setText(""); 
			vista.txtcedula.setText(""); 
			vista.txtcorreo.setText(""); 
		}
		
		if (boton == vista.btnregistrar)
		{
			
			if (vista.txtnombre.getText().equals("") || vista.txtapellido.getText().equals("") || 
					vista.txtdireccion.getText().equals("")
					|| vista.txttelefono.getText().equals("") || vista.txtcedula.getText().equals("")
					|| vista.txtcorreo.getText().equals("")) 
			{
				
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
			}
			
			if (vista.txtnombre.getText().length() >= 3 && vista.txtapellido.getText().length() >= 5 &&
					vista.txtdireccion.getText().length() >= 5
					&& vista.txttelefono.getText().length() <= 10 && vista.txtcedula.getText().length() == 10
					&& vista.txtcorreo.getText().length() >= 5) 
			{
				
				cliente = new Cliente (vista.txtnombre.getText(), vista.txtapellido.getText(), vista.txtcedula.getText()
						,vista.txttelefono.getText() ,vista.txtcorreo.getText() ,
						vista.txtdireccion.getText(),(String) vista.cmbtipo.getSelectedItem());
				
				cliente.ingresarCliente(cliente);
				
				JOptionPane.showMessageDialog(null, "Registro Exitoso");
				
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
