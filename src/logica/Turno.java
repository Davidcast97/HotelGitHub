package logica;

import java.io.File;

public class Turno {

	private long gasto;
	private long base= 200000;
	private int id, horaEntrada, horaSalida;

	public Turno(long gasto, int horaEntrada, int horaSalida, int id, Recepcionista miRecepcionista) {

		gasto = this.gasto;
		horaEntrada = this.horaEntrada;
		horaSalida = this.horaSalida;
		id = this.id;
		
	}

	public void GenerarGasto() {
		
	}

	public long getBase() {
		return base;
	}

	public void setBase(long base) {
		this.base = base;
	}

	public long getGasto() {
		return gasto;
	}

	public int getId() {
		return id;
	}

	public int getHoraEntrada() {
		return horaEntrada;
	}

	public int getHoraSalida() {
		return horaSalida;
	}

}
