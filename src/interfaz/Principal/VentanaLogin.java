package interfaz.Principal;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;

import interfaz.Diseno;
import logica.Hotel;;

public class VentanaLogin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JTextField Usuario;
	private JTextField Contrasena;
	private JButton btnIngresar;
	private JLabel lblIncorrecto;
	private JButton btnSalir;
	private Hotel hotel;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin window = new VentanaLogin();
					window.setVisible(true);
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

		setUndecorated(true);
		setBounds(100, 100, 490, 278);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		Diseno d = new Diseno(this);
		hotel = new Hotel();

		JLabel TxtUsuario = new JLabel("Usuario :");
		TxtUsuario.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 15));
		TxtUsuario.setForeground(new Color(0, 0, 0));
		TxtUsuario.setBounds(140, 35, 70, 56);
		getContentPane().add(TxtUsuario);

		Usuario = new JTextField();
		Usuario.setBackground(UIManager.getColor("Button.darkShadow"));
		Usuario.setForeground(Color.BLACK);
		Usuario.setColumns(10);
		Usuario.setBounds(233, 55, 105, 20);
		getContentPane().add(Usuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
		lblContrasea.setForeground(new Color(0, 0, 0));
		lblContrasea.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 15));
		lblContrasea.setBounds(107, 80, 118, 56);
		getContentPane().add(lblContrasea);

		Contrasena = new JPasswordField();
		Contrasena.setBackground(UIManager.getColor("Button.darkShadow"));
		Contrasena.setForeground(Color.BLACK);
		Contrasena.setColumns(10);
		Contrasena.setBounds(233, 100, 105, 20);
		getContentPane().add(Contrasena);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 15));
		btnIngresar.setBounds(344, 184, 109, 23);
		btnIngresar.addActionListener(this);
		getContentPane().add(btnIngresar);

		lblIncorrecto = new JLabel();
		lblIncorrecto.setForeground(Color.RED);
		lblIncorrecto.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 15));
		lblIncorrecto.setBounds(145, 117, 263, 56);
		getContentPane().add(lblIncorrecto);

		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 15));
		btnSalir.setBounds(58, 186, 109, 23);
		btnSalir.addActionListener(this);
		getContentPane().add(btnSalir);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(new File("").getAbsolutePath()+"\\src\\imagenes\\FondoSuave.jpg"));

		lblNewLabel.setBounds(0, 0, 490, 278);
		getContentPane().add(lblNewLabel);
	}

	public void actionPerformed(ActionEvent e) {
		boolean centinela = true;
		if (e.getSource().equals(btnIngresar) && Usuario.getText().length()!=0 &&Contrasena.getText().length()!=0) {
			if (Usuario.getText().equals("Admin") && Contrasena.getText().equals("123")) {
				lblIncorrecto.setText("");
				VentanaCrearAdministrador window = new VentanaCrearAdministrador(hotel);
				window.setVisible(true);
				centinela = false;
				Usuario.setText("");
				Contrasena.setText("");
				
			}
			if (hotel.comprobarEmpleado(Usuario.getText(), Contrasena.getText())) {
				lblIncorrecto.setText("");
				if (hotel.comprobarAdministrador(Usuario.getText())) {
					VentanaAdministrador window = new VentanaAdministrador();
					window.setVisible(true);
				} else {
					VentanaRecepcionista window = new VentanaRecepcionista(Usuario.getText());
					window.setVisible(true);
				}
				centinela = false;
				Usuario.setText("");
				Contrasena.setText("");
			} else if (centinela) {
				lblIncorrecto.setText("Usuario o Contrase�a Incorrecta");
			}

		}
		if (e.getSource().equals(btnSalir)) {
			System.exit(0);

		}
	}

	public JTextField getUsuario() {
		return Usuario;
	}

	public void setUsuario(JTextField usuario) {
		Usuario = usuario;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
}
