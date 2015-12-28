/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.factmex.app.server.services.factura.cfdv2;

import mx.com.factmex.app.server.services.factura.cfdv2.exceptions.ComprobanteException;
import mx.com.factmex.app.server.services.factura.cfdv2.exceptions.ConceptoException;
import mx.com.factmex.app.server.services.factura.cfdv2.exceptions.ReceptorException;
import mx.com.factmex.app.server.services.factura.cfdv2.exceptions.TUbicacionException;
import mx.com.factmex.app.server.services.factura.cfdv2.exceptions.TUbicacionFiscalException;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Jonathan
 */
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;

@XmlRegistry




public class ObjectFactory
{
  public Facture createFacture()
  {
    return new Facture();
  }

  public Facture.DatosFacture createFactureDatosFacture()
  {
    return new Facture.DatosFacture();
  }

  public Comprobante createComprobante() {
    return new Comprobante();
  }

  public Comprobante createComprobanteEgreso(Comprobante.Emisor emisor, Comprobante.Receptor receptor, Comprobante.Conceptos conceptos, Comprobante.Impuestos impuestos, String folio, Date fecha, String sello, long noAprobacion, long anoAprobacion, int parcialidadPago, int tortalParcialidades, String noCertificado, double subtotal, double total)
    throws ComprobanteException
  {
    Comprobante comprobante = new Comprobante();

    comprobante.emisor = emisor;
    comprobante.receptor = receptor;
    comprobante.conceptos = conceptos;
    comprobante.impuestos = impuestos;

    comprobante.setFolio(folio);
    comprobante.setFecha(fecha);
    comprobante.sello = sello;
    comprobante.setNoAprobacion(noAprobacion);
    comprobante.setAnoAprobacion(anoAprobacion);
    if ((parcialidadPago > 0) && (tortalParcialidades >= parcialidadPago))
      comprobante.setFormaDePagoParcialidades(parcialidadPago, tortalParcialidades);
    else
      comprobante.setFormaDePagoUnaSolaExhibicion();
    comprobante.setNoCertificado(noCertificado);
    comprobante.setSubTotal(subtotal);
    comprobante.setTotal(total);
    comprobante.setTipoDeComprobante(2);

    if (comprobante.emisor == null) throw new ComprobanteException(1000);
    if (comprobante.receptor == null) throw new ComprobanteException(1001);
    if (comprobante.conceptos == null) throw new ComprobanteException(1002);
    if (comprobante.conceptos.getConcepto().isEmpty()) throw new ComprobanteException(1002);
    if (comprobante.impuestos == null) throw new ComprobanteException(1003);
    if (comprobante.folio == null) throw new ComprobanteException(1006);
    if (comprobante.fecha == null) throw new ComprobanteException(1007);
    if (comprobante.sello == null) throw new ComprobanteException(1008);
    if (comprobante.noAprobacion == null) throw new ComprobanteException(1009);
    if (comprobante.anoAprobacion == null) throw new ComprobanteException(1010);
    if (comprobante.formaDePago == null) throw new ComprobanteException(1011);
    if (comprobante.noCertificado == null) throw new ComprobanteException(1012);
    if (comprobante.subTotal == null) throw new ComprobanteException(1013);
    if (comprobante.total == null) throw new ComprobanteException(1014);
    if (comprobante.tipoDeComprobante == null) throw new ComprobanteException(1015);

    return comprobante;
  }

