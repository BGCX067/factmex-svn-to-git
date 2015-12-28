
package mx.com.factmex.app.server.services.factura.cfdv2;


/**
 *
 * @author Jonathan
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="t_InformacionAduanera")
public class TInformacionAduanera
{

  @XmlAttribute(required=true)
  protected String aduana;

  @XmlAttribute(required=true)
  protected XMLGregorianCalendar fecha;

  @XmlAttribute(required=true)
  protected String numero;

  public String getAduana()
  {
    return this.aduana;
  }

  public void setAduana(String value)
  {
    this.aduana = value;
  }

  public XMLGregorianCalendar getFecha()
  {
    return this.fecha;
  }

  public void setFecha(XMLGregorianCalendar value)
  {
    this.fecha = value;
  }

  public String getNumero()
  {
    return this.numero;
  }

  public void setNumero(String value)
  {
    this.numero = value;
  }
}