package logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Hotel {
	private ArrayList<Empleado> misEmpleados;
	private File archivo;

	public Hotel() {

		archivo = new File("Usuarios.txt");
		// misEmpleados= new ArrayList<Empleado>();
		//
		// Administrador a= new Administrador("david", "1097405579", "310834308",
		// "dafa", "12");
		// misEmpleados.add(a);
	}

	public void crearAdminitradores(Administrador miAdministrador) {
		
		String cadena = miAdministrador.getNombre() + ";" + miAdministrador.getCedula() + ";"
				+ miAdministrador.getTelefono() + ";" + miAdministrador.getLogin() + ";"
				+ miAdministrador.getContrasena()+";"+ true;
		try {
			FileWriter fw = new FileWriter(archivo, true); // booleano sirve para saber si se agrega false= borra todo y
															// coloca el ultimo string
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(cadena);
			bw.newLine(); // agrega otra linea para el proximo dato a guardar
			bw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

	public void crearRecepcionistas(Recepcionista miRecepcionista) {
		String cadena = miRecepcionista.getNombre() + ";" + miRecepcionista.getCedula() + ";"
				+ miRecepcionista.getTelefono() + ";" + miRecepcionista.getLogin() + ";"
				+ miRecepcionista.getContrasena()+";"+ false;
		try {
			FileWriter fw = new FileWriter(archivo, true); // booleano sirve para saber si se agrega false= borra todo y
															// coloca el ultimo string
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(cadena);
			bw.newLine(); // agrega otra linea para el proximo dato a guardar
			bw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean comprobarEmpleado(String login, String contrasena) {
		String cadena = "";
		try {
			FileReader fr= new FileReader(archivo);
			BufferedReader br= new BufferedReader(fr);
			while((cadena=br.readLine()) !=null){
				String[] partes = cadena.split(";");
				String parteLogin = partes[3];
				String parteContrasena = partes[4];
				if (parteLogin.equals(login)&& parteContrasena.equals(contrasena)) {
					return true;
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public boolean comprobarAdministrador(String usuario) {
		String cadena = "";
		try {
			FileReader fr= new FileReader(archivo);
			BufferedReader br= new BufferedReader(fr);
			while((cadena=br.readLine()) !=null){
				String[] partes = cadena.split(";");
				String parteLogin = partes[3];
				String s = partes[5];
				if (parteLogin.equals(usuario)&& s.equals("true")) {
					return true;
				}
				
			}
		} catch (Exception e) {
		}
		return false;
	
	}

	public boolean existe(String login) {
		String cadena = "";
		try {
			FileReader fr= new FileReader(archivo);
			BufferedReader br= new BufferedReader(fr);
			while((cadena=br.readLine()) !=null){
				String[] partes = cadena.split(";");
				String parteLogin = partes[3];
				if (parteLogin.equals(login)) {
					return true;
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public String listarRecepcionistas() {
		String lista = "";
		String cadena = "";
		try {
			
			FileReader fr= new FileReader(archivo);
			
			BufferedReader br= new BufferedReader(fr);
			while ((cadena = br.readLine()) != null) {
				
				lista += cadena + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lista;
	}

}
