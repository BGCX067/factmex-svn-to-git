/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.util;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Jonathan
 */
import java.io.*;
import org.bouncycastle.util.encoders.Base64;

public class CodificarBase64
{

    public CodificarBase64()
    {
    }

    public String base64Encode(String url)
        throws FileNotFoundException, IOException
    {
        FileInputStream fis = new FileInputStream(url);
        byte b[] = new byte[fis.available()];
        fis.read(b);
        new Base64();
        return new String(Base64.encode(b));
    }

    public InputStream base64Decode(String base64)
    {
        new Base64();
        byte b[] = Base64.decode(base64);
        return new ByteArrayInputStream(b);
    }

    public String base64Encode(InputStream fis)
        throws FileNotFoundException, IOException
    {
        byte b[] = new byte[fis.available()];
        fis.read(b);
        new Base64();
        return new String(Base64.encode(b));
    }

    public static void main(String args[])
        throws FileNotFoundException, IOException
    {
        System.out.println((new CodificarBase64()).base64Encode("/home/dario/Facturas/div/00001000000000816228.cer"));
    }
}
