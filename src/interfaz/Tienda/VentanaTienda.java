package interfaz.Tienda;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.TableView.TableRow;

import interfaz.Diseno;

//import org.sqlite.SQLiteJDBCLoader;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;

import logica.Administrador;
import logica.Empleado;
import logica.LogTienda.Producto;
import logica.LogTienda.Tienda;
import logica.Reservas.Habitacion;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.ScrollPane;
import java.awt.Color;
import javax.swing.ImageIcon;

public class VentanaTienda implements  ActionListener, ListSelectionListener, ChangeListener {

	private JFrame frame;
	private JButton btnComprar, btnFiar, btnAVenta,btnLimpiar,btnAdmin ;
	private JLabel precioUnitario, precioTotal, inventario,estado;
	private JComboBox<String> comboBoxHabitaciones;
	private JList listProductos;
	private JSpinner spinnerCantidad;
	private DefaultTableModel model;
	private Tienda miTienda;
	private JTable table;
	private JPanel tablePanel;
	private TableColumnModel columnModel;
	private JLabel label;
	


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

	public VentanaTienda() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 491, 506);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		Diseno d = new Diseno(frame);
       
		miTienda = new Tienda();

		listProductos = new JList(miTienda.getListaNombresProductos());
		listProductos.setFont(new Font(d.TipoLetra, Font.ITALIC, d.tamanoPequeno));
		listProductos.setBounds(10, 45, 245, 257);
		listProductos.addListSelectionListener(this);
		JScrollPane jsp = new JScrollPane(listProductos);
		jsp.setBounds(10, 45, 245, 257);
		frame.getContentPane().add(jsp);

		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setFont(new Font(d.TipoLetra, Font.BOLD | Font.ITALIC, d.tamanoTitulos));
		lblProductos.setBounds(173, 11, 159, 23);
		frame.getContentPane().add(lblProductos);

		btnComprar = new JButton("Comprar");
		btnComprar.setFont(new Font(d.TipoLetra, Font.PLAIN, d.tamanoPequeno));
		btnComprar.setBounds(314, 334, 103, 23);
		btnComprar.addActionListener(this);
		frame.getContentPane().add(btnComprar);

		estado = new JLabel("");
		estado.setForeground(new Color(0, 0, 0));
		estado.setHorizontalAlignment(SwingConstants.CENTER);
		estado.setFont(new Font(d.TipoLetra, Font.ITALIC, d.tamanoPequeno));
		estado.setBounds(265, 440, 210, 20);
		frame.getContentPane().add(estado);

		btnFiar = new JButton("Fiar");
		btnFiar.setFont(new Font(d.TipoLetra, Font.PLAIN, d.tamanoPequeno));
		btnFiar.setBounds(314, 372, 103, 23);
		btnFiar.addActionListener(this);
		frame.getContentPane().add(btnFiar);

		JLabel lblDetallesDeLa = new JLabel("Detalles de la venta");
		lblDetallesDeLa.setFont(new Font(d.TipoLetra, Font.BOLD | Font.ITALIC, d.tamanoPequeno));
		lblDetallesDeLa.setBounds(10, 309, 159, 14);
		frame.getContentPane().add(lblDetallesDeLa);


		JPanel panel = new JPanel();
		panel.setBounds(265, 66, 199, 257);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblPrecioUnidad = new JLabel("Precio unidad");
		lblPrecioUnidad.setBounds(10, 52, 102, 15);
		panel.add(lblPrecioUnidad);
		lblPrecioUnidad.setFont(new Font(d.TipoLetra, Font.PLAIN, d.tamanoPequeno));

		JLabel lblInventario = new JLabel("Inventario:");
		lblInventario.setBounds(10, 11, 76, 15);
		panel.add(lblInventario);
		lblInventario.setFont(new Font(d.TipoLetra, Font.PLAIN, d.tamanoPequeno));

		inventario = new JLabel("");
		inventario.setFont(new Font(d.TipoLetra, Font.PLAIN, d.tamanoPequeno));
		inventario.setHorizontalAlignment(SwingConstants.RIGHT);
		inventario.setBounds(144, 11, 35, 19);
		panel.add(inventario);

		precioUnitario = new JLabel("");
		precioUnitario.setFont(new Font(d.TipoLetra, Font.PLAIN, d.tamanoPequeno));
		precioUnitario.setHorizontalAlignment(SwingConstants.RIGHT);
		precioUnitario.setBounds(90, 52, 89, 14);
		panel.add(precioUnitario);

		precioTotal = new JLabel("");
		precioTotal.setFont(new Font(d.TipoLetra, Font.PLAIN, d.tamanoPequeno));
		precioTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		precioTotal.setBounds(90, 125, 89, 14);
		panel.add(precioTotal);

		comboBoxHabitaciones = new JComboBox();
		comboBoxHabitaciones.setFont(new Font(d.TipoLetra, Font.PLAIN, d.tamanoPequeno));
		comboBoxHabitaciones.setBounds(127, 162, 52, 20);
		panel.add(comboBoxHabitaciones);
		comboBoxHabitaciones.addItem("100");
		comboBoxHabitaciones.addItem("101");
		comboBoxHabitaciones.addItem("202");

		spinnerCantidad = new JSpinner();
		spinnerCantidad.setFont(new Font(d.TipoLetra, Font.PLAIN, d.tamanoPequeno));
		spinnerCantidad.setBounds(133, 87, 46, 20);
		panel.add(spinnerCantidad);
		spinnerCantidad.setValue(1);
		spinnerCantidad.addChangeListener(this);
		spinnerCantidad.setModel(new SpinnerNumberModel(0, 0, 0, 1));

		btnAVenta = new JButton("A\u00F1adir Venta");
		btnAVenta.setFont(new Font(d.TipoLetra, Font.PLAIN, d.tamanoPequeno));
		btnAVenta.setBounds(41, 223, 112, 23);
		btnAVenta.addActionListener(this);
		panel.add(btnAVenta);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(10, 89, 76, 14);
		panel.add(lblCantidad);
		lblCantidad.setFont(new Font(d.TipoLetra, Font.PLAIN, d.tamanoPequeno));

		JLabel lblPrecioTotal = new JLabel("Precio total");
		lblPrecioTotal.setBounds(10, 125, 76, 14);
		panel.add(lblPrecioTotal);
		lblPrecioTotal.setFont(new Font(d.TipoLetra, Font.PLAIN, d.tamanoPequeno));

		JLabel lblHabitacion = new JLabel("Habitacion");
		lblHabitacion.setBounds(10, 164, 76, 14);
		panel.add(lblHabitacion);
		lblHabitacion.setFont(new Font(d.TipoLetra, Font.PLAIN, d.tamanoPequeno));
		
		
		Object columnNames[] = { "Producto", "#", "Precio"};
		Object rowData[][] = {
				{
					"","",""
				}
		};
		model = new DefaultTableModel(rowData, columnNames);
		table= new JTable(model);
		table.setEnabled(false);
		table.setSurrendersFocusOnKeystroke(true);
		table.setRowSelectionAllowed(false);
		table.setFont(new Font(d.TipoLetra, Font.PLAIN, d.tamanoPequeno));
		columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(170);
		columnModel.getColumn(1).setPreferredWidth(25);
		
		
		
		tablePanel = new JPanel(new BorderLayout());
		tablePanel.setBounds(10, 334, 245, 126);
		tablePanel.add(table, BorderLayout.CENTER);
		tablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
		
		frame.getContentPane().add(tablePanel);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font(d.TipoLetra, Font.PLAIN, d.tamanoPequeno));
		System.err.println(d.tamanoPequeno);
		btnLimpiar.setBounds(314, 406, 103, 23);
		btnLimpiar.addActionListener(this);
		frame.getContentPane().add(btnLimpiar);
		
		btnAdmin = new JButton("Admin");
		btnAdmin.setBounds(425, 374, 50, 23);
		btnAdmin.addActionListener(this);
		frame.getContentPane().add(btnAdmin);
		
		label = new JLabel("");
		label.setBounds(425, 11, 43, 34);
		frame.getContentPane().add(label);
		
		
		model.removeRow(0);
		
	}

	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {

			int select = listProductos.getSelectedIndex();
			Producto p = miTienda.buscarProducto((String) listProductos.getSelectedValue());
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
		
		if (e.getSource()==btnAdmin) {
			VentanaAdminTienda vat= new VentanaAdminTienda();
			
		}

		if (e.getSource() == btnAVenta) {
			int precioT = Integer.parseInt(precioTotal.getText());
			boolean verificado = verificarAgregar(listProductos.getSelectedValue(),spinnerCantidad.getValue());
			if (verificado) {
				model.addRow(new Object[]{listProductos.getSelectedValue(), ""+spinnerCantidad.getValue(), precioT+""});
				
				miTienda.guardarVentaParcial(Integer.parseInt(spinnerCantidad.getValue() + ""), precioT,
						miTienda.getMisProductos().get(listProductos.getSelectedIndex()));
				estado.setText("Producto agregado");	
			}
		}

		if (e.getSource() == btnComprar) {
			int totalVentaCompleta = miTienda.crearVentaCompleta("");
			table.removeAll();
			int cantidad = miTienda.getMisProductos().get(listProductos.getSelectedIndex()).getCantidad();
			inventario.setText(cantidad + "");
			JOptionPane.showMessageDialog(null, "La venta fue concretada: " + totalVentaCompleta);
			estado.setText("Se ha realizado la compra "+totalVentaCompleta);
			limpiar();
		}

		if (btnFiar == e.getSource()) {
			int totalVentaCompleta = miTienda.crearVentaCompleta((String) comboBoxHabitaciones.getSelectedItem());
			int cantidad = miTienda.getMisProductos().get(listProductos.getSelectedIndex()).getCantidad();
			inventario.setText(cantidad + "");
			JOptionPane.showMessageDialog(null, "La venta fue concretada: " + totalVentaCompleta);
		}
		
		if (btnLimpiar == e.getSource()) {
			 
			limpiar();
			miTienda.reiniciarVentasParciales();
			estado.setText("Se han borrado los elementos.");
		}
		
	}
	
	private boolean verificarAgregar(Object selectedValue, Object value) {
		for (int i = 0; i < table.getRowCount(); i++) {
			
			String smod =  (String)model.getValueAt(i, 0);
			String select = (String)selectedValue;
			System.out.println(smod+" "+select+" "+smod.equals(select));
			if (smod.equals(select)) {
				
				JOptionPane.showMessageDialog(null, "No puede volver a agregar el producto. Limpie la ventana en caso de necesitar cambiar la cantidad del producto");
				return false;
			}
		}
		System.err.println("---------------");
		return true;
		
	}

	public void limpiar() {
		int fila = table.getRowCount();
		
        if (fila > 0) {
         
           for (int i=1; i<=fila;i++)
           {
        	   System.out.println(i);
        	   model.removeRow(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay elementos a borrar", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
	}
}