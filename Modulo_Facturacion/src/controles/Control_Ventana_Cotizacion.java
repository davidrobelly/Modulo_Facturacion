package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo_clases.Cotizacion;
import pantallas.Ventana_Detalle_Cotizacion;
import pantallas.Ventana_Ingreso_Cotizacion;

public class Control_Ventana_Cotizacion implements ActionListener{

	Ventana_Ingreso_Cotizacion vista;
	Cotizacion cotizacion;
	Ventana_Detalle_Cotizacion detallecotizacion;
	
	public Control_Ventana_Cotizacion(Ventana_Ingreso_Cotizacion vista) {
		super();
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		Object boton = e.getSource();
		
		if (boton == vista.btnagregardetalle)
		{
			if (vista.txtcodigo.getText().length() > 1  && vista.txtcliente.getText().length() > 1
					&& vista.txtfecha.getText().length() > 1 && vista.txtvendedor.getText().length() > 1 && vista.txtvigencia.getText().length() > 1) 
			{
				detallecotizacion = new Ventana_Detalle_Cotizacion();
				detallecotizacion.txtcotizacion.setText(vista.txtcodigo.getText());
				vista.txtcodigo.setEditable(false);
			}
			
			JOptionPane.showMessageDialog(null, "faltan campos de llenar");
			
		}
		
		if (boton == vista.btnlimpiar)
		{
			vista.txtcantidad.setText("");
			vista.txtcliente.setText("");
			vista.txtfecha.setText("");
			vista.txtiva.setText("");
			vista.txtsubtotal.setText("");
			vista.txttotal.setText("");
			vista.txtvendedor.setText("");
			vista.txtvigencia.setText("");
			vista.txtcodigo.setEditable(true);
			vista.txtcodigo.setText("");
		}
		
		if (boton == vista.btngenerar) 
		{
			JOptionPane.showMessageDialog(null, "Reporte Generado");
		}
		
		
	}

}
