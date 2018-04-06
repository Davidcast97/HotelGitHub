package logica;

import java.util.ArrayList;

public class VentaCompleta {
	private String fecha;
	private int precioTotal;
	private boolean debe;
	private Habitacion miHabitacion;
	
	private ArrayList<VentaParcial> misVentasParciales;

	public VentaCompleta(String fecha, int precioTotal, boolean debe,Habitacion hab) {
		this.fecha = fecha;
		this.precioTotal = precioTotal;
		this.debe = debe;
		miHabitacion = hab;
	}
	
	public VentaCompleta(String fecha,Habitacion hab){
		this.fecha = fecha;
		miHabitacion = hab;
	}

	

	public ArrayList<VentaParcial> getMisVentasParciales() {
		return misVentasParciales;
	}

	public void setMisVentasParciales(ArrayList<VentaParcial> misVentasParciales) {
		this.misVentasParciales = misVentasParciales;
		precioTotal = 0;
		for (int i = 0; i < misVentasParciales.size(); i++) {
			precioTotal+=misVentasParciales.get(i).getPrecioVenta();
		}
	}

	public void setDebe(boolean debe) {
		this.debe = debe;
	}

	public String getFecha() {
		return fecha;
	}

	public int getPrecioTotal() {
		return precioTotal;
	}

	public boolean isDebe() {
		return debe;
	}
	
	
	
	
}
