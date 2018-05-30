package interfaz.Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Hotel;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class VentanaGastosRecepcionista extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtDescripcion;
	private JTextField txtValor;
	private JButton btnGenerar;
	private Hotel mihotel;
	private VentanaRecepcionista mi;

	public VentanaGastosRecepcionista(VentanaRecepcionista mi) {

		mi = this.mi;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		mihotel = new Hotel();
		JLabel lblVentanaGastosTurno = new JLabel("Ventana Gastos Turno");
		lblVentanaGastosTurno.setBounds(147, 23, 126, 14);
		contentPane.add(lblVentanaGastosTurno);

		btnGenerar = new JButton("Generar ");
		btnGenerar.setBounds(335, 208, 89, 23);
		contentPane.add(btnGenerar);
		btnGenerar.addActionListener(this);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(30, 76, 380, 67);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(30, 61, 77, 14);
		contentPane.add(lblDescripcion);

		JLabel lblValorGasto = new JLabel("Valor Gasto ");
		lblValorGasto.setBounds(30, 154, 58, 14);
		contentPane.add(lblValorGasto);

		txtValor = new JTextField();
		txtValor.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				 char c= arg0.getKeyChar();
				 if(c<'0' || c>'9') arg0.consume();;
					 
				 
			}
		});
		txtValor.setBounds(101, 151, 86, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGenerar) {
			//String usuario= mi.getUsuario();
			//mihotel.generarGasto(usuario, txtDescripcion.getText(), Long.parseLong(txtValor.getText()));
		}
	}
}
