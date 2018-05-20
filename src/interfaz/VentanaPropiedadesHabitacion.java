package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;

public class VentanaPropiedadesHabitacion extends JFrame {

	private JPanel contentPane;

	public VentanaPropiedadesHabitacion() {
		setBounds(100, 100, 269, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHabitacion = new JLabel("Habitacion: ");
		lblHabitacion.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblHabitacion.setBounds(10, 11, 233, 20);
		contentPane.add(lblHabitacion);
		
		JLabel lblTemporada = new JLabel("Temporada:");
		lblTemporada.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblTemporada.setBounds(10, 36, 233, 20);
		contentPane.add(lblTemporada);
		
		JLabel lblTarifa = new JLabel("Tarifa:");
		lblTarifa.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblTarifa.setBounds(10, 61, 233, 20);
		contentPane.add(lblTarifa);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblEstado.setBounds(10, 86, 233, 20);
		contentPane.add(lblEstado);
		
		JLabel lblCamas = new JLabel("Camas:");
		lblCamas.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblCamas.setBounds(10, 111, 233, 20);
		contentPane.add(lblCamas);
		
		JLabel lblDetalles = new JLabel("Detalles:");
		lblDetalles.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblDetalles.setBounds(10, 136, 233, 20);
		contentPane.add(lblDetalles);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Verdana", Font.PLAIN, 15));
		textArea.setBounds(10, 161, 233, 114);
		contentPane.add(textArea);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnAtras.setBounds(10, 286, 106, 23);
		contentPane.add(btnAtras);
		
		JButton btnAgregar = new JButton("Ocupar");
		btnAgregar.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnAgregar.setBounds(137, 286, 106, 23);
		contentPane.add(btnAgregar);
	}
}
