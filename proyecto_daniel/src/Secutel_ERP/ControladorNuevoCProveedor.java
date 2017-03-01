package Secutel_ERP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ControladorNuevoCProveedor implements ActionListener,KeyListener{
	
	final int limite = 10;
	VentanaNuevoProveedor ingreso;
	VentanaNuevoCproveedor ingresoC;
	VentanaModificarProvedor modificarP;
	ArrayList<String> lista = new ArrayList<>();
	String nombre,apellido,cedula,val;
	String variable = "a";

	ControladorNuevoCProveedor(VentanaNuevoCproveedor vista) {
		ingresoC = vista;
		variable = "a";
	}
	
	ControladorNuevoCProveedor(VentanaNuevoProveedor vista) {
		ingreso = vista;
		variable = "b";
	}	
	
	ControladorNuevoCProveedor(VentanaModificarProvedor vista) {
		modificarP = vista;
		variable ="c";
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object control = e.getSource();
		if (control == ingresoC.registrar) {
			if("a".equals(variable)){
				System.out.println("no viene de nadie");
			}
			if("b".equals(variable)){
				boolean controlCon;
				controlCon = ValidarConenido();
				if (controlCon) {
					JOptionPane.showMessageDialog(null, "faltan campos de llenar");
				}else{
					ContactoProveedor cPro = new ContactoProveedor(nombre, apellido, cedula);
					cPro.setLista(ingresoC.listaTel);
					boolean verdad = ValidarCedula(cedula);
					if (verdad) {
						JOptionPane.showMessageDialog(null, "Cedula ya se encuentra registrada");
					}else{
						boolean cerca = false;
						if (ingreso.listaContactos.size()>0) {
							for (int i = 0; i < ingreso.listaContactos.size(); i++) {
								if (ingreso.listaContactos.get(i).cedula.equals(cedula)) {
									cerca = true;
								}else{
									cerca = false;
								}
							}
						}
						if (cerca) {
							JOptionPane.showMessageDialog(null, "Cedula ya se encuentra registrada");
						}else{
							ingreso.listaContactos.add(cPro);
							TablaContactos modeloC = new TablaContactos(ingreso.listaContactos);
							ingreso.tableCon.setModel(modeloC);
							ingreso.tableCon.updateUI();
							ingresoC.txtnombreC.setText("");
							ingresoC.txtapellido.setText("");
							ingresoC.txtcedula.setText("");
							TablaTelefonoContacto nueva = new TablaTelefonoContacto();
							ingresoC.tableTel.setModel(nueva);
							ingresoC.tableTel.updateUI();
							ingresoC.listaTel = new ArrayList<>();
							
						}
					}
				}
			}
			if("c".equals(variable)){
				boolean controlCon;
				controlCon = ValidarConenido();
				if (controlCon) {
					JOptionPane.showMessageDialog(null, "faltan campos de llenar");
				}else{
					ContactoProveedor cPro = new ContactoProveedor(nombre, apellido, cedula);
					cPro.setLista(ingresoC.listaTel);
					boolean verdad = ValidarCedula(cedula);
					if (verdad) {
						JOptionPane.showMessageDialog(null, "Cedula ya se encuentra registrada");
					}else{
						boolean cerca = false;
						if (modificarP.listaConPro.size()>0) {
							for (int i = 0; i < modificarP.listaConPro.size(); i++) {
								if (modificarP.listaConPro.get(i).cedula.equals(cedula)) {
									cerca = true;
								}else{
									cerca = false;
								}
							}
						}
						if (cerca) {
							JOptionPane.showMessageDialog(null, "Cedula ya se encuentra registrada");
						}else{
							modificarP.listaConPro.add(cPro);
							TablaEditarContacto modeloC = new TablaEditarContacto(modificarP.listaConPro);
							modificarP.tableConEd.removeAll();
							modificarP.tableConEd.setModel(modeloC);
							modificarP.tableConEd.updateUI();
							ingresoC.txtnombreC.setText("");
							ingresoC.txtapellido.setText("");
							ingresoC.txtcedula.setText("");
							ingresoC.tableTel.removeAll();
							ingresoC.tableTel.updateUI();
							ingresoC.listaTel = new ArrayList<>();
						}	
					}
				}
			}
		}
		if (control == ingresoC.registrarCon) {
			VentanaNuevoTelefono venTel = new VentanaNuevoTelefono(ingresoC.controlNT);
			venTel.setVisible(true);
		}
	}
	boolean ValidarConenido(){
		boolean validador = true;
		nombre = ingresoC.txtnombreC.getText();
		apellido = ingresoC.txtapellido.getText();
		cedula = ingresoC.txtcedula.getText();
		if ("".equals(nombre)||"".equals(apellido)||"".equals(cedula)||cedula.length()<10) {
			validador = true;
		}else{
			validador = false;
		}
		return validador;
	}
	boolean ValidarCedula(String cedula){
		boolean validador = true;
		ContactoProveedor cp = new ContactoProveedor();
		validador = cp.verificarContacto(cedula);
		return validador;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		Object control = e.getSource();
		if (control ==  ingresoC.txtcedula) {
			if (limite == ingresoC.txtcedula.getText().length()){
			     e.consume();
			}
			char caracter = e.getKeyChar();
			if(Character.isDigit(caracter)){
			}else{
				e.consume();
			}
		}
		if (control == ingresoC.txtnombreC || control == ingresoC.txtapellido) {
			char caracter = e.getKeyChar();
			if(Character.isLetter(caracter)){
			}else{
				e.consume();
			}
		}
	}
}
