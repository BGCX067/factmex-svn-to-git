package mx.com.factmex.app.client.to.request;


public class ValidaUsuarioRequest extends Request {

	public ValidaUsuarioRequest() {
		super();
	}
	public ValidaUsuarioRequest(String service, String method) {
		super(service, method);
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIdEmisor() {
		return idEmisor;
	}
	public void setIdEmisor(int idEmisor) {
		this.idEmisor = idEmisor;
	}
	private String usuario;
	private String password;
	private int idEmisor;
	
}
