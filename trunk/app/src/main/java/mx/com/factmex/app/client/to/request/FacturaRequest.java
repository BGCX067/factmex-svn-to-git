package mx.com.factmex.app.client.to.request;

import java.io.Serializable;
import java.util.ArrayList;

import mx.com.factmex.app.client.to.model.Concepto;
import mx.com.factmex.app.client.to.model.Retencion;
import mx.com.factmex.app.client.to.model.Traslado;
import mx.com.factmex.app.client.util.ConvertUtil;


public class FacturaRequest extends Request  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8860586116903829053L;
	private String cliente;
	private String nuevoNombre;
	public String getIdTipoPago() {
		return idTipoPago;
	}
	public void setIdTipoPago(String idTipoPago) {
		this.idTipoPago = idTipoPago;
	}
	public String getParcialidad() {
		return parcialidad;
	}
	public void setParcialidad(String parcialidad) {
		this.parcialidad = parcialidad;
	}
	public String getTotalParcialidades() {
		return totalParcialidades;
	}
	public void setTotalParcialidades(String totalParcialidades) {
		this.totalParcialidades = totalParcialidades;
	}
	public String getNuevoNombre() {
		return nuevoNombre;
	}
	public void setNuevoNombre(String nuevoNombre) {
		this.nuevoNombre = nuevoNombre;
	}
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
	private String idSerie;
	private String idTipoPago;
	private String parcialidad = "";
	private String totalParcialidades = "";
	
	
	public String getIdSerie() {
		return idSerie;
	}
	public void setIdSerie(String idSerie) {
		this.idSerie = idSerie;
	}
	private ArrayList<Concepto> conceptos = new ArrayList<Concepto>();
	public void addConcepto(Concepto concepto) {
		conceptos.add(concepto);
	}
	private ArrayList<Retencion> retenciones = new ArrayList<Retencion>();
	public void addRetencion(Retencion retencion) {
		retenciones.add(retencion);
	}
	private ArrayList<Traslado> traslados = new ArrayList<Traslado>();
	public void addTraslado(Traslado traslado) {
		traslados.add(traslado);
	}	
	public FacturaRequest(String service, String method) {
		super(service, method);
	}
	public FacturaRequest(){
		
	}
	
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
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public ArrayList<Concepto> getConceptos() {
		return conceptos;
	}
	public ArrayList<Retencion> getRetenciones() {
		return retenciones;
	}
	public ArrayList<Traslado> getTraslados() {
		return traslados;
	}
	
	public double getSubtotal(){
		double subtotal = 0;
		for(Concepto concepto : getConceptos()){
			subtotal += ConvertUtil.redondear(new Double(concepto.getImporte()),6);
		}
		return subtotal;
	}
	
	public double getRetencionISR(){
		double retencionISR = 0.00;
		for(Retencion retencion : getRetenciones()){
			if(retencion.getImpuesto().equals("ISR")){
				retencionISR += ConvertUtil.redondear(new Double(retencion.getImporte(getSubtotal())),6);
			}
		}
		return retencionISR;
	}
	
	public double getRetencionIVA(){
		double retencionIVA = 0.00;
		for(Retencion retencion : getRetenciones()){
			if(retencion.getImpuesto().equals("IVA")){
				retencionIVA += ConvertUtil.redondear(new Double(retencion.getImporte(getSubtotal())),6);
			}
		}
		return retencionIVA;
	}
	
	public double getTrasladoIEPS(){
		double trasladoIEPS = 0.00;
		for(Traslado traslado : getTraslados()){
			if(traslado.getImpuesto().equals("IEPS")){
				trasladoIEPS += ConvertUtil.redondear(new Double(traslado.getImporte(getSubtotal())),6);
			}
		}
		return trasladoIEPS;
	}
	
	public double getTrasladoIVA(){
		double trasladoIVA = 0.00;
		for(Traslado traslado : getTraslados()){
			if(traslado.getImpuesto().equals("IVA")){
				trasladoIVA += ConvertUtil.redondear(new Double(traslado.getImporte(getSubtotal())),6);
			}
		}
		return trasladoIVA;
	}
	
	public double getTotal(){
		double subtotal = getSubtotal();
		double total = subtotal;
		for(Traslado traslado : getTraslados()){
			total += ConvertUtil.redondear(new Double(traslado.getImporte(subtotal)),6);
		}
		
		for(Retencion retencion : getRetenciones()){
			total -= ConvertUtil.redondear(new Double(retencion.getImporte(subtotal)),6);
		}
		
		return total;
	}
}
