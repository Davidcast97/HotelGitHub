package interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//import org.sqlite.SQLiteJDBCLoader;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;
import java.awt.event.ActionEvent;

import logica.Habitacion;
import logica.LogTienda.Producto;
import logica.LogTienda.Tienda;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class VentanaTienda implements ActionListener, ListSelectionListener, ChangeListener {

	private JFrame frame;
	private JButton btnComprar, btnFiar, btnAVenta;
	private JLabel precioUnitario, precioTotal, inventario;
	private JComboBox<String> comboBoxHabitaciones;
	private JList listProductos;
	private JSpinner spinnerCantidad;
	private JTextPane detallesVenta;
	private Tienda miTienda;

	/**
	 * Launch the application.
	 * 
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTienda window = new VentanaTienda();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public VentanaTienda() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 383, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		miTienda = new Tienda();

		listProductos = new JList(miTienda.getListaNombresProductos());
		listProductos.setFont(new Font("Arial", Font.ITALIC, 12));
		listProductos.setBounds(10, 45, 159, 257);
		listProductos.addListSelectionListener(this);
		frame.getContentPane().add(listProductos);

		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblProductos.setBounds(10, 11, 149, 23);
		frame.getContentPane().add(lblProductos);

		btnComprar = new JButton("Comprar");
		btnComprar.setBounds(265, 365, 103, 23);
		btnComprar.addActionListener(this);
		frame.getContentPane().add(btnComprar);

		JLabel estado = new JLabel("");
		estado.setBounds(10, 471, 149, 14);
		frame.getContentPane().add(estado);

		btnFiar = new JButton("Fiar");
		btnFiar.setBounds(265, 399, 103, 23);
		btnFiar.addActionListener(this);
		frame.getContentPane().add(btnFiar);

		JLabel lblDetallesDeLa = new JLabel("Detalles de la venta");
		lblDetallesDeLa.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblDetallesDeLa.setBounds(10, 309, 159, 14);
		frame.getContentPane().add(lblDetallesDeLa);

		detallesVenta = new JTextPane();
		detallesVenta.setEditable(false);
		detallesVenta.setBounds(10, 334, 245, 118);
		frame.getContentPane().add(detallesVenta);

		JPanel panel = new JPanel();
		panel.setBounds(179, 45, 189, 257);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblPrecioUnidad = new JLabel("Precio unidad");
		lblPrecioUnidad.setBounds(10, 52, 76, 15);
		panel.add(lblPrecioUnidad);
		lblPrecioUnidad.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lblInventario = new JLabel("Inventario:");
		lblInventario.setBounds(10, 11, 56, 15);
		panel.add(lblInventario);
		lblInventario.setFont(new Font("Arial", Font.PLAIN, 12));

		inventario = new JLabel("");
		inventario.setHorizontalAlignment(SwingConstants.RIGHT);
		inventario.setBounds(144, 11, 35, 19);
		panel.add(inventario);

		precioUnitario = new JLabel("");
		precioUnitario.setHorizontalAlignment(SwingConstants.RIGHT);
		precioUnitario.setBounds(90, 52, 89, 14);
		panel.add(precioUnitario);

		precioTotal = new JLabel("");
		precioTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		precioTotal.setBounds(90, 125, 89, 14);
		panel.add(precioTotal);

		comboBoxHabitaciones = new JComboBox();
		comboBoxHabitaciones.setBounds(127, 162, 52, 20);
		panel.add(comboBoxHabitaciones);
		comboBoxHabitaciones.addItem("100");
		comboBoxHabitaciones.addItem("101");
		comboBoxHabitaciones.addItem("202");

		spinnerCantidad = new JSpinner();
		spinnerCantidad.setBounds(133, 87, 46, 20);
		panel.add(spinnerCantidad);
		spinnerCantidad.setValue(1);
		spinnerCantidad.addChangeListener(this);
		spinnerCantidad.setModel(new SpinnerNumberModel(0, 0, 0, 1));

		btnAVenta = new JButton("A\u00F1adir Venta");
		btnAVenta.setBounds(41, 223, 112, 23);
		panel.add(btnAVenta);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(10, 89, 76, 14);
		panel.add(lblCantidad);
		lblCantidad.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lblPrecioTotal = new JLabel("Precio total");
		lblPrecioTotal.setBounds(10, 125, 76, 14);
		panel.add(lblPrecioTotal);
		lblPrecioTotal.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lblHabitacion = new JLabel("Habitacion");
		lblHabitacion.setBounds(10, 164, 76, 14);
		panel.add(lblHabitacion);
		lblHabitacion.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAVenta.addActionListener(this);

	}

	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			
			int select = listProductos.getSelectedIndex();
			Producto p = miTienda.buscarProducto((String)listProductos.getSelectedValue());
			precioUnitario.setText(p.getPrecio() + "");
			int cantidad = p.getCantidad();
			inventario.setText(cantidad + "");
			if (cantidad > 0) {
				spinnerCantidad.setModel(
						new SpinnerNumberModel(1, 1, miTienda.getMisProductos().get(select).getCantidad(), 1));
				precioTotal.setText(p.getPrecio() + "");
			} else {
				spinnerCantidad.setModel(
						new SpinnerNumberModel(0, 0, miTienda.getMisProductos().get(select).getCantidad(), 1));
			}

		}

	}

	public void stateChanged(ChangeEvent e) {
		int total = Integer.parseInt(precioUnitario.getText())
				* Integer.parseInt(spinnerCantidad.getValue().toString());
		precioTotal.setText(total + "");
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnAVenta) {
			int precioT = Integer.parseInt(precioTotal.getText());
			if (detallesVenta.getText().equals("")) {
				detallesVenta.setText(listProductos.getSelectedValue() + " \t  " + precioT);

			} else {
				detallesVenta.setText(
						detallesVenta.getText() + " \r\n " + listProductos.getSelectedValue() + " \t  " + precioT);

			}

			miTienda.guardarVentaParcial(Integer.parseInt(spinnerCantidad.getValue() + ""), precioT,
					miTienda.getMisProductos().get(listProductos.getSelectedIndex()));
		}

		if (e.getSource() == btnComprar) {
			int totalVentaCompleta = miTienda.crearVentaCompleta();
			detallesVenta.setText("");
			int cantidad = miTienda.getMisProductos().get(listProductos.getSelectedIndex()).getCantidad();
			inventario.setText(cantidad + "");
			JOptionPane.showMessageDialog(null, "La venta fue concretada: " + totalVentaCompleta);
		}

		if (btnFiar == e.getSource()) {
			int totalVentaCompleta = miTienda.crearVentaCompleta((String) comboBoxHabitaciones.getSelectedItem());
			detallesVenta.setText("");
			int cantidad = miTienda.getMisProductos().get(listProductos.getSelectedIndex()).getCantidad();
			inventario.setText(cantidad + "");
			JOptionPane.showMessageDialog(null, "La venta fue concretada: " + totalVentaCompleta);
		}
	}
}
