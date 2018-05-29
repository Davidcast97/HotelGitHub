package interfaz.Principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logica.Administrador;
import logica.Hotel;
import logica.Recepcionista;

public class VentanaCrearRecepcionista extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtCedula, txtNombre, txtTelefono;
	private JLabel lblContrasena;
	private JTextField txtContrasena;
	private JTextField txtLogin;
	private Hotel hotel2;
	private JButton btnGuargar;

	public VentanaCrearRecepcionista() {
		this.hotel2 = hotel2;
		hotel2 = new Hotel();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 334, 310);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 14));
		lblNombre.setBounds(50, 58, 95, 26);
		contentPane.add(lblNombre);

		JLabel lblCedula = new JLabel("Cedula :");
		lblCedula.setForeground(Color.BLACK);
		lblCedula.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 14));
		lblCedula.setBounds(50, 83, 95, 26);
		contentPane.add(lblCedula);

		JLabel lblTelefono = new JLabel("Telefono :");
		lblTelefono.setForeground(Color.BLACK);
		lblTelefono.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 14));
		lblTelefono.setBounds(50, 106, 95, 26);
		contentPane.add(lblTelefono);

		lblContrasena = new JLabel("Contrase\u00F1a :");
		lblContrasena.setForeground(Color.BLACK);
		lblContrasena.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 14));
		lblContrasena.setBounds(50, 152, 95, 26);
		contentPane.add(lblContrasena);

		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 14));
		lblLogin.setBounds(50, 130, 95, 26);
		contentPane.add(lblLogin);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 14));
		txtNombre.setBounds(155, 62, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtCedula = new JTextField();
		txtCedula.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 14));
		txtCedula.setColumns(10);
		txtCedula.setBounds(155, 87, 86, 20);
		contentPane.add(txtCedula);

		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 14));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(155, 110, 86, 20);
		contentPane.add(txtTelefono);

		txtContrasena = new JTextField();
		txtContrasena.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 14));
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(155, 156, 86, 20);
		contentPane.add(txtContrasena);

		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 14));
		txtLogin.setColumns(10);
		txtLogin.setBounds(155, 134, 86, 20);
		contentPane.add(txtLogin);

		JLabel lblCrearAdminitrador = new JLabel("Crear Recepcionista");
		lblCrearAdminitrador.setForeground(Color.BLACK);
		lblCrearAdminitrador.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 14));
		lblCrearAdminitrador.setBounds(113, 11, 166, 26);
		contentPane.add(lblCrearAdminitrador);

		btnGuargar = new JButton("Guargar");
		btnGuargar.setBounds(50, 189, 89, 23);
		contentPane.add(btnGuargar);
		btnGuargar.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnGuargar)) {
			if (!(txtNombre.getText().length() == 0 || txtCedula.getText().length() == 0
					|| txtContrasena.getText().length() == 0 || txtTelefono.getText().length() == 0
					|| txtLogin.getText().length() == 0)) {
				if ((hotel2.existe(txtLogin.getText()))) {
					JOptionPane.showMessageDialog(null, "Usuario Existente");
				} else {

					Recepcionista miRecep = new Recepcionista(txtNombre.getText(), txtCedula.getText(),
							txtTelefono.getText(), txtLogin.getText(), txtContrasena.getText());
					hotel2.crearRecepcionistas(miRecep);
					JOptionPane.showMessageDialog(null, "Recepcionista Creado");
				}
			}
		}

	}
}
