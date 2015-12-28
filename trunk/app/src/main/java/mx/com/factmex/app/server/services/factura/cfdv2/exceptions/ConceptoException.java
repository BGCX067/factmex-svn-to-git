/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.cfdv2.exceptions;

/**
 *
 * @author Jonathan
 */
public class ConceptoException extends CFDException
{

    public ConceptoException(int err)
    {
        switch(err)
        {
        case 1398:
            tipoError = 1398;
            break;

        case 1399:
            tipoError = 1399;
            break;

        case 1400:
            tipoError = 1400;
            break;

        case 1401:
            tipoError = 1401;
            break;

        case 1402:
            tipoError = 1402;
            break;

        case 1403:
            tipoError = 1403;
            break;

        default:
            tipoError = 1499;
            break;
        }
    }

    public static final int CLAVE_SIN_VALOR = 1398;
    public static final int UNIDAD_SIN_VALOR = 1399;
    public static final int CANTIDAD_SIN_VALOR = 1400;
    public static final int DESCRIPCION_SIN_VALOR = 1401;
    public static final int VALOR_UNITARIO_SIN_VALOR = 1402;
    public static final int IMPORTE_SIN_VALOR = 1403;
    public static final int ERROR_GENERAL = 1499;
}

