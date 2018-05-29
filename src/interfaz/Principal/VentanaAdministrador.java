package interfaz.Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import logica.Hotel;

public class VentanaAdministrador extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Hotel hotel2;
	private JButton btnBalance, btnModificarRecepcionista, btnListarRecepcionistas,
			btnModificarTienda, btnCrearRecepcionista;
	private JTextArea textArea;

	public VentanaAdministrador() {
		hotel2 =new Hotel();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 603, 405);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCrearAdminitrador = new JLabel("Ventana Administrador");
		lblCrearAdminitrador.setForeground(Color.BLACK);
		lblCrearAdminitrador.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 14));
		lblCrearAdminitrador.setBounds(67, 11, 183, 26);
		contentPane.add(lblCrearAdminitrador);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textArea.setForeground(Color.BLACK);
		textArea.setBackground(new Color(0, 0, 0, 0));
		textArea.setBounds(149, 59, 386, 221);
		textArea.setOpaque(false);
		contentPane.add(textArea);
		
		
		btnCrearRecepcionista = new JButton("Crear Recepcionista");
		btnCrearRecepcionista.setBounds(10, 84, 129, 23);
		btnCrearRecepcionista.addActionListener(this);
		contentPane.add(btnCrearRecepcionista);

		btnModificarTienda = new JButton("Modificar Tienda");
		btnModificarTienda.setBounds(10, 183, 129, 23);
		btnModificarTienda.addActionListener(this);
		contentPane.add(btnModificarTienda);

		btnListarRecepcionistas = new JButton("Listar Recepcionistas");
		btnListarRecepcionistas.setBounds(10, 115, 129, 23);
		btnListarRecepcionistas.addActionListener(this);
		contentPane.add(btnListarRecepcionistas);

		btnModificarRecepcionista = new JButton("Eliminar Recepcionista");
		btnModificarRecepcionista.setBounds(10, 149, 129, 23);
		btnModificarRecepcionista.addActionListener(this);
		contentPane.add(btnModificarRecepcionista);

		btnBalance = new JButton("Balance");
		btnBalance.setBounds(10, 217, 89, 23);
		btnBalance.addActionListener(this);
		contentPane.add(btnBalance);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnListarRecepcionistas)) {
			String lista = hotel2.listarRecepcionistas();
			textArea.setText(lista);
		}if(e.getSource().equals(btnCrearRecepcionista)) {
			VentanaCrearRecepcionista VCR= new VentanaCrearRecepcionista();
			VCR.setVisible(true);
		}if(e.getSource().equals(btnModificarRecepcionista)) {
			String login =JOptionPane.showInputDialog(null, "Para eliminar recepcionista Ingrese el Login:");
			if(hotel2.existe(login)) {
				hotel2.eliminarRecepcionista(login);
			}else {
				JOptionPane.showMessageDialog(null, "Recepcionista no exste");
			}
			
		}

	}
}
