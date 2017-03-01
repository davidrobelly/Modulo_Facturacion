package Secutel_ERP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ControladorNuevoTelefono implements ActionListener,KeyListener{
	final int limite = 10;
	final int minimo = 7;
	VentanaNuevoCproveedor venNCP;
	VentanaNuevoTelefono venNT;
	boolean validador = true;
	String numTel = "";
	public ControladorNuevoTelefono(VentanaNuevoCproveedor vista) {
		venNCP = vista;
		validador = true;
	}
	public ControladorNuevoTelefono(VentanaNuevoTelefono vista) {
		venNT = vista;
		validador = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object control = e.getSource();
		if (control == venNT.registrar) {
			if (validador) {
				boolean valid = validarDatos();
				if (!(valid)) {
					TelefonoContacto telefono = new TelefonoContacto(numTel);
					addUnique(venNCP.listaTel, telefono);
					venNCP.tableTel.removeAll();
					TablaTelefonoContacto tT = new TablaTelefonoContacto(venNCP.listaTel);
					venNCP.tableTel.setModel(tT);
					venNCP.tableTel.updateUI();
					venNT.txtTel.setText("");
				}else{
					venNT.txtTel.setText("");
				}
			}else{
				boolean valid = validarDatos();
				if (valid) {
					
				}
			}
		}
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		if (limite == venNT.txtTel.getText().length()){
		     e.consume();
		}
		char caracter = e.getKeyChar();
		if(Character.isDigit(caracter)){
		}else{
			e.consume();
		}
	}
	boolean validarDatos(){
		boolean val = true;
		numTel = venNT.txtTel.getText();
		if ("".equals(numTel)) {
			val = true;
			JOptionPane.showMessageDialog(null, "faltan campos de llenar");
		}else{
			String contador = venNT.txtTel.getText();
			if (minimo == contador.length() || limite == contador.length()) {
				val = false;
			}else{
				val = true;
				JOptionPane.showMessageDialog(null, "numero de digitos incorrectos");
			}
		}
		return val;
	}
	public void addUnique(ArrayList<TelefonoContacto> lista, TelefonoContacto elemento){
		TelefonoContacto tel = new TelefonoContacto();
		tel.buscarTelefono(elemento.getNumero());
		System.out.println(tel.getNumero());
		if(tel.getNumero().equals(elemento.getNumero())){
			JOptionPane.showMessageDialog(null, "Este numero ya esta registrado");
		}else{
			boolean verdad = false;
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getNumero().equals(elemento.getNumero())) {
					verdad = true;
				}
			}
			if (verdad) {
				JOptionPane.showMessageDialog(null, "Este numero ya esta registrado");
			}else{
				lista.add(elemento);
			}	
		}
	}
}
