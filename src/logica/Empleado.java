package logica;

public class Empleado {

	private String nombre;
	private String cedula;
	private String telefono;
	private String contrasena;
	private String login;

	public Empleado(String nombre, String cedula, String telefono, String contrasena, String login) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.telefono = telefono;
		this.contrasena = contrasena;
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

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
