/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.cfdv2.exceptions;

/**
 *
 * @author Jonathan
 */
public abstract class CFDException extends Exception
{

    public CFDException()
    {
        tipoError = 1099;
    }

    public int getTipoError()
    {
        return tipoError;
    }

    protected int tipoError;
}
