package Vista;

import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Persistencia.Conexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

@SuppressWarnings("serial")
public class Pantalla_Reporte_IngSal_Producto extends JFrame{
	
	public ImageIcon ico_aplicacion;
	Conexion conexion = new Conexion();
	InputStream rutaJasperKardex;
	JasperReport reporteKardex;
	JasperPrint imprimirKardex;
	JRViewer vistaReporteKardex;
	public JPanel pnl_vistaReporte;
	
	public Pantalla_Reporte_IngSal_Producto (){
		
		super("Reporte");
		setVisible(true);
		setSize(900, 400);
		setLocation(200, 100);
		setResizable(false);
		
		ico_aplicacion = new ImageIcon("src/Imagenes/icono.gif");
		setIconImage(ico_aplicacion.getImage());
		
		pnl_vistaReporte = new JPanel();
		pnl_vistaReporte.setBorder(new TitledBorder("Ingresos y Egresos"));
		pnl_vistaReporte.removeAll();
		pnl_vistaReporte.setLayout(new BorderLayout());
		
		conexion = new Conexion();			
		try {
			rutaJasperKardex = new FileInputStream("C:/Users/MCEVALLOS/Documents/GitHub/SECUTEL_ERP/Secutel-ERP/Modulo_Inventario/Modulo_Inventario/src/Reportes/ReportMinMax.jasper");				
			reporteKardex = (JasperReport) JRLoader.loadObject(rutaJasperKardex);
			imprimirKardex = JasperFillManager. fillReport(reporteKardex, new HashMap<String, Object>(), conexion.getConexion());
		
			vistaReporteKardex = new JRViewer(imprimirKardex);       
			pnl_vistaReporte.add(vistaReporteKardex);
			vistaReporteKardex.setVisible(true);
			pnl_vistaReporte.repaint();
			pnl_vistaReporte.revalidate();
			JasperExportManager.exportReportToPdfFile(imprimirKardex,"Ingresos y Egresos.pdf");
		conexion.cerrar();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		getContentPane().add(pnl_vistaReporte, BorderLayout.CENTER);
	
		
	}

}
