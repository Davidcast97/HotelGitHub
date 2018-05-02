package logica;

import java.util.ArrayList;

public class RegistroHistorial {
	private ArrayList<RegistroPersonal> misRegistros;
	public RegistroHistorial() {
		misRegistros = new ArrayList<RegistroPersonal>();
	}
	public boolean agregarNuevoRegistro(RegistroPersonal miRegistro) {
		boolean control = true;
		if(misRegistros.size()==0) {
			misRegistros.add(miRegistro);
		}else {
			for (int i = 0; i < misRegistros.size() && control == true; i++) {
				if(miRegistro.getId() == misRegistros.get(i).getId()) {
					control = false;
				}
			}
			if(control == true) {
				misRegistros.add(miRegistro);
			}
		}
		return control;
	}
	public ArrayList<RegistroPersonal> getMisRegistros() {
		return misRegistros;
	}
	public void setMisRegistros(ArrayList<RegistroPersonal> misRegistros) {
		this.misRegistros = misRegistros;
	}
}
