package logicaAlmacenar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import logica.Reservas.Habitacion;
import logica.Reservas.Tarifa;

public class AlmacenarHabitacion {
	private File archivo;
	public AlmacenarHabitacion() {
		archivo = new File("src//Data//habitaciones.txt");
	}
	public boolean agregarHabitacion(Habitacion miHabitacion) {
		boolean centinela;
		//ejemplo: 101;15000;baja;true;2;dos camas sencillas, refrigerador pequeño, un baño privado
		String nombre = miHabitacion.getNombre();
		Double valorTarifa = miHabitacion.getTarifa().getValor();
		String temporadaTarifa = miHabitacion.getTarifa().getTemporada();
		boolean estado = miHabitacion.getEstado();
		int numeroCamas = miHabitacion.getNumeroCamas();
		String detalles = miHabitacion.getDetalles();
			String cadena = nombre+";"+valorTarifa+";"+temporadaTarifa+";"+estado+";"+numeroCamas+";"+detalles;
			try {
				FileWriter fw = new FileWriter(archivo, true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(cadena);
				bw.newLine();
				bw.close();
				centinela = true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				centinela = false;
			} catch (IOException e) {
				e.printStackTrace();
				centinela = false;
			}
		return centinela;
	}	
	public Habitacion buscarHabitacion(String nombre) {
		Habitacion miHabitacion = new Habitacion(null, null, false, 0, null);
		String busqueda = "";
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			while ((busqueda = br.readLine()) != null) {
				String[] arreglo = busqueda.split(";");
				String n = arreglo[0];
				if (n.equals(nombre)) {
					miHabitacion.setNombre(arreglo[0]);
					Tarifa miTarifa = new Tarifa(Double.parseDouble(arreglo[1]), arreglo[2]);
					miHabitacion.setTarifa(miTarifa);
					if(arreglo[3].equals("true")) {
						miHabitacion.setEstado(true);
					}else {
						miHabitacion.setEstado(false);
					}
					miHabitacion.setNumeroCamas(Integer.parseInt(arreglo[4]));
					miHabitacion.setDetalles(arreglo[5]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return miHabitacion;
	}
	public boolean editarHabitacion(Habitacion miHabitacion) {
		boolean centinela = false;
		String cadenaRegistro = "";
		String cadena = "";
			try {
				FileReader fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);
				String saltoDeLinea = "\n";
				while ((cadena = br.readLine()) != null) {
					if (!cadena.contains(miHabitacion.getNombre())) {
						cadenaRegistro += cadena + saltoDeLinea;
					} else {
						String nombre = miHabitacion.getNombre();
						Double valorTarifa = miHabitacion.getTarifa().getValor();
						String temporadaTarifa = miHabitacion.getTarifa().getTemporada();
						boolean estado = miHabitacion.getEstado();
						int numeroCamas = miHabitacion.getNumeroCamas();
						String detalles = miHabitacion.getDetalles();
						String registro = nombre+";"+valorTarifa+";"+temporadaTarifa+";"+estado+";"+numeroCamas+";"+detalles;
						cadenaRegistro += registro + saltoDeLinea;
					}
				}
				cadenaRegistro = cadenaRegistro.substring(0, cadenaRegistro.length());//elimina el salto de linea final;
				FileWriter fw = new FileWriter(archivo);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(cadenaRegistro);
				bw.close();
				centinela = true;
			} catch (FileNotFoundException e) {
				centinela = false;
				e.printStackTrace();
			} catch (IOException e) {
				centinela = false;
				e.printStackTrace();
			}
		return centinela;
	}
	public String listarTodosLasHabitaciones() {
		String entrada = "";
		String salida = "";
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			while ((entrada = br.readLine())!=null) {
				salida = salida + entrada + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return salida;
	}
	public boolean eliminarHabitacion(String nombre) {
		boolean centinela = false;
		String cadenaRegistro = "";
		String cadena = "";
			try {
				FileReader fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);
				String saltoDeLinea = "\n";
				while ((cadena = br.readLine()) !=null) {
					String arreglo[] = cadena.split(";");
					if (!arreglo[1].equals(nombre)) {
						cadenaRegistro = cadenaRegistro + cadena + saltoDeLinea;
					}
				}
				cadenaRegistro = cadenaRegistro.substring(0, cadenaRegistro.length());//elimina el salto de linea final;
				FileWriter fw = new FileWriter(archivo);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(cadenaRegistro);
				bw.close();
				centinela = true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return centinela;
	}
}