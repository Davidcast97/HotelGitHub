package interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//import org.sqlite.SQLiteJDBCLoader;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;
import java.awt.event.ActionEvent;

import logica.Habitacion;
import logica.Producto;
import logica.Tienda;
import logica.VentaParcial;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;

public class VentanaTienda implements ActionListener, ListSelectionListener {

	private JFrame frame;
	private JButton btnActualizar, btnComprar, btnEntregar, btnFiar, btnAVenta;
	private JLabel precioUnitario, precioTotal, inventario;
	private JList listProductos;
	private JSpinner spinnerCantidad;
	private JTextPane detallesVenta;
	private Tienda miTienda;
	private JTextField txtHabitacion;

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
		frame.setBounds(100, 100, 330, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		miTienda = new Tienda();

		listProductos = new JList(miTienda.getListaNombresProductos());
		listProductos.setBounds(10, 45, 159, 251);
		listProductos.addListSelectionListener(this);
		frame.getContentPane().add(listProductos);

		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblProductos.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(lblProductos);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(179, 130, 56, 14);
		frame.getContentPane().add(lblCantidad);

		spinnerCantidad = new JSpinner();
		spinnerCantidad.setBounds(245, 127, 46, 20);
		spinnerCantidad.setValue(1);
		frame.getContentPane().add(spinnerCantidad);
		spinnerCantidad.setModel(new SpinnerNumberModel(0, 0, 0, 1));


		JLabel lblPrecioUnidad = new JLabel("Precio unidad");
		lblPrecioUnidad.setBounds(179, 80, 89, 14);
		frame.getContentPane().add(lblPrecioUnidad);

		precioUnitario = new JLabel("");
		precioUnitario.setBounds(179, 105, 89, 14);
		frame.getContentPane().add(precioUnitario);

		JLabel lblPrecioTotal = new JLabel("Precio total");
		lblPrecioTotal.setBounds(179, 169, 76, 14);
		frame.getContentPane().add(lblPrecioTotal);

		precioTotal = new JLabel("");
		precioTotal.setBounds(179, 194, 89, 14);
		frame.getContentPane().add(precioTotal);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(179, 296, 112, 23);
		btnActualizar.addActionListener(this);
		frame.getContentPane().add(btnActualizar);

		btnComprar = new JButton("Comprar");
		btnComprar.setBounds(179, 383, 103, 23);
		btnComprar.addActionListener(this);
		frame.getContentPane().add(btnComprar);

		JLabel estado = new JLabel("");
		estado.setBounds(10, 471, 149, 14);
		frame.getContentPane().add(estado);

		JLabel lblInventario = new JLabel("Inventario:");
		lblInventario.setBounds(179, 46, 76, 23);
		frame.getContentPane().add(lblInventario);

		inventario = new JLabel("");
		inventario.setBounds(249, 50, 33, 19);
		frame.getContentPane().add(inventario);

		btnEntregar = new JButton("Entregar ");
		btnEntregar.setBounds(179, 462, 103, 23);
		btnEntregar.addActionListener(this);
		frame.getContentPane().add(btnEntregar);

		btnFiar = new JButton("Fiar");
		btnFiar.setBounds(179, 414, 103, 23);
		btnFiar.addActionListener(this);
		frame.getContentPane().add(btnFiar);

		JLabel lblDetallesDeLa = new JLabel("Detalles de la venta");
		lblDetallesDeLa.setBounds(10, 328, 117, 14);
		frame.getContentPane().add(lblDetallesDeLa);

		btnAVenta = new JButton("A\u00F1adir Venta");
		btnAVenta.setBounds(179, 330, 112, 23);
		btnAVenta.addActionListener(this);
		frame.getContentPane().add(btnAVenta);

		detallesVenta = new JTextPane();
		detallesVenta.setBounds(20, 353, 149, 118);
		frame.getContentPane().add(detallesVenta);

		JLabel lblHabitacion = new JLabel("Habitacion");
		lblHabitacion.setBounds(179, 230, 76, 14);
		frame.getContentPane().add(lblHabitacion);

		txtHabitacion = new JTextField();
		txtHabitacion.setBounds(264, 227, 40, 20);
		frame.getContentPane().add(txtHabitacion);
		txtHabitacion.setColumns(10);

	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if (!e.getValueIsAdjusting()) {
			int select = listProductos.getSelectedIndex();
			precioUnitario.setText(miTienda.getMisProductos().get(select).getPrecio() + "");
			inventario.setText(miTienda.getMisProductos().get(select).getCantidad() + "");
			spinnerCantidad.setModel(new SpinnerNumberModel(1, 1, miTienda.getMisProductos().get(select).getCantidad(), 1));
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnActualizar) {
			int total = Integer.parseInt(precioUnitario.getText())
					* Integer.parseInt(spinnerCantidad.getValue().toString());
			precioTotal.setText(total + "");
		}

		if (e.getSource() == btnAVenta) {
			int precioT = Integer.parseInt(precioTotal.getText());
			detallesVenta
					.setText(detallesVenta.getText() + " \r\n " + listProductos.getSelectedValue() + " \t  " + precioT);
			
			miTienda.guardarVentaParcial(Integer.parseInt(spinnerCantidad.getValue() + ""), precioT,
					miTienda.getMisProductos().get(listProductos.getSelectedIndex()));
		}

		if (e.getSource() == btnComprar) {
			Habitacion pruebita = new Habitacion();
			int totalVentaCompleta = miTienda.crearVentaCompleta(pruebita,false);
			JOptionPane.showMessageDialog(null, "La venta fue concretada: "+totalVentaCompleta);
		}

		if (btnFiar == e.getSource()) {
		}

		if (e.getSource() == btnEntregar) {
			if (JOptionPane.showConfirmDialog(null, "¿Esta seguro de entregar?") == 0) {
				VEntrega v = new VEntrega(this);
			}
		}
	}

	
}
