/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.cfdv2;

/**
 *
 * @author Jonathan
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"comprobante", "datosFacture"})
@XmlRootElement(name="Facture")
public class Facture
{

  @XmlElement(name="Comprobante", required=true)
  protected Comprobante comprobante;

  @XmlElement(name="DatosFacture", required=true)
  protected DatosFacture datosFacture;

  public Comprobante getComprobante()
  {
    return this.comprobante;
  }

  public void setComprobante(Comprobante value)
  {
    this.comprobante = value;
  }

  public DatosFacture getDatosFacture()
  {
    return this.datosFacture;
  }

  public void setDatosFacture(DatosFacture value)
  {
    this.datosFacture = value;
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name="", propOrder={"urlArchivoCertificado", "passLlavePrivada", "urlArchivoLlavePrivada", "urlArchivoFacturaSalida", "urlImangenPdf", "urlJXMLPDF", "urlJprint"})
  public static class DatosFacture
  {

    @XmlElement(required=true)
    protected String urlArchivoCertificado;

    @XmlElement(required=true)
    protected String passLlavePrivada;

    @XmlElement(required=true)
    protected String urlArchivoLlavePrivada;

    @XmlElement(required=true)
    protected String urlArchivoFacturaSalida;

    @XmlElement(name="url_ImangenPdf")
    protected String urlImangenPdf;

    @XmlElement(name="urlJXML_PDF")
    protected String urlJXMLPDF;
    protected String urlJprint;

    public String getUrlArchivoCertificado()
    {
      return this.urlArchivoCertificado;
    }

    public void setUrlArchivoCertificado(String value)
    {
      this.urlArchivoCertificado = value;
    }

    public String getPassLlavePrivada()
    {
      return this.passLlavePrivada;
    }

    public void setPassLlavePrivada(String value)
    {
      this.passLlavePrivada = value;
    }

    public String getUrlArchivoLlavePrivada()
    {
      return this.urlArchivoLlavePrivada;
    }

    public void setUrlArchivoLlavePrivada(String value)
    {
      this.urlArchivoLlavePrivada = value;
    }

    public String getUrlArchivoFacturaSalida()
    {
      return this.urlArchivoFacturaSalida;
    }

    public void setUrlArchivoFacturaSalida(String value)
    {
      this.urlArchivoFacturaSalida = value;
    }

    public String getUrlImangenPdf()
    {
      return this.urlImangenPdf;
    }

    public void setUrlImangenPdf(String value)
    {
      this.urlImangenPdf = value;
    }

    public String getUrlJXMLPDF()
    {
      return this.urlJXMLPDF;
    }

    public void setUrlJXMLPDF(String value)
    {
      this.urlJXMLPDF = value;
    }

    public String getUrlJprint()
    {
      return this.urlJprint;
    }

    public void setUrlJprint(String value)
    {
      this.urlJprint = value;
    }
  }
}