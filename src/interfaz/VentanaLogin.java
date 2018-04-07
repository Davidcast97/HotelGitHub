package interfaz;

import java.awt.Color;
import java.awt.Event;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder; ;
public class VentanaLogin {
	
	
	private JPanel panel;
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin window = new VentanaLogin();
					window.panel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the panel.
	 */
	public VentanaLogin() {
		System.out.println("dkfdskl");
		panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(100, 100, 330, 535);
		panel.setLayout(null);
	}

}
