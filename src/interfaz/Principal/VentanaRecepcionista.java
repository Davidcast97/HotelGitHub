package interfaz.Principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaz.Reservas.VentanaRegistroPersonal;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRecepcionista extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblUsuario, lblVentanaRecepcionista ;
	private JButton btnTienda;
	private JButton btnReservas;
	public VentanaRecepcionista(String usuario) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 634, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVentanaRecepcionista = new JLabel("Ventana Recepcionista");
		lblVentanaRecepcionista.setBounds(100, 11, 211, 14);
		lblVentanaRecepcionista.setForeground(Color.BLACK);
		lblVentanaRecepcionista.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 14));

		contentPane.add(lblVentanaRecepcionista);
		
		lblUsuario = new JLabel(""+usuario);
		lblUsuario.setBounds(466, 12, 46, 14);
		contentPane.add(lblUsuario);
		
		btnTienda = new JButton("Tienda");
		btnTienda.setBounds(41, 89, 89, 23);
		contentPane.add(btnTienda);
		
		btnReservas = new JButton("Reservas");
		btnReservas.addActionListener(this);
		btnReservas.setBounds(41, 122, 89, 23);
		contentPane.add(btnReservas);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnReservas) {
			VentanaRegistroPersonal ventana = new VentanaRegistroPersonal(this);
			ventana.setVisible(true);
		}
	}

}
