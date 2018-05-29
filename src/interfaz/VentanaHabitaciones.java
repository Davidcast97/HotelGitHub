package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaHabitaciones extends JFrame implements ActionListener{
	
	private JPanel contenedorSuperior, contenedorCentral, contenedorInferior;
	private JLabel titulo;
	private JButton matrizBotones[][], btnAtras, btnContinuar;
	private int tamanio;
	
	public VentanaHabitaciones(){
		setBounds(100, 100, 450, 300);
		panelSuperior();
		panelCentral();
		panelInferior();
	}
	public void panelSuperior(){
		contenedorSuperior = new JPanel();
		titulo = new JLabel("Habitaciones");
		titulo.setFont(new Font("Verdana", Font.BOLD, 11));
		contenedorSuperior.add(titulo);
		this.add(contenedorSuperior, BorderLayout.NORTH);
	}
	public void panelCentral(){	
		matrizBotones = new JButton[4][6];
		contenedorCentral = new JPanel();
		contenedorCentral.setLayout(new GridLayout(4, 6));
		int numero = 0;
		for(int i = 0; i < matrizBotones.length; i++){
			numero += 100;
			for(int j = 0; j < matrizBotones[0].length; j++){
				numero += j + 1;
				JButton boton = new JButton(""+numero);
				boton.setFont(new Font("Verdana", Font.PLAIN, 11));
				matrizBotones[i][j] = boton;
				matrizBotones[i][j].addActionListener(this);
				contenedorCentral.add(matrizBotones[i][j]);
				numero -= j + 1;
			}
		}
		this.add(contenedorCentral, BorderLayout.CENTER);
	}
	public void panelInferior() {
		contenedorInferior = new JPanel();
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(this);
		btnAtras.setFont(new Font("Verdana", Font.PLAIN, 11));
		contenedorInferior.add(btnAtras);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(this);
		btnContinuar.setFont(new Font("Verdana", Font.PLAIN, 11));
		contenedorInferior.add(btnContinuar);
		
		this.add(contenedorInferior, BorderLayout.SOUTH);
	}
	public void pintarCasilla(int i, int j) {
		matrizBotones[i][j].setBackground(Color.red);
	}
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < matrizBotones.length; i++) {
			for (int j = 0; j < matrizBotones[0].length; j++) {
				if(e.getSource() == matrizBotones[i][j]) {
					VentanaPropiedadesHabitacion ventana = new VentanaPropiedadesHabitacion(this, matrizBotones[i][j].getText());
					ventana.setVisible(true);
				}
			}
		}
		if(e.getSource() == btnAtras) {
			this.setVisible(false);
		}
		if(e.getSource() == btnContinuar) {
			//verificar numero de camas.
			
		}
	}
}