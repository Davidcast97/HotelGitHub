package logica.LogTienda;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import logica.Reservas.Habitacion;;

public class VentaCompleta {
	private String fecha;
	private int precioTotal;
	private int miHabitacion;
	private String descripcion;
	
	private ArrayList<VentaParcial> misVentasParciales;
	
	public VentaCompleta( ArrayList<VentaParcial> mis,String hab,String desc) {
		if (hab.equals("")) {
			miHabitacion=0;
		}else {
			miHabitacion=Integer.parseInt(hab);
		}
		misVentasParciales = mis;
		descripcion=desc;
		precioTotal = 0;
		for (int i = 0; i < misVentasParciales.size(); i++) {
			precioTotal+=misVentasParciales.get(i).getPrecioVenta();
		}
		
		
		Date f = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		fecha = hourdateFormat.format(f);
		
	} 
	

	public ArrayList<VentaParcial> getMisVentasParciales() {
		return misVentasParciales;
	}

	public String getFecha() {
		return fecha;
	}

	public int getMiHabitacion() {
		return miHabitacion;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public int getPrecioTotal() {
		return precioTotal;
	}

}
