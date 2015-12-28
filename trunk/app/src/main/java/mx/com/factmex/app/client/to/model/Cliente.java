package mx.com.factmex.app.client.to.model;

import java.io.Serializable;

public class Cliente implements Serializable{

	private static final long serialVersionUID = -3714700119638374642L;
	public Cliente(){
		
	}
	private int idCliente;
	private String nombre;
	private String rfc;
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
}
