package base_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import logica.LogTienda.Producto;
import logica.LogTienda.VentaCompleta;

public class ConexionTienda extends Conexion{

	private Connection conn;
	
	public ConexionTienda() {
		super("tienda");
		conn = this.conectar();
	}
	
	public boolean actualizarInventarioProducto(int cantidad,String nombre) {
		String sql = "UPDATE productos SET inventario = "+cantidad+" WHERE nombre='"+nombre+"'";
		boolean c = true;
		int rs=0;
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			rs = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rs==-1) {
			c=false;
		}
		return c;
	}
	
	public ArrayList<Producto> getMisProd() {
		ArrayList<Producto> prod = new ArrayList<Producto>();
		try {
			PreparedStatement st = conn.prepareStatement("SELECT * FROM productos");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Producto p = new Producto(rs.getString("nombre"),Integer.parseInt(rs.getString("precio")), Integer.parseInt(rs.getString("inventario")), Integer.parseInt(rs.getString("categoria")));
				prod.add(p);
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prod;
	}

	public boolean guardarVentaCompleta(VentaCompleta v) {
		String sql = "INSERT INTO `ventas` (`idVentaCompleta`, `fecha`, `precioTotal`, `miHabitacion`, `descripcion`) VALUES (NULL, '"+v.getFecha()+"', '"+v.getPrecioTotal()+"', "+v.getMiHabitacion()+", '"+v.getDescripcion()+"');";
		int r =0;
		System.out.println(sql);
		boolean c = true;
		try {
			System.err.println(r+sql);
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (r==-1) {
			c=false;
		}
		return c;
	}
	
	
	
	
	
}
