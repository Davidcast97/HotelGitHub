package logica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JLocaleChooser;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaRegistroPersonal extends JFrame {

	private JPanel contentPane;
	private JTextField txtHilos;
	private JTextField txtNombre;
	private JTextField txtIdentificacion;
	private JTextField txtTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistroPersonal frame = new VentanaRegistroPersonal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistroPersonal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setBounds(187, 11, 46, 14);
		contentPane.add(lblRegistro);
		
		JLabel lblCheckIn = new JLabel("Fecha de Ingreso");
		lblCheckIn.setBounds(10, 36, 100, 20);
		contentPane.add(lblCheckIn);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(116, 36, 81, 20);
		contentPane.add(dateChooser);
		
		JLabel lblHoraDeIngreso = new JLabel("Hora de Ingreso");
		lblHoraDeIngreso.setBounds(10, 67, 100, 14);
		contentPane.add(lblHoraDeIngreso);
		
		txtHilos = new JTextField();
		txtHilos.setText("hilos??");
		txtHilos.setBounds(116, 64, 86, 20);
		contentPane.add(txtHilos);
		txtHilos.setColumns(10);
		
		JLabel lblTitular = new JLabel("Titular:");
		lblTitular.setBounds(10, 92, 46, 14);
		contentPane.add(lblTitular);
		
		JLabel lblNombre = new JLabel("nombre");
		lblNombre.setBounds(10, 117, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblIdentificacion = new JLabel("identificacion");
		lblIdentificacion.setBounds(10, 142, 46, 14);
		contentPane.add(lblIdentificacion);
		
		JLabel lblFechaDeNacimiento = new JLabel("fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(10, 167, 46, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblTelefono = new JLabel("telefono");
		lblTelefono.setBounds(10, 192, 46, 14);
		contentPane.add(lblTelefono);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(335, 227, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnAgregar = new JButton(" Agregar acompa\u00F1antes");
		btnAgregar.setBounds(167, 227, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 227, 89, 23);
		contentPane.add(btnCancelar);
		
		txtNombre = new JTextField();
		txtNombre.setText("nombre");
		txtNombre.setBounds(111, 114, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setText("Identifiacion");
		txtIdentificacion.setBounds(111, 139, 86, 20);
		contentPane.add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(116, 167, 81, 20);
		contentPane.add(dateChooser_1);
		
		txtTelefono = new JTextField();
		txtTelefono.setText("telefono");
		txtTelefono.setBounds(116, 198, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
	}
}
