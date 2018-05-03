package logica.LogTienda;

public class Producto {
	private String nombre;
	private int precio;
	private int cantidad;
	private int categoria;
	
	public Producto(String nombre, int precio, int cantidad, int categoria) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		
		// 1. Bebidas 2. Solidos 3. Licores 4. Aseo
		this.categoria = categoria;
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


	public int getCategoria() {

		return categoria;
	}
	
}
