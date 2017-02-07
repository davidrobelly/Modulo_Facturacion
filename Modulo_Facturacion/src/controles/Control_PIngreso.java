package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import modelo_clases.Credenciales;
import pantallas.Pantalla_Ingreso;
import pantallas.Pantalla_Principal;

public class Control_PIngreso implements ActionListener{

	Pantalla_Ingreso vista;
	Credenciales credencial;
	Pantalla_Principal nuevaVentana;
	
	
	public Control_PIngreso (Pantalla_Ingreso vista)
	{
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object boton = e.getSource();
		
		if(boton == vista.btn_ingresar){
		
			nuevaVentana = new Pantalla_Principal();
			nuevaVentana.setVisible(true);
			vista.dispose();				
		}
		
		if (boton == vista.btn_cancelar) 
		{
			vista.dispose();
		}
	}
	
	

}
