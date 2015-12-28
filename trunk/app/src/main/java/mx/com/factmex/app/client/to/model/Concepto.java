package mx.com.factmex.app.client.to.model;

import java.io.Serializable;

public class Concepto implements Serializable {
	private String cantidad;
	private String unidad;
	private String descripcion;
	private String valorUnitario;
	private String importe;
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}

}