  public Comprobante createComprobanteIngreso(Comprobante.Emisor emisor, Comprobante.Receptor receptor, Comprobante.Conceptos conceptos, Comprobante.Impuestos impuestos, String folio, Date fecha, String sello, long noAprobacion, long anoAprobacion, int parcialidadPago, int tortalParcialidades, String noCertificado, double subtotal, double total)
    throws ComprobanteException
  {
    Comprobante comprobante = new Comprobante();

    comprobante.emisor = emisor;
    comprobante.receptor = receptor;
    comprobante.conceptos = conceptos;
    comprobante.impuestos = impuestos;

    comprobante.setFolio(folio);
    comprobante.setFecha(fecha);
    comprobante.sello = sello;
    comprobante.setNoAprobacion(noAprobacion);
    comprobante.setAnoAprobacion(anoAprobacion);
    if ((parcialidadPago > 0) && (tortalParcialidades >= parcialidadPago))
      comprobante.setFormaDePagoParcialidades(parcialidadPago, tortalParcialidades);
    else
      comprobante.setFormaDePagoUnaSolaExhibicion();
    comprobante.setNoCertificado(noCertificado);
    comprobante.setSubTotal(subtotal);
    comprobante.setTotal(total);
    comprobante.setTipoDeComprobante(1);

    if (comprobante.emisor == null) throw new ComprobanteException(1000);
    if (comprobante.receptor == null) throw new ComprobanteException(1001);
    if (comprobante.conceptos == null) throw new ComprobanteException(1002);
    if (comprobante.conceptos.getConcepto().isEmpty()) throw new ComprobanteException(1002);
    if (comprobante.impuestos == null) throw new ComprobanteException(1003);
    if (comprobante.folio == null) throw new ComprobanteException(1006);
    if (comprobante.fecha == null) throw new ComprobanteException(1007);
    if (comprobante.sello == null) throw new ComprobanteException(1008);
    if (comprobante.noAprobacion == null) throw new ComprobanteException(1009);
    if (comprobante.anoAprobacion == null) throw new ComprobanteException(1010);
    if (comprobante.formaDePago == null) throw new ComprobanteException(1011);
    if (comprobante.noCertificado == null) throw new ComprobanteException(1012);
    if (comprobante.subTotal == null) throw new ComprobanteException(1013);
    if (comprobante.total == null) throw new ComprobanteException(1014);
    if (comprobante.tipoDeComprobante == null) throw new ComprobanteException(1015);

    return comprobante;
  }

  public Comprobante createComprobanteTraslado(Comprobante.Emisor emisor, Comprobante.Receptor receptor, Comprobante.Conceptos conceptos, Comprobante.Impuestos impuestos, String folio, Date fecha, String sello, long noAprobacion, long anoAprobacion, int parcialidadPago, int tortalParcialidades, String noCertificado, double subtotal, double total)
    throws ComprobanteException
  {
    Comprobante comprobante = new Comprobante();

    comprobante.emisor = emisor;
    comprobante.receptor = receptor;
    comprobante.conceptos = conceptos;
    comprobante.impuestos = impuestos;

    comprobante.setFolio(folio);
    comprobante.setFecha(fecha);
    comprobante.sello = sello;
    comprobante.setNoAprobacion(noAprobacion);
    comprobante.setAnoAprobacion(anoAprobacion);
    if ((parcialidadPago > 0) && (tortalParcialidades >= parcialidadPago))
      comprobante.setFormaDePagoParcialidades(parcialidadPago, tortalParcialidades);
    else
      comprobante.setFormaDePagoUnaSolaExhibicion();
    comprobante.setNoCertificado(noCertificado);
    comprobante.setSubTotal(subtotal);
    comprobante.setTotal(total);
    comprobante.setTipoDeComprobante(3);

    if (comprobante.emisor == null) throw new ComprobanteException(1000);
    if (comprobante.receptor == null) throw new ComprobanteException(1001);
    if (comprobante.conceptos == null) throw new ComprobanteException(1002);
    if (comprobante.conceptos.getConcepto().isEmpty()) throw new ComprobanteException(1002);
    if (comprobante.impuestos == null) throw new ComprobanteException(1003);
    if (comprobante.folio == null) throw new ComprobanteException(1006);
    if (comprobante.fecha == null) throw new ComprobanteException(1007);
    if (comprobante.sello == null) throw new ComprobanteException(1008);
    if (comprobante.noAprobacion == null) throw new ComprobanteException(1009);
    if (comprobante.anoAprobacion == null) throw new ComprobanteException(1010);
    if (comprobante.formaDePago == null) throw new ComprobanteException(1011);
    if (comprobante.noCertificado == null) throw new ComprobanteException(1012);
    if (comprobante.subTotal == null) throw new ComprobanteException(1013);
    if (comprobante.total == null) throw new ComprobanteException(1014);
    if (comprobante.tipoDeComprobante == null) throw new ComprobanteException(1015);

    return comprobante;
  }

  public Comprobante createComprobanteEgreso(Comprobante.Emisor emisor, Comprobante.Receptor receptor, Comprobante.Conceptos conceptos, Comprobante.Impuestos impuestos, String folio, Date fecha, String sello, long noAprobacion, long anoAprobacion, String noCertificado, double subtotal, double total)
    throws ComprobanteException
  {
    Comprobante comprobante = new Comprobante();

    comprobante.emisor = emisor;
    comprobante.receptor = receptor;
    comprobante.conceptos = conceptos;
    comprobante.impuestos = impuestos;

    comprobante.setFolio(folio);
    comprobante.setFecha(fecha);
    comprobante.sello = sello;
    comprobante.setNoAprobacion(noAprobacion);
    comprobante.setAnoAprobacion(anoAprobacion);
    comprobante.setFormaDePagoUnaSolaExhibicion();

    comprobante.setNoCertificado(noCertificado);
    comprobante.setSubTotal(subtotal);
    comprobante.setTotal(total);
    comprobante.setTipoDeComprobante(2);

    if (comprobante.emisor == null) throw new ComprobanteException(1000);
    if (comprobante.receptor == null) throw new ComprobanteException(1001);
    if (comprobante.conceptos == null) throw new ComprobanteException(1002);
    if (comprobante.conceptos.getConcepto().isEmpty()) throw new ComprobanteException(1002);
    if (comprobante.impuestos == null) throw new ComprobanteException(1003);
    if (comprobante.folio == null) throw new ComprobanteException(1006);
    if (comprobante.fecha == null) throw new ComprobanteException(1007);
    if (comprobante.sello == null) throw new ComprobanteException(1008);
    if (comprobante.noAprobacion == null) throw new ComprobanteException(1009);
    if (comprobante.anoAprobacion == null) throw new ComprobanteException(1010);
    if (comprobante.formaDePago == null) throw new ComprobanteException(1011);
    if (comprobante.noCertificado == null) throw new ComprobanteException(1012);
    if (comprobante.subTotal == null) throw new ComprobanteException(1013);
    if (comprobante.total == null) throw new ComprobanteException(1014);
    if (comprobante.tipoDeComprobante == null) throw new ComprobanteException(1015);

    return comprobante;
  }

  public Comprobante createComprobanteIngreso(Comprobante.Emisor emisor, Comprobante.Receptor receptor, Comprobante.Conceptos conceptos, Comprobante.Impuestos impuestos, String folio, Date fecha, String sello, long noAprobacion, long anoAprobacion, String noCertificado, double subtotal, double total)
    throws ComprobanteException
  {
    Comprobante comprobante = new Comprobante();

    comprobante.emisor = emisor;
    comprobante.receptor = receptor;
    comprobante.conceptos = conceptos;
    comprobante.impuestos = impuestos;
    System.out.println("concetos en fact "+comprobante.conceptos.concepto.size());
    System.out.println("concetos en fact "+comprobante.conceptos.getConcepto().size());
    comprobante.setFolio(folio);
    comprobante.setFecha(fecha);
    comprobante.sello = sello;
    comprobante.setNoAprobacion(noAprobacion);
    comprobante.setAnoAprobacion(anoAprobacion);
    comprobante.setFormaDePagoUnaSolaExhibicion();
    comprobante.setNoCertificado(noCertificado);
    comprobante.setSubTotal(subtotal);
    comprobante.setTotal(total);
    comprobante.setTipoDeComprobante(1);

    if (comprobante.emisor == null) throw new ComprobanteException(1000);
    if (comprobante.receptor == null) throw new ComprobanteException(1001);
    if (comprobante.conceptos == null) throw new ComprobanteException(1002);
    if (comprobante.conceptos.getConcepto().isEmpty()) throw new ComprobanteException(1002);
    if (comprobante.impuestos == null) throw new ComprobanteException(1003);
    if (comprobante.folio == null) throw new ComprobanteException(1006);
    if (comprobante.fecha == null) throw new ComprobanteException(1007);
    if (comprobante.sello == null) throw new ComprobanteException(1008);
    if (comprobante.noAprobacion == null) throw new ComprobanteException(1009);
    if (comprobante.anoAprobacion == null) throw new ComprobanteException(1010);
    if (comprobante.formaDePago == null) throw new ComprobanteException(1011);
    if (comprobante.noCertificado == null) throw new ComprobanteException(1012);
    if (comprobante.subTotal == null) throw new ComprobanteException(1013);
    if (comprobante.total == null) throw new ComprobanteException(1014);
    if (comprobante.tipoDeComprobante == null) throw new ComprobanteException(1015);

    return comprobante;
  }

