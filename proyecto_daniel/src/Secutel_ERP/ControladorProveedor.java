package Secutel_ERP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ControladorProveedor implements ActionListener,KeyListener{

	final int limite = 10;
	VentanaNuevoProveedor venNPro;
	String nombre = "",direccion = "",descripcion = "",ruc = "";
	public ControladorProveedor(VentanaNuevoProveedor pan) {
		venNPro = pan;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object control = e.getSource();
		boolean verdad = true;
		if (control == venNPro.registrar) {
			verdad = textoValido();
			if(verdad){
				JOptionPane.showMessageDialog(null, "faltan campos de llenar");
			}else{
				Proveedor pro = new Proveedor(nombre, direccion, ruc, descripcion);
				pro.ingresarProveedor(pro);
				if (venNPro.listaContactos.size()>0) {
					for (int i = 0; i < venNPro.listaContactos.size(); i++) {
						ContactoProveedor con = venNPro.listaContactos.get(i);
						con.insertarContacto(con, nombre);
						if (con.getLista().size()>0) {
							for (int j = 0; j < con.getLista().size(); j++) {
								TelefonoContacto tel = con.getLista().get(j);
								tel.insertarTelefono(tel, con.getCedula());
							}
						}
					}
				}
				venNPro.txtnombre.setText("");
				venNPro.txtdireccion.setText("");
				venNPro.txtruc.setText("");
				venNPro.txtdescripcion.setText("");
				TablaContactos nueva = new TablaContactos();
				venNPro.tableCon.setModel(nueva);
				venNPro.tableCon.updateUI();
				venNPro.listaContactos = new ArrayList<>();
				JOptionPane.showMessageDialog(null, "Proveedor Registrado Correctamente");
			}
		}
		if (control == venNPro.registrarCon) {
			VentanaNuevoCproveedor contPro = new VentanaNuevoCproveedor(venNPro.controlContacto);
			contPro.setVisible(true);
		}
		if (control == venNPro.cerrar) {
			venNPro.dispose();
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {	
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {
		if (limite == venNPro.txtruc.getText().length()){
		     e.consume();
		}
		char caracter = e.getKeyChar();
		if(Character.isDigit(caracter)){
		}else{
			e.consume();
		}
	}
	boolean textoValido(){
		nombre = venNPro.txtnombre.getText();
		direccion = venNPro.txtdireccion.getText();
		ruc = venNPro.txtruc.getText();
		descripcion = venNPro.txtdescripcion.getText();
		boolean validador = true;
		if("".equals(nombre)||"".equals(direccion)||"".equals(ruc)||"".equals(descripcion)&& ruc.length() == 10){
			validador = true;
		}else{
			validador = false;
		}
		return validador;
	}
}
