package logica.Reservas;

import java.util.GregorianCalendar;

public class Persona {
	private String nombre;
	private String identificacion;
	private GregorianCalendar fechaDeNacimiento;
	private String telefono;
	private boolean mayorDeEdad;
	public Persona(String nombre, String identificacion, GregorianCalendar fechaDeNacimiento, String telefono, boolean mayorDeEdad) {
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.telefono = telefono;
		this.mayorDeEdad = mayorDeEdad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public GregorianCalendar getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(GregorianCalendar fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public boolean isMayorDeEdad() {
		return mayorDeEdad;
	}
	public void setMayorDeEdad(boolean mayorDeEdad) {
		this.mayorDeEdad = mayorDeEdad;
	}
}
