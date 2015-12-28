/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.util;
import cripfia.ext.FirmasDigitales;
import java.io.*;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Hex;
/**
 *
 * @author Jonathan
 */
public class SelloDigitalV2
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

    public SelloDigitalV2()
    {
        sello = "";
        firmasdigitales = null;
        sign_v2 = new GeneraSello();
        abyte0 = null;
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
        throws IOException
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
            cadena = (new StringBuilder(cadena)).append("|").toString();
        abyte0 = sign_v2.Generar(new BufferedInputStream(RLlave), Pass, cadenaOriginal);
        if(abyte0 == null)
            if(firmasdigitales.getMsgError() == -20)
            {
                setTipoError((short)3);
                return false;
            } else
            {
                setTipoError((short)4);
                return false;
            }
        if((new GeneraSello()).Verificarx509(x509certificate, cadenaOriginal, abyte0))
            sello = new String(Base64.encode(abyte0));
        else
            return false;
        return true;
    }
    public static String HextoAscii(String hex) {
        String s = "";
        for (int i = 0; i < hex.length(); i += 2) {
            String h = hex.substring(i, i + 2);
            int n = Integer.parseInt(h, 16);
            n &= 255;
            char ch = (char) n;
            s = s + ch;
        }
        return s;
    }

    public String NoCertifacado(InputStream RCert) throws UnsupportedEncodingException {
        if (firmasdigitales == null) {
            firmasdigitales = new FirmasDigitales();
        }
        java.security.cert.X509Certificate x509certificate = firmasdigitales.cargaCert(RCert);
        String ser = new String(Hex.encode(x509certificate.getSerialNumber().toByteArray()), "UTF8");
        ser = HextoAscii(ser);
        return ser;
    }

    private String sello;
    private FirmasDigitales firmasdigitales;
    private GeneraSello sign_v2;
    public byte abyte0[];
    private int _$1824;
    private String _$1838;
}

