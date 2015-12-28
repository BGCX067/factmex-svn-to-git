/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.cfdv2.exceptions;

/**
 *
 * @author Jonathan
 */
public class ReceptorException extends CFDException
{

    public ReceptorException(int err)
    {
        switch(err)
        {
        case 1200:
            tipoError = 1200;
            break;

        case 1201:
            tipoError = 1201;
            break;

        default:
            tipoError = 1299;
            break;
        }
    }

    public static final int DOMICILIO_SIN_VALOR = 1200;
    public static final int RFC_SIN_VALOR = 1201;
    public static final int ERROR_GENERAL = 1299;
}

