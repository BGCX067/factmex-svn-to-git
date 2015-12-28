/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura;
import mx.com.factmex.app.client.util.ConvertUtil;
import mx.com.factmex.app.server.services.factura.cfd.SelloDigital;
import mx.com.factmex.app.server.services.factura.cfdv2.Comprobante;
import mx.com.factmex.app.server.services.factura.cfdv2.ObjectFactory;
import mx.com.factmex.app.server.services.factura.cfdv2.TUbicacionFiscal;
import mx.com.factmex.app.server.services.factura.cfdv2.TUbicacion;
import mx.com.factmex.app.server.services.factura.cfdv2.util.CadenaOriginalv2;
import mx.com.factmex.app.server.services.factura.cfdv2.util.CadenaOriginalv3;
import mx.com.factmex.app.server.services.factura.cfdv2.util.GenerarCadenaOriginalException;
import mx.com.factmex.app.server.services.factura.cfdv2.util.MarshallCFDv2XML;
import mx.com.factmex.app.server.services.factura.util.CodificarBase64;
import java.io.*;
import java.text.SimpleDateFormat;
import mx.com.factmex.app.server.services.factura.util.GeneraSello;
import mx.com.factmex.app.server.services.factura.util.SelloDigitalV2;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Jonathan
 */
public class CFD {

 public CFD()
    {
        comprobante = new Comprobante();
        emisor = new mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Emisor();
        ubicacionFiscal = new TUbicacionFiscal();
        receptor = new mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Receptor();
        ubicacion = new TUbicacion();
        lugarExpedicion = new TUbicacion();
        objectFactory = new ObjectFactory();
        conceptos = new mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Conceptos();
        //concepto = new mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Conceptos.Concepto();
        impuestos = new mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Impuestos();
        traslados = new mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Impuestos.Traslados();
        sellodigital = new SelloDigital();
        cadenaoriginal = new CadenaOriginalv2();
        cadenaoriginalv3 = new CadenaOriginalv3();
        signv2 = new SelloDigitalV2();
        sign_v2 = new GeneraSello();
        certificadoAsignado = false;
    }

    public void creaEmisor(String em[], String dir[])
        throws Exception
    {
        if(em.length < 2)
            throw new Exception("ProxyEJB:creaEmisor:Faltan datos para el Emisor");
        if(dir.length < 10)
            throw new Exception("ProxyEJB:creaEmisor:Faltan datos para el Domicilio Fiscal");
        emisor.setNombre(em[0]);
        emisor.setRfc(em[1]);
        if(!ConvertUtil.convertIsNull(dir[0]).trim().equals(""))
            ubicacionFiscal.setCalle(dir[0]);
        if(!ConvertUtil.convertIsNull(dir[1]).trim().equals(""))
            ubicacionFiscal.setCodigoPostal(dir[1]);
        if(!ConvertUtil.convertIsNull(dir[2]).trim().equals(""))
            ubicacionFiscal.setColonia(dir[2]);
        if(!ConvertUtil.convertIsNull(dir[3]).trim().equals(""))
            ubicacionFiscal.setEstado(dir[3]);
        if(!ConvertUtil.convertIsNull(dir[4]).trim().equals(""))
            ubicacionFiscal.setLocalidad(dir[4]);
        if(!ConvertUtil.convertIsNull(dir[5]).trim().equals(""))
            ubicacionFiscal.setMunicipio(dir[5]);
        if(!ConvertUtil.convertIsNull(dir[6]).trim().equals(""))
            ubicacionFiscal.setNoExterior(dir[6]);
        if(!ConvertUtil.convertIsNull(dir[7]).trim().equals(""))
            ubicacionFiscal.setNoInterior(dir[7]);
        if(!ConvertUtil.convertIsNull(dir[8]).trim().equals(""))
            ubicacionFiscal.setPais(dir[8]);
        if(!ConvertUtil.convertIsNull(dir[9]).trim().equals(""))
            ubicacionFiscal.setReferencia(dir[9]);
        emisor.setDomicilioFiscal(ubicacionFiscal);
    }

