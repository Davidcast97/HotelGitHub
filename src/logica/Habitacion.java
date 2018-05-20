package logica;

public class Habitacion {
	private String nombre;
	private Tarifa tarifa;
	private boolean estado;
	private int numeroCamas;
	private String detalles;
	public Habitacion(String nombre, Tarifa tarifa, boolean estado, int numeroCamas, String detalles) {
		this.nombre = nombre;
		this.tarifa = tarifa;
		this.estado = estado;
		this.numeroCamas = numeroCamas;
		this.detalles = detalles;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Tarifa getTarifa() {
		return tarifa;
	}
	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getNumeroCamas() {
		return numeroCamas;
	}
	public void setNumeroCamas(int numeroCamas) {
		this.numeroCamas = numeroCamas;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
}