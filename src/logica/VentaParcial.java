package logica;

public class VentaParcial {
	
	private int cantidad;
	private int precioVenta;
	private Producto miProducto;
	
	public VentaParcial(int cantidad, int precioVenta, Producto miProducto) {
		this.cantidad = cantidad;
		this.precioVenta = precioVenta;
		this.miProducto = miProducto;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public int getPrecioVenta() {
		return precioVenta;
	}
	
	public Producto getMiProducto() {
		return miProducto;
	}
	
	
}