    public void creaReceptor(String rec[], String dir[])
        throws Exception
    {
        if(rec.length < 2)
            throw new Exception("ProxyEJB:creaEmisor:Faltan datos para el Receptor");
        if(dir.length < 10)
            throw new Exception("ProxyEJB:creaReceptor:Faltan datos para el Domicilio");
        receptor.setNombre(rec[0]);
        receptor.setRFC(rec[1]);
        
        ubicacion = new TUbicacion();
        if(!ConvertUtil.convertIsNull(dir[0]).trim().equals(""))
            ubicacion.setCalle(dir[0]);
        if(!ConvertUtil.convertIsNull(dir[1]).trim().equals(""))
            ubicacion.setCodigoPostal(dir[1]);
        if(!ConvertUtil.convertIsNull(dir[2]).trim().equals(""))
            ubicacion.setColonia(dir[2]);
        if(!ConvertUtil.convertIsNull(dir[3]).trim().equals(""))
            ubicacion.setEstado(dir[3]);
        if(!ConvertUtil.convertIsNull(dir[4]).trim().equals(""))
            ubicacion.setLocalidad(dir[4]);
        if(!ConvertUtil.convertIsNull(dir[5]).trim().equals(""))
            ubicacion.setMunicipio(dir[5]);
        if(!ConvertUtil.convertIsNull(dir[6]).trim().equals(""))
            ubicacion.setNoExterior(dir[6]);
        if(!ConvertUtil.convertIsNull(dir[7]).trim().equals(""))
            ubicacion.setNoInterior(dir[7]);
        if(!ConvertUtil.convertIsNull(dir[8]).trim().equals(""))
            ubicacion.setPais(dir[8]);
        if(!ConvertUtil.convertIsNull(dir[9]).trim().equals(""))
            ubicacion.setReferencia(dir[9]);
        receptor.setDomicilio(ubicacion);
    }

    public void creaLugarExpedicion(String le[])
        throws Exception
    {
        if(le.length < 10)
            throw new Exception("ProxyEJB:creaLugarExpedcion:Faltan datos para el Lugar de expedici\363n");
        if(!ConvertUtil.convertIsNull(le[0]).trim().equals(""))
            lugarExpedicion.setCalle(le[0]);
        if(!ConvertUtil.convertIsNull(le[1]).trim().equals(""))
            lugarExpedicion.setCodigoPostal(le[1]);
        if(!ConvertUtil.convertIsNull(le[2]).trim().equals(""))
            lugarExpedicion.setColonia(le[2]);
        if(!ConvertUtil.convertIsNull(le[3]).trim().equals(""))
            lugarExpedicion.setEstado(le[3]);
        if(!ConvertUtil.convertIsNull(le[4]).trim().equals(""))
            lugarExpedicion.setLocalidad(le[4]);
        if(!ConvertUtil.convertIsNull(le[5]).trim().equals(""))
            lugarExpedicion.setMunicipio(le[5]);
        if(!ConvertUtil.convertIsNull(le[6]).trim().equals(""))
            lugarExpedicion.setNoExterior(le[6]);
        if(!ConvertUtil.convertIsNull(le[7]).trim().equals(""))
            lugarExpedicion.setNoInterior(le[7]);
        if(!ConvertUtil.convertIsNull(le[8]).trim().equals(""))
            lugarExpedicion.setPais(le[8]);
        if(!ConvertUtil.convertIsNull(le[9]).trim().equals(""))
            lugarExpedicion.setReferencia(le[9]);
        emisor.setExpedidoEn(lugarExpedicion);
    }

    public void creaConceptos(String con[])
        throws Exception
    {
        System.out.println(con.length);
        if(con.length % 6 != 0)
            throw new Exception("ProxyEJB:creaConceptos:El listado de conceptos esta incompleto");
        long totCons = con.length / 6;
        System.out.println(conceptos.getConcepto().size());
        for(int i = 0; (long)i < totCons; i++)
        {
            int idx = i * 6;
            mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Conceptos.Concepto concepto = objectFactory.createComprobanteConceptosConcepto(Double.parseDouble(con[idx + 2]), con[idx + 3], Double.parseDouble(con[idx + 4]), Double.parseDouble(con[idx + 5]));
            if(con[idx] != null && con[idx] != "")
                concepto.setNoIdentificacion(con[idx]);
            if(con[idx + 1] != null && con[idx + 1] != "")
                concepto.setUnidad(con[idx + 1]);
            conceptos.getConcepto().add(concepto);
        }

    }

