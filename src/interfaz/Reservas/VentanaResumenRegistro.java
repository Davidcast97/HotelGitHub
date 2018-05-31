package interfaz.Reservas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Reservas.RegistroPersonal;
import logica.Reservas.Reserva;
import logicaAlmacenar.AlmacenarReserva;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaResumenRegistro extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnAceptar;
	private JButton btnAgregarDeposito;
	private JButton btnCancelarRegistro;
	private JButton btnModificar;
	private JButton btnDescuentos;
	private VentanaHabitaciones ventana;
	private RegistroPersonal miRegistro;

	public VentanaResumenRegistro(VentanaHabitaciones ventana,RegistroPersonal miRegistro) {
		this.ventana = ventana;
		this.miRegistro = miRegistro;
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
		
		JLabel lblNombreTitular = new JLabel("Nombre titular:"+miRegistro.getMiPersonaTitular().getNombre());
		lblNombreTitular.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNombreTitular.setBounds(10, 52, 414, 20);
		contentPane.add(lblNombreTitular);
		
		JLabel lblCc = new JLabel("Identificaci\u00F3n:"+miRegistro.getMiPersonaTitular().getIdentificacion());
		lblCc.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblCc.setBounds(10, 83, 184, 20);
		contentPane.add(lblCc);
		
		int contador = 0;
		for (int i = 0; i < miRegistro.getMiPersonaTitular().getMisAcompanantes().size(); i++) {
			contador ++;
		}
		
		JLabel lblNumeroDeAcompaantes = new JLabel("N\u00FAmero de acompa\u00F1antes:"+contador);
		lblNumeroDeAcompaantes.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNumeroDeAcompaantes.setBounds(204, 83, 166, 20);
		contentPane.add(lblNumeroDeAcompaantes);
		
		String Habitaciones = "";
		double valor = 0;
		for (int i = 0; i < miRegistro.getMisHabitaciones().size(); i++) {
			Habitaciones += miRegistro.getMisHabitaciones().get(i).getNombre() + ",";
			valor += miRegistro.getMisHabitaciones().get(i).getTarifa().getValor();
		}
		Habitaciones = Habitaciones.substring(0, Habitaciones.length()-1);
		JLabel lblHabitaciones = new JLabel("Habitaciones:"+ Habitaciones);
		lblHabitaciones.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblHabitaciones.setBounds(10, 114, 271, 20);
		contentPane.add(lblHabitaciones);
		
		JLabel lblFacturar = new JLabel("Facturar:"+valor);
		lblFacturar.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblFacturar.setBounds(10, 145, 184, 20);
		contentPane.add(lblFacturar);
		
		JLabel lblDeposito = new JLabel("Deposito:");
		lblDeposito.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblDeposito.setBounds(222, 145, 159, 20);
		contentPane.add(lblDeposito);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
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
		JOptionPane.showMessageDialog(null, "agregado");
		this.setVisible(false);
	}
}
