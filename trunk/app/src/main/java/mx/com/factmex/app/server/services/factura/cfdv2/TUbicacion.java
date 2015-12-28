/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.cfdv2;
import mx.com.factmex.app.server.services.factura.cfdv2.exceptions.TUbicacionException;
/**
 *
 * @author Jonathan
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="t_Ubicacion")
public class TUbicacion
{

  @XmlAttribute
  protected String calle;

  @XmlAttribute
  protected String codigoPostal;

  @XmlAttribute
  protected String colonia;

  @XmlAttribute
  protected String estado;

  @XmlAttribute
  protected String localidad;

  @XmlAttribute
  protected String municipio;

  @XmlAttribute
  protected String noExterior;

  @XmlAttribute
  protected String noInterior;

  @XmlAttribute(required=true)
  protected String pais;

  @XmlAttribute
  protected String referencia;

  public TUbicacion()
  {
  }

  public TUbicacion(String pais)
    throws TUbicacionException
  {
    setPais(pais);
    if (this.pais == null) throw new TUbicacionException(2100);
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
    this.referencia = value;
  }
}