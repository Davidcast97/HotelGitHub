package logicaAlmacenar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import logica.Reservas.RegistroPersonal;
import logica.Reservas.Reserva;

public class AlmacenarReserva {
	private String archivo;

	public AlmacenarReserva() {
		archivo = "src//Data//habitaciones.txt";

		if (!(new File(archivo).exists())) {
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
				oos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean agregarReserva(Reserva miReserva) {
		boolean centinela = false;
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(archivo));
			Object aux = ois.readObject();
			while (aux != null) {
				if (aux instanceof Reserva) {
					Reserva a = (Reserva) aux;
					reservas.add(a);
				}	
				aux = ois.readObject();
			}
			ois.close();		
		} catch (EOFException e) {
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
			for(Reserva a:reservas) {
				oos.writeObject(a);
			}
			oos.writeObject(miReserva);
			oos.close();
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return centinela;
	}
	public Reserva BuscarAsignatura(int id) {
		try {
			if (new File(archivo).exists()) {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
				Object aux = ois.readObject();

				while (aux != null) {
					if (aux instanceof Reserva) {
						if (id == (((Reserva) aux).getId())) {
							ois.close();
							return (Reserva) aux;
						}
					}
					aux = ois.readObject();
				}
				ois.close();
			}

		} catch (EOFException e1) {
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return null;
	}
	
	public boolean editarReserva(Reserva miReserva) {
		boolean centinela = false;
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(archivo));
			Object aux = ois.readObject();
			while (aux != null) {
				if (aux instanceof Reserva) {
					Reserva a = (Reserva) aux;
					if (a.getId()!=(miReserva.getId())) {
						reservas.add(a);	
					}
				}
				aux = ois.readObject();
			}
			ois.close();
		} catch (EOFException e) {
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
			for (Reserva a: reservas) {
				oos.writeObject(a);
			}
			oos.writeObject(miReserva);
			oos.close();
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return centinela;
	}

	public String listarTodosLasReservas() {
		String salida = "";
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
			Object aux = ois.readObject();
			while (aux != null) {
				if (aux instanceof Reserva) {
					Reserva a = (Reserva) aux;
					salida += a.getId() + " " + a.getFacturar() +"\n\r";
				}
				aux = ois.readObject();
			}
			ois.close();
		} catch (EOFException e) {
		} catch (Exception e) {
		}
		return salida;
	}

	public boolean eliminarReserva(int id) {
		boolean centinela = false;
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(archivo));
			Object aux = ois.readObject();
			while (aux != null) {
				if (aux instanceof Reserva) {
					Reserva a = (Reserva) aux;
					if (a.getId() != id ) {
						reservas.add(a);	
					}				
					
				}
				aux = ois.readObject();
			}
			ois.close();
			
		} catch (EOFException e) {
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
			for(Reserva a: reservas) {
				oos.writeObject(a);
			}
			oos.close();
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return centinela;
	}
}