package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAgregarAcompanantes extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtIdentificacion;
	private JTextField txtTelefono;
	private JButton btnCancelar;
	private JButton btnAgregar;
	private VentanaRegistroPersonal ventana;

	public VentanaAgregarAcompanantes(VentanaRegistroPersonal ventana) {
		this.ventana = ventana;
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNombre.setBounds(89, 63, 60, 20);
		contentPane.add(lblNombre);
		
		JLabel lblIdentificacion = new JLabel("Identificaci\u00F3n:");
		lblIdentificacion.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblIdentificacion.setBounds(89, 84, 97, 20);
		contentPane.add(lblIdentificacion);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblFechaDeNacimiento.setBounds(89, 126, 139, 20);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblTelefono.setBounds(89, 105, 66, 20);
		contentPane.add(lblTelefono);
		
		JLabel lblAgregar = new JLabel("Agregar acompa\u00F1antes");
		lblAgregar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregar.setFont(new Font("Verdana", Font.BOLD, 12));
		lblAgregar.setBounds(10, 11, 414, 14);
		contentPane.add(lblAgregar);
		
		JDateChooser dateNacimiento = new JDateChooser();
		dateNacimiento.setBounds(233, 126, 103, 20);
		contentPane.add(dateNacimiento);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtNombre.setColumns(10);
		txtNombre.setBounds(233, 63, 103, 20);
		contentPane.add(txtNombre);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtIdentificacion.setColumns(10);
		txtIdentificacion.setBounds(233, 84, 103, 20);
		contentPane.add(txtIdentificacion);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(233, 105, 103, 20);
		contentPane.add(txtTelefono);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCancelar.setBounds(10, 230, 139, 20);
		contentPane.add(btnCancelar);
		
		btnAgregar = new JButton(" Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnAgregar.setBounds(285, 230, 139, 20);
		contentPane.add(btnAgregar);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCancelar) {
			this.setVisible(false);
		}
		if(e.getSource() == btnAgregar) {
			
		}
	}
}
