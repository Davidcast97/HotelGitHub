package logica;

public class Empleado {

	private String nombre;
	private String cedula;
	private String telefono;
	private String contraseña;
	private String login;

	public Empleado(String nombre, String cedula, String telefono, String contraseña, String login) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.telefono = telefono;
		this.contraseña = contraseña;
		this.login = login;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
