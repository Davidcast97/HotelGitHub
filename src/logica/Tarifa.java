package logica;

public class Tarifa {
	private double valor;
	private String temporada;
	public Tarifa(double valor, String temporada) {
		super();
		this.valor = valor;
		this.temporada = temporada;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getTemporada() {
		return temporada;
	}
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
}
