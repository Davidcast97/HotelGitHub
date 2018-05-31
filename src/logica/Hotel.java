package logica;

import java.awt.JobAttributes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
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
	private File archivo, gastoRecepcionista;
	private long base;

	public Hotel() {

		archivo = new File("src//Data//Usuarios.txt");
		gastoRecepcionista = new File("src//Data//GastoRecepcionista.txt");
		base= comprobarBase();
	}

	public long comprobarBase() {
		String cadena = "";
		try {
			FileReader fr = new FileReader(gastoRecepcionista);
			BufferedReader br = new BufferedReader(fr);
			String parteBase = "" ;
			while ((cadena = br.readLine()) != null) {
				String[] partes = cadena.split(";");
				parteBase = partes[2];
				
			}
			return Long.parseLong(parteBase);
		} catch (EOFException e) {
		} catch (Exception e) {
		} 
		return 168000;

	}


	public void generarGasto(String descripcion, Long b) {
		base=base-b;
		String cadena = descripcion + ";" + b+ ";"+ base ;
		try {
			FileWriter fw = new FileWriter(gastoRecepcionista, true); // booleano sirve para saber si se agrega false= borra todo y
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
	
	
	public String eliminarRecepcionista(String usuario) {
		String mensaje = "";
		String cadena = "";
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);

			while ((cadena = br.readLine()) != null) {
				String[] partes = cadena.split(";");
				String parteCedula = partes[3];

				if (parteCedula.equals(usuario) && JOptionPane.showConfirmDialog(null, "Esta seguro") == 0) {
					mensaje += "";
				} else {
					mensaje += cadena + "\n";
				}

			}
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(mensaje);
			bw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return mensaje;

	}
	

	public void crearAdminitradores(Administrador miAdministrador) {

		String cadena = miAdministrador.getNombre() + ";" + miAdministrador.getCedula() + ";"
				+ miAdministrador.getTelefono() + ";" + miAdministrador.getLogin() + ";"
				+ miAdministrador.getContrasena() + ";" + true;
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
				+ miRecepcionista.getContrasena() + ";" + false;
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
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			while ((cadena = br.readLine()) != null) {
				String[] partes = cadena.split(";");
				String parteLogin = partes[3];
				String parteContrasena = partes[4];
				if (parteLogin.equals(login) && parteContrasena.equals(contrasena)) {
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
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			while ((cadena = br.readLine()) != null) {
				String[] partes = cadena.split(";");
				String parteLogin = partes[3];
				String s = partes[5];
				if (parteLogin.equals(usuario) && s.equals("true")) {
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
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			while ((cadena = br.readLine()) != null) {
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

			FileReader fr = new FileReader(archivo);

			BufferedReader br = new BufferedReader(fr);
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

	public long getBase() {
		return base;
	}

	public void setBase(long base) {
		this.base = base;
	}

	

}
