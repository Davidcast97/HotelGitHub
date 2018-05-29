package logica.Reservas;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Titular extends Persona {
	private String ciudadDeOrigen;
	private String nacionalidad;
	private String correoElectronico;
	private String ocupacion;
	private ArrayList<Acompanante> misAcompanantes;

	public Titular(String nombre, String identificacion, GregorianCalendar fechaDeNacimiento, String telefono,	boolean mayorDeEdad, String ciudadDeOrigen, String nacionalidad, String correoElectronico,String ocupacion) {
		
		super(nombre, identificacion, fechaDeNacimiento, telefono, mayorDeEdad);
		this.ciudadDeOrigen = ciudadDeOrigen;
		this.nacionalidad = nacionalidad;
		this.correoElectronico = correoElectronico;
		this.ocupacion = ocupacion;
		misAcompanantes = new ArrayList<Acompanante>();
	}

	public boolean agregarAcompanantes(Acompanante miAcompanante) {
		boolean centinela = true;
		if (misAcompanantes.size() == 0) {
			misAcompanantes.add(miAcompanante);
		} else {
			String idAcompanante = miAcompanante.getIdentificacion();
			for (int i = 0; i < misAcompanantes.size() && centinela == true; i++) {
				String idActual = misAcompanantes.get(i).getIdentificacion();
				if (idActual.equals(idAcompanante)) {
					centinela = false;
				}
			}
			if (centinela == true) {
				misAcompanantes.add(miAcompanante);
			}
		}
		return centinela;
	}

	public String getCiudadDeOrigen() {
		return ciudadDeOrigen;
	}

	public void setCiudadDeOrigen(String ciudadDeOrigen) {
		this.ciudadDeOrigen = ciudadDeOrigen;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
}
