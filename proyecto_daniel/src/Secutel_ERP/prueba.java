package Secutel_ERP;

//import java.util.ArrayList;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Proveedor pro = new Proveedor();
		/*ArrayList<String> lista = new ArrayList<>();
		lista = pro.listaProveedores();
		System.out.println(lista.size());
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}*/
		/*String nombre = "daniel";
		pro = pro.obtenerProveedor(nombre);
		System.out.println(pro.getNombre());
		System.out.println(pro.getRuc());
		System.out.println(pro.getDireccion());
		System.out.println(pro.getDescripcion());*/
		ConectBase base = new ConectBase();
		base.conectar();
	}

}
