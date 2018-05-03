package logica;

import java.util.ArrayList;

import com.jgoodies.common.base.SystemUtils;

public class Hotel {
	private ArrayList<Administrador> misAdministradores;
	
		public Hotel() {
			misAdministradores= new ArrayList<Administrador>();
		}
	
		public void crearAdminitradores(String nombre, String cedula, String telefono, String contraseña, String login) {
		
		misAdministradores.add(new Administrador(nombre, cedula, telefono, contraseña, login));
		System.out.println(misAdministradores.size());
		System.out.println("Adminitrador Creado");
	}
		public boolean comprobarAdministrador(String login, String contraseña) {
			for (int i = 0; i < misAdministradores.size(); i++) {
				if(misAdministradores.get(i).getLogin().equals(login) && misAdministradores.get(i).getContraseña().equals(contraseña)) {
					return true;
				}
			}
			
			return false;
			
		}
	
}
