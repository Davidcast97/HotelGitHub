package logica;

public class Producto {
	private String nombre;
	private int precio;
	private int cantidad;
	
	public Producto(String nombre, int precio, int cantidad) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getNombre() {
		return nombre;
	}


	public int getPrecio() {
		return precio;
	}


	public int getCantidad() {
		return cantidad;
	}
	
}