  public Comprobante createComprobanteTraslado(Comprobante.Emisor emisor, Comprobante.Receptor receptor, Comprobante.Conceptos conceptos, Comprobante.Impuestos impuestos, String folio, Date fecha, String sello, long noAprobacion, long anoAprobacion, String noCertificado, double subtotal, double total)
    throws ComprobanteException
  {
    Comprobante comprobante = new Comprobante();

    comprobante.emisor = emisor;
    comprobante.receptor = receptor;
    comprobante.conceptos = conceptos;
    comprobante.impuestos = impuestos;

    comprobante.setFolio(folio);
    comprobante.setFecha(fecha);
    comprobante.sello = sello;
    comprobante.setNoAprobacion(noAprobacion);
    comprobante.setAnoAprobacion(anoAprobacion);
    comprobante.setFormaDePagoUnaSolaExhibicion();
    comprobante.setNoCertificado(noCertificado);
    comprobante.setSubTotal(subtotal);
    comprobante.setTotal(total);
    comprobante.setTipoDeComprobante(3);

    if (comprobante.emisor == null) throw new ComprobanteException(1000);
    if (comprobante.receptor == null) throw new ComprobanteException(1001);
    if (comprobante.conceptos == null) throw new ComprobanteException(1002);
    if (comprobante.conceptos.getConcepto().isEmpty()) throw new ComprobanteException(1002);
    if (comprobante.impuestos == null) throw new ComprobanteException(1003);
    if (comprobante.folio == null) throw new ComprobanteException(1006);
    if (comprobante.fecha == null) throw new ComprobanteException(1007);
    if (comprobante.sello == null) throw new ComprobanteException(1008);
    if (comprobante.noAprobacion == null) throw new ComprobanteException(1009);
    if (comprobante.anoAprobacion == null) throw new ComprobanteException(1010);
    if (comprobante.formaDePago == null) throw new ComprobanteException(1011);
    if (comprobante.noCertificado == null) throw new ComprobanteException(1012);
    if (comprobante.subTotal == null) throw new ComprobanteException(1013);
    if (comprobante.total == null) throw new ComprobanteException(1014);
    if (comprobante.tipoDeComprobante == null) throw new ComprobanteException(1015);

    return comprobante;
  }

  public Comprobante.Impuestos.Traslados createComprobanteImpuestosTraslados()
  {
    return new Comprobante.Impuestos.Traslados();
  }

  public Comprobante.Receptor createComprobanteReceptor(String rfc, TUbicacion ubicacion)
    throws ReceptorException
  {
    return new Comprobante.Receptor(rfc, ubicacion);
  }

  public Comprobante.Receptor createComprobanteReceptor(String rfc, String nombre, TUbicacion ubicacion)
    throws ReceptorException
  {
    return new Comprobante.Receptor(rfc, nombre, ubicacion);
  }

  public TUbicacion createTUbicacion(String calle)
    throws TUbicacionException
  {
    return new TUbicacion(calle);
  }

  public Comprobante.Impuestos createComprobanteImpuestos()
  {
    return new Comprobante.Impuestos();
  }

  public Comprobante.Complemento createComprobanteComplemento()
  {
    return new Comprobante.Complemento();
  }

