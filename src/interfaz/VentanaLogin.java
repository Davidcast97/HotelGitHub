package interfaz;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.UIManager;;

public class VentanaLogin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JTextField Usuario;
	private JTextField Contraseņa;
	private JButton btnIngresar;
	private JLabel lblIncorrecto;
	private JButton btnSalir;

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
		Container contentpane = getContentPane();
		getContentPane().setLayout(null);

		JLabel TxtUsuario = new JLabel("Usuario :");
		TxtUsuario.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 15));
		TxtUsuario.setForeground(Color.WHITE);
		TxtUsuario.setBounds(140, 35, 70, 56);
		getContentPane().add(TxtUsuario);

		Usuario = new JTextField();
		Usuario.setBackground(UIManager.getColor("Button.darkShadow"));
		Usuario.setForeground(Color.BLACK);
		Usuario.setColumns(10);
		Usuario.setBounds(233, 55, 105, 20);
		getContentPane().add(Usuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 15));
		lblContrasea.setBounds(107, 80, 118, 56);
		getContentPane().add(lblContrasea);

		Contraseņa = new JTextField();
		Contraseņa.setBackground(UIManager.getColor("Button.darkShadow"));
		Contraseņa.setForeground(Color.BLACK);
		Contraseņa.setColumns(10);
		Contraseņa.setBounds(233, 100, 105, 20);
		getContentPane().add(Contraseņa);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 15));
		btnIngresar.setBounds(344, 184, 109, 23);
		btnIngresar.addActionListener(this);
		getContentPane().add(btnIngresar);

		lblIncorrecto = new JLabel();
		lblIncorrecto.setForeground(Color.WHITE);
		lblIncorrecto.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 15));
		lblIncorrecto.setBounds(145, 117, 263, 56);
		getContentPane().add(lblIncorrecto);

		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 15));
		btnSalir.setBounds(58, 186, 109, 23);
		btnSalir.addActionListener(this);
		getContentPane().add(btnSalir);

		JLabel lblFondo = new JLabel("");
		lblFondo.setForeground(Color.WHITE);
		lblFondo.setIcon(new ImageIcon(
				new File (".").getAbsolutePath ()+"\\src\\imagenes\\1.2.jpg"));//	"C:\\Users\\deivi\\Documents\\workspace\\HotelGitHub\\HotelGitHub\\bin\\imagenes\\1.2.jpg"
		

		System.out.println (new File ("").getAbsolutePath ()+"\\src\\imagenes\\1.2.jpg");

		lblFondo.setBounds(0, 0, 490, 278);
		contentpane.add(lblFondo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnIngresar)) {
			System.out.println(Usuario.getText());
			if (Usuario.getText().equals("Admin") && Contraseņa.getText().equals("123")) {
				setVisible(false);
				VentanaAdmin window = new VentanaAdmin();
				window.setVisible(true);
				lblIncorrecto.setText("Entro");
			} else {
				lblIncorrecto.setText("Usuario o Contraseņa Incorrecta");
			}
		}
		if (e.getSource().equals(btnSalir)) {
			System.exit(0);
			
		}
	}
}
