/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.cfdv2;

import mx.com.factmex.app.server.services.factura.cfdv2.exceptions.TUbicacionFiscalException;
/**
 *
 * @author Jonathan
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="t_UbicacionFiscal")
public class TUbicacionFiscal
{

  @XmlAttribute(required=true)
  protected String calle;

  @XmlAttribute(required=true)
  protected String codigoPostal;

  @XmlAttribute
  protected String colonia;

  @XmlAttribute(required=true)
  protected String estado;

  @XmlAttribute
  protected String localidad;

  @XmlAttribute(required=true)
  protected String municipio;

  @XmlAttribute
  protected String noExterior;

  @XmlAttribute
  protected String noInterior;

  @XmlAttribute(required=true)
  protected String pais;

  @XmlAttribute
  protected String referencia;

  public TUbicacionFiscal()
  {
  }

  public TUbicacionFiscal(String calle, String municipio, String estado, String pais, String codigoPostal)
    throws TUbicacionFiscalException
  {
    setCalle(calle);
    setMunicipio(municipio);
    setEstado(estado);
    setPais(pais);
    setCodigoPostal(codigoPostal);
    if (this.calle == null) throw new TUbicacionFiscalException(2000);
    if (this.municipio == null) throw new TUbicacionFiscalException(2001);
    if (this.estado == null) throw new TUbicacionFiscalException(2002);
    if (this.pais == null) throw new TUbicacionFiscalException(2003);
    if (this.codigoPostal == null) throw new TUbicacionFiscalException(2004);
  }

  public String getCalle()
  {
    return this.calle;
  }

  public void setCalle(String value)
  {
    if ((value != null) && (value.length() > 0))
      this.calle = value;
  }

  public String getCodigoPostal()
  {
    return this.codigoPostal;
  }

  public void setCodigoPostal(String value)
  {
    if ((value != null) && (value.length() == 5))
      this.codigoPostal = value;
  }

  public String getColonia()
  {
    return this.colonia;
  }

  public void setColonia(String value)
  {
    if ((value != null) && (value.length() > 0))
      this.colonia = value;
  }

  public String getEstado()
  {
    return this.estado;
  }

  public void setEstado(String value)
  {
    if ((value != null) && (value.length() > 0))
      this.estado = value;
  }

  public String getLocalidad()
  {
    return this.localidad;
  }

  public void setLocalidad(String value)
  {
    if ((value != null) && (value.length() > 0))
      this.localidad = value;
  }

  public String getMunicipio()
  {
    return this.municipio;
  }

  public void setMunicipio(String value)
  {
    if ((value != null) && (value.length() > 0))
      this.municipio = value;
  }

  public String getNoExterior()
  {
    return this.noExterior;
  }

  public void setNoExterior(String value)
  {
    if ((value != null) && (value.length() > 0))
      this.noExterior = value;
  }

  public String getNoInterior()
  {
    return this.noInterior;
  }

  public void setNoInterior(String value)
  {
    if ((value != null) && (value.length() > 0))
      this.noInterior = value;
  }

  public String getPais()
  {
    return this.pais;
  }

  public void setPais(String value)
  {
    if ((value != null) && (value.length() > 0))
      this.pais = value;
  }

  public String getReferencia()
  {
    return this.referencia;
  }

  public void setReferencia(String value)
  {
    if ((value != null) && (value.length() > 0))
      this.referencia = value;
  }
}