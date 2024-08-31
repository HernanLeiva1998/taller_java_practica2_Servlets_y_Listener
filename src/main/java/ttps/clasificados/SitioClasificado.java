package ttps.clasificados;

public class SitioClasificado {

	String nombre;
	String email;
	String telefono;
	
	public SitioClasificado() {}
	
	public SitioClasificado(String nombre, String email, String telefono) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
