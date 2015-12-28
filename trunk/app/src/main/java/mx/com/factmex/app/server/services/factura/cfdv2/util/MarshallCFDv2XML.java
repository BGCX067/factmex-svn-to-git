/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.cfdv2.util;
import java.io.*;
import javax.xml.bind.*;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;
import mx.com.factmex.app.server.services.factura.cfdv2.Comprobante;
import mx.com.factmex.app.server.services.factura.cfdv2.exceptions.ParseComprobanteException;
import com.sun.xml.bind.marshaller.NamespacePrefixMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

public class MarshallCFDv2XML
{
  public static Comprobante unmarshalCfdV2(InputStream inputstream)
    throws ParseComprobanteException
  {
    Comprobante comprobante = null;
    JAXBContext jc = null;
    Unmarshaller unmarshaller = null;
    SchemaFactory schemafactory = null;
    Schema $esquema = null;
    try
    {
      jc = JAXBContext.newInstance("mx.com.factmex.app.server.services.factura.cfdv2", Thread.currentThread().getContextClassLoader());
      unmarshaller = jc.createUnmarshaller();

      schemafactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
      
      File xsd = new File("src/main/resources/xsd/cfdv2.xsd"); 
      $esquema = schemafactory.newSchema(xsd);

      comprobante = (Comprobante)unmarshaller.unmarshal(inputstream);
    }
    catch (JAXBException ex) {
      throw new ParseComprobanteException(ex.getMessage());
    }
    catch (SAXException ex)
    {
    	throw new ParseComprobanteException(ex.getMessage());
    }

    return comprobante;
  }

  public static Comprobante unmarshalCfdV2ConErrorEnEstructura(InputStream inputstream) throws IOException, Exception {
    Comprobante comprobante = null;
    JAXBContext jc = null;
    Unmarshaller unmarshaller = null;
    SchemaFactory schemafactory = null;
    Schema $esquema = null;
    try {
      jc = JAXBContext.newInstance("mx.com.factmex.app.server.services.factura.cfdv2", Thread.currentThread().getContextClassLoader());
      unmarshaller = jc.createUnmarshaller();

      schemafactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
      $esquema = schemafactory.newSchema(new MarshallCFDv2XML().getClass().getResource("esquemas/cfdv2.xsd"));

      comprobante = (Comprobante)unmarshaller.unmarshal(inputstream);
    } catch (JAXBException ex) {
      throw new Exception(ex.getMessage());
    } catch (SAXException ex) {
      throw new Exception(ex.getMessage());
    }

    return comprobante;
  }

  public static Comprobante unmarshalCfdV2(String url) throws Exception
  {
    File file = new File(url);
    FileInputStream fileInputStream = new FileInputStream(file);
    return unmarshalCfdV2(fileInputStream);
  }
  public static class PrefixMapper extends NamespacePrefixMapper
    {
        public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix)
        {
            String result = suggestion;

            if ("http://www.xyz.org/xyz".equals(namespaceUri))
            {
                result = "xyz";
            }

            return result;
        }
    }


  public static void marshalCfdV2(Comprobante comprobante, OutputStream output) throws IOException, Exception {
    JAXBContext jc = null;
    Marshaller marshaller = null;
    SchemaFactory schemafactory = null;
    Schema $esquema = null;
    try {
      jc = JAXBContext.newInstance("mx.com.factmex.app.server.services.factura.cfdv2", Thread.currentThread().getContextClassLoader());
      marshaller = jc.createMarshaller();
      //@XmlSchema(namespace="http://www.sat.gob.mx/cfd/2", elementFormDefault=XmlNsForm.QUALIFIED)
     // marshaller.setProperty("jaxb.xmlns", "http://www.sat.gob.mx/cfd/2");
     //PrefixMapper prefixMapper = new PrefixMapper();
      marshaller.setProperty("jaxb.formatted.output", new Boolean(true));
      //marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", prefixMapper);

      marshaller.setProperty("jaxb.schemaLocation", "http://www.sat.gob.mx/cfd/2  http://www.sat.gob.mx/sitio_internet/cfd/2/cfdv2.xsd");

      schemafactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
      File xsd = new File("src/main/resources/xsd/cfdv2.xsd"); 
      $esquema = schemafactory.newSchema(xsd);

      marshaller.marshal(comprobante, output);
    } catch (JAXBException ex) {
    	throw new Exception(ex.getMessage());
    } catch (SAXException ex) {
    	throw new Exception(ex.getMessage());
    }
  }

  public static void marshalCfdV2AddSchema(Comprobante comprobante, OutputStream output, String Schema)
    throws IOException,Exception
  {
    JAXBContext jc = null;
    Marshaller marshaller = null;
    SchemaFactory schemafactory = null;
    Schema $esquema = null;
    try {
      jc = JAXBContext.newInstance("mx.com.factmex.app.server.services.factura.cfdv2", Thread.currentThread().getContextClassLoader());
      marshaller = jc.createMarshaller();

      marshaller.setProperty("jaxb.formatted.output", new Boolean(true));

      marshaller.setProperty("jaxb.schemaLocation", "http://www.sat.gob.mx/cfd/2  http://www.sat.gob.mx/sitio_internet/cfd/2/cfdv2.xsd " + Schema);

      schemafactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
      File xsd = new File("src/main/resources/xsd/cfdv2.xsd"); 
      $esquema = schemafactory.newSchema(xsd);

      marshaller.marshal(comprobante, output);
    } catch (JAXBException ex) {
    	throw new Exception(ex.getMessage());
    } catch (SAXException ex) {
    	throw new Exception(ex.getMessage());
    }
  }

  public static void marshalCfdV2ConErrorEnEstructura(Comprobante comprobante, OutputStream output) throws IOException, Exception
  {
    JAXBContext jc = null;
    Marshaller marshaller = null;
    SchemaFactory schemafactory = null;
    Schema $esquema = null;
    try {
      jc = JAXBContext.newInstance("mx.com.factmex.app.server.services.factura.cfdv2", Thread.currentThread().getContextClassLoader());
      marshaller = jc.createMarshaller();

      marshaller.setProperty("jaxb.formatted.output", new Boolean(true));
      marshaller.setProperty("jaxb.schemaLocation", "http://www.sat.gob.mx/cfd/2  http://www.sat.gob.mx/sitio_internet/cfd/2/cfdv2.xsd");

      schemafactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
      $esquema = schemafactory.newSchema(new MarshallCFDv2XML().getClass().getResource("esquemas/cfdv2.xsd"));

      marshaller.marshal(comprobante, output);
    } catch (JAXBException ex) {
    	throw new Exception(ex.getMessage());
    } catch (SAXException ex) {
    	throw new Exception(ex.getMessage());
    }
  }
}