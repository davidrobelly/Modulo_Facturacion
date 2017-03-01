package Secutel_ERP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ControladorModificarProveedor implements ActionListener,MouseListener{
	
	VentanaModificarProvedor ventana;
	ArrayList<String> listaProveedores = new ArrayList<>();
	String nom,ruc,dir,des;
	Proveedor proveedor;
	public ControladorModificarProveedor(VentanaModificarProvedor vista) {
		ventana = vista;
		proveedor = new Proveedor();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object control = e.getSource();
		if (control == ventana.registrarCon) {
			VentanaNuevoCproveedor vncp = new VentanaNuevoCproveedor(ventana.controlNCP);
			vncp.setVisible(true);
		}
		if (control == ventana.registrar) {
			boolean vol;
			boolean vl =  validadorDatos();
			if (vl) {
				if (ventana.nomBuscar.equals(nom)) {
					if (ventana.rucBuscar.equals(ruc)) {
						modificarProveedor(proveedor, ventana.rucBuscar);
					}else{
						vol = proveedor.obtenerRucProveedor(ruc);
						if (vol) {
							JOptionPane.showMessageDialog(null, "Ya se encuentra registrado este ruc de proveedor");
						}else{
							modificarProveedor(proveedor, ventana.rucBuscar);
						}
					}
				}else{
					vol = proveedor.obtenerNombreProveedor(nom);
					if (vol) {
						JOptionPane.showMessageDialog(null, "Ya se encuentra registrado este nombre de proveedor");
					}else{
						if (ventana.rucBuscar.equals(ruc)) {
							modificarProveedor(proveedor, ventana.rucBuscar);
						}else{
							vol = proveedor.obtenerRucProveedor(ruc);
							System.out.println(vol);
							if (vol) {
								JOptionPane.showMessageDialog(null, "Ya se encuentra registrado este ruc de proveedor");
							}else{
								modificarProveedor(proveedor, ventana.rucBuscar);
							}
						}
					}
				}
				
			}else{
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
			}
		}
		if (control == ventana.buscar) {
			VentanaBuscarProveedor venBp = new VentanaBuscarProveedor(ventana.controlBP);
			venBp.setVisible(true);
		}
	}
	boolean validadorDatos(){
		boolean val = false;
		nom = ventana.txtnombre.getText();
		ruc = ventana.txtruc.getText();
		dir = ventana.txtdireccion.getText();
		des = ventana.txtdescripcion.getText();
		if (!("".equals(nom)||"".equals(ruc)||"".equals(dir)||"".equals(des))) {
			if(ruc.length() == 10){
				val = true;
				proveedor.setNombre(nom);
				proveedor.setRuc(ruc);
				proveedor.setDireccion(dir);
				proveedor.setDescripcion(des);
			}
		}
		return val;
	}
	void modificarProveedor(Proveedor pro, String ruc){
		Proveedor prov = new Proveedor();
		ContactoProveedor cont = new ContactoProveedor();
		prov.modificarProveedor(ruc, pro);
		if (ventana.listaConPro.size()>0) {
			for (int i = 0; i < ventana.listaConPro.size(); i++) {
				boolean valCon = cont.verificarContacto(ventana.listaConPro.get(i).getCedula());
				if (valCon) {
					if ((boolean) ventana.tableConEd.getValueAt(i, 3)) {
						cont.inactivar(ventana.listaConPro.get(i).getCedula());
					}
				}else{
					if (!((boolean) ventana.tableConEd.getValueAt(i, 3))) {
						cont.insertarContacto(ventana.listaConPro.get(i), nom);
					}
				}
			}
		}
		ventana.txtnombre.setText("");
		ventana.txtruc.setText("");
		ventana.txtdireccion.setText("");
		ventana.txtdescripcion.setText("");
		ventana.registrar.setEnabled(false);
		ventana.registrarCon.setEnabled(false);
		TablaEditarContacto nueva = new TablaEditarContacto();
		ventana.tableConEd.setModel(nueva);
		ventana.tableConEd.updateUI();
		JOptionPane.showMessageDialog(null, "Proveedor Modificado Correctamente");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int fil = ventana.tableConEd.rowAtPoint(e.getPoint());
		int col = ventana.tableConEd.columnAtPoint(e.getPoint());
		if (col == 3) {
			boolean valor = (boolean) ventana.tableConEd.getValueAt(fil, col);
			if (valor) {
				ventana.tableConEd.setValueAt(false, fil, col);
			}else{
				ventana.tableConEd.setValueAt(true, fil, col);
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
