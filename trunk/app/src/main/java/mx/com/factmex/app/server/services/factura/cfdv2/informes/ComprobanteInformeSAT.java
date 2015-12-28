package mx.com.factmex.app.server.services.factura.cfdv2.informes;

import mx.com.factmex.app.server.services.factura.cfdv2.Comprobante;
import mx.com.factmex.app.server.services.factura.cfdv2.TInformacionAduanera;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class ComprobanteInformeSAT
{
  public static final byte COMPROBANTE_CANCELADO = 0;
  public static final byte COMPROBANTE_VIGENTE = 1;
  private String rfc;
  private String serie;
  private BigInteger folio;
  private BigInteger noAprobacion;
  private Date fecha;
  private BigDecimal montoOperacion;
  private BigDecimal montoImpuesto;
  private short estado;
  private Date fechaAprobacion;
  private String tipoComprobante;
  private String pedimento;
  private String fechaPedimento;
  private String aduana;
  Comprobante.Conceptos.Concepto concepto;
  Comprobante.Conceptos conceptos;
  List conceptoLst;
  TInformacionAduanera infoAduana;

  public ComprobanteInformeSAT(String rfc, String serie, BigInteger folio, BigInteger noAprobacion, Date fechaAprobacion, Date fechaComprobante, BigDecimal montoOperacion, BigDecimal montoImpuesto, short estado)
  {
  }

  public ComprobanteInformeSAT(Comprobante comprobante, short estado)
  {
    if (comprobante != null) {
      this.rfc = comprobante.getEmisor().getRfc();
      this.folio = new BigInteger(comprobante.getFolio());
      comprobante.getNoAprobacion();
      this.fechaAprobacion = new GregorianCalendar(comprobante.getAnoAprobacion().intValue(), 1, 1).getTime();
      this.fecha = comprobante.getFechaToDate();
      this.montoOperacion = comprobante.getSubTotal();
      this.noAprobacion = comprobante.getNoAprobacion();
      this.setEstado(estado);
      this.setSerie(comprobante.getSerie());
      setTipoComprobante(comprobante.getTipoDeComprobante());
      setTipoComprobante(getTipoComprobante().substring(0,1).toUpperCase());
      this.conceptos = comprobante.getConceptos();
      this.conceptoLst = this.conceptos.getConcepto();
      int cantConceptos = this.conceptoLst.size();
      for (int j = 0; j < cantConceptos; j++) {
          this.concepto = ((Comprobante.Conceptos.Concepto) this.conceptoLst.get(j));
          if(concepto.getInformacionAduanera()!=null){
        	  infoAduana = (TInformacionAduanera) concepto.getInformacionAduanera();
              if(pedimento.equals("")||pedimento==null){
            	  pedimento = infoAduana.getNumero();
              }else{
            	  pedimento = pedimento+","+pedimento;
              }
              if(fechaPedimento.equals("")||fechaPedimento==null){
            	  fechaPedimento = infoAduana.getFecha().toString();
              }else{
            	  fechaPedimento = fechaPedimento+","+fechaPedimento;
              }
              if(aduana.equals("")||aduana==null){
            	  aduana = infoAduana.getAduana();
              }else{
            	  aduana = aduana+","+aduana;
              }
          }else{
        	  pedimento="";
        	  fechaPedimento="";
        	  aduana="";
          }
      }
      this.montoImpuesto = null;
      if ((comprobante.getImpuestos() != null) && (comprobante.getImpuestos().getTotalImpuestosTrasladados() != null))
        this.montoImpuesto = comprobante.getImpuestos().getTotalImpuestosTrasladados();
    }
  }

  public short getEstado()
  {
    return this.estado;
  }

  public void setEstado(short estado)
  {
    this.estado = estado;
  }

  public Date getFecha()
  {
    return this.fecha;
  }

  public String getFechaToString()
  {
    SimpleDateFormat formatoFecha = formatoFecha = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    return formatoFecha.format(this.fecha);
  }

  public void setFecha(Date fecha)
  {
    this.fecha = fecha;
  }

  public BigInteger getFolio()
  {
    return this.folio;
  }

  public void setFolio(BigInteger folio)
  {
    this.folio = folio;
  }

  public BigDecimal getMontoImpuesto()
  {
    return this.montoImpuesto;
  }

  public void setMontoImpuesto(BigDecimal montoImpuesto)
  {
    this.montoImpuesto = montoImpuesto;
  }

  public BigDecimal getMontoOperacion()
  {
    return this.montoOperacion;
  }

  public void setMontoOperacion(BigDecimal montoOperacion)
  {
    this.montoOperacion = montoOperacion;
  }

  public BigInteger getNoAprobacion()
  {
    return this.noAprobacion;
  }

  public String getNoAprobacionToString()
  {
    SimpleDateFormat formatoFecha = formatoFecha = new SimpleDateFormat("yyyy");
    return formatoFecha.format(this.fechaAprobacion) + this.noAprobacion;
  }

  public void setNoAprobacion(BigInteger noAprobacion, Date fechaAprobacion)
  {
    this.noAprobacion = noAprobacion;
    this.fechaAprobacion = fechaAprobacion;
  }

  public String getRFC()
  {
    return this.rfc;
  }

  public void setRFC(String rfc)
  {
    this.rfc = rfc;
  }

  public String getSerie()
  {
    return this.serie;
  }

  public void setSerie(String serie)
  {
    this.serie = serie;
  }

public void setTipoComprobante(String tipoComprobante) {
	this.tipoComprobante = tipoComprobante;
}

public String getTipoComprobante() {
	return tipoComprobante;
}

public void setPedimento(String pedimento) {
	this.pedimento = pedimento;
}

public String getPedimento() {
	return pedimento;
}

public void setAduana(String aduana) {
	this.aduana = aduana;
}

public String getAduana() {
	return aduana;
}

public void setFechaPedimento(String fechaPedimento) {
	this.fechaPedimento = fechaPedimento;
}

public String getFechaPedimento() {
	return fechaPedimento;
}
}

