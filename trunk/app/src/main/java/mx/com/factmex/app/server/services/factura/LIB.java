/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura;

import mx.com.factmex.app.server.services.factura.xml2pdf.GeneraPDF;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
/**
 *
 * @author Jonathan
 */
public class LIB {
    public CFD pcfd;
    public GeneraPDF gpdf;
    public String []args = new String[11];
    public String las_emisor[];
    public String las_domicilio_emisor[];
    public String las_lugar_expedicion[];
    public String las_receptor[];
    public String las_domicilio_cliente[];
    public String las_conceptos[][];
    public String las_impuestos[][];
    public int tcon;
    public int timp;



    public LIB()
    {
        pcfd = null;
        gpdf = null;
        las_emisor = new String[2];
        las_domicilio_emisor = new String[10];
        las_lugar_expedicion = new String[10];
        las_receptor = new String[2];
        las_domicilio_cliente = new String[10];
        las_conceptos = null;
        las_impuestos = null;
        tcon = 0;
        timp = 0;
    
    }

    public String[] setArgs(String folio, String fecha, String noaprobacion, String anioaprobacion, String certificado, String subtotal, String total,
            String serie,String contado,String parcialidad,String totalParcilidad)
    {
    	args[0] = folio; //folio
        args[1] = fecha; //fecha
        args[2] = noaprobacion; //no. aprobacion
        args[3] = anioaprobacion; //anio aprobacion
        args[4] = certificado; //certificado
        args[5] = subtotal; //subtotal
        args[6] = total; //total
        args[7] = serie; //serie
        args[8] = contado;//Si es de contado 1 de lo contrario 0
        args[9]= parcialidad; //Numero de parcialidad
        args[10]= totalParcilidad;//Total Parcialidades
        return args;
    }

    public int PruebaSuma()
    {
        return 2;
    }

    public String[] setEmisor(String nombre, String rfc)
    {
        las_emisor[0] = nombre;
        las_emisor[1] = rfc;
        return las_emisor;
    }

    public String[] setDomicilioEmisor(String calle, String cp, String colonia, String estado, String localidad, String municipio, String noexterior,
            String nointerior, String pais, String referencia)
    {
        las_domicilio_emisor[0] = calle;
        las_domicilio_emisor[1] = cp;
        las_domicilio_emisor[2] = colonia;
        las_domicilio_emisor[3] = estado;
        las_domicilio_emisor[4] = localidad;
        las_domicilio_emisor[5] = municipio;
        las_domicilio_emisor[6] = noexterior;
        las_domicilio_emisor[7] = nointerior;
        las_domicilio_emisor[8] = pais;
        las_domicilio_emisor[9] = referencia;
        return las_domicilio_emisor;
    }

    public String[] setLugarExpedicion(String calle, String cp, String colonia, String estado, String localidad, String municipio, String noexterior,
            String nointerior, String pais, String referencia)
    {
        las_lugar_expedicion[0] = calle;
        las_lugar_expedicion[1] = cp;
        las_lugar_expedicion[2] = colonia;
        las_lugar_expedicion[3] = estado;
        las_lugar_expedicion[4] = localidad;
        las_lugar_expedicion[5] = municipio;
        las_lugar_expedicion[6] = noexterior;
        las_lugar_expedicion[7] = nointerior;
        las_lugar_expedicion[8] = pais;
        las_lugar_expedicion[9] = referencia;
        return las_lugar_expedicion;
    }

    public String[] setReceptor(String nombre, String rfc)
    {
    	
        las_receptor[0] = nombre;
        las_receptor[1] = rfc;
        System.out.println(" setReceptor"  + las_receptor[0]);
        System.out.println(" setReceptor"  + las_receptor[1]);
        return las_receptor;
    }

    public String[] setDomicilioCliente(String calle, String cp, String colonia, String estado, String localidad, String municipio, String noexterior,
            String nointerior, String pais, String referencia)
    {
        las_domicilio_cliente[0] = calle;
        las_domicilio_cliente[1] = cp;
        las_domicilio_cliente[2] = colonia;
        las_domicilio_cliente[3] = estado;
        las_domicilio_cliente[4] = localidad;
        las_domicilio_cliente[5] = municipio;
        las_domicilio_cliente[6] = noexterior;
        las_domicilio_cliente[7] = nointerior;
        las_domicilio_cliente[8] = pais;
        las_domicilio_cliente[9] = referencia;
        return las_domicilio_cliente;
    }

    public void setConceptos(int idx, String a1, String a2, String a3, String a4)
    {
        idx--;
        las_conceptos[idx][0] = a1;
        las_conceptos[idx][1] = a2;
        las_conceptos[idx][2] = a3;
        las_conceptos[idx][3] = a4;
    }

    public String [][] setConceptos(int idConcepto, String cve, String unidad, String cantidad, String descripcion, String importe, String valorunitario)
    {
        idConcepto--;
        las_conceptos[idConcepto][0] = cve;
        las_conceptos[idConcepto][1] = unidad;
        las_conceptos[idConcepto][2] = cantidad;
        las_conceptos[idConcepto][3] = descripcion;
        las_conceptos[idConcepto][4] = importe;
        las_conceptos[idConcepto][5] = valorunitario;
        return las_conceptos;
    }

    public String  [][]setImpuestos(int idx, String importe, String tasa, String descripcion)
    {
        idx--;
        las_impuestos[idx][0] = importe;
        las_impuestos[idx][1] = tasa;
        las_impuestos[idx][2] = descripcion;
        return las_impuestos;
    }

    public void setPrivada(String a1, String a2)
        throws IOException
    {
        pcfd.setLlavePrivada64(a1, a2);
    }

    public void setPrivadaFile(String a1, String a2)
        throws IOException
    {
        pcfd.setLlavePrivada(a1, a2);
    }

    public void setPublica(String a1)
        throws IOException
    {
        pcfd.setLlavePublica64(a1);
    }

    public void setPublicaFile(String a1)
        throws IOException
    {
        pcfd.setLlavePublica(a1);
    }

    public String getCadena()
    {
        return pcfd.getCadenaOriginal();
    }

    public String getSello()
    {
        return pcfd.getSelloDigital();
    }

    public void setTotalConceptos(int tc)
    {
        tcon = tc;
        las_conceptos = new String[tcon][6];
    }

    public void setTotalImp(int ti)
    {
        timp = ti;
        las_impuestos = new String[timp][4];
    }

 

    public int CreaComprobante(String privada, String pass, String publica)
        throws IOException, Exception
    {
            pcfd = new CFD();
            setPrivadaFile(privada, pass);
            setPublicaFile(publica);
            pcfd.creaEmisor(las_emisor, las_domicilio_emisor);
            pcfd.creaLugarExpedicion(las_lugar_expedicion);
            pcfd.creaReceptor(las_receptor, las_domicilio_cliente);
            System.out.println("CreaComprobante " + pcfd.receptor.getRfc());
            String _conceptos[] = new String[6];
            //System.out.println("LIB crea comprobante conce "+tcon);
            for(int i = 0; i <= tcon - 1; i++)
            {
                for(int j = 0; j <= 5; j++){
                	_conceptos[j] = las_conceptos[i][j];
                }
                    

                pcfd.creaConceptos(_conceptos);
                
                //System.out.println("lib concepto"+pcfd.conceptos.getConcepto().size());	
                
                
            }

            String _impuestos[][] = new String[timp][4];
            for(int i = 0; i <= timp - 1; i++)
            {
                for(int j = 0; j <= 3; j++)
                    _impuestos[i][j] = las_impuestos[i][j];

            }

            pcfd.creaImpuestos(_impuestos);

        return 1;
    }

    public int CreaXML(String xmlfile, String ruta) throws Exception
    {
        
         pcfd.creaComprobante(args, xmlfile, ruta);
                
        return 1;
    }

    public int CreaPDF(String xmlfile, String imagenfile, String pdffile, String sucursal, String coordenadas)  throws Exception
    {
    	 	
            gpdf = new GeneraPDF();
            gpdf.setImagen(imagenfile);
            gpdf.setNombreSucursal(sucursal);
            gpdf.setCoordenadas(coordenadas);
            gpdf.construyePDF(xmlfile, pdffile);
            System.out.println((new StringBuilder("Se ha creado documento: ")).append(pdffile).toString());
        return 1;
    }
}
