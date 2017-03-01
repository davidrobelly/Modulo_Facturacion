package Secutel_ERP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ControladorEstadoProveedor implements ActionListener,MouseListener{

	VentanaEstadoProveedor ventana;
	ArrayList<Proveedor> listaActivos = new ArrayList<>();
	ArrayList<Proveedor> listaInactiv = new ArrayList<>();
	Proveedor proveedor = new Proveedor();
	 public ControladorEstadoProveedor(VentanaEstadoProveedor vista) {
		 ventana = vista;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object control = e.getSource();
		if (control == ventana.activar) {
			for (int i = 0; i < listaInactiv.size(); i++) {
				if ((boolean) ventana.tableProvI.getValueAt(i, 4)) {
					proveedor.activarProveedor(listaInactiv.get(i).getRuc());
				}
			}
			JOptionPane.showMessageDialog(null, "Proveedores Modificados Correctamente");
			llenarActivos();
			llenarInactivos();
		}
		if (control == ventana.desactivar) {
			for (int i = 0; i < listaActivos.size(); i++) {
				if ((boolean) ventana.tableProvA.getValueAt(i, 4)) {
					proveedor.inactivarProveedor(listaActivos.get(i).getRuc());
				}
			}
			JOptionPane.showMessageDialog(null, "Proveedores Modificados Correctamente");
			llenarActivos();
			llenarInactivos();
		}
	}
	void llenarActivos(){
		listaActivos = proveedor.listaProveedores();
		TablaEstadoProveedor tep = new TablaEstadoProveedor(listaActivos);
		ventana.tableProvA.setModel(tep);
		ventana.tableProvA.updateUI();
	}
	void llenarInactivos(){
		listaInactiv = proveedor.listaProveedoresInactivos();
		TablaEstadoProveedor tep = new TablaEstadoProveedor(listaInactiv);
		ventana.tableProvI.setModel(tep);
		ventana.tableProvI.updateUI();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		int fila = ventana.tableProvA.rowAtPoint(e.getPoint());
		int cola = ventana.tableProvA.columnAtPoint(e.getPoint());
		int filb = ventana.tableProvI.rowAtPoint(e.getPoint());
		int colb = ventana.tableProvI.columnAtPoint(e.getPoint());
		if (cola == 4) {
			boolean valor = (boolean) ventana.tableProvA.getValueAt(fila, cola);
			if (valor) {
				ventana.tableProvA.setValueAt(false, fila, cola);
			}else{
				ventana.tableProvA.setValueAt(true, fila, cola);
			}
		}
		if (colb == 4) {
			boolean valor = (boolean) ventana.tableProvI.getValueAt(filb, colb);
			if (valor) {
				ventana.tableProvI.setValueAt(false, filb, colb);
			}else{
				ventana.tableProvI.setValueAt(true, filb, colb);
			}
		}
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
}
