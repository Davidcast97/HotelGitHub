package base_datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Conexion {
	private String nombreBD;
	public Conexion(String bd) {
		nombreBD =bd;
	}
	
	
	public Connection conectar() {
		Connection conect =null;
		
		
		String servidor = "jdbc:mysql://127.0.0.1:3306/"+nombreBD+"?user=root&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String usuario = "root";
		String contrasena = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conect = DriverManager.getConnection(servidor,usuario,contrasena);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error 1: "+e);
			conect=null;
		} catch (SQLException e) {
			conect=null;
			JOptionPane.showMessageDialog(null, "Error 2: "+e);
		}
		
		
		return conect;
	}
}
