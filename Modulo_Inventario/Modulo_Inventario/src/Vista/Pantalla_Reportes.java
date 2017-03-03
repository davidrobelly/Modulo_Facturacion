package Vista;

import java.awt.BorderLayout; 
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

@SuppressWarnings("serial")
public class Pantalla_Reportes extends JFrame implements ActionListener{
	
	public ImageIcon ico_aplicacion;
	public JLabel lbl_reporte1, lbl_reporte2, lbl_reporte3, lbl_reporte4;
	public JButton btn_generarReporte1, btn_generarReporte2, btn_generarReporte3, btn_generarReporte4;
	public JPanel pnl_reportes, pnl_vistaReporte;
	
	InputStream rutaJasperContarProducto, rutaJasperProductoCategoria, rutaJasperMinMax, rutaJasperKardex;
	JasperReport reporteContarProducto, reporteProductoCategoria, reporteMinMax, reporteKardex;
	JasperPrint imprimirContarProducto, imprimirProductoCategoria, imprimirMinMax, imprimirKardex;
	JRViewer vistaReporteContarProducto, vistaReporteProductoCategoria, vistaReporteMinMax, vistaReporteKardex;
	
	Pantalla_Reportes(){
		
		super("Reportes");
		setVisible(true);
		setSize(400, 300);
		setLocation(50, 100);
		setResizable(false);

		pnl_reportes = new JPanel();
		pnl_reportes.setBorder(new TitledBorder("Escoja que reporte desea generar"));
		
		GridBagLayout gridCentral = new GridBagLayout();
		pnl_reportes.setLayout(gridCentral);
		
		GridBagConstraints gridConCentral = new GridBagConstraints();
		gridConCentral.fill = GridBagConstraints.BOTH;
		gridConCentral.insets = new Insets(3, 3, 3, 3);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 0;
		gridConCentral.gridheight = 1;
		gridConCentral.gridwidth = 1;
		lbl_reporte1 = new JLabel("Reporte - Minimos y Maximos de Productos");
		pnl_reportes.add(lbl_reporte1);
		gridCentral.setConstraints(lbl_reporte1, gridConCentral);
	
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 0;
		btn_generarReporte1 = new JButton(new ImageIcon("src/Imagenes/generarReporte.jpeg"));
		btn_generarReporte1.setBorder(null);
		btn_generarReporte1.addActionListener(this);
		pnl_reportes.add(btn_generarReporte1);
		gridCentral.setConstraints(btn_generarReporte1, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 1;
		lbl_reporte2 = new JLabel("Reporte - Productos por Categoria");
		pnl_reportes.add(lbl_reporte2);
		gridCentral.setConstraints(lbl_reporte2, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 1;
		btn_generarReporte2 = new JButton(new ImageIcon("src/Imagenes/generarReporte.jpeg"));
		btn_generarReporte2.setBorder(null);
		btn_generarReporte2.addActionListener(this);
		pnl_reportes.add(btn_generarReporte2);
		gridCentral.setConstraints(btn_generarReporte2, gridConCentral);
		
		gridConCentral.gridx = 0;
		gridConCentral.gridy = 2;
		lbl_reporte3 = new JLabel("Reporte - Contar Productos");
		pnl_reportes.add(lbl_reporte3);
		gridCentral.setConstraints(lbl_reporte3, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 2;
		btn_generarReporte3 = new JButton(new ImageIcon("src/Imagenes/generarReporte.jpeg"));
		btn_generarReporte3.setBorder(null);
		btn_generarReporte3.addActionListener(this);
		pnl_reportes.add(btn_generarReporte3);
		gridCentral.setConstraints(btn_generarReporte3, gridConCentral);

		gridConCentral.gridx = 0;
		gridConCentral.gridy = 3;
		lbl_reporte4 = new JLabel("Reporte - Ingresos y Salidas de Productos");
		pnl_reportes.add(lbl_reporte4);
		gridCentral.setConstraints(lbl_reporte4, gridConCentral);
		
		gridConCentral.gridx = 1;
		gridConCentral.gridy = 3;
		btn_generarReporte4 = new JButton(new ImageIcon("src/Imagenes/generarReporte.jpeg"));
		btn_generarReporte4.setBorder(null);
		btn_generarReporte4.addActionListener(this);
		pnl_reportes.add(btn_generarReporte4);
		gridCentral.setConstraints(btn_generarReporte4, gridConCentral);
		
		getContentPane().add(pnl_reportes, BorderLayout.CENTER);
		
		((JComponent)getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	
	}

	
	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getSource() == btn_generarReporte1){
			
			Pantalla_Reporte_MinMax minMax = new Pantalla_Reporte_MinMax();
			minMax.setVisible(true);

		}
		
		if(evento.getSource() == btn_generarReporte2){
			
			Pantalla_Reporte_Producto_Categoria categoria = new Pantalla_Reporte_Producto_Categoria();
			categoria.setVisible(true);
		
		}
		
		if(evento.getSource() == btn_generarReporte3){
					
			Pantalla_Reporte_Producto producto = new Pantalla_Reporte_Producto();
			producto.setVisible(true);
	    }
		
		if(evento.getSource() == btn_generarReporte4){
			
			Pantalla_Reporte_IngSal_Producto ingSal = new Pantalla_Reporte_IngSal_Producto();
			ingSal.setVisible(true);
			
	
		}
	}
	

}
