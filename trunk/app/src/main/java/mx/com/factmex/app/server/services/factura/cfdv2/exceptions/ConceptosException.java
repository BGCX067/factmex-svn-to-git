/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.cfdv2.exceptions;

/**
 *
 * @author Jonathan
 */
public class ConceptosException extends CFDException
{

    public ConceptosException(int err)
    {
        switch(err)
        {
        case 1300:
            tipoError = 1300;
            break;

        default:
            tipoError = 1399;
            break;
        }
    }

    public static final int CONCEPTOS_SIN_VALOR = 1300;
    public static final int ERROR_GENERAL = 1399;
}

