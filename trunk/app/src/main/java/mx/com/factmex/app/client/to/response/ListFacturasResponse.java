package mx.com.factmex.app.client.to.response;

import java.util.ArrayList;
import java.util.List;

import  mx.com.factmex.app.client.to.model.Factura;

public class ListFacturasResponse extends Response {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4021585320563086251L;
	List<Factura> facturas = new ArrayList<Factura>();

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	
}
