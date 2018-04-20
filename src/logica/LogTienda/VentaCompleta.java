package logica.LogTienda;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import logica.Habitacion;;

public class VentaCompleta {
	private String fecha;
	private int precioTotal;
	private boolean debe;
	private String miHabitacion;
	
	private ArrayList<VentaParcial> misVentasParciales;
	
	public VentaCompleta( ArrayList<VentaParcial> mis,boolean debe,String hab) {
		misVentasParciales = mis;
		precioTotal = 0;
		for (int i = 0; i < misVentasParciales.size(); i++) {
			precioTotal+=misVentasParciales.get(i).getPrecioVenta();
		}
		this.debe = debe;
		miHabitacion = hab;
		GregorianCalendar fecha = new GregorianCalendar();
		this.fecha = fecha.getTime().toString();
	}
	

	public ArrayList<VentaParcial> getMisVentasParciales() {
		return misVentasParciales;
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
