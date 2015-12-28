package mx.com.factmex.app.client.to.response;

import java.util.ArrayList;
import java.util.List;

import mx.com.factmex.app.client.to.model.Cliente;

public class ListClientesResponse extends Response {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4021585320563086251L;
	List<Cliente> clientes = new ArrayList<Cliente>();

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}
