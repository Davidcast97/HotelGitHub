package logica.Reservas;

import java.util.GregorianCalendar;

public class Acompanante extends Persona{
	private Titular miTitular;
	public Acompanante(String nombre, String identificacion, GregorianCalendar fechaDeNacimiento, String telefono, boolean mayorDeEdad, Titular miTitular) {
		super(nombre, identificacion, fechaDeNacimiento, telefono, mayorDeEdad);
		this.miTitular = miTitular;
	}
	public Titular getMiTitular() {
		return miTitular;
	}
	public void setMiTitular(Titular miTitular) {
		this.miTitular = miTitular;
	}
}
