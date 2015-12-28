/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.cfdv2.exceptions;

/**
 *
 * @author Jonathan
 */
public class EmisorException extends CFDException
{

    public EmisorException(int err)
    {
        switch(err)
        {
        case 1100:
            tipoError = 1100;
            break;

        case 1101:
            tipoError = 1101;
            break;

        case 1102:
            tipoError = 1102;
            break;

        default:
            tipoError = 1199;
            break;
        }
    }

    public static final int DOMICILIO_FISCAL_SIN_VALOR = 1100;
    public static final int RFC_SIN_VALOR = 1101;
    public static final int NOMBRE_SIN_VALOR = 1102;
    public static final int ERROR_GENERAL = 1199;
}