    public void creaImpuestos(String imp[][])
    {
        impuestos = objectFactory.createComprobanteImpuestos();
        traslados = objectFactory.createComprobanteImpuestosTraslados();
        retenciones = objectFactory.createComprobanteImpuestosRetenciones();
        for(int i = 0; i < imp.length; i++)
        {
            if(imp[i][2].equals("IVA"))
            {
                traslados.getTraslado().add(objectFactory.createComprobanteImpuestosTrasladosTrasladoIVA(Double.parseDouble(imp[i][0]), Double.parseDouble(imp[i][1])));
                impuestos.setTraslados(traslados);
            }
            if(imp[i][2].equals("IEPS"))
            {
                traslados.getTraslado().add(objectFactory.createComprobanteImpuestosTrasladosTrasladoIEPS(Double.parseDouble(imp[i][0]), Double.parseDouble(imp[i][1])));
                impuestos.setTraslados(traslados);
            }
            if(imp[i][2].equals("-IVA"))
            {
                retenciones.getRetencion().add(objectFactory.createComprobanteImpuestosRetencionesRetencionIVA(Double.parseDouble(imp[i][0])));
                impuestos.setRetenciones(retenciones);
            }
            if(imp[i][2].equals("-ISR"))
            {
                retenciones.getRetencion().add(objectFactory.createComprobanteImpuestosRetencionesRetencionISR(Double.parseDouble(imp[i][0])));
                impuestos.setRetenciones(retenciones);
            }
        }

    }

    public void creaComprobante(String com[], String xmlRutaDestino, String url)
        throws Exception
    {
        this.com = com;
        File ruta = new File(url);
        if(ruta.exists()){
        	this.xmlRutaDestino = ruta+""+xmlRutaDestino;
            creaXML(crea());
        }else{
        	ruta.mkdir();
        	this.xmlRutaDestino = ruta+""+xmlRutaDestino;
            creaXML(crea());
        }
        
    }

    public void setLlavePrivada(String ruta, String pwd)
        throws FileNotFoundException
    {
        isLlavePrivada = new FileInputStream(ruta);
        pwdLlave = pwd;
    }

    public void setLlavePrivada(InputStream is, String pwd)
        throws FileNotFoundException
    {
        isLlavePrivada = is;
        pwdLlave = pwd;
    }

    public void setLlavePrivada64(String s64, String pwd)
        throws IOException
    {
        isLlavePrivada = base642archivo(s64, null);
        pwdLlave = pwd;
    }

    public void setLlavePublica(String ruta)
        throws FileNotFoundException
    {
        isLlavePublica = new FileInputStream(ruta);
        isLlavePublica2 = new FileInputStream(ruta);
    }

    public void setLlavePublica(InputStream is)
        throws FileNotFoundException
    {
        isLlavePublica = is;
    }

    public void setLlavePublica64(String s64)
        throws IOException
    {
        certificado = s64;
        certificadoAsignado = true;
        isLlavePublica = base642archivo(s64, null);
    }

    public void reiniciaObjetos()
    {
        comprobante = new Comprobante();
        emisor = null;
        ubicacionFiscal = null;
        receptor = null;
        ubicacion = null;
        objectFactory = null;
        conceptos = null;
        //concepto = null;
        impuestos = null;
        traslados = null;
        sellodigital = null;
        cadenaoriginal = null;
        cadenaoriginalv3 = null;
        signv2 = null;
        sign_v2 = null;
        System.gc();
        comprobante = new Comprobante();
        emisor = new mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Emisor();
        ubicacionFiscal = new TUbicacionFiscal();
        receptor = new mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Receptor();
        ubicacion = new TUbicacion();
        objectFactory = new ObjectFactory();
        conceptos = new mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Conceptos();
        //concepto = new mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Conceptos.Concepto();
        impuestos = new mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Impuestos();
        traslados = new mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Impuestos.Traslados();
        sellodigital = new SelloDigital();
        cadenaoriginal = new CadenaOriginalv2();
        cadenaoriginalv3 = new CadenaOriginalv3();
        certificadoAsignado = false;
    }

