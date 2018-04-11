package logica;

import java.util.ArrayList;

public class RegistroHistorial {
	private ArrayList<RegistroPersonal> misRegistros;
	public RegistroHistorial(ArrayList<RegistroPersonal> misRegistros) {
		this.misRegistros = misRegistros;
	}
	public ArrayList<RegistroPersonal> getMisRegistros() {
		return misRegistros;
	}
	public void setMisRegistros(ArrayList<RegistroPersonal> misRegistros) {
		this.misRegistros = misRegistros;
	}
}
