package logica;

import java.util.ArrayList;
import java.util.Iterator;

public class Administrador extends Empleado {
	private ArrayList<Recepcionista> misRecepcionista = new ArrayList<Recepcionista>();
	
	public Administrador(String nombre, String cedula, String telefono, String login,String contrasena) {
		super(nombre, cedula, telefono, login, contrasena);
		
	}
	public void crearRecepcionista(String nombre, String cedula, String telefono, String contrasena, String login) {
		
		misRecepcionista.add(new Recepcionista(nombre, cedula, telefono, contrasena, login));
		
	}
	public boolean comprobarRecepcionista (String login, String contrasena) {
		for (Recepcionista recepcionista : misRecepcionista) {
			if(recepcionista.getLogin().equals(login)&& recepcionista.getContrasena().equals(contrasena)) {
				return true;
			}
		}
		return false;
	
	}

}
