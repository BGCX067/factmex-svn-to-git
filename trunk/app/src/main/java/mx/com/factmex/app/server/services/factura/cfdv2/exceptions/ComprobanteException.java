/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.cfdv2.exceptions;

/**
 *
 * @author Jonathan
 */
public class ComprobanteException extends CFDException
{

    public ComprobanteException(int err)
    {
        switch(err)
        {
        case 1000:
            tipoError = 1000;
            break;

        case 1001:
            tipoError = 1001;
            break;

        case 1002:
            tipoError = 1002;
            break;

        case 1003:
            tipoError = 1003;
            break;

        case 1004:
            tipoError = 1004;
            break;

        case 1005:
            tipoError = 1005;
            break;

        case 1006:
            tipoError = 1006;
            break;

        case 1007:
            tipoError = 1007;
            break;

        case 1008:
            tipoError = 1008;
            break;

        case 1009:
            tipoError = 1009;
            break;

        case 1010:
            tipoError = 1010;
            break;

        case 1011:
            tipoError = 1011;
            break;

        case 1012:
            tipoError = 1012;
            break;

        case 1013:
            tipoError = 1013;
            break;

        case 1014:
            tipoError = 1014;
            break;

        case 1015:
            tipoError = 1015;
            break;

        default:
            tipoError = 1099;
            break;
        }
    }

    public static final int EMISOR_SIN_VALOR = 1000;
    public static final int RECEPTOR_SIN_VALOR = 1001;
    public static final int CONCEPTOS_SIN_VALOR = 1002;
    public static final int IMPUESTOS_SIN_VALOR = 1003;
    public static final int VERSION_SIN_VALOR = 1004;
    public static final int SERIE_SIN_VALOR = 1005;
    public static final int FOLIO_SIN_VALOR = 1006;
    public static final int FECHA_SIN_VALOR = 1007;
    public static final int SELLO_SIN_VALOR = 1008;
    public static final int NUMERO_APROBACION_SIN_VALOR = 1009;
    public static final int ANNO_APROBACION_SIN_VALOR = 1010;
    public static final int FORMA_PAGO_SIN_VALOR = 1011;
    public static final int NUMERO_CERTIFICADO_SIN_VALOR = 1012;
    public static final int SUBTOTAL_SIN_VALOR = 1013;
    public static final int TOTAL_SIN_VALOR = 1014;
    public static final int TIPO_COMPROBANTE_SIN_VALOR = 1015;
    public static final int ERROR_GENERAL = 1099;
}

