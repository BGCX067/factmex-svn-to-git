/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.cfdv2.util;

/**
 *
 * @author Jonathan
 */
public class GenerarCadenaOriginalException extends Exception
{

    public GenerarCadenaOriginalException(int err)
    {
        mensajeError = null;
        switch(err)
        {
        case 1: // '\001'
            mensajeError = "No se puede generar la cadena original debido a que falta el nodo Comprobante";
            break;

        case 2: // '\002'
            mensajeError = "No se puede generar la cadena original debido a que falta el nodo Emisor";
            break;

        case 3: // '\003'
            mensajeError = "No se puede generar la cadena original debido a que falta el nodo Receptor";
            break;

        case 4: // '\004'
            mensajeError = "No se puede generar la cadena original debido a que falta el nodo Conceptos";
            break;

        case 5: // '\005'
            mensajeError = "No se puede generar la cadena original debido a que falta el nodo DomicilioFiscal del Emisor";
            break;

        case 6: // '\006'
            mensajeError = "No se puede generar la cadena original debido a que falta el nodo Domicilio del Receptor";
            break;

        case 7: // '\007'
            mensajeError = "No se puede generar la cadena original debido a que falta el nodo TotalImpuestosRetenidos";
            break;

        case 8: // '\b'
            mensajeError = "No se puede generar la cadena original debido a que falta el nodo TotalImpuestosTrasladados";
            break;

        case 9: // '\t'
            mensajeError = "No se puede generar la cadena original debido a que falta el nodo TotalImpuestosRetenidos";
            break;

        case 10: // '\n'
            mensajeError = "No se puede generar la cadena original debido a que falta el nodo TotalImpuestosRetenidos";
            break;
        }
    }

    public String getMessage()
    {
        return (new StringBuilder("[")).append(mensajeError).append("] ").append(super.getMessage()).toString();
    }

    private String mensajeError;
    public static int COMPROBANTE_SIN_VALOR = 1;
    public static int EMISOR_SIN_VALOR = 2;
    public static int RECEPTOR_SIN_VALOR = 3;
    public static int CONCEPTOS_SIN_VALOR = 4;
    public static int DOMICILIO_FISCAL_EMISOR_SIN_VALOR = 5;
    public static int DOMICILIO_RECEPTOR_SIN_VALOR = 6;
    public static int TOTAL_IMPUESTOS_RETENIDOS_SIN_VALOR = 7;
    public static int TOTAL_IMPUESTOS_TRASLADADOS_SIN_VALOR = 8;

}
