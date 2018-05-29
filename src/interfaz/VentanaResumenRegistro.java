package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaResumenRegistro extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNombreTitular;
	private JTextField txtIdentificacion;
	private JTextField txtNumeroDeacompaantes;
	private JTextField txtHabitaciones;
	private JTextField txtFacturar;
	private JTextField txtDeposito;
	private JButton btnAceptar;
	private JButton btnAgregarDeposito;
	private JButton btnCancelarRegistro;
	private JButton btnModificar;
	private JButton btnDescuentos;

	public VentanaResumenRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDetallesDeHospedaje = new JLabel("Detalles de hospedaje");
		lblDetallesDeHospedaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetallesDeHospedaje.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDetallesDeHospedaje.setBounds(10, 11, 414, 20);
		contentPane.add(lblDetallesDeHospedaje);
		
		JLabel lblNombreTitular = new JLabel("Nombre titular:");
		lblNombreTitular.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNombreTitular.setBounds(10, 52, 96, 20);
		contentPane.add(lblNombreTitular);
		
		JLabel lblCc = new JLabel("Identificaci\u00F3n:");
		lblCc.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblCc.setBounds(10, 83, 85, 20);
		contentPane.add(lblCc);
		
		JLabel lblNumeroDeAcompaantes = new JLabel("N\u00FAmero de acompa\u00F1antes:");
		lblNumeroDeAcompaantes.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNumeroDeAcompaantes.setBounds(204, 83, 166, 20);
		contentPane.add(lblNumeroDeAcompaantes);
		
		JLabel lblHabitaciones = new JLabel("Habitaciones:");
		lblHabitaciones.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblHabitaciones.setBounds(10, 114, 85, 20);
		contentPane.add(lblHabitaciones);
		
		JLabel lblFacturar = new JLabel("Facturar:");
		lblFacturar.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblFacturar.setBounds(10, 145, 59, 20);
		contentPane.add(lblFacturar);
		
		JLabel lblDeposito = new JLabel("Deposito:");
		lblDeposito.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblDeposito.setBounds(222, 145, 59, 20);
		contentPane.add(lblDeposito);

		txtNombreTitular = new JTextField();
		txtNombreTitular.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtNombreTitular.setBounds(106, 53, 318, 20);
		contentPane.add(txtNombreTitular);
		txtNombreTitular.setColumns(10);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtIdentificacion.setBounds(98, 83, 96, 20);
		contentPane.add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		txtNumeroDeacompaantes = new JTextField();
		txtNumeroDeacompaantes.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtNumeroDeacompaantes.setBounds(365, 84, 59, 20);
		contentPane.add(txtNumeroDeacompaantes);
		txtNumeroDeacompaantes.setColumns(10);
		
		txtHabitaciones = new JTextField();
		txtHabitaciones.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtHabitaciones.setBounds(89, 114, 335, 20);
		contentPane.add(txtHabitaciones);
		txtHabitaciones.setColumns(10);
		
		txtFacturar = new JTextField();
		txtFacturar.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtFacturar.setBounds(67, 145, 145, 20);
		contentPane.add(txtFacturar);
		txtFacturar.setColumns(10);
		
		txtDeposito = new JTextField();
		txtDeposito.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtDeposito.setBounds(279, 145, 145, 20);
		contentPane.add(txtDeposito);
		txtDeposito.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(317, 227, 107, 23);
		contentPane.add(btnAceptar);
		
		btnAgregarDeposito = new JButton("Agregar Deposito");
		btnAgregarDeposito.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnAgregarDeposito.addActionListener(this);
		btnAgregarDeposito.setBounds(222, 176, 159, 23);
		contentPane.add(btnAgregarDeposito);
		
		btnCancelarRegistro = new JButton("Cancelar");
		btnCancelarRegistro.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCancelarRegistro.addActionListener(this);
		btnCancelarRegistro.setBounds(10, 227, 107, 23);
		contentPane.add(btnCancelarRegistro);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(163, 227, 107, 23);
		contentPane.add(btnModificar);
		
		btnDescuentos = new JButton("Agregar Descuentos");
		btnDescuentos.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnDescuentos.addActionListener(this);
		btnDescuentos.setBounds(53, 176, 159, 23);
		contentPane.add(btnDescuentos);
	}
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
