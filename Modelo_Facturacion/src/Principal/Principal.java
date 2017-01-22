package Principal;
import DBClases.ConexionDB;
import modelo_clases.cliente;
import pantallas.ventana_ingreso_clientes;

public class Principal {

	public static void main(String[] args) {
		
//		ConexionDB conectar = new ConexionDB();
//		conectar.conectar();
		
		//cliente cliente1 = new cliente("David Robelly", "0919676320", "0968946875", 
		//		"daverobe@espol.edu.ec", "Gral. Vernaza entre Sucre y 10 de agosto", "minorista", "1");
		//conectar.ingresarCliente(cliente1);

		
		ventana_ingreso_clientes vingreso = new ventana_ingreso_clientes();
		
	}

}
