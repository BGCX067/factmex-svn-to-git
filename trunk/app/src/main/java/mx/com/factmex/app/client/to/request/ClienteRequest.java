package mx.com.factmex.app.client.to.request;

import com.google.gwt.http.client.Request;

public class ClienteRequest extends Request {
	private String rfc;
	private String calle;
	private String noExt;
	private String noInt;
	private String colonia;
	private String localidad;
	private String referencia;
	private String municipio;
	private String estado;
	private String pais;
	private String cp;
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNoExt() {
		return noExt;
	}
	public void setNoExt(String noExt) {
		this.noExt = noExt;
	}
	public String getNoInt() {
		return noInt;
	}
	public void setNoInt(String noInt) {
		this.noInt = noInt;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
}
