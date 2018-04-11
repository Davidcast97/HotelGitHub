package logica;
import java.util.GregorianCalendar;
public class RegistroPersonal {
	private GregorianCalendar checkIn;
	private GregorianCalendar checkOut;
	private String miIdPersonaTitular;
	private Habitacion miHabitacion;
	public RegistroPersonal(GregorianCalendar checkIn,GregorianCalendar checkOut, String miIdPersonaTitular, Habitacion miHabitacion) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.miIdPersonaTitular = miIdPersonaTitular;
		this.miHabitacion = miHabitacion;
	}
	public GregorianCalendar getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(GregorianCalendar checkIn) {
		this.checkIn = checkIn;
	}
	public GregorianCalendar getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(GregorianCalendar checkOut) {
		this.checkOut = checkOut;
	}
	public String getMiIdPersonaTitular() {
		return miIdPersonaTitular;
	}
	public void setMiIdPersona(String miIdPersonaTitular) {
		this.miIdPersonaTitular = miIdPersonaTitular;
	}
	public Habitacion getMiHabitacion() {
		return miHabitacion;
	}
	public void setMiHabitacion(Habitacion miHabitacion) {
		this.miHabitacion = miHabitacion;
	}
}
