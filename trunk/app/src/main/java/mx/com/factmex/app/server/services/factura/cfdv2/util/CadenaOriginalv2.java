/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.cfdv2.util;
import mx.com.factmex.app.server.services.factura.cfdv2.*;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
/**
 *
 * @author Jonathan
 */
public class CadenaOriginalv2
{

    public CadenaOriginalv2()
    {
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
        String strComplemento = IncluirNodoComplemento(comprobante.getComplemento());
        if(strComplemento != null)
            appendToCadenaOriginal(strComplemento);
        return cadenaOriginal = (new StringBuilder("||")).append(cadenaOriginal.replaceAll("\\s+", " ").trim()).append("|").toString();
    }

    protected String IncluirNodoComplementoConcepto(mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Conceptos.Concepto.ComplementoConcepto cc)
    {
        return null;
    }

    protected String IncluirNodoComplemento(mx.com.factmex.app.server.services.factura.cfdv2.Comprobante.Complemento cc)
    {
        return null;
    }

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
            appendToCadenaOriginal(s.toString());
    }

    protected void appendToCadenaOriginal(BigDecimal s)
    {
        if(s != null)
            appendToCadenaOriginal(s.toPlainString());
    }

    protected void appendToCadenaOriginal(XMLGregorianCalendar s)
    {
        if(s != null)
        {
            s.setMillisecond(0);
            appendToCadenaOriginal(s.toXMLFormat());
        }
    }

    public String getCadenaOriginal()
        throws UnsupportedEncodingException
    {
        return new String(cadenaOriginal.getBytes("UTF-8"));
    }

    private String cadenaOriginal;
}