    public String getCadenaOriginal()
    {
        return cad_original;
    }

    public String getSelloDigital()
    {
        return sello_generado;
    }

    public String archivo2Base64(String ruta)
        throws IOException
    {
        return (new CodificarBase64()).base64Encode(ruta);
    }

    public InputStream base642archivo(String b64, String ruta)
        throws IOException
    {
        CodificarBase64 cb64 = new CodificarBase64();
        InputStream is = cb64.base64Decode(b64);
        if(ruta != null)
        {
            byte data[] = new byte[is.available()];
            is.read(data);
            FileOutputStream fos = new FileOutputStream(ruta);
            fos.write(data);
            fos.close();
        }
        return is;
    }

    public boolean creaXML(Comprobante c)
        throws Exception
    {
        try
        {
            System.out.println("Entrando al MARSHALLCFDXML");
            MarshallCFDv2XML xmls= new MarshallCFDv2XML();
            FileOutputStream out = new FileOutputStream(xmlRutaDestino);
            xmls.marshalCfdV2(c, out);
            System.out.println("Ha pasado el  MARSHALLCFDXML");
            System.out.println((new StringBuilder("Se ha creado documento: ")).append(xmlRutaDestino).toString());
            reiniciaObjetos();
        }
        catch(FileNotFoundException e)
        {
            throw new Exception(e.getMessage());
            
        }
        catch(Exception e)
        {
        	throw e;
        }
        return true;
    }

    public Comprobante crea () throws GenerarCadenaOriginalException, Exception
    {
            SimpleDateFormat sdf_rep = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("crea() " + emisor.getRfc());
            String NumCer = signv2.NoCertifacado(isLlavePublica2);
            System.out.println("numero de concetos al generar el xml"+conceptos.getConcepto().size());
            if(com[8].equals("0")){
            	comprobante = objectFactory.createComprobanteIngreso(emisor, receptor, conceptos, impuestos, com[0], sdf_rep.parse(com[1]), "SELLO NO GENERADO", Long.parseLong(com[2]), Long.parseLong(com[3]),Integer.parseInt(com[9]),Integer.parseInt(com[10]),NumCer , Double.parseDouble(com[5]), Double.parseDouble(com[6]));
            }else{
            	comprobante = objectFactory.createComprobanteIngreso(emisor, receptor, conceptos, impuestos, com[0], sdf_rep.parse(com[1]), "SELLO NO GENERADO", Long.parseLong(com[2]), Long.parseLong(com[3]),NumCer , Double.parseDouble(com[5]), Double.parseDouble(com[6]));
            }
            comprobante.setSerie(com[7].trim());
            if(certificadoAsignado)
                comprobante.setCertificado(certificado);
            cadenaoriginalv3.generarCadenaOriginal(comprobante);
            cad_original = cadenaoriginalv3.getCadenaOriginalUTF8();
            if(!signv2.generarSello(isLlavePublica, isLlavePrivada, pwdLlave, emisor.getRfc(), cad_original))
                throw new Exception("Error al generar el sello " + signv2.getMsgErrorTxt());
            sello_generado = signv2.getSello();
            comprobante.setSello(sello_generado);
       
        return comprobante;
    }

    Comprobante comprobante;
    mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Emisor emisor;
    TUbicacionFiscal ubicacionFiscal;
    mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Receptor receptor;
    TUbicacion ubicacion;
    TUbicacion lugarExpedicion;
    ObjectFactory objectFactory;
    mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Conceptos conceptos;
    
    mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Impuestos impuestos;
    mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Impuestos.Traslados traslados;
    mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Impuestos.Retenciones retenciones;
    SelloDigital sellodigital;
    CadenaOriginalv2 cadenaoriginal;
    CadenaOriginalv3 cadenaoriginalv3;
    SelloDigitalV2 signv2;
    GeneraSello sign_v2;
    String cad_original;
    String sello_generado;
    String pwdLlave;
    String certificado;
    String xmlRutaDestino;
    String com[];
    InputStream isLlavePrivada;
    InputStream isLlavePublica;
    InputStream isLlavePublica2;
    boolean certificadoAsignado;
}

