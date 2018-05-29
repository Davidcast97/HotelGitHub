package interfaz.Tienda;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import logica.LogTienda.Producto;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VentanaAgregarProducto implements ActionListener {

	private JFrame frame;
	private JTextField txtNombre,txtPrecio,txtCantidad;
	private JComboBox cBoxCategoria;
	private JButton btnGuardar;
	private VentanaAdminTienda miVAT;

	
	public VentanaAgregarProducto(VentanaAdminTienda miV) {
	
		frame = new JFrame();
		frame.setBounds(100, 100, 267, 259);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		miVAT = miV;
		txtNombre = new JTextField();
		txtNombre.setBounds(141, 48, 86, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(141, 79, 86, 20);
		frame.getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(141, 110, 86, 20);
		frame.getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		cBoxCategoria = new JComboBox();
		cBoxCategoria.setBounds(141, 141, 86, 20);
		frame.getContentPane().add(cBoxCategoria);
		cBoxCategoria.addItem("Liquidos");
		cBoxCategoria.addItem("Aseo");
		cBoxCategoria.addItem("Solidos");
		cBoxCategoria.addItem("Licores");
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(68, 179, 89, 23);
		btnGuardar.addActionListener(this);
		frame.getContentPane().add(btnGuardar);
		
		JLabel lblNombreProducto = new JLabel("Nombre Producto");
		lblNombreProducto.setBounds(22, 51, 86, 14);
		frame.getContentPane().add(lblNombreProducto);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(22, 82, 46, 14);
		frame.getContentPane().add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(22, 113, 46, 14);
		frame.getContentPane().add(lblCantidad);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(22, 144, 86, 14);
		frame.getContentPane().add(lblCategoria);
		
		
		
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnGuardar) {
			String[] prod = { " ",txtNombre.getText(),txtCantidad.getText(),txtPrecio.getText(),String.valueOf(cBoxCategoria.getSelectedIndex())};
			miVAT.guardarProducto(prod);			
		}
	}
}
