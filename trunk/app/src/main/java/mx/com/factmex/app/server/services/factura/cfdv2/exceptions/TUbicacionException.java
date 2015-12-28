/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.cfdv2.exceptions;

/**
 *
 * @author Jonathan
 */
public class TUbicacionException extends CFDException
{

    public TUbicacionException(int err)
    {
        switch(err)
        {
        case 2100:
            tipoError = 2100;
            break;

        default:
            tipoError = 2199;
            break;
        }
    }

    public static final int PAIS_SIN_VALOR = 2100;
    public static final int ERROR_GENERAL = 2199;
}
