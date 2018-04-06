package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VEntrega {

	private JFrame frame;
	private VentanaTienda VProd;
	private JLabel lblEntrega;
	private JTextField txtEntrega;
	private JLabel lblRecibe;
	private JTextField txtRecibe;
	private JLabel lblD;
	private JLabel lblDinero;
	private JButton btnEntregar;

	/**
	 * Create the application.
	 */
	public VEntrega(VentanaTienda VP) {
		VProd = VP;
		frame = new JFrame();
		frame.setBounds(100, 100, 230, 280);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 64, 46, 14);
		frame.getContentPane().add(lblFecha);
		
		JLabel label = new JLabel("");
		label.setBounds(74, 64, 130, 14);
		frame.getContentPane().add(label);
		
		lblEntrega = new JLabel("Entrega:");
		lblEntrega.setBounds(10, 100, 46, 14);
		frame.getContentPane().add(lblEntrega);
		
		txtEntrega = new JTextField();
		txtEntrega.setBounds(74, 97, 130, 20);
		frame.getContentPane().add(txtEntrega);
		txtEntrega.setColumns(10);
		
		lblRecibe = new JLabel("Recibe: ");
		lblRecibe.setBounds(10, 134, 46, 14);
		frame.getContentPane().add(lblRecibe);
		
		txtRecibe = new JTextField();
		txtRecibe.setBounds(74, 131, 130, 20);
		frame.getContentPane().add(txtRecibe);
		txtRecibe.setColumns(10);
		
		lblD = new JLabel("Dinero:");
		lblD.setBounds(10, 169, 46, 14);
		frame.getContentPane().add(lblD);
		
		lblDinero = new JLabel("");
		lblDinero.setBounds(74, 169, 130, 14);
		frame.getContentPane().add(lblDinero);
		
		btnEntregar = new JButton("Entregar");
		btnEntregar.setBounds(74, 208, 89, 23);
		frame.getContentPane().add(btnEntregar);
		frame.setVisible(true);
	}

}
