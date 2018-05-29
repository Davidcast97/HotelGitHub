package interfaz.Reservas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.toedter.components.JSpinField;

import interfaz.Principal.VentanaRecepcionista;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JLocaleChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistroPersonal extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtHora;
	private JTextField txtNombre;
	private JTextField txtIdentificacion;
	private JTextField txtTelefono;
	private JTextField txtNacionalidad;
	private JTextField txtCiudad;
	private JTextField txtOcupacion;
	private JTextField txtCorreo;
	private JButton btnGuardar;
	private JButton btnAgregar;
	private JButton btnCancelar;
	private VentanaRecepcionista miVentanaRecepcionista;
	
	public VentanaRegistroPersonal(VentanaRecepcionista miVentanaRecepcionista) {
		this.miVentanaRecepcionista = miVentanaRecepcionista;
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setFont(new Font("Verdana", Font.BOLD, 12));
		lblRegistro.setBounds(10, 11, 414, 14);
		contentPane.add(lblRegistro);
		
		JLabel lblFechaSalida = new JLabel("Fecha de Salida");
		lblFechaSalida.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblFechaSalida.setBounds(10, 36, 124, 20);
		contentPane.add(lblFechaSalida);
		
		JLabel lblHoraDeIngreso = new JLabel("Hora de Salida");
		lblHoraDeIngreso.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblHoraDeIngreso.setBounds(223, 36, 111, 20);
		contentPane.add(lblHoraDeIngreso);
		
		JLabel lblTitular = new JLabel("Titular:");
		lblTitular.setFont(new Font("Verdana", Font.BOLD, 11));
		lblTitular.setBounds(10, 67, 60, 20);
		contentPane.add(lblTitular);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNombre.setBounds(10, 92, 60, 20);
		contentPane.add(lblNombre);
		
		JLabel lblIdentificacion = new JLabel("Identificaci\u00F3n:");
		lblIdentificacion.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblIdentificacion.setBounds(10, 113, 97, 20);
		contentPane.add(lblIdentificacion);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblFechaDeNacimiento.setBounds(10, 155, 139, 20);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblTelefono.setBounds(223, 92, 66, 20);
		contentPane.add(lblTelefono);
		
		JLabel lblCiudadDeOrigen = new JLabel("Ciudad de origen:");
		lblCiudadDeOrigen.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblCiudadDeOrigen.setBounds(10, 134, 124, 20);
		contentPane.add(lblCiudadDeOrigen);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNacionalidad.setBounds(223, 113, 93, 20);
		contentPane.add(lblNacionalidad);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electronico:");
		lblCorreoElectronico.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblCorreoElectronico.setBounds(10, 176, 135, 20);
		contentPane.add(lblCorreoElectronico);
		
		JLabel lblOcupacion = new JLabel("Ocupaci\u00F3n:");
		lblOcupacion.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblOcupacion.setBounds(223, 134, 93, 20);
		contentPane.add(lblOcupacion);
		
		JDateChooser dateSalida = new JDateChooser();
		dateSalida.setBounds(127, 36, 93, 20);
		contentPane.add(dateSalida);
		
		JDateChooser dateNacimiento = new JDateChooser();
		dateNacimiento.setBounds(152, 155, 93, 20);
		contentPane.add(dateNacimiento);
		
		txtHora = new JTextField();
		txtHora.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtHora.setBounds(329, 36, 95, 20);
		contentPane.add(txtHora);
		txtHora.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtNombre.setBounds(127, 92, 93, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtIdentificacion.setBounds(127, 113, 93, 20);
		contentPane.add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtTelefono.setBounds(321, 92, 103, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtNacionalidad.setBounds(321, 113, 103, 20);
		contentPane.add(txtNacionalidad);
		txtNacionalidad.setColumns(10);
		
		txtCiudad = new JTextField();
		txtCiudad.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtCiudad.setBounds(127, 134, 93, 20);
		contentPane.add(txtCiudad);
		txtCiudad.setColumns(10);
		
		txtOcupacion = new JTextField();
		txtOcupacion.setBounds(321, 134, 103, 20);
		contentPane.add(txtOcupacion);
		txtOcupacion.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtCorreo.setBounds(152, 176, 272, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnGuardar.setBounds(324, 230, 100, 20);
		contentPane.add(btnGuardar);
		
		btnAgregar = new JButton(" Agregar acompa\u00F1antes");
		btnAgregar.addActionListener(this);
		btnAgregar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnAgregar.setBounds(122, 230, 189, 20);
		contentPane.add(btnAgregar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCancelar.setBounds(8, 230, 100, 20);
		contentPane.add(btnCancelar);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCancelar) {
			this.setVisible(false);
		}
		if(e.getSource() == btnAgregar) {
			VentanaAgregarAcompanantes ventana = new VentanaAgregarAcompanantes(this);
			ventana.setVisible(true);
		}
		if(e.getSource() == btnGuardar) {
			//verificar;
			VentanaHabitaciones ventana = new VentanaHabitaciones();
			ventana.setVisible(true);
		}
	}
}