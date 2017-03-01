package Secutel_ERP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMenuCompra implements ActionListener{

	VentanaMenuCompra vista;
	VentanaNuevoProveedor venNP;
	VentanaModificarProvedor venMP;
	VentanaEstadoProveedor venEP;
	VentanaNuevoCproveedor venNC;
	ControladorMenuCompra(VentanaMenuCompra vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object control = e.getSource();
		if (control == vista.nuevoPro) {
			venNP = new VentanaNuevoProveedor();
			venNP.setVisible(true);
		}
		if (control == vista.editarPro) {
			venMP = new VentanaModificarProvedor();
			venMP.setVisible(true);
		}
		if (control == vista.estadoPro) {
			venEP = new VentanaEstadoProveedor();
			venEP.setVisible(true);
		}
		if (control == vista.nuevoCon) {
			venNC = new VentanaNuevoCproveedor();
			venNC.setVisible(true);
		}
		if (control == vista.salir) {
			this.vista.dispose();
		}
		
	}
}
