package logica.LogTienda;

import java.awt.Checkbox;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import logica.Habitacion;
import logica.LogTienda.VentaParcial;
import logica.LogTienda.VentaCompleta;

public class Tienda {
	
	private ArrayList<Producto> misProductos;
	private ArrayList<VentaCompleta> misVentasCompletas;
	private ArrayList<VentaParcial> misVentasParciales;  
	private String[] categorias;
	
	public Tienda(){
		String c[] = {"BEBIDAS" ,"SOLIDOS","LICORES","ASEO"};
		categorias = c;
		misProductos = new ArrayList<Producto>();
		
		//AGREGAR ALGUNOS PRODUCTOS A LA TIENDA
		Producto prod1 = new Producto("Agua Grande", 2500, 9,1);
		Producto prod10 = new Producto("Agua pequeña", 2000, 9,1);
		Producto prod2 = new Producto("Vive 100", 3000, 14,1);
		Producto prod3 = new Producto("Papitas", 2000, 19,2);
		Producto prod4 = new Producto("Gaseosa", 2000, 5,1);
		Producto prod5 = new Producto("Chocolatina pequeña",800 , 5,2);
		Producto prod6 = new Producto("Chocolatina mediana", 2000 , 5,2);
		Producto prod7= new Producto("Chocolatina grande", 3000, 5,2);
		Producto prod8 = new Producto("Mani", 2000, 5,2);
		misProductos.add(prod1);
		misProductos.add(prod10);
		misProductos.add(prod2);
		misProductos.add(prod3);
		misProductos.add(prod4);
		misProductos.add(prod5);
		misProductos.add(prod6);
		misProductos.add(prod7);
		misProductos.add(prod8);
		
		
		
		misVentasCompletas = new ArrayList<VentaCompleta>();
		misVentasParciales = new ArrayList<VentaParcial>();
	}
	
	public int crearVentaCompleta(){
		VentaCompleta vc = new VentaCompleta(misVentasParciales,false,null);
		
		for(VentaParcial v:misVentasParciales) {
			for(Producto p: misProductos) {
				if (v.getMiProducto().equals(p)) {
					p.setCantidad(p.getCantidad()-v.getCantidad());
				}
			}
		}
		misVentasCompletas.add(vc);
		misVentasParciales= new ArrayList<VentaParcial>();
		return vc.getPrecioTotal();
	}
	
	public int crearVentaCompleta(String hab){
		VentaCompleta vc = new VentaCompleta(misVentasParciales,true,hab);
		for(VentaParcial v:misVentasParciales) {
			for(Producto p: misProductos) {
				if (v.getMiProducto().equals(p)) {
					p.setCantidad(p.getCantidad()-v.getCantidad());
				}
			}
		}
	
		misVentasCompletas.add(vc);
		misVentasParciales= new ArrayList<VentaParcial>();
		return vc.getPrecioTotal();
	}


	public ArrayList<Producto> getMisProductos() {
		
		return misProductos;
	}
	public Object[] getListaNombresProductosOrdenadosPorCategoria() {
		
		ArrayList<String> prodOrdenados = new ArrayList<String>();
		
		Font negrita = new Font("Arial", Font.BOLD, 14);
		
		for (int i = 0; i < categorias.length; i++) {
			prodOrdenados.add(categorias[i]+"\n\r");
			for (Producto c: misProductos) {
				
				if (i+1==c.getCategoria()) {
					prodOrdenados.add(c.getNombre());
				}				
			}
		}
		Object[] listaNombres = prodOrdenados.toArray();
		return listaNombres;
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

	public Producto buscarProducto(String selectedValue) {
		for(Producto p:misProductos) {
			if (p.getNombre().equals(selectedValue)) {
				return p;
			}
		}
		return null;
	}
	
	
	
}