  public Comprobante.Conceptos.Concepto.ComplementoConcepto createComprobanteConceptosConceptoComplementoConcepto()
  {
    return new Comprobante.Conceptos.Concepto.ComplementoConcepto();
  }

  public Comprobante.Conceptos.Concepto.CuentaPredial createComprobanteConceptosConceptoCuentaPredial()
  {
    return new Comprobante.Conceptos.Concepto.CuentaPredial();
  }

  public Comprobante.Addenda createComprobanteAddenda()
  {
    return new Comprobante.Addenda();
  }

  public TInformacionAduanera createTInformacionAduanera()
  {
    return new TInformacionAduanera();
  }

  public Comprobante.Conceptos.Concepto.Parte createComprobanteConceptosConceptoParte()
  {
    return new Comprobante.Conceptos.Concepto.Parte();
  }

  public Comprobante.Conceptos createComprobanteConceptos()
  {
    return new Comprobante.Conceptos();
  }

  public Comprobante.Emisor createComprobanteEmisor(TUbicacionFiscal domicilio, String nombre, String rfc)
  {
    return new Comprobante.Emisor(domicilio, nombre, rfc);
  }

  public Comprobante.Impuestos.Traslados.Traslado createComprobanteImpuestosTrasladosTrasladoIEPS(double importe, double tasa)
  {
    return new Comprobante.Impuestos.Traslados.Traslado(importe, Comprobante.Impuestos.Traslados.Traslado.TRASLADO_IEPS, tasa);
  }

  public Comprobante.Impuestos.Traslados.Traslado createComprobanteImpuestosTrasladosTrasladoIVA(double importe, double tasa)
  {
    return new Comprobante.Impuestos.Traslados.Traslado(importe, Comprobante.Impuestos.Traslados.Traslado.TRASLADO_IVA, tasa);
  }

  public Comprobante.Impuestos.Retenciones.Retencion createComprobanteImpuestosRetencionesRetencionIVA(double importe)
  {
    return new Comprobante.Impuestos.Retenciones.Retencion(Comprobante.Impuestos.Retenciones.Retencion.RETENCION_IVA, importe);
  }

  public Comprobante.Impuestos.Retenciones.Retencion createComprobanteImpuestosRetencionesRetencionISR(double importe)
  {
    return new Comprobante.Impuestos.Retenciones.Retencion(Comprobante.Impuestos.Retenciones.Retencion.RETENCION_ISR, importe);
  }

  public Comprobante.Impuestos.Retenciones createComprobanteImpuestosRetenciones()
  {
    return new Comprobante.Impuestos.Retenciones();
  }

  public Comprobante.Conceptos.Concepto createComprobanteConceptosConcepto(double cantidad, String descripcion, double importe, double valorUnitario)
    throws ConceptoException
  {
	  //System.out.println("factory concep"+cantidad+","+descripcion+","+importe+","+valorUnitario);
    return new Comprobante.Conceptos.Concepto(new BigDecimal(cantidad), descripcion, new BigDecimal(importe), new BigDecimal(valorUnitario));
  }

  public Comprobante.Conceptos.Concepto createComprobanteConceptosConcepto(String unidad, double cantidad, String descripcion, double importe, double valorUnitario)
    throws ConceptoException
  {
    return new Comprobante.Conceptos.Concepto(unidad, new BigDecimal(cantidad), descripcion, new BigDecimal(importe), new BigDecimal(valorUnitario));
  }

  public Comprobante.Conceptos.Concepto createComprobanteConceptosConcepto(String clave, String unidad, double cantidad, String descripcion, double importe, double valorUnitario)
    throws ConceptoException
  {
    return new Comprobante.Conceptos.Concepto(clave, unidad, new BigDecimal(cantidad), descripcion, new BigDecimal(importe), new BigDecimal(valorUnitario));
  }

  public TUbicacionFiscal createTUbicacionFiscal(String calle, String municipio, String estado, String pais, String codigoPostal)
    throws TUbicacionFiscalException
  {
    return new TUbicacionFiscal(calle, municipio, estado, pais, codigoPostal);
  }
}