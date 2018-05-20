package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import base_datos.ConexionTienda;
import logica.LogTienda.Producto;

public class VentanaAdminTienda implements ActionListener {

	private JFrame frame;
	private JTable table;
	private JButton btnAumentarInventario,btnAgregarProducto,btnEliminarProducto,btnEditar;
	private JPanel tablePanel;
	private TableColumnModel columnModel;
	private DefaultTableModel model;
	private ConexionTienda conTienda;
	private ArrayList<Producto> productos;
	private int selectedCol;
	private int selectedRow; 
	private boolean DEBUG = false;
    private boolean ALLOW_COLUMN_SELECTION = true;
    private boolean ALLOW_ROW_SELECTION = true;

	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdminTienda window = new VentanaAdminTienda();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VentanaAdminTienda() {
		frame = new JFrame();
		frame.setBounds(100, 100, 504, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		conTienda = new ConexionTienda();
		productos =  conTienda.getMisProd();
		selectedCol = 6;
		selectedRow = 100;
		
		btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.setBounds(332, 44, 134, 23);
		btnAgregarProducto.addActionListener(this);
		frame.getContentPane().add(btnAgregarProducto);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(332, 78, 134, 23);
		btnEditar.addActionListener(this);
		frame.getContentPane().add(btnEditar);
		
		btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.setBounds(332, 112, 134, 23);
		btnEliminarProducto.addActionListener(this);
		frame.getContentPane().add(btnEliminarProducto);
		
		
		Object columnNames[] = { "Id","Producto", "#", "Precio","Cat"};
		Object rowData[][] = obtenerDatosProductos();
		model = new DefaultTableModel(rowData, columnNames);
        final JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(200, 300));
        table.setFillsViewportHeight(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(20);
		columnModel.getColumn(1).setPreferredWidth(180);
		columnModel.getColumn(2).setPreferredWidth(30);
		columnModel.getColumn(3).setPreferredWidth(80);
		columnModel.getColumn(4).setPreferredWidth(20);
		frame.getContentPane().setLayout(null);
		
		tablePanel = new JPanel();
		tablePanel.setBounds(10, 11, 312, 300);
		
		
		if (ALLOW_ROW_SELECTION) { // true by default
            ListSelectionModel rowSM = table.getSelectionModel();
            rowSM.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    //Ignore extra messages.
                    if (e.getValueIsAdjusting()) return;

                    ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                    if (lsm.isSelectionEmpty()) {
                        System.out.println("No rows are selected.");
                    } else {
                        selectedRow = lsm.getMinSelectionIndex();
                        System.out.println("Row " + selectedRow
                                           + " is now selected.");
                    }
                }
            });
        } else {
            table.setRowSelectionAllowed(false);
        }      
		
		if (ALLOW_COLUMN_SELECTION) { // false by default
            if (ALLOW_ROW_SELECTION) {
                //We allow both row and column selection, which
                //implies that we *really* want to allow individual
                //cell selection.
                table.setCellSelectionEnabled(true);
            }
            table.setColumnSelectionAllowed(true);
            ListSelectionModel colSM =
                table.getColumnModel().getSelectionModel();
            colSM.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    //Ignore extra messages.
                    if (e.getValueIsAdjusting()) return;

                    ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                    if (lsm.isSelectionEmpty()) {
                        System.out.println("No columns are selected.");
                    } else {
                    	selectedCol = lsm.getMinSelectionIndex();
                        System.out.println("Column " + selectedCol
                                           + " is now selected.");
                    }
                }
            });
        }

        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }
        tablePanel.setLayout(null);

 
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 312, 300);
 
        //Add the scroll pane to this panel.
        tablePanel.add(scrollPane);
        tablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
        frame.getContentPane().add(tablePanel);
        
		
		
	}
	
	public Object[][] obtenerDatosProductos() {
		Object rowData[][] = new Object[productos.size()][5];
		int i = 0;
		for (Producto p : productos) {
			rowData[i][1] = p.getNombre();
			rowData[i][2] = p.getCantidad();
			rowData[i][3] = p.getPrecio();
			rowData[i][4] = p.getCategoria();
			rowData[i][0] = p.getIdProducto();
			i++;
		}
		
		return rowData;
	}
	
	 private void printDebugData(JTable table) {
	        int numRows = table.getRowCount();
	        int numCols = table.getColumnCount();
	        

	        System.out.println("Value of data: ");
	        for (int i=0; i < numRows; i++) {
	            System.out.print("    row " + i + ":");
	            for (int j=0; j < numCols; j++) {
	                System.out.print("  " + model.getValueAt(i, j));
	            }
	            System.out.println();
	        }
	        System.out.println("--------------------------");
	    }


	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnAgregarProducto) {
			String[] prod = JOptionPane.showInputDialog("Ingrese el producto de la siguiente manera \n nombre,precio,cantidad,categoria").split(",");
			boolean g = conTienda.guardarProducto(prod[0],prod[1], prod[2], prod[3]);
			if (g) {
				JOptionPane.showMessageDialog(null, "Guardo correctamente");
				Producto p = new Producto(prod[0],Integer.parseInt(prod[1]), Integer.parseInt(prod[2]), Integer.parseInt(prod[3]),0);
				productos.add(p);
				Object columnNames[] = { "Id","Producto", "#", "Precio","Cat"};
				Object rowData[][] = obtenerDatosProductos();
				model = new DefaultTableModel(rowData, columnNames);
				table.setModel(model);
			}else {
				JOptionPane.showMessageDialog(null, "No pudo guardar en la bd");
			}
		}
		if (e.getSource()==btnEditar) {
			if (selectedCol!=6 && selectedRow!=100) {
				boolean g=conTienda.editarProducto(model.getValueAt(selectedRow, 0),model.getValueAt(selectedRow, 1),model.getValueAt(selectedRow, 3),model.getValueAt(selectedRow, 2),model.getValueAt(selectedRow, 4));
				if (g) {
					JOptionPane.showMessageDialog(null, "Editado correctamente");
				}else {
					JOptionPane.showMessageDialog(null, "No se pudo editar");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar y editar el producto");
			}
		}
		
		if (e.getSource()==btnEliminarProducto) {
			if (selectedCol!=6) {
				boolean g = conTienda.eliminarProducto(model.getValueAt(selectedRow, 0));
				if (g) {
					model.removeRow(selectedRow);
					JOptionPane.showMessageDialog(null, "Borrado correctamente");
				}else {
					JOptionPane.showMessageDialog(null, "No pudo ser eliminado");
				}
			}
		}
	}
}
