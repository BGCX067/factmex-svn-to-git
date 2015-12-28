package mx.com.factmex.app.client.to.model;

import java.io.Serializable;

public class Factura implements Serializable{

	private static final long serialVersionUID = -3714700119638374642L;
	public Factura(){
		
	}
	
	private int idComprobante;
	private int folio;
	private String fecha;
	private String facturado;
	private double monto;
	public int getIdComprobante() {
		return idComprobante;
	}
	public void setIdComprobante(int idComprobante) {
		this.idComprobante = idComprobante;
	}
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getFacturado() {
		return facturado;
	}
	public void setFacturado(String facturado) {
		this.facturado = facturado;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
}
