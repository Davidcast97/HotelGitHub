package logica.Reservas;

import java.util.ArrayList;

public class Reserva {
	private int id;
	private RegistroPersonal miRegistroPersonal;
	private double facturar;
	private double deposito;
	private double gastosAdicionales;
	public Reserva(RegistroPersonal miRegistroPersonal,  double facturar,
			double deposito, double gastosAdicionales) {
		this.id = miRegistroPersonal.getId();
		this.miRegistroPersonal = miRegistroPersonal;
		this.facturar = facturar;
		this.deposito = deposito;
		this.gastosAdicionales = gastosAdicionales;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public RegistroPersonal getMiRegistroPersonal() {
		return miRegistroPersonal;
	}
	public void setMiRegistroPersonal(RegistroPersonal miRegistroPersonal) {
		this.miRegistroPersonal = miRegistroPersonal;
	}
	public double getFacturar() {
		return facturar;
	}
	public void setFacturar(double facturar) {
		this.facturar = facturar;
	}
	public double getDeposito() {
		return deposito;
	}
	public void setDeposito(double deposito) {
		this.deposito = deposito;
	}
	public double getGastosAdicionales() {
		return gastosAdicionales;
	}
	public void setGastosAdicionales(double gastosAdicionales) {
		this.gastosAdicionales = gastosAdicionales;
	}
}
