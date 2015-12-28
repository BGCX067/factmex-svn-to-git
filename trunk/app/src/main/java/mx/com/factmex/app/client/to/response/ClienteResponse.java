package mx.com.factmex.app.client.to.response;

import mx.com.factmex.app.client.to.model.Cliente;

public class ClienteResponse extends Response {
	public ClienteResponse(){
		cliente = new Cliente();
	}
	private Cliente cliente;
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
