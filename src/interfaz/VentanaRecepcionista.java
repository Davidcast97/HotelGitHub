package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class VentanaRecepcionista extends JFrame {

	private JPanel contentPane;
	private JLabel lblUsuario, lblVentanaRecepcionista ;
	public VentanaRecepcionista(String usuario) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 634, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVentanaRecepcionista = new JLabel("Ventana Recepcionista");
		lblVentanaRecepcionista.setBounds(158, 11, 133, 14);
		contentPane.add(lblVentanaRecepcionista);
		
		lblUsuario = new JLabel(""+usuario);
		lblUsuario.setBounds(485, 11, 46, 14);
		contentPane.add(lblUsuario);
	}

}
