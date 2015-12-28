package mx.com.factmex.app.client.to.model;

import java.io.Serializable;

public class Traslado implements Serializable {
	private String impuesto;
	private String tasa;
	private String importe;
	public String getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(String impuesto) {
		this.impuesto = impuesto;
	}
	public String getTasa() {
		return tasa;
	}
	public void setTasa(String tasa) {
		this.tasa = tasa;
	}
	public String getImporte(double subtotal) {
		return new Double(new Double(tasa)/100 * subtotal).toString();
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
}
