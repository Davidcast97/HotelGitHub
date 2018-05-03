package logica;

import java.util.ArrayList;


public class Hotel {
	private ArrayList<Administrador> misAdministradores;
	

	
		public Hotel() {
			misAdministradores= new ArrayList<Administrador>();
			
		}
	
		public void crearAdminitradores(String nombre, String cedula, String telefono, String contrasena, String login) {
		
		misAdministradores.add(new Administrador(nombre, cedula, telefono, contrasena, login));
		System.out.println(misAdministradores.size());
		System.out.println("Adminitrador Creado");
	}
		public boolean comprobarAdministrador(String login, String contrasena) {
			for (int i = 0; i < misAdministradores.size(); i++) {
				if(misAdministradores.get(i).getLogin().equals(login) && misAdministradores.get(i).getContrasena().equals(contrasena)) {
					return true;
				}
			}
			
			return false;
			
		}

	
}
