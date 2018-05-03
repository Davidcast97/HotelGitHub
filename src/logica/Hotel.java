package logica;

import java.util.ArrayList;

import com.jgoodies.common.base.SystemUtils;

public class Hotel {
	private ArrayList<Administrador> misAdministradores;
	
		public Hotel() {
			misAdministradores= new ArrayList<Administrador>();
		}
	
		public void crearAdminitradores(String nombre, String cedula, String telefono, String contrase�a, String login) {
		
		misAdministradores.add(new Administrador(nombre, cedula, telefono, contrase�a, login));
		System.out.println(misAdministradores.size());
		System.out.println("Adminitrador Creado");
	}
		public boolean comprobarAdministrador(String login, String contrase�a) {
			for (int i = 0; i < misAdministradores.size(); i++) {
				if(misAdministradores.get(i).getLogin().equals(login) && misAdministradores.get(i).getContrase�a().equals(contrase�a)) {
					return true;
				}
			}
			
			return false;
			
		}
	
}
