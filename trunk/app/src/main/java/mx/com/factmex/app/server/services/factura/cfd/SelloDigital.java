/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.cfd;

/**
 *
 * @author Jonathan
 */
import cripfia.AlgoritmoDigestion;
import cripfia.ext.FirmasDigitales;
import java.io.InputStream;

public class SelloDigital
{

    public int getMsgError()
    {
        return _$1824;
    }

    public String getMsgErrorTxt()
    {
        return _$1838;
    }

    public String getSello()
    {
        return sello;
    }

    public SelloDigital()
    {
        sello = "";
        firmasdigitales = null;
        _$1824 = 0;
        _$1838 = null;
        firmasdigitales = new FirmasDigitales();
    }

    private void setTipoError(short err)
    {
        _$1824 = err;
        switch(err)
        {
        case 1: // '\001'
            _$1838 = (new StringBuilder("ERROR ")).append(firmasdigitales.getMsgError()).append(": NO FUE POSIBLE LEER EL ARCHIVO QUE CONTIENE EL CERTIFICADO").toString();
            break;

        case 2: // '\002'
            _$1838 = (new StringBuilder("ERROR ")).append(firmasdigitales.getMsgError()).append(": EL RFC DEL USUARIO NO COINCIDE CON EL DEL CERTIFICADO").toString();
            break;

        case 3: // '\003'
            _$1838 = (new StringBuilder("ERROR ")).append(firmasdigitales.getMsgError()).append(": ").append(firmasdigitales.getMsgErrorTxt().toUpperCase()).toString();
            break;

        case 4: // '\004'
            _$1838 = (new StringBuilder("ERROR ")).append(firmasdigitales.getMsgError()).append(": LA CONTRASE\321A DE SU CLAVE PRIVADA ES INCORRECTA \n O LOS ARCHIVOS DE SU FIRMA ELECTR\323NICA AVANZADA PUEDEN ESTAR DA\321ADOS").toString();
            break;

        default:
            _$1824 = 1000;
            break;
        }
    }

    public boolean generarSello(InputStream RCert, InputStream RLlave, String Pass, String RFC, String cadenaOriginal)
    {
        if(firmasdigitales == null)
            firmasdigitales = new FirmasDigitales();
        String rfcEnvio = "";
        String rfcCert = "";
        String cadena = "";
        java.security.cert.X509Certificate x509certificate = firmasdigitales.cargaCert(RCert);
        if(x509certificate == null)
        {
            setTipoError((short)1);
            return false;
        }
        rfcCert = firmasdigitales.certRFC(x509certificate);
        rfcCert = rfcCert.substring(0, RFC.length());
        if(!RFC.equals(rfcCert))
        {
            setTipoError((short)2);
            return false;
        }
        rfcEnvio = RFC;
        rfcEnvio = rfcEnvio.replace('&', '*');
        cadena = (new StringBuilder("|")).append(rfcEnvio).append("|").append(firmasdigitales.certNumSerie(x509certificate)).append("|").append(cadenaOriginal).toString();
        if(cadena.charAt(cadena.length() - 1) != '|')
            cadena = (new StringBuilder(String.valueOf(cadena))).append("|").toString();
        byte abyte0[] = firmasdigitales.mGeneraFirmaDigitalBase64(cadena.getBytes(), AlgoritmoDigestion.MD5, x509certificate, RLlave, Pass);
        if(abyte0 == null)
        {
            if(firmasdigitales.getMsgError() == -20)
            {
                setTipoError((short)3);
                return false;
            } else
            {
                setTipoError((short)4);
                return false;
            }
        } else
        {
            sello = new String(abyte0);
            return true;
        }
    }

    private String sello;
    private FirmasDigitales firmasdigitales;
    private int _$1824;
    private String _$1838;
}