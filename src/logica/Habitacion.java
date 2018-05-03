package logica;

public class Habitacion {
	private String nombre;
	private Tarifa tarifa;
	private boolean estado;
	public Habitacion(String nombre, Tarifa tarifa, boolean estado) {
		this.nombre = nombre;
		this.tarifa = tarifa;
		this.estado = estado;
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
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
