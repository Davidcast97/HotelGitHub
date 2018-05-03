package logica.LogTienda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.processing.Filer;

public class archivoTienda {
	private String miArchivo;
	private ArrayList<Producto> misProd;
	private File f;
	
	public archivoTienda() {
		this.miArchivo = "productos.txt";
		this.misProd = new ArrayList<Producto>();
		f = new File(miArchivo);
		if (!(f.exists())) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String getMiArchivo() {
		return miArchivo;
	}
	public void setMiArchivo(String miArchivo) {
		this.miArchivo = miArchivo;
	}
	public ArrayList<Producto> getMisProd() {
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String c = "";
			while ((c= br.readLine())!=null) {
				String[] l  = c.split(",");
				int precio = Integer.parseInt(l[1]);
				int cant = Integer.parseInt(l[2]);
				int cate= Integer.parseInt(l[3]);
				Producto p = new Producto(l[0], precio , cant, cate);
				misProd.add(p);
			}
			br.close();
		}catch (EOFException e) {
			System.out.println("Fin de lectura");
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return misProd;
	}
	
	
	public void setMisProd(ArrayList<Producto> misProd) {
		this.misProd = misProd;
		
		try {
			FileWriter fw= new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Producto producto : misProd) {
				String c = producto.getNombre()+","+producto.getPrecio()+","+producto.getCantidad()+","+producto.getCategoria();
				bw.write(c);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
