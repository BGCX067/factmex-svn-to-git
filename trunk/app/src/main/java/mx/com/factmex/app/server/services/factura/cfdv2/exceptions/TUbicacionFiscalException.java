/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.cfdv2.exceptions;

/**
 *
 * @author Jonathan
 */
public class TUbicacionFiscalException extends CFDException
{

    public TUbicacionFiscalException(int err)
    {
        switch(err)
        {
        case 2000:
            tipoError = 2000;
            break;

        case 2001:
            tipoError = 2001;
            break;

        case 2002:
            tipoError = 2002;
            break;

        case 2003:
            tipoError = 2003;
            break;

        case 2004:
            tipoError = 2004;
            break;

        default:
            tipoError = 2099;
            break;
        }
    }

    public static final int CALLE_SIN_VALOR = 2000;
    public static final int MUNICIPIO_SIN_VALOR = 2001;
    public static final int ESTADO_SIN_VALOR = 2002;
    public static final int PAIS_SIN_VALOR = 2003;
    public static final int CODIGOPOSTAL_SIN_VALOR = 2004;
    public static final int ERROR_GENERAL = 2099;
}
