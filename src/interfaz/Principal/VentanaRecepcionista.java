package interfaz.Principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaz.Diseno;
import interfaz.Reservas.VentanaRegistroPersonal;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRecepcionista extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblUsuario, lblVentanaRecepcionista ;
	private JButton btnTienda;
	private JButton btnReservas, btnGastos;
	private String usuario;
	public VentanaRecepcionista(String usuario) {
		usuario=this.usuario;
		Diseno d = new Diseno(this);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 207, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVentanaRecepcionista = new JLabel("Ventana Recepcionista");
		lblVentanaRecepcionista.setBounds(10, 11, 211, 14);
		lblVentanaRecepcionista.setForeground(Color.BLACK);
		lblVentanaRecepcionista.setFont(new Font(d.TipoLetra, Font.BOLD | Font.ITALIC, d.tamanoPequeno));

		contentPane.add(lblVentanaRecepcionista);
		
		lblUsuario = new JLabel(""+usuario);
		lblUsuario.setBounds(59, 36, 46, 14);
		contentPane.add(lblUsuario);
		
		btnTienda = new JButton("Tienda");
		btnTienda.setBounds(41, 89, 89, 23);
		contentPane.add(btnTienda);
		
		btnReservas = new JButton("Reservas");
		btnReservas.addActionListener(this);
		btnReservas.setBounds(41, 122, 89, 23);
		contentPane.add(btnReservas);
		
		btnGastos = new JButton("Gastos");
		btnGastos.addActionListener(this);
		btnGastos.setBounds(41, 156, 89, 23);
		contentPane.add(btnGastos);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnReservas) {
			VentanaRegistroPersonal ventana = new VentanaRegistroPersonal(this);
			ventana.setVisible(true);
		}if(e.getSource()==btnGastos) {
			VentanaGastosRecepcionista ventana= new VentanaGastosRecepcionista(this);
			ventana.setVisible(true);
		}
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
}
