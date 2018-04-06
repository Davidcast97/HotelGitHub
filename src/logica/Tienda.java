package logica;

import java.awt.Checkbox;
import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class Tienda {
	
	private ArrayList<Producto> misProductos;
	private ArrayList<VentaCompleta> misVentasCompletas;
	private ArrayList<VentaParcial> misVentasParciales;  
	
	public Tienda(){
		
		
		misProductos = new ArrayList<>();
		
		//AGREGAR ALGUNOS PRODUCTOS A LA TIENDA
		Producto prod1 = new Producto("Agua", 2500, 9);
		Producto prod2 = new Producto("Vive 100", 3000, 14);
		Producto prod3 = new Producto("Papitas", 2000, 19);
		misProductos.add(prod1);
		misProductos.add(prod2);
		misProductos.add(prod3);
		
		
		misVentasCompletas = new ArrayList<>();
		misVentasParciales = new ArrayList<>();
	}
	
	public int crearVentaCompleta(Habitacion hab,boolean debe){
		VentaCompleta vc = new VentaCompleta("Hoy", hab);
		vc.setMisVentasParciales(misVentasParciales);
		vc.setDebe(debe);
		
		misVentasCompletas = new ArrayList<>();
		return vc.getPrecioTotal();
	}

	public ArrayList<Producto> getMisProductos() {
		return misProductos;
	}

	public Object[] getListaNombresProductos() {
		Object[] listaNombres = new Object[misProductos.size()]; 
		for (int i = 0; i < misProductos.size(); i++) {
			listaNombres[i] = misProductos.get(i).getNombre();
		}
		return listaNombres;
	}

	public void guardarVentaParcial(int cantidad, int precioT, Producto producto) {
		VentaParcial vp = new VentaParcial(cantidad,precioT,producto);
		misVentasParciales.add(vp);
	}
	
	
	
}
