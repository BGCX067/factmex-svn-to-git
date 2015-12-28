/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.cfdv2.util;

/**
 *
 * @author Jonathan
 */
import java.text.*;
import java.util.Date;

public class Fechas
{

    public Fechas()
    {
    }

    public static void main(String args1[])
    {
    }

    public static Date parsearFecha(String fecha, String formato)
        throws ParseException
    {
        DateFormat df = new SimpleDateFormat(formato);
        return df.parse(fecha);
    }

    public static String obtenerFechaActualConFormato(String formato)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        return formatter.format(new Date());
    }

    public static String obtenerFechaConFormato(Date date, String formato)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        return formatter.format(date);
    }

    public static Date getDate(String fecha)
        throws ParseException
    {
        return (new SimpleDateFormat("dd/MM/yyyy")).parse(fecha);
    }

    public static Date getHora(String hora)
        throws ParseException
    {
        return (new SimpleDateFormat("HH:mm:ss")).parse(hora);
    }

    public static String obtenerFechaFormateada(Date date)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }

    public static String obtenerHoraFormateada(Date hora)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(hora);
    }

    public static final String FECHA_DD_MM_AA_HH_MM_SS = "dd-MM-yyyy H:mm:ss";
    public static final String FECHA_DD_MM_AAAA = "dd/MM/yyyy";
    public static final String HORA_HH_MM_SS = "HH:mm:ss";
    public static final String FECHA_FACTURE = "yyyy-MM-dd'T'HH:mm:ss";
}

