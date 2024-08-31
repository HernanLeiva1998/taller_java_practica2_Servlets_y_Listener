package ttps.clasificados;

public class Usuario {
	public Usuario(String user, String password, String type) {
		super();
		this.user = user;
		this.password = password;
		this.type = type;
	}
	private String user;
	private String password;
	private String type;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
