/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.xml2pdf;


import mx.com.factmex.app.server.services.factura.cfdv2.exceptions.ParseComprobanteException;
import mx.com.factmex.app.server.services.factura.cfdv2.util.CadenaOriginalv2;
import mx.com.factmex.app.server.services.factura.cfdv2.util.GenerarCadenaOriginalException;
import mx.com.factmex.app.server.services.factura.cfdv2.util.MarshallCFDv2XML;
import mx.com.factmex.app.server.services.factura.cfdv2.*;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException; 
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Paragraph;
import com.lowagie.*;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.util.List;
import mx.com.factmex.app.server.services.factura.xml2pdf.util.*;


public class GeneraPDF {

    Document document;
    PdfWriter writer;
    PdfContentByte content;
    Image image;
    Coordenadas[] coord;
    Comprobante cfd;
    Comprobante.Emisor emisor;
    TUbicacionFiscal domicilioFiscal;
    Comprobante.Receptor receptor;
    TUbicacion domicilio;
    TUbicacion lugarExpedicion;
    Comprobante.Conceptos conceptos;
    Comprobante.Conceptos.Concepto concepto;
    List conceptoLst;
    Comprobante.Impuestos impuestos;
    CadenaOriginalv2 cadenaoriginal;
    ConversorLetras conversorletras;
    DecimalFormat df;
    String publicoGeneral;
    String nombreSucursal;
    String imagen;
    int pagina;
    int totPaginas;
    int inicioDocumento;
    int finDocumento;

    public GeneraPDF() {
        this.conversorletras = new ConversorLetras();
        this.document = new Document();
        this.cadenaoriginal = new CadenaOriginalv2();

        this.publicoGeneral = "XAXX010101000";

        this.pagina = 0;
        this.finDocumento = 95;

        this.df = new DecimalFormat("#,##0.00");
    }

    public void construyePDF(String xml, String pdf)
            throws DocumentException, MalformedURLException, IOException, GenerarCadenaOriginalException, ParseComprobanteException {
        DecimalFormat cent = new DecimalFormat("00");

        int i = 19;
        this.cfd = MarshallCFDv2XML.unmarshalCfdV2(new FileInputStream(xml));
        this.emisor = this.cfd.getEmisor();
        this.receptor = this.cfd.getReceptor();
        this.conceptos = this.cfd.getConceptos();
        this.impuestos = this.cfd.getImpuestos();

        this.document = new Document(PageSize.LETTER);
        this.document.setMargins(1.0F, 1.0F, 1.0F, 1.0F);

        this.writer = PdfWriter.getInstance(this.document, new FileOutputStream(pdf));

        this.image = Image.getInstance(this.imagen);
        this.image.setAlignment(8);
        this.image.scaleAbsolute(610.0F, 800.0F);

        BigDecimal total = new BigDecimal(0.0D);

        this.inicioDocumento = this.coord[i].intY();

        int y = this.inicioDocumento;
        int ii = i;

        int anchoCadenas = 128;
        int numRenglones = 55;

        boolean primerPagina = true;

        this.conceptoLst = this.conceptos.getConcepto();
        String selloDigital = this.cfd.getSello();
        String cadenaOriginal = this.cadenaoriginal.generarCadenaOriginal(this.cfd);
        int cantConceptos = this.conceptoLst.size();
        int totalRenglones = cantConceptos
                + selloDigital.length() / anchoCadenas + 2
                + cadenaOriginal.length() / anchoCadenas + 2
                + 3;
        this.totPaginas = (totalRenglones / numRenglones);
       if (this.totPaginas > 0) {
            primerPagina = false;
            if (totalRenglones % numRenglones > 0) {
                this.totPaginas += 1;
            }
        } else {
            primerPagina = true;
            this.totPaginas = 1;
        }

        paginaNueva();

        for (int j = 0; j < cantConceptos; j++) {
            i = ii;
            this.concepto = ((Comprobante.Conceptos.Concepto) this.conceptoLst.get(j));

            BigDecimal cantidad = this.concepto.getCantidad();
            String descripcion = this.concepto.getDescripcion();
            BigDecimal importe = this.concepto.getImporte();
            BigDecimal unitario = this.concepto.getValorUnitario();

            this.content.showTextAligned(2, String.valueOf(cantidad.doubleValue()), this.coord[i].intX(), y, 0.0F);
            i++;

            this.content.showTextAligned(0, descripcion, this.coord[i].intX(), y, 0.0F);
            i++;

            this.content.showTextAligned(2, this.df.format(unitario.doubleValue()), this.coord[i].intX(), y, 0.0F);
            i++;

            this.content.showTextAligned(2, this.df.format(importe.doubleValue()), this.coord[i].intX(), y, 0.0F);
            i++;

            y -= 8;

            if ((y < this.finDocumento) && (j < cantConceptos)) {
                paginaNueva();

                y = this.inicioDocumento;
            }
        }
        this.content.setFontAndSize(BaseFont.createFont("Courier", "Cp1252", false), 7.0F);
        this.content.setColorFill(Color.BLUE);
        pintaCampo("cadena original", y, anchoCadenas, new Coordenadas(38, y - 5));
        this.content.setColorFill(Color.BLACK);
        y = pintaCampo(cadenaOriginal, y, anchoCadenas, new Coordenadas(38, y - 15));
        this.content.setColorFill(Color.BLUE);
        pintaCampo("sello digital", y, anchoCadenas, new Coordenadas(38, y));
        this.content.setColorFill(Color.BLACK);
        y = pintaCampo(selloDigital, y, anchoCadenas, new Coordenadas(38, y - 10));
        BigDecimal impuestoTotal = this.impuestos.getTotalImpuestosTrasladados();
        this.content.setColorFill(Color.BLUE);
        this.content.setFontAndSize(BaseFont.createFont("Helvetica-Bold", "Cp1252", false), 7.0F);
        if (!this.receptor.getRfc().equals(this.publicoGeneral)) {
        	if(this.impuestos.getRetenciones()==null){
            		pintaCampo("subtotal:", i, 0, new Coordenadas(540,79),2);
                    pintaImporte(this.df.format(this.cfd.getSubTotal().doubleValue()), i, new Coordenadas(575, 79));
                    i++;
                    //pintaCampo("iva 16%:", i, 0, new Coordenadas(540,69),2);
                    String etiquetaIva = impuestos.getTraslados().getTraslado().get(0).getImpuesto()+" "+impuestos.getTraslados().getTraslado().get(0).getTasa().toString()+"%:";
                    pintaCampo(etiquetaIva, i, 0, new Coordenadas(540,69),2);
                    pintaImporte(this.df.format(impuestoTotal.doubleValue()), i, new Coordenadas(575, 69));
                    i++;
                    pintaCampo("total:", i, 0, new Coordenadas(540,61),2);
                    pintaImporte(this.df.format(this.cfd.getTotal().doubleValue()), i, new Coordenadas(575, 61));
                    i++;
                
            }
        	else{
            	pintaCampo("importe:", i, 0, new Coordenadas(540,79),2);
                pintaImporte(this.df.format(this.cfd.getSubTotal().doubleValue()-impuestoTotal.doubleValue()), i, new Coordenadas(575, 79));
                i++;
                String etiquetaIva = impuestos.getTraslados().getTraslado().get(0).getImpuesto()+" "+impuestos.getTraslados().getTraslado().get(0).getTasa().toString()+"%:";
                pintaCampo(etiquetaIva, i, 0, new Coordenadas(540,69),2);
                pintaImporte(this.df.format(impuestoTotal.doubleValue()), i, new Coordenadas(575, 69));
                i++;
                pintaCampo("subtotal:", i, 0, new Coordenadas(540,59),2);
                pintaImporte(this.df.format(this.cfd.getSubTotal().doubleValue()), i, new Coordenadas(575, 59));
                i++;
                if(impuestos.getRetenciones().getRetencion().get(0)!=null){
                    pintaCampo("Retencion iva:", i, 0, new Coordenadas(540,49),2);
                    pintaImporte(this.df.format(impuestos.getRetenciones().getRetencion().get(0).getImporte().doubleValue()), i, new Coordenadas(575, 49));
                    i++;
                }
                if(impuestos.getRetenciones().getRetencion().size()>=2){
                   if(impuestos.getRetenciones().getRetencion().get(1)!=null){
                	   pintaCampo("Retencion ISR:", i, 0, new Coordenadas(540,39),2);
                       pintaImporte(this.df.format(impuestos.getRetenciones().getRetencion().get(1).getImporte().doubleValue()), i, new Coordenadas(575, 39));
                       i++;
                    }
                }
                
                pintaCampo("total:", i, 0, new Coordenadas(540,30),2);
                pintaImporte(this.df.format(this.cfd.getTotal().doubleValue()), i, new Coordenadas(575, 30));
                i++;
            }
            
        } else {
            i += 2;
            pintaCampo("total:", i, 0, new Coordenadas(540,61),2);
            pintaImporte(this.df.format(this.cfd.getTotal().doubleValue()), i, new Coordenadas(575, 61));
            i++;
        }
        
        String importeLetra = "(" + this.conversorletras.convertirLetras((int) this.cfd.getTotal().doubleValue()).toUpperCase()
                + " PESOS "
                + cent.format((int) ((this.cfd.getTotal().doubleValue() - (int) this.cfd.getTotal().doubleValue()) * 100.0D))
                + "/100 M.N.)";

        

        pintaCampo("importe con letra", i, 0, new Coordenadas(38,79));
        this.content.setFontAndSize(BaseFont.createFont("Helvetica", "Cp1252", false), 7.0F);
        this.content.setColorFill(Color.BLACK);
        pintaCampo(importeLetra, i, 0, new Coordenadas(38,61));
        i++;
        this.content.endText();
        this.document.close();
    }

    private void paginaNueva()
            throws DocumentException, IOException {
        String cadDomicilio = "";

        this.pagina += 1;

        if (this.pagina == 1) {
            this.document.open();
        } else {
            this.content.endText();
            this.document.newPage();
        }

        this.document.add(this.image);

        this.content = this.writer.getDirectContent();
        this.content.setFontAndSize(BaseFont.createFont("Helvetica", "Cp1252", false), 7.0F);
        this.content.beginText();

        int i = 0;

        pintaCampo(this.cfd.getNoCertificado(), i++, 0, null);

        pintaCampo(this.cfd.getFecha().toString(), i++, 0, null);

        this.content.setFontAndSize(BaseFont.createFont("Helvetica", "Cp1252", false), 10.0F);
        this.content.setColorFill(Color.RED);
        pintaCampo(this.cfd.getFolio(), i++, 0, null);
        this.content.setFontAndSize(BaseFont.createFont("Helvetica", "Cp1252", false), 7.0F);
        this.content.setColorFill(Color.BLACK);

        pintaCampo(this.cfd.getSerie(), i++, 0, null);

        pintaCampo(String.valueOf(this.cfd.getNoAprobacion()), i++, 0, null);

        pintaCampo(this.receptor.getNombre(), i++, 0, null);

        pintaCampo(this.receptor.getRfc(), i++, 0, null);

        this.domicilio = this.receptor.getDomicilio();

        String info = this.domicilio.getCalle();
        if (info != null) {
            cadDomicilio = cadDomicilio + info + " ";
        }
        info = this.domicilio.getNoExterior();
        if (info != null) {
            cadDomicilio = cadDomicilio + info + " ";
        }
        info = this.domicilio.getNoInterior();
        if (info != null) {
            cadDomicilio = cadDomicilio + info + " ";
        }
        pintaCampo(cadDomicilio, i++, 0, null);

        pintaCampo(this.domicilio.getColonia(), i++, 0, null);

        pintaCampo(this.domicilio.getMunicipio(), i++, 0, null);

        info = this.domicilio.getEstado();
        if (info != null) {
            pintaCampo(this.domicilio.getEstado().toUpperCase(), i++, 0, null);
        } else {
            i++;
        }

        pintaCampo(this.domicilio.getCodigoPostal(), i++, 0, null);

        info = this.domicilio.getPais();
        if (info != null) {
            pintaCampo(this.domicilio.getPais().toUpperCase(), i++, 0, null);
        } else {
            i++;
        }
        
        this.lugarExpedicion = this.emisor.getExpedidoEn();
        pintaCampo(this.nombreSucursal, i++, 0, null, 1);
        cadDomicilio = "";
        info = this.lugarExpedicion.getCalle();
        if (info != null) {
            cadDomicilio = cadDomicilio + info + " ";
        }
        info = this.lugarExpedicion.getNoExterior();
        if (info != null) {
            cadDomicilio = cadDomicilio + info + " ";
        }
        info = this.lugarExpedicion.getNoInterior();
        if (info != null) {
            cadDomicilio = cadDomicilio + info + " ";
        }
        pintaCampo(cadDomicilio, i++, 0, null, 1);

        pintaCampo(this.lugarExpedicion.getColonia(), i++, 0, null, 1);

        pintaCampo(this.lugarExpedicion.getMunicipio(), i++, 0, null, 1);

        pintaCampo(this.lugarExpedicion.getEstado(), i++, 0, null, 1);

        pintaCampo((this.lugarExpedicion.getMunicipio() + ", " + this.lugarExpedicion.getEstado()).toUpperCase(), 1, 0, new Coordenadas(-170, 0));

        pintaCampo(this.lugarExpedicion.getCodigoPostal(), i++, 0, null, 1);

        //pintaCampo(this.lugarExpedicion.getPais(), i++, 0, null,1);
        info=this.emisor.getNombre();
        String nombrecompleto="";
        if(info!=null){
        	nombrecompleto=nombrecompleto+info+" ";
        }
        Paragraph par = new Paragraph(nombrecompleto);
        par.font().setStyle(Font.BOLD);
        par.setAlignment(Element.ALIGN_CENTER);
        document.add(par);
        info=this.emisor.getRfc();
        pintaCampo(info, i, 0, new Coordenadas(306,765),1);
        String lugar = "";
        info = this.lugarExpedicion.getEstado();
        if (info != null) {
            lugar = lugar + info + " ";
        }
        info = this.lugarExpedicion.getMunicipio();
        if (info != null) {
            lugar = lugar + ", " + info + " ";
        }
        info=this.cfd.getFormaDePago();
        pintaCampo(info, i, 0, new Coordenadas(40,575),0);
        pintaCampo(lugar, i, 0, new Coordenadas(460,650),0);
        pintaCampo("Página " + this.pagina + " de " + this.totPaginas, 29, 0, null);
    }

    private int pintaCampo(String data, int i, int tam, Coordenadas ref)
            throws DocumentException, IOException {
    	int refx = 0;
        int refy = 0;

        if (ref != null) {
            refx = ref.intX();
            refy = ref.intY();

        } else {
            refx = coord[i].intX();
            refy = coord[i].intY();
        }
        if ((data == null) || (data.equals("null")) || (data.trim().equals(""))) {
            return 0;
        }

        if (tam > 0) {

            String[] partes = descomponerCadena(tam, data);

            if (refy - 2 < this.finDocumento) {
                refy = this.inicioDocumento;
                paginaNueva();
            }

            for (int j = 0; j < data.length() / tam + 1; j++) {
                this.content.showTextAligned(0,partes[j],refx,refy,0.0F);
                refy -= 8;

                if (refy < this.finDocumento) {
                    refy = this.inicioDocumento;
                    paginaNueva();
                    this.content.setFontAndSize(BaseFont.createFont("Courier", "Cp1250", false), 7.0F);
                }
            }
            return refy- 8;
        }

        this.content.showTextAligned(0,data,refx,refy,0.0F);

        i = refy;

        return i - 8;
    }

    private int pintaCampo(String data, int i, int tam, Coordenadas ref, int alin)
            throws DocumentException, IOException {
        int y = this.coord[i].intY();

        int refx = 0;
        int refy = 0;

        if (ref != null) {
            refx = ref.intX();
            refy = ref.intY();

        } else {
            refx = coord[i].intX();
            refy = coord[i].intY();
        }
        if ((data == null) || (data.equals("null")) || (data.trim().equals(""))) {
            return 0;
        }

        if (tam > 0) {

            String[] partes = descomponerCadena(tam, data);

            if (y + refy - 2 < this.finDocumento) {
                refy = this.inicioDocumento;
                y = 0;
                paginaNueva();
            }

            for (int j = 0; j < data.length() / tam + 1; j++) {
                this.content.showTextAligned(0,partes[j],refx,y + refy,0.0F);
                y -= 6;

                if (y + refy < this.finDocumento) {
                    refy = this.inicioDocumento;
                    y = 0;
                    paginaNueva();

                    this.content.setFontAndSize(BaseFont.createFont("Courier", "Cp1250", false), 7.0F);
                }
            }
            return y + refy - 8;
        }

        this.content.showTextAligned(alin,data,refx,refy,0.0F);

        y = refy;

        return y - 8;
    }

    private void pintaImporte(String data, int i, Coordenadas ref ) {
        int refx = 0;
        int refy = 0;

        if (data == null) {
            return;
        }

        if (ref != null) {
            refx = ref.intX();
            refy = ref.intY();
        }

        this.content.showTextAligned(2,data,refx, refy,0.0F);
    }
    private void pintaImporte(String data, int i, Coordenadas ref,int alin ) {
        int refx = 0;
        int refy = 0;

        if (data == null) {
            return;
        }

        if (ref != null) {
            refx = ref.intX();
            refy = ref.intY();
        }

        this.content.showTextAligned(alin,data,refx, refy,0.0F);
    }
    private String[] descomponerCadena(int tamCad, String cadenota) {
        String[] arregloCadenas = new String[15000];

        int i = 0;
        int ind = 0;
        if (tamCad > 0) {
            while (i < cadenota.length()) {
                if (i + tamCad <= cadenota.length()) {
                    arregloCadenas[(ind++)] = cadenota.substring(i, i + tamCad);
                } else {
                    arregloCadenas[(ind++)] = cadenota.substring(i, cadenota.length());
                }
                i += tamCad;
            }
        } else {
            arregloCadenas[ind] = "";
        }
        return arregloCadenas;
    }

    private String[] descomponerDescripcion(int tamCad, String cadenota) {
        String[] arregloCadenas = new String[20];

        int i = 0;
        int ind = 0;
        int sep = 0;

        while (i < cadenota.length()) {
            if (i + tamCad <= cadenota.length()) {
                String sub_cadena = cadenota.substring(i, i + tamCad);
                sep = sub_cadena.lastIndexOf(" ");
                arregloCadenas[(ind++)] = sub_cadena.substring(0, sep);

                i += sep;
            } else {
                arregloCadenas[(ind++)] = cadenota.substring(i, cadenota.length());

                i += tamCad;
            }
        }

        return arregloCadenas;
    }

    public void setPublicoGenera(String pg) {
        this.publicoGeneral = pg;
    }

    public void setImagen(String img) {
        this.imagen = img;
    }

    public void setNombreSucursal(String suc) {
        this.nombreSucursal = suc;
    }

    public void defaultPublicoGenera() {
        this.publicoGeneral = "XAXX010101000";
    }

    public void setCoordenadas(String ruta) throws IOException, ClassNotFoundException {
        this.coord = Coordenadas.leerDesdeArchivo(ruta);
    }
}
