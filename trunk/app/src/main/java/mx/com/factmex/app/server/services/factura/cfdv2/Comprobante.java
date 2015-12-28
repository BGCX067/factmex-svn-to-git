/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//


//@XmlSchema(namespace="http://www.sat.gob.mx/cfd/2", elementFormDefault=XmlNsForm.QUALIFIED)
package mx.com.factmex.app.server.services.factura.cfdv2;

import mx.com.factmex.app.server.services.factura.cfdv2.exceptions.ConceptoException;
import mx.com.factmex.app.server.services.factura.cfdv2.exceptions.EmisorException;
import mx.com.factmex.app.server.services.factura.cfdv2.exceptions.ReceptorException;
import mx.com.factmex.app.server.services.factura.cfdv2.util.Fechas;
import mx.com.factmex.app.server.services.factura.cfdv2.util.DateAdapter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jonathan
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
//@javax.xml.bind.annotation.XmlSchema (namespace = "http://www.example.com/MYPO1")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"emisor", "receptor", "conceptos", "impuestos", "complemento", "addenda"})

@XmlRootElement(name="Comprobante")

public class Comprobante
{

  @XmlElement(name="Emisor", required=true)
  protected Emisor emisor;

  @XmlElement(name="Receptor", required=true)
  protected Receptor receptor;

  @XmlElement(name="Conceptos", required=true)
  protected Conceptos conceptos;

  @XmlElement(name="Impuestos", required=true)
  protected Impuestos impuestos;

  @XmlElement(name="Complemento")
  protected Complemento complemento;

  @XmlElement(name="Addenda")
  protected Addenda addenda;

  @XmlAttribute(required=true)
  protected BigInteger anoAprobacion;

  @XmlAttribute
  protected String certificado;

  @XmlAttribute
  protected String condicionesDePago;

  @XmlAttribute
  protected BigDecimal descuento;

  @XmlAttribute(required=true)
  @XmlJavaTypeAdapter(DateAdapter.class)
  protected Date fecha;
  protected static int decimales;

  @XmlAttribute(required=true)
  protected String folio;

  @XmlAttribute(required=true)
  protected String formaDePago;

  @XmlAttribute
  protected String metodoDePago;

  @XmlAttribute
  protected String motivoDescuento;

  @XmlAttribute(required=true)
  protected BigInteger noAprobacion;

  @XmlAttribute(required=true)
  protected String noCertificado;

  @XmlAttribute(required=true)
  protected String sello;

  @XmlAttribute
  protected String serie;

  @XmlAttribute(required=true)
  protected BigDecimal subTotal;

  @XmlAttribute(required=true)
  protected String tipoDeComprobante;

  @XmlAttribute(required=true)
  protected BigDecimal total;
  
  @XmlAttribute(required=true)
  protected String version = "2.0";
  public static final int TIPO_COMPROBANTE_INGRESO = 1;
  public static final int TIPO_COMPROBANTE_EGRESO = 2;
  public static final int TIPO_COMPROBANTE_TRASLADO = 3;

  public void setDecimales(int d)
  {
    decimales = decimales;
  }
  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public String getFecha() {
    return Fechas.obtenerFechaConFormato(this.fecha, "yyyy-MM-dd'T'HH:mm:ss");
  }

  public Date getFechaToDate() {
    return this.fecha;
  }

  public Emisor getEmisor()
  {
    return this.emisor;
  }

  public Receptor getReceptor()
  {
    return this.receptor;
  }

  public Conceptos getConceptos()
  {
    return this.conceptos;
  }

  public void setConceptos(Conceptos conceptosEntrada)
  {
    this.conceptos = conceptosEntrada;
  }

  public Impuestos getImpuestos()
  {
    return this.impuestos;
  }

  public void setImpuestos(Impuestos impuestos) {
    this.impuestos = impuestos;
  }

  public Complemento getComplemento()
  {
    return this.complemento;
  }

  public void setComplemento(Complemento value)
  {
    this.complemento = value;
  }

  public Addenda getAddenda()
  {
    return this.addenda;
  }

  public void setAddenda(Addenda value)
  {
    this.addenda = value;
  }

  public BigInteger getAnoAprobacion()
  {
    return this.anoAprobacion;
  }

  public void setAnoAprobacion(BigInteger value)
  {
    setAnoAprobacion(value.longValue());
  }

  public void setAnoAprobacion(long value)
  {
    if ((value > 1995L) && (value < 2100L))
      this.anoAprobacion = new BigInteger((new StringBuilder()).append(value).toString());
  }

  public String getCertificado()
  {
    return this.certificado;
  }

  public void setCertificado(String value)
  {
    if ((value != null) && (value.trim().length() > 0))
      this.certificado = value;
  }

  public String getCondicionesDePago()
  {
    return this.condicionesDePago;
  }

  public void setCondicionesDePago(String value)
  {
    if ((value != null) && (value.length() > 0))
      this.condicionesDePago = value;
  }

  public BigDecimal getDescuento()
  {
    return this.descuento;
  }

  public void setDescuento(BigDecimal value)
  {
    if (value != null)
      setDescuento(value.doubleValue());
  }

  public void setDescuento(double value)
  {
    this.descuento = new BigDecimal(value).setScale(4, 4);
  }

  public String getFolio()
  {
    return this.folio;
  }

  public void setFolio(String value)
  {
    Pattern pattern = Pattern.compile("^[0-9]{1,20}$");
    Matcher matcher = pattern.matcher(value);
    try {
      if ((matcher.find()) && (Long.parseLong(value) >= 1L))
        this.folio = value;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
  }

  public void setFolio(BigInteger value)
  {
    if (value != null)
      setFolio(value.toString());
  }

  public void setFolio(long value)
  {
    setFolio(value);
  }

  public String getFormaDePago()
  {
    return this.formaDePago;
  }

  public void setFormaDePagoUnaSolaExhibicion()
  {
    this.formaDePago = "Pago en una solo exhibicion";
  }

  public void setFormaDePagoParcialidades(int parcialidad, int total)
  {
    if ((parcialidad > 0) && (total >= parcialidad))
      this.formaDePago = ("Parcialidad " + parcialidad + " de " + total);
  }

  public String getMetodoDePago()
  {
    return this.metodoDePago;
  }

  public void setMetodoDePago(String value)
  {
    if ((value != null) && (value.trim().length() > 0))
      this.metodoDePago = value;
  }

  public String getMotivoDescuento()
  {
    return this.motivoDescuento;
  }

  public void setMotivoDescuento(String value)
  {
    if ((value != null) && (value.trim().length() > 0))
      this.motivoDescuento = value;
  }

  public BigInteger getNoAprobacion()
  {
    return this.noAprobacion;
  }

  public void setNoAprobacion(BigInteger value)
  {
    this.noAprobacion = value;
  }

  public void setNoAprobacion(long value)
  {
    this.noAprobacion = new BigInteger((new StringBuilder()).append(value).toString());
  }

  public String getNoCertificado()
  {
    return this.noCertificado;
  }

  public void setNoCertificado(String value)
  {
    if ((value != null) && (value.length() == 20))
      this.noCertificado = value;
  }

  public String getSello()
  {
    return this.sello;
  }

  public void setSello(String value)
  {
    if ((value != null) && (value.trim().length() > 0))
      this.sello = value;
  }

  public String getSerie()
  {
    return this.serie;
  }

  public void setSerie(String value)
  {
    Pattern pattern = Pattern.compile("^[a-zA-Z]{1,10}$");
    Matcher matcher = pattern.matcher(value);
    if (matcher.find())
      this.serie = value.toUpperCase();
  }

  public BigDecimal getSubTotal()
  {
    return this.subTotal;
  }

  public void setSubTotal(BigDecimal value)
  {
    if (value != null)
      setSubTotal(value.doubleValue());
  }

  public void setSubTotal(double value)
  {
    this.subTotal = new BigDecimal(value).setScale(4, 4);
  }

  public String getTipoDeComprobante()
  {
    return this.tipoDeComprobante;
  }

  public void setTipoDeComprobante(int value)
  {
    switch (value) {
    case 2:
      this.tipoDeComprobante = "egreso";
      break;
    case 1:
      this.tipoDeComprobante = "ingreso";
      break;
    case 3:
      this.tipoDeComprobante = "traslado";
      break;
    default:
      return;
    }
  }

  public BigDecimal getTotal()
  {
    return this.total;
  }

  public void setTotal(BigDecimal value)
  {
    if (value != null)
      setTotal(value.doubleValue());
  }

  public void setTotal(double value) {
    this.total = new BigDecimal(value).setScale(4, 4);
  }

  public String getVersion()
  {
    return this.version = "2.0";
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name="", propOrder={"any"})
  public static class Addenda
  {

    @XmlAnyElement(lax=true)
    protected List<Object> any;

    public List<Object> getAny()
    {
      if (this.any == null) {
        this.any = new ArrayList();
      }
      return this.any;
    }
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name="", propOrder={"any"})
  public static class Complemento
  {

    @XmlAnyElement(lax=true)
    protected List<Object> any;

    public List<Object> getAny()
    {
      if (this.any == null) {
        this.any = new ArrayList();
      }
      return this.any;
    }
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name="", propOrder={"concepto"})
  public static class Conceptos
  {

    @XmlElement(name="Concepto", required=true)
    protected List<Concepto> concepto;

    public List<Concepto> getConcepto()
    {
      if (this.concepto == null) {
        this.concepto = new ArrayList();
      }
      return this.concepto;
    }

    public void setConcepto(List<Concepto> concepto) {
      this.concepto = concepto;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name="", propOrder={"informacionAduanera", "cuentaPredial", "complementoConcepto", "parte"})
    public static class Concepto
    {

      @XmlElement(name="InformacionAduanera")
      protected List<TInformacionAduanera> informacionAduanera;

      @XmlElement(name="CuentaPredial")
      protected CuentaPredial cuentaPredial;

      @XmlElement(name="ComplementoConcepto")
      protected ComplementoConcepto complementoConcepto;

      @XmlElement(name="Parte")
      protected List<Parte> parte;

      @XmlAttribute(required=true)
      protected BigDecimal cantidad;

      @XmlAttribute(required=true)
      protected String descripcion;

      @XmlAttribute(required=true)
      protected BigDecimal importe;

      @XmlAttribute
      protected String noIdentificacion;

      @XmlAttribute
      protected String unidad;

      @XmlAttribute
      protected String clave;

      @XmlAttribute(required=true)
      protected BigDecimal valorUnitario;

      public Concepto()
      {
      }

      public Concepto(BigDecimal cantidad, String descripcion, BigDecimal importe, BigDecimal valorUnitario)
        throws ConceptoException
      {
        setCantidad(cantidad);
        setDescripcion(descripcion);
        setImporte(importe);
        setValorUnitario(valorUnitario);
        if (this.cantidad == null) throw new ConceptoException(1400);
        if (this.descripcion == null) throw new ConceptoException(1401);
        if (this.importe == null) throw new ConceptoException(1403);
        if (this.valorUnitario == null) throw new ConceptoException(1402);
      }

      public Concepto(String unidad, BigDecimal cantidad, String descripcion, BigDecimal importe, BigDecimal valorUnitario) throws ConceptoException
      {
        setUnidad(unidad);
        setCantidad(cantidad);
        setDescripcion(descripcion);
        setImporte(importe);
        setValorUnitario(valorUnitario);
        if (this.unidad == null) throw new ConceptoException(1399);
        if (this.cantidad == null) throw new ConceptoException(1400);
        if (this.descripcion == null) throw new ConceptoException(1401);
        if (this.importe == null) throw new ConceptoException(1403);
        if (this.valorUnitario == null) throw new ConceptoException(1402);
      }

      public Concepto(String clave, String unidad, BigDecimal cantidad, String descripcion, BigDecimal importe, BigDecimal valorUnitario)
        throws ConceptoException
      {
        setNoIdentificacion(clave);
        setUnidad(unidad);
        setCantidad(cantidad);
        setDescripcion(descripcion);
        setImporte(importe);
        setValorUnitario(valorUnitario);

        if (this.unidad == null) throw new ConceptoException(1399);
        if (this.cantidad == null) throw new ConceptoException(1400);
        if (this.descripcion == null) throw new ConceptoException(1401);
        if (this.importe == null) throw new ConceptoException(1403);
        if (this.valorUnitario == null) throw new ConceptoException(1402);
      }

      public List<TInformacionAduanera> getInformacionAduanera()
      {
        //if (this.informacionAduanera == null) {
          //this.informacionAduanera = new ArrayList();
        //}
        return this.informacionAduanera;
      }

      public void setInformacionAduanera(List<TInformacionAduanera> informacionAduanera)
      {
        this.informacionAduanera = informacionAduanera;
      }

      public CuentaPredial getCuentaPredial()
      {
        return this.cuentaPredial;
      }

      public void setCuentaPredial(CuentaPredial value)
      {
        this.cuentaPredial = value;
      }

      public ComplementoConcepto getComplementoConcepto()
      {
        return this.complementoConcepto;
      }

      public void setComplementoConcepto(ComplementoConcepto value)
      {
        this.complementoConcepto = value;
      }

      public List<Parte> getParte()
      {
        if (this.parte == null) {
          this.parte = new ArrayList();
        }
        return this.parte;
      }

      public void serParte(List<Parte> parteList)
      {
        this.parte = parteList;
      }

      public BigDecimal getCantidad()
      {
        return this.cantidad;
      }

      public void setCantidad(BigDecimal value)
      {
        if (value != null)
          setCantidad(value.doubleValue());
      }

      public void setCantidad(double value)
      {
        this.cantidad = new BigDecimal(value).setScale(4, 4);
      }

      public String getDescripcion()
      {
        return this.descripcion;
      }

      public void setDescripcion(String value)
      {
        if ((value != null) && (value.trim().length() > 0))
          this.descripcion = value;
      }

      public BigDecimal getImporte()
      {
        return this.importe;
      }

      public void setImporte(BigDecimal value)
      {
        if (value != null)
          setImporte(value.doubleValue());
      }

      public void setImporte(double value) {
        this.importe = new BigDecimal(value).setScale(4, 4);
      }

      public String getNoIdentificacion()
      {
        return this.noIdentificacion;
      }

      public void setNoIdentificacion(String value)
      {
        if ((value != null) && (value.trim().length() > 0))
          this.noIdentificacion = value;
      }

      public String getUnidad()
      {
        return this.unidad;
      }

      public void setUnidad(String value)
      {
        if ((value != null) && (value.trim().length() > 0))
          this.unidad = value;
      }

      public void setClave(String clave)
      {
        if ((clave != null) && (clave.trim().length() > 0))
          this.clave = clave;
      }

      public BigDecimal getValorUnitario()
      {
        return this.valorUnitario;
      }

      public void setValorUnitario(BigDecimal value)
      {
        if (value != null)
          setValorUnitario(value.doubleValue());
      }

      public void setValorUnitario(double value) {
        this.valorUnitario = new BigDecimal(value).setScale(4, 4);
      }

      @XmlAccessorType(XmlAccessType.FIELD)
      @XmlType(name="", propOrder={"any"})
      public static class ComplementoConcepto
      {

        @XmlAnyElement(lax=true)
        protected List<Object> any;

        public List<Object> getAny()
        {
          if (this.any == null) {
            this.any = new ArrayList();
          }
          return this.any;
        }
      }

      @XmlAccessorType(XmlAccessType.FIELD)
      @XmlType(name="")
      public static class CuentaPredial
      {

        @XmlAttribute(required=true)
        protected String numero;

        public String getNumero()
        {
          return this.numero;
        }

        public void setNumero(String value)
        {
          if ((value != null) && (value.trim().length() > 0))
            this.numero = value;
        }
      }

      @XmlAccessorType(XmlAccessType.FIELD)
      @XmlType(name="", propOrder={"informacionAduanera"})
      public static class Parte
      {

        @XmlElement(name="InformacionAduanera")
        protected List<TInformacionAduanera> informacionAduanera;

        @XmlAttribute(required=true)
        protected BigDecimal cantidad;

        @XmlAttribute
        protected String unidad;

        @XmlAttribute
        protected String noIdentificacion;

        @XmlAttribute(required=true)
        protected String descripcion;

        @XmlAttribute
        protected BigDecimal valorUnitario;

        @XmlAttribute
        protected BigDecimal importe;

        public BigDecimal getCantidad()
        {
          return this.cantidad;
        }

        public List getInformacionAduanera()
        {
          return this.informacionAduanera;
        }

        public void setInformacionAduanera(List<TInformacionAduanera> informacionAduanera) {
          this.informacionAduanera = informacionAduanera;
        }

        public void setCantidad(BigDecimal value)
        {
          if (value != null)
            setCantidad(value.doubleValue());
        }

        public void setCantidad(double value) {
          this.cantidad = new BigDecimal(value).setScale(4, 4);
        }

        public String getDescripcion()
        {
          return this.descripcion;
        }

        public void setDescripcion(String value)
        {
          if ((value != null) && (value.trim().length() > 0))
            this.descripcion = value;
        }

        public BigDecimal getImporte()
        {
          return this.importe;
        }

        public void setImporte(BigDecimal value)
        {
          if (value != null)
            setImporte(value.doubleValue());
        }

        public void setImporte(double value) {
          this.importe = new BigDecimal(value).setScale(4, 4);
        }

        public String getNoIdentificacion()
        {
          return this.noIdentificacion;
        }

        public void setNoIdentificacion(String value)
        {
          if ((value != null) && (value.trim().length() > 0))
            this.noIdentificacion = value;
        }

        public String getUnidad()
        {
          return this.unidad;
        }

        public void setUnidad(String value)
        {
          if ((value != null) && (value.trim().length() > 0))
            this.unidad = value;
        }

        public BigDecimal getValorUnitario()
        {
          return this.valorUnitario;
        }

        public void setValorUnitario(BigDecimal value)
        {
          if (value != null)
            setValorUnitario(value.doubleValue());
        }

        public void setValorUnitario(double value) {
          this.valorUnitario = new BigDecimal(value).setScale(4, 4);
        }
      }
    }
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name="", propOrder={"domicilioFiscal", "expedidoEn"})
  public static class Emisor
  {

    @XmlElement(name="DomicilioFiscal", required=true)
    protected TUbicacionFiscal domicilioFiscal;

    @XmlElement(name="ExpedidoEn")
    protected TUbicacion expedidoEn;

    @XmlAttribute(required=true)
    protected String rfc;

    @XmlAttribute(required=true)
    protected String nombre;

    public Emisor()
    {
    }

    public Emisor(TUbicacionFiscal domicilioFiscal, TUbicacion expedidoEn, String nombre, String rfc)
    {
      setDomicilioFiscal(domicilioFiscal);
      setExpedidoEn(expedidoEn);
      setNombre(nombre);
      setRfc(rfc);

      if (this.domicilioFiscal == null) new EmisorException(1100);
      if (this.nombre == null) new EmisorException(1102);
      if (this.rfc == null) new EmisorException(1101);
    }

    public Emisor(TUbicacionFiscal domicilioFiscal, String nombre, String rfc)
    {
      setDomicilioFiscal(domicilioFiscal);
      setExpedidoEn(this.expedidoEn);
      setNombre(nombre);
      setRfc(rfc);

      if (this.domicilioFiscal == null) new EmisorException(1100);
      if (this.nombre == null) new EmisorException(1102);
      if (this.rfc == null) new EmisorException(1101);
    }

    public TUbicacionFiscal getDomicilioFiscal()
    {
      return this.domicilioFiscal;
    }

    public void setDomicilioFiscal(TUbicacionFiscal value)
    {
      this.domicilioFiscal = value;
    }

    public TUbicacion getExpedidoEn()
    {
      return this.expedidoEn;
    }

    public void setExpedidoEn(TUbicacion value)
    {
      this.expedidoEn = value;
    }

    public String getNombre()
    {
      return this.nombre;
    }

    public void setNombre(String value)
    {
      if ((value != null) && (value.trim().length() > 0))
        this.nombre = value;
    }

    public String getRfc()
    {
      return this.rfc;
    }

    public void setRfc(String value)
    {
      if ((value != null) && (value.length() >= 12) && (value.length() <= 13))
        this.rfc = value.toUpperCase();
    }
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name="", propOrder={"retenciones", "traslados"})
  public static class Impuestos
  {

    @XmlElement(name="Retenciones")
    protected Retenciones retenciones;

    @XmlElement(name="Traslados")
    protected Traslados traslados;

    @XmlAttribute
    protected BigDecimal totalImpuestosRetenidos;

    @XmlAttribute
    protected BigDecimal totalImpuestosTrasladados;

    public Retenciones getRetenciones()
    {
      return this.retenciones;
    }

    public void setRetenciones(Retenciones value)
    {
      double $totaImpuestosRetenidos = 0.0D;
      if (value != null) {
        this.retenciones = value;
        Comprobante.Impuestos.Retenciones.Retencion[] arr = new Comprobante.Impuestos.Retenciones.Retencion[this.retenciones.getRetencion().size()];
        arr = (Comprobante.Impuestos.Retenciones.Retencion[])this.retenciones.getRetencion().toArray(arr);
        for (Comprobante.Impuestos.Retenciones.Retencion r : arr) {
          $totaImpuestosRetenidos += r.getImporte().doubleValue();
        }
        this.totalImpuestosRetenidos = new BigDecimal($totaImpuestosRetenidos).setScale(2, 4);
      }
    }

    public Traslados getTraslados()
    {
      return this.traslados;
    }

    public void setTraslados(Traslados value)
    {
      double $totaImpuestosTrasladados = 0.0D;
      if (value != null) {
        this.traslados = value;
        Comprobante.Impuestos.Traslados.Traslado[] arr = new Comprobante.Impuestos.Traslados.Traslado[this.traslados.getTraslado().size()];
        arr = (Comprobante.Impuestos.Traslados.Traslado[])this.traslados.getTraslado().toArray(arr);
        for (Comprobante.Impuestos.Traslados.Traslado r : arr) {
          $totaImpuestosTrasladados += r.getImporte().doubleValue();
        }

        this.totalImpuestosTrasladados = new BigDecimal($totaImpuestosTrasladados).setScale(2, 4);
      }
    }

    public BigDecimal getTotalImpuestosRetenidos()
    {
      return this.totalImpuestosRetenidos;
    }

    public BigDecimal getTotalImpuestosTrasladados() {
      return this.totalImpuestosTrasladados;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name="", propOrder={"retencion"})
    public static class Retenciones
    {

      @XmlElement(name="Retencion", required=true)
      protected List<Retencion> retencion;

      public List<Retencion> getRetencion()
      {
        if (this.retencion == null) {
          this.retencion = new ArrayList();
        }
        return this.retencion;
      }

      @XmlAccessorType(XmlAccessType.FIELD)
      @XmlType(name="")
      public static class Retencion
      {
        public static short RETENCION_IVA = 1;
        public static short RETENCION_ISR = 2;

        @XmlAttribute(required=true)
        protected String impuesto;

        @XmlAttribute(required=true)
        protected BigDecimal importe;

        public Retencion() {  }
        public Retencion(short tipoImpuesto, double importe) { setImpuesto(tipoImpuesto);
          //setImporte(new BigDecimal(importe));
        setImporte(new BigDecimal((new StringBuilder()).append(importe).toString()));
        }

        public BigDecimal getImporte()
        {
          return this.importe;
        }

        public void setImporte(BigDecimal value)
        {
          if (value != null)
            setImporte(value.doubleValue());
        }

        public void setImporte(double value)
        {
          //this.importe = new BigDecimal(value);
          importe = new BigDecimal((new StringBuilder()).append(value).toString());
          System.out.println("XML IMPORTE RETENCION" + this.importe);
        }

        public String getImpuesto()
        {
          return this.impuesto;
        }

        public void setImpuesto(short value)
        {
          if (value == RETENCION_ISR)
            this.impuesto = "ISR";
          else if (value == RETENCION_IVA)
            this.impuesto = "IVA";
        }
      }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name="", propOrder={"traslado"})
    public static class Traslados
    {

      @XmlElement(name="Traslado", required=true)
      protected List<Traslado> traslado;

      public List<Traslado> getTraslado()
      {
        if (this.traslado == null) {
          this.traslado = new ArrayList();
        }
        return this.traslado;
      }

      @XmlAccessorType(XmlAccessType.FIELD)
      @XmlType(name="")
      public static class Traslado
      {
        public static short TRASLADO_IVA = 1;
        public static short TRASLADO_IEPS = 2;

        @XmlAttribute(required=true)
        protected String impuesto;

        @XmlAttribute(required=true)
        protected BigDecimal tasa;

        @XmlAttribute(required=true)
        protected BigDecimal importe;

        public Traslado() {  }
        public Traslado(double importe, short tipoImpuesto, double tasa) { 
          //setImporte(new BigDecimal(importe));
          setImporte(new BigDecimal((new StringBuilder()).append(importe).toString()));
          setImpuesto(tipoImpuesto);
          setTasa(new BigDecimal(tasa));
        }

        public BigDecimal getImporte()
        {
          return this.importe;
        }

        public void setImporte(BigDecimal value)
        {
          if (value != null)
            setImporte(value.doubleValue());
        }

        public void setImporte(double value) {
          importe = new BigDecimal((new StringBuilder()).append(value).toString());
          //this.importe = new BigDecimal(value);

          System.out.println("XML IMPORTE TRASLADO" + this.importe);
        }

        public String getImpuesto()
        {
          return this.impuesto;
        }

        public void setImpuesto(short value)
        {
          if (value == TRASLADO_IEPS)
            this.impuesto = "IEPS";
          else if (value == TRASLADO_IVA)
            this.impuesto = "IVA";
        }

        public BigDecimal getTasa()
        {
          return this.tasa;
        }

        public void setTasa(BigDecimal value)
        {
          if (value != null)
            setTasa(value.doubleValue());
        }

        public void setTasa(double value) {
          //this.tasa = new BigDecimal(value).setScale(Comprobante.decimales, 4);
          tasa=(new BigDecimal((new StringBuilder()).append(value).toString())).setScale(Comprobante.decimales, 4);
        }
      }
    }
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name="", propOrder={"domicilio"})
  public static class Receptor
  {

    @XmlElement(name="Domicilio", required=true)
    protected TUbicacion domicilio;

    @XmlAttribute(required=true)
    protected String rfc;

    @XmlAttribute
    protected String nombre;

    public Receptor()
    {
    }

    public Receptor(String rfc, TUbicacion domicilio)
      throws ReceptorException
    {
      setDomicilio(domicilio);
      setRFC("RFC");
      if (this.domicilio == null) throw new ReceptorException(1200);
      if (this.rfc == null) throw new ReceptorException(1201);
    }

    public Receptor(String rfc, String nombre, TUbicacion domicilio) throws ReceptorException
    {
      setDomicilio(domicilio);
      setNombre(nombre);
      setRFC(rfc);
      if (this.domicilio == null) throw new ReceptorException(1200);
      if (this.rfc == null) throw new ReceptorException(1201);
    }

    public TUbicacion getDomicilio()
    {
      return this.domicilio;
    }

    public void setDomicilio(TUbicacion value)
    {
      if (value != null)
        this.domicilio = value;
    }

    public String getNombre()
    {
      return this.nombre;
    }

    public void setNombre(String value)
    {
      if ((value != null) && (value.trim().length() > 0))
        this.nombre = value;
    }

    public String getRfc()
    {
      return this.rfc;
    }

    public void setRFC(String value)
    {
      if ((value != null) && (value.length() >= 12) && (value.length() <= 13))
        this.rfc = value.toUpperCase();
    }
  }
}