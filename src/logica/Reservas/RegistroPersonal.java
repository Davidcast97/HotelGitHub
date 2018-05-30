package logica.Reservas;
import java.util.ArrayList;
import java.util.GregorianCalendar;
public class RegistroPersonal {
	private int id;
	private GregorianCalendar checkIn;
	private GregorianCalendar checkOut;
	private Titular miPersonaTitular;
	private ArrayList<Habitacion> misHabitaciones;
	public RegistroPersonal(int id, GregorianCalendar checkIn,GregorianCalendar checkOut, Titular miPersonaTitular,ArrayList<Habitacion> misHabitaciones) {
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.miPersonaTitular = miPersonaTitular;
		this.misHabitaciones = misHabitaciones;
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
	public Titular getMiPersonaTitular() {
		return miPersonaTitular;
	}
	public void setMiPersonaTitular(Titular miPersonaTitular) {
		this.miPersonaTitular = miPersonaTitular;
	}
	public ArrayList<Habitacion> getMisHabitaciones() {
		return misHabitaciones;
	}
	public void setMisHabitaciones(ArrayList<Habitacion> misHabitaciones) {
		this.misHabitaciones = misHabitaciones;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
