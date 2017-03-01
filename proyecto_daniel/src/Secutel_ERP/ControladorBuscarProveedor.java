package Secutel_ERP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ControladorBuscarProveedor  implements ActionListener,KeyListener,MouseListener{

	final int limite = 10;
	VentanaBuscarProveedor venBP;
	VentanaModificarProvedor venMP;
	String nombre = "";
	String numero = "";
	
	ControladorBuscarProveedor(VentanaBuscarProveedor vista) {
		venBP = vista;
	}
	
	ControladorBuscarProveedor(VentanaModificarProvedor vista) {
		venMP = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object control = e.getSource();
		if (control == venBP.radioNombre) {
			venBP.OpNom.setEnabled(true);
			venBP.OpRuc.setEnabled(false);
			venBP.txtOpNom.setEnabled(true);
			venBP.txtOpRuc.setEnabled(false);
			venBP.txtOpNom.setText("");
			venBP.txtOpRuc.setText("");
			TablaProveedores tPro = new TablaProveedores();
			venBP.tablePro.setModel(tPro);
			venBP.tablePro.updateUI();
		}
		if (control == venBP.radioRuc) {
			venBP.txtOpNom.setText("");
			venBP.txtOpRuc.setText("");
			venBP.OpNom.setEnabled(false);
			venBP.OpRuc.setEnabled(true);
			venBP.txtOpNom.setEnabled(false);
			venBP.txtOpRuc.setEnabled(true);
			TablaProveedores tPro = new TablaProveedores();
			venBP.tablePro.setModel(tPro);
			venBP.tablePro.updateUI();
		}
		if (control == venBP.OpNom) {
			nombre = venBP.txtOpNom.getText();
			if ("".equals(nombre)) {
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
				venBP.txtOpNom.setText("");
			}else{
				Proveedor pro = new Proveedor();
				ArrayList<Proveedor> lisPro = pro.listaProveedoresxNombre(nombre);
				TablaProveedores tPro = new TablaProveedores(lisPro);
				venBP.tablePro.removeAll();
				venBP.tablePro.setModel(tPro);
				venBP.tablePro.updateUI();
			}
		}
		if (control == venBP.OpRuc) {
			numero = venBP.txtOpRuc.getText();
			if ("".equals(numero)) {
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
				venBP.txtOpRuc.setText("");
			}else{
					Proveedor pro = new Proveedor();
					ArrayList<Proveedor> lisPro = pro.listaProveedoresxRuc(numero);
					TablaProveedores tPro = new TablaProveedores(lisPro);
					venBP.tablePro.removeAll();
					venBP.tablePro.setModel(tPro);
					venBP.tablePro.updateUI();
			}
		}
	}
	@Override
	public void keyPressed(KeyEvent arg0) {	
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if (limite == venBP.txtOpRuc.getText().length()){
		     e.consume();
		}
		char caracter = e.getKeyChar();
		if(Character.isDigit(caracter)){
		}else{
			e.consume();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int fila = venBP.tablePro.rowAtPoint(e.getPoint());
        venMP.txtnombre.setText(venBP.tablePro.getValueAt(fila, 0).toString());
        venMP.txtruc.setText(venBP.tablePro.getValueAt(fila, 1).toString());
        venMP.txtdireccion.setText(venBP.tablePro.getValueAt(fila, 2).toString());
        venMP.txtdescripcion.setText(venBP.tablePro.getValueAt(fila, 3).toString());
        venMP.nomBuscar = venBP.tablePro.getValueAt(fila, 0).toString();
        venMP.rucBuscar = venBP.tablePro.getValueAt(fila, 1).toString();
        venMP.registrar.setEnabled(true);
        venMP.registrarCon.setEnabled(true);
        Proveedor pro = new Proveedor();
        venMP.listaConPro = pro.listarContactosProveedor(venBP.tablePro.getValueAt(fila, 0).toString());
        TablaEditarContacto tec = new TablaEditarContacto(venMP.listaConPro);
        venMP.tableConEd.removeAll();
        venMP.tableConEd.setModel(tec);
        venMP.tableConEd.updateUI();
        venBP.dispose();
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
