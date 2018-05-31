package interfaz.Reservas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import logica.Reservas.Acompanante;
import logica.Reservas.Habitacion;
import logicaAlmacenar.AlmacenarHabitacion;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPropiedadesHabitacion extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnAtras;
	private JButton btnAgregar;
	private VentanaHabitaciones ventana;
	private AlmacenarHabitacion habitaciones;
	private Habitacion miHabitacion;
	private String nombre;

	public VentanaPropiedadesHabitacion(VentanaHabitaciones ventana, String nombre) { 
		this.ventana = ventana;
		this.nombre = nombre;
		habitaciones = new AlmacenarHabitacion();
		setBounds(100, 100, 269, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		miHabitacion = habitaciones.buscarHabitacion(nombre);
		
		JLabel lblHabitacion = new JLabel("Habitaci\u00F3n: "+ miHabitacion.getNombre());
		lblHabitacion.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblHabitacion.setBounds(10, 11, 233, 20);
		contentPane.add(lblHabitacion);
		
		JLabel lblTemporada = new JLabel("Temporada:"+miHabitacion.getTarifa().getTemporada());
		lblTemporada.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblTemporada.setBounds(10, 31, 233, 20);
		contentPane.add(lblTemporada);
		
		JLabel lblTarifa = new JLabel("Tarifa:"+miHabitacion.getTarifa().getValor());
		lblTarifa.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblTarifa.setBounds(10, 51, 233, 20);
		contentPane.add(lblTarifa);
		
		JLabel lblEstado = new JLabel("Estado:"+miHabitacion.getEstado());
		lblEstado.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblEstado.setBounds(10, 71, 233, 20);
		contentPane.add(lblEstado);
		
		JLabel lblCamas = new JLabel("Camas:"+miHabitacion.getNumeroCamas());
		lblCamas.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblCamas.setBounds(10, 91, 233, 20);
		contentPane.add(lblCamas);
		
		JLabel lblDetalles = new JLabel("Detalles:");
		lblDetalles.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblDetalles.setBounds(10, 111, 233, 20);
		contentPane.add(lblDetalles);
		
		String[] arreglo = miHabitacion.getDetalles().split(",");
		String mostrar = "";
		for (int i = 0; i < arreglo.length; i++) {
			mostrar += arreglo[i]+"\n";
		}
		JTextArea textArea = new JTextArea(mostrar);
		textArea.setEditable(false);
		textArea.setFont(new Font("Verdana", Font.PLAIN, 14));
		textArea.setBounds(10, 131, 233, 87);
		//contentPane.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 131, 233, 87);
		contentPane.add(scrollPane);
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(this);
		btnAtras.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnAtras.setBounds(10, 229, 106, 23);
		contentPane.add(btnAtras);
		
		btnAgregar = new JButton("Ocupar");
		btnAgregar.addActionListener(this);
		btnAgregar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnAgregar.setBounds(137, 229, 106, 23);
		contentPane.add(btnAgregar);
	}
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == btnAtras) {
			this.setVisible(false);
		}
		if(arg0.getSource() == btnAgregar) {
			this.setVisible(false);
			int numero = Integer.parseInt(nombre);
			int i = (numero/100)-1;
			int j = (numero%100)-1;
			ventana.pintarCasilla(i, j);
			ventana.obtenerHabitaciones(miHabitacion);
		}
	}
}
