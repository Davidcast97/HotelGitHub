package logica.LogTienda;

import java.awt.Checkbox;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

//import base_datos.ConexionTienda;
import logica.Habitacion;
import logica.LogTienda.VentaParcial;
import logica.LogTienda.VentaCompleta;

public class Tienda {
	
	private ArrayList<Producto> misProductos;
	private ArrayList<VentaCompleta> misVentasCompletas;
	private ArrayList<VentaParcial> misVentasParciales;  
	private String[] categorias;
	//private ConexionTienda ConTienda;
	private archivoTienda archT;
	
	public Tienda(){
		String c[] = {"BEBIDAS" ,"SOLIDOS","LICORES","ASEO"};
		categorias = c;
		misProductos = new ArrayList<Producto>();
		
		archT = new archivoTienda();
		//ConTienda = new ConexionTienda(); 
		//misProductos = ConTienda.getMisProd();
		misProductos = archT.getMisProd();
			
		
		misVentasCompletas = new ArrayList<VentaCompleta>();
		misVentasParciales = new ArrayList<VentaParcial>();
	}
	
	public int crearVentaCompleta(String hab){
		String descripcion = "";
		for(VentaParcial v:misVentasParciales) {
			for(Producto p: misProductos) {
				if (v.getMiProducto().equals(p)) {
					int c = p.getCantidad()-v.getCantidad();
					p.setCantidad(c);
					//ConTienda.actualizarInventarioProducto(c, p.getNombre());
					descripcion+=p.getNombre()+": "+p.getCantidad()+" ! ";
				}
			}
		}
		VentaCompleta vc = new VentaCompleta(misVentasParciales,hab,descripcion.substring(0,descripcion.length()-2));
		//ConTienda.guardarVentaCompleta(vc);
		archT.setMisProd(misProductos);
		misVentasCompletas.add(vc);
		misVentasParciales= new ArrayList<VentaParcial>();
		return vc.getPrecioTotal();
	}


	public ArrayList<Producto> getMisProductos() {
		
		return misProductos;
	}
	
	public Object[] getListaNombresProductosOrdenadosPorCategoria() {
		
		ArrayList<String> prodOrdenados = new ArrayList<String>();		
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
	
	public void reiniciarVentasParciales() {
		misVentasParciales.clear();
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
