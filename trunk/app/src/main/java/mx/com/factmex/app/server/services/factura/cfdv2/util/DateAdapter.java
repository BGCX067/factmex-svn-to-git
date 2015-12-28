/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.cfdv2.util;

import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date>
{
  public Date unmarshal(String date)
    throws Exception
  {
    return Fechas.parsearFecha(date, "yyyy-MM-dd'T'HH:mm:ss");
  }

  public String marshal(Date date) throws Exception {
    return Fechas.obtenerFechaConFormato(date, "yyyy-MM-dd'T'HH:mm:ss");
  }
}