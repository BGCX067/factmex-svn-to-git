/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.cfdv2.util;

import mx.com.factmex.app.server.services.factura.cfdv2.Comprobante;
import mx.com.factmex.app.server.services.factura.cfdv2.TInformacionAduanera;
import mx.com.factmex.app.server.services.factura.cfdv2.TUbicacion;
import mx.com.factmex.app.server.services.factura.cfdv2.TUbicacionFiscal;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import org.w3c.dom.*;
/**
 *
 * @author Jonathan
 */
public class CadenaOriginalv3
{

    public CadenaOriginalv3()
    {
        r = 0;
        cadenaOriginal = "";
    }

    public String generarCadenaOriginal(Comprobante comprobante)
        throws GenerarCadenaOriginalException
    {
        if(comprobante == null)
            throw new GenerarCadenaOriginalException(GenerarCadenaOriginalException.COMPROBANTE_SIN_VALOR);
        if(comprobante.getVersion() != null)
            appendToCadenaOriginal(comprobante.getVersion());
        if(comprobante.getSerie() != null)
            appendToCadenaOriginal(comprobante.getSerie());
        if(comprobante.getFolio() != null)
            appendToCadenaOriginal(comprobante.getFolio());
        if(comprobante.getFecha() != null)
            appendToCadenaOriginal(comprobante.getFecha());
        if(comprobante.getNoAprobacion() != null)
            appendToCadenaOriginal(comprobante.getNoAprobacion());
        if(comprobante.getAnoAprobacion() != null)
            appendToCadenaOriginal(comprobante.getAnoAprobacion());
        if(comprobante.getTipoDeComprobante() != null)
            appendToCadenaOriginal(comprobante.getTipoDeComprobante());
        if(comprobante.getFormaDePago() != null)
            appendToCadenaOriginal(comprobante.getFormaDePago());
        if(comprobante.getCondicionesDePago() != null)
            appendToCadenaOriginal(comprobante.getCondicionesDePago());
        if(comprobante.getSubTotal() != null)
            appendToCadenaOriginal(comprobante.getSubTotal());
        if(comprobante.getDescuento() != null)
            appendToCadenaOriginal(comprobante.getDescuento());
        if(comprobante.getTotal() != null)
            appendToCadenaOriginal(comprobante.getTotal());
        mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Emisor emisor = comprobante.getEmisor();
        if(emisor == null)
            throw new GenerarCadenaOriginalException(GenerarCadenaOriginalException.EMISOR_SIN_VALOR);
        if(emisor.getRfc() != null)
            appendToCadenaOriginal(emisor.getRfc());
        if(emisor.getNombre() != null)
            appendToCadenaOriginal(emisor.getNombre());
        TUbicacionFiscal domicilioFiscalDelEmisor = emisor.getDomicilioFiscal();
        if(domicilioFiscalDelEmisor == null)
            throw new GenerarCadenaOriginalException(GenerarCadenaOriginalException.DOMICILIO_FISCAL_EMISOR_SIN_VALOR);
        if(domicilioFiscalDelEmisor.getCalle() != null)
            appendToCadenaOriginal(domicilioFiscalDelEmisor.getCalle());
        if(domicilioFiscalDelEmisor.getNoExterior() != null)
            appendToCadenaOriginal(domicilioFiscalDelEmisor.getNoExterior());
        if(domicilioFiscalDelEmisor.getNoInterior() != null)
            appendToCadenaOriginal(domicilioFiscalDelEmisor.getNoInterior());
        if(domicilioFiscalDelEmisor.getColonia() != null)
            appendToCadenaOriginal(domicilioFiscalDelEmisor.getColonia());
        if(domicilioFiscalDelEmisor.getLocalidad() != null)
            appendToCadenaOriginal(domicilioFiscalDelEmisor.getLocalidad());
        if(domicilioFiscalDelEmisor.getReferencia() != null)
            appendToCadenaOriginal(domicilioFiscalDelEmisor.getReferencia());
        if(domicilioFiscalDelEmisor.getMunicipio() != null)
            appendToCadenaOriginal(domicilioFiscalDelEmisor.getMunicipio());
        if(domicilioFiscalDelEmisor.getEstado() != null)
            appendToCadenaOriginal(domicilioFiscalDelEmisor.getEstado());
        if(domicilioFiscalDelEmisor.getPais() != null)
            appendToCadenaOriginal(domicilioFiscalDelEmisor.getPais());
        if(domicilioFiscalDelEmisor.getCodigoPostal() != null)
            appendToCadenaOriginal(domicilioFiscalDelEmisor.getCodigoPostal());
        TUbicacion domicilioExpedidoEn = emisor.getExpedidoEn();
        if(domicilioExpedidoEn != null)
        {
            if(domicilioExpedidoEn.getCalle() != null)
                appendToCadenaOriginal(domicilioExpedidoEn.getCalle());
            if(domicilioExpedidoEn.getNoExterior() != null)
                appendToCadenaOriginal(domicilioExpedidoEn.getNoExterior());
            if(domicilioExpedidoEn.getNoInterior() != null)
                appendToCadenaOriginal(domicilioExpedidoEn.getNoInterior());
            if(domicilioExpedidoEn.getColonia() != null)
                appendToCadenaOriginal(domicilioExpedidoEn.getColonia());
            if(domicilioExpedidoEn.getLocalidad() != null)
                appendToCadenaOriginal(domicilioExpedidoEn.getLocalidad());
            if(domicilioExpedidoEn.getReferencia() != null)
                appendToCadenaOriginal(domicilioExpedidoEn.getReferencia());
            if(domicilioExpedidoEn.getMunicipio() != null)
                appendToCadenaOriginal(domicilioExpedidoEn.getMunicipio());
            if(domicilioExpedidoEn.getEstado() != null)
                appendToCadenaOriginal(domicilioExpedidoEn.getEstado());
            if(domicilioExpedidoEn.getPais() != null)
                appendToCadenaOriginal(domicilioExpedidoEn.getPais());
            if(domicilioExpedidoEn.getCodigoPostal() != null)
                appendToCadenaOriginal(domicilioExpedidoEn.getCodigoPostal());
        }
        mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Receptor receptor = comprobante.getReceptor();
        if(receptor == null)
            throw new GenerarCadenaOriginalException(GenerarCadenaOriginalException.RECEPTOR_SIN_VALOR);
        if(receptor.getRfc() != null)
            appendToCadenaOriginal(receptor.getRfc());
        if(receptor.getNombre() != null)
            appendToCadenaOriginal(receptor.getNombre());
        TUbicacion domicilioReceptor = receptor.getDomicilio();
        if(domicilioReceptor == null)
            throw new GenerarCadenaOriginalException(GenerarCadenaOriginalException.DOMICILIO_RECEPTOR_SIN_VALOR);
        if(domicilioReceptor.getCalle() != null)
            appendToCadenaOriginal(domicilioReceptor.getCalle());
        if(domicilioReceptor.getNoExterior() != null)
            appendToCadenaOriginal(domicilioReceptor.getNoExterior());
        if(domicilioReceptor.getNoInterior() != null)
            appendToCadenaOriginal(domicilioReceptor.getNoInterior());
        if(domicilioReceptor.getColonia() != null)
            appendToCadenaOriginal(domicilioReceptor.getColonia());
        if(domicilioReceptor.getLocalidad() != null)
            appendToCadenaOriginal(domicilioReceptor.getLocalidad());
        if(domicilioReceptor.getReferencia() != null)
            appendToCadenaOriginal(domicilioReceptor.getReferencia());
        if(domicilioReceptor.getMunicipio() != null)
            appendToCadenaOriginal(domicilioReceptor.getMunicipio());
        if(domicilioReceptor.getEstado() != null)
            appendToCadenaOriginal(domicilioReceptor.getEstado());
        if(domicilioReceptor.getPais() != null)
            appendToCadenaOriginal(domicilioReceptor.getPais());
        if(domicilioReceptor.getCodigoPostal() != null)
            appendToCadenaOriginal(domicilioReceptor.getCodigoPostal());
        mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Conceptos conceptos = comprobante.getConceptos();
        if(conceptos == null && conceptos.getConcepto().size() < 1)
            throw new GenerarCadenaOriginalException(GenerarCadenaOriginalException.CONCEPTOS_SIN_VALOR);
        mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Conceptos.Concepto arrConceptos[] = new mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Conceptos.Concepto[conceptos.getConcepto().size()];
        arrConceptos = (mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Conceptos.Concepto[])conceptos.getConcepto().toArray(arrConceptos);
        mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Conceptos.Concepto aconcepto[];
        int j = (aconcepto = arrConceptos).length;
        for(int i = 0; i < j; i++)
        {
            mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Conceptos.Concepto r = aconcepto[i];
            if(r.getCantidad() != null)
                appendToCadenaOriginal(r.getCantidad());
            if(r.getUnidad() != null)
                appendToCadenaOriginal(r.getUnidad());
            if(r.getNoIdentificacion() != null)
                appendToCadenaOriginal(r.getNoIdentificacion());
            if(r.getDescripcion() != null)
                appendToCadenaOriginal(r.getDescripcion());
            if(r.getValorUnitario() != null)
                appendToCadenaOriginal(r.getValorUnitario());
            if(r.getImporte() != null)
                appendToCadenaOriginal(r.getImporte());
            if(r.getInformacionAduanera() != null && r.getInformacionAduanera().size() > 0)
            {
                TInformacionAduanera informacionAduaneraArr[] = new TInformacionAduanera[r.getInformacionAduanera().size()];
                informacionAduaneraArr = (TInformacionAduanera[])r.getInformacionAduanera().toArray(informacionAduaneraArr);
                TInformacionAduanera atinformacionaduanera[];
                int l1 = (atinformacionaduanera = informacionAduaneraArr).length;
                for(int j1 = 0; j1 < l1; j1++)
                {
                    TInformacionAduanera tia = atinformacionaduanera[j1];
                    if(tia.getNumero() != null)
                        appendToCadenaOriginal(tia.getNumero());
                    if(tia.getFecha() != null)
                        appendToCadenaOriginal(tia.getFecha());
                    if(tia.getAduana() != null)
                        appendToCadenaOriginal(tia.getAduana());
                }

            }
            if(r.getCuentaPredial() != null && r.getCuentaPredial().getNumero() != null)
                r.getCuentaPredial().getNumero();
            String strComplmentoConcepto = IncluirNodoComplementoConcepto(r.getComplementoConcepto());
            if(strComplmentoConcepto != null)
                appendToCadenaOriginal(strComplmentoConcepto);
        }

        mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Impuestos impuestos = comprobante.getImpuestos();
        if(impuestos != null)
        {
            mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Impuestos.Retenciones retenciones = impuestos.getRetenciones();
            if(retenciones != null && retenciones.getRetencion().size() > 0)
            {
                mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Impuestos.Retenciones.Retencion arrRetenciones[] = new mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Impuestos.Retenciones.Retencion[retenciones.getRetencion().size()];
                arrRetenciones = (mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Impuestos.Retenciones.Retencion[])retenciones.getRetencion().toArray(arrRetenciones);
                mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Impuestos.Retenciones.Retencion aretencion[];
                int l = (aretencion = arrRetenciones).length;
                for(int k = 0; k < l; k++)
                {
                    mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Impuestos.Retenciones.Retencion r = aretencion[k];
                    if(r.getImpuesto() != null)
                        appendToCadenaOriginal(r.getImpuesto());
                    if(r.getImporte() != null)
                        appendToCadenaOriginal(r.getImporte());
                }

                if(impuestos.getTotalImpuestosRetenidos() == null)
                    throw new GenerarCadenaOriginalException(GenerarCadenaOriginalException.TOTAL_IMPUESTOS_RETENIDOS_SIN_VALOR);
                appendToCadenaOriginal(impuestos.getTotalImpuestosRetenidos());
            }
            mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Impuestos.Traslados traslados = impuestos.getTraslados();
            if(traslados != null && traslados.getTraslado().size() > 0)
            {
                mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Impuestos.Traslados.Traslado arrTraslados[] = new mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Impuestos.Traslados.Traslado[traslados.getTraslado().size()];
                arrTraslados = (mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Impuestos.Traslados.Traslado[])traslados.getTraslado().toArray(arrTraslados);
                mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Impuestos.Traslados.Traslado atraslado[];
                int k1 = (atraslado = arrTraslados).length;
                for(int i1 = 0; i1 < k1; i1++)
                {
                    mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Impuestos.Traslados.Traslado r = atraslado[i1];
                    if(r.getImpuesto() != null)
                        appendToCadenaOriginal(r.getImpuesto());
                    if(r.getTasa() != null)
                        appendToCadenaOriginal(r.getTasa());
                    if(r.getImporte() != null)
                        appendToCadenaOriginal(r.getImporte());
                }

                if(impuestos.getTotalImpuestosTrasladados() == null)
                    throw new GenerarCadenaOriginalException(GenerarCadenaOriginalException.TOTAL_IMPUESTOS_TRASLADADOS_SIN_VALOR);
                appendToCadenaOriginal(impuestos.getTotalImpuestosTrasladados());
            }
        }
        cadenaOriginal = cadenaOriginal.replaceAll("\321", "\321");
        cadenaOriginal = cadenaOriginal.replaceAll("\361", "\322");
        return cadenaOriginal = (new StringBuilder("||")).append(cadenaOriginal.replaceAll("\\s+", " ").trim()).append("|").toString();
    }

    protected String IncluirNodoComplementoConcepto(mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Conceptos.Concepto.ComplementoConcepto cc)
    {
        return null;
    }

    protected void IncluirNodoComplemento(mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Complemento cc)
    {
        String cadenota = null;
        String name = null;
        try
        {
            List ls = cc.getAny();
            Element e = (Element)ls.iterator().next();
            name = e.getNodeName();
            if(name.indexOf(":") > 0)
                name = name.substring(name.indexOf(":") + 1, name.length());
            String padre_atributo = name;
            if(padre_atributo.indexOf(":") > 0)
                padre_atributo = padre_atributo.substring(name.indexOf(":") + 1, padre_atributo.length());
            String valor = e.getFirstChild().getNodeValue();
            NamedNodeMap a1 = e.getAttributes();
            if(a1 != null && a1.getLength() > 0)
            {
                for(int j = 0; j < a1.getLength(); j++)
                    try
                    {
                        name = a1.item(j).getNodeName();
                        if(name.indexOf(":") > 0)
                            name = name.substring(name.indexOf(":") + 1, name.length());
                        valor = a1.item(j).getNodeValue();
                        if(detallista[0][r].equals(padre_atributo) && detallista[1][r].equals(name))
                        {
                            if(valor != null)
                                appendToCadenaOriginal(valor);
                            r++;
                        }
                        if(name != null)
                            System.out.println((new StringBuilder("Atributo 0 : ")).append(name).append(" = ").append(valor).toString());
                    }
                    catch(Exception e1)
                    {
                        System.out.println(e1);
                    }

            }
            parsearComplemento(e, Integer.valueOf(1), e.getNodeName(), cadenota);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void parsearComplemento(Element el, Integer nivel, String padre, String cadena)
    {
        Element docEle = el;
        String name = el.getNodeName();
        if(name.indexOf(":") > 0)
            name = name.substring(name.indexOf(":") + 1, name.length());
        padre = name;
        String valor = el.getFirstChild().getNodeValue();
        NodeList nl = docEle.getChildNodes();
        if(nl != null && nl.getLength() > 0)
        {
            for(int i = 0; i < nl.getLength(); i++)
                try
                {
                    Element elemento1 = (Element)nl.item(i);
                    NamedNodeMap a1 = elemento1.getAttributes();
                    name = elemento1.getNodeName();
                    if(name.indexOf(":") > 0)
                        name = name.substring(name.indexOf(":") + 1, name.length());
                    String padre_atributo = name;
                    if(padre_atributo.indexOf(":") > 0)
                        padre_atributo = padre_atributo.substring(name.indexOf(":") + 1, padre_atributo.length());
                    valor = elemento1.getFirstChild().getNodeValue();
                    if(detallista[0][r].equals(padre) && detallista[1][r].equals(name))
                    {
                        if(valor != null)
                            appendToCadenaOriginal(valor);
                        r++;
                    }
                    if(a1 != null && a1.getLength() > 0)
                    {
                        for(int j = 0; j < a1.getLength(); j++)
                            try
                            {
                                name = a1.item(j).getNodeName();
                                if(name.indexOf(":") > 0)
                                    name = name.substring(name.indexOf(":") + 1, name.length());
                                valor = a1.item(j).getNodeValue();
                                if(detallista[0][r].equals(padre_atributo) && detallista[1][r].equals(name))
                                {
                                    if(valor != null)
                                        appendToCadenaOriginal(valor);
                                    r++;
                                }
                                if(name != null)
                                    System.out.println((new StringBuilder("Atributo ")).append(nivel).append(" : ").append(name).append(" = ").append(valor).toString());
                            }
                            catch(Exception e)
                            {
                                System.out.println(e);
                            }

                    }
                    if(name != null)
                        System.out.println((new StringBuilder("Elemento ")).append(nivel).append(" : ").append(name).append(" = ").append(valor).toString());
                    parsearComplemento(elemento1, Integer.valueOf(nivel.intValue() + 1), elemento1.getNodeName(), cadena);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }

        }
    }

    private Object getObject(Element elemento, String cName)
    {
        Object myInstance = null;
        try
        {
            Class obj = Class.forName(cName);
            myInstance = obj.newInstance();
            Method metList[] = obj.getDeclaredMethods();
            for(int i = 0; i < metList.length; i++)
            {
                String methodName = metList[i].getName().startsWith("set") ? metList[i].getName() : "";
                if(methodName.equals("setId"))
                    metList[i].invoke(myInstance, new Object[] {
                        elemento.getAttribute("id")
                    });
                else
                if(!methodName.equals(""))
                {
                    String tempAtribute = methodName.substring(3);
                    metList[i].invoke(myInstance, new Object[] {
                        obtenerTexto(elemento, tempAtribute.replace(tempAtribute.substring(0, 1), tempAtribute.substring(0, 1).toLowerCase()))
                    });
                }
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return myInstance;
    }

    private String obtenerTexto(Element elemento, String nombreEtiqueta)
    {
        String texto = null;
        NodeList nl = elemento.getElementsByTagName(nombreEtiqueta);
        if(nl != null && nl.getLength() > 0)
        {
            Element el = (Element)nl.item(0);
            texto = el.getFirstChild().getNodeValue();
        }
        return texto;
    }
/**
    protected void appendToCadenaOriginal(String s)
    {
        if(s == null){
            if(cadenaOriginal == null)
            cadenaOriginal = "||";
            s.trim();
        }else{
            //if(cadenaOriginal == null||cadenaOriginal.equals(""))
            //cadenaOriginal = "||";
            s.trim();
            cadenaOriginal = cadenaOriginal+s+"|";
        }
         System.out.println(cadenaOriginal);
 }**/
      protected void appendToCadenaOriginal(String s)
  {
    if (s != null) {
      if (this.cadenaOriginal == null)
        this.cadenaOriginal = "";
      this.cadenaOriginal = (this.cadenaOriginal + s.trim() + "|");
    }
  }



    protected void appendToCadenaOriginal(BigInteger s)
    {
        if(s != null)
            appendToCadenaOriginal(s.toString().trim());
    }

    protected void appendToCadenaOriginal(BigDecimal s)
    {
        if(s != null)
            appendToCadenaOriginal(s.toPlainString().trim());
    }

    protected void appendToCadenaOriginal(XMLGregorianCalendar s)
    {
        if(s != null)
        {
            s.setMillisecond(0);
            appendToCadenaOriginal(s.toXMLFormat().trim());
        }
    }

    public String getCadenaOriginal()
    {
        return cadenaOriginal;
    }

    public String getCadenaOriginalUTF8()
        throws UnsupportedEncodingException
    {
        return new String(cadenaOriginal.getBytes("UTF-8"));
    }

    private String cadenaOriginal;
    private String detallista[][] = {
        {
            "detallista", "orderIdentification", "orderIdentification", "buyer", "seller", "seller", "totalAmount", "TotalAllowanceCharge", "TotalAllowanceCharge"
        }, {
            "documentStructureVersion", "referenceIdentification", "ReferenceDate", "gln", "gln", "alternatePartyIdentification", "Amount", "specialServicesType", "Amount"
        }
    };
    private int r;
}
