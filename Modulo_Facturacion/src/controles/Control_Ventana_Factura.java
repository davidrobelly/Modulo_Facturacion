package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo_clases.Cotizacion;
import modelo_clases.Factura;
import pantallas.Ventana_Detalle_Cotizacion;
import pantallas.Ventana_Detalle_Factura;
import pantallas.Ventana_Ingreso_Cotizacion;
import pantallas.Ventana_Ingreso_Factura;

public class Control_Ventana_Factura implements ActionListener{

	Ventana_Ingreso_Factura vista;
	Factura factura;
	Ventana_Detalle_Factura detallefactura;
	
	public Control_Ventana_Factura(Ventana_Ingreso_Factura vista) {
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
				detallefactura = new Ventana_Detalle_Factura();
				detallefactura.txtfactura.setText(vista.txtcodigo.getText());
				vista.txtcodigo.setEditable(false);
				
				
				
			}
			
			else JOptionPane.showMessageDialog(null, "faltan campos de llenar");
			
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
			vista.txtlocal.setText("");
			vista.txtcodigo.setEditable(true);
			vista.txtcodigo.setText("");
		}
		
		if (boton == vista.btngenerar) 
		{
			JOptionPane.showMessageDialog(null, "Reporte Generado");
		}
		
		
	}

}

