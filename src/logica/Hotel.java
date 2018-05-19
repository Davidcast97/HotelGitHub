package logica;

import java.util.ArrayList;


public class Hotel {
	private ArrayList<Empleado> misEmpleados;
	
		public Hotel() {
			misEmpleados= new ArrayList<Empleado>();
			
		}
	
		public void crearAdminitradores(String nombre, String cedula, String telefono, String login, String contrasena, boolean admin) {
			misEmpleados.add(new Administrador(nombre,cedula,telefono,login,contrasena,admin));
		
	}
		public boolean comprobarAdministrador(String login, String contrasena) {
			for (int i = 0; i < misEmpleados.size(); i++) {
				if(misEmpleados.get(i).getLogin().equals(login) && misEmpleados.get(i).getContrasena().equals(contrasena)) {
					return true;
				}
			}
			
			return false;
			
		}

	
}
