package mx.com.factmex.app.server.services.factura.cfdv2.informes;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ComprobantesInformeSAT
{
  private List<ComprobanteInformeSAT> comprobantes;

  public ComprobantesInformeSAT()
  {
    this.comprobantes = new ArrayList();
  }

  public List<ComprobanteInformeSAT> getComprobantesInformeSAT() {
    if (this.comprobantes == null) {
      this.comprobantes = new ArrayList();
    }
    return this.comprobantes;
  }

  public void addComprobanteInformeSAT(ComprobanteInformeSAT comprobante)
  {
    if (this.comprobantes == null) {
      this.comprobantes = new ArrayList();
    }
    if (comprobante != null)
      this.comprobantes.add(comprobante);
  }

  public void removeComprobanteInformeSAT(int i) {
    this.comprobantes.remove(i);
  }

  public void generarReporteSAT(OutputStream o)
    throws IOException
  {
    if (this.comprobantes == null) {
      this.comprobantes = new ArrayList();
    }
    Writer out = new OutputStreamWriter(o, "ISO-8859-1");
    ComprobanteInformeSAT[] arrComprobantes = (ComprobanteInformeSAT[])this.comprobantes.toArray(new ComprobanteInformeSAT[this.comprobantes.size()]);

    for (ComprobanteInformeSAT comprobante : arrComprobantes) {
      out.write("|");
      out.write(comprobante.getRFC() + "|");
      out.write(comprobante.getSerie() + "|");
      out.write(comprobante.getFolio() + "|");
      out.write(comprobante.getNoAprobacionToString() + "|");
      out.write(comprobante.getFechaToString() + "|");
      out.write(comprobante.getMontoOperacion() + "|");
      out.write(comprobante.getMontoImpuesto() + "|");
      out.write(comprobante.getEstado() + "|");
      out.write(comprobante.getTipoComprobante() + "|");
      out.write(comprobante.getPedimento() + "|");
      out.write(comprobante.getFechaPedimento() + "|");
      out.write(comprobante.getAduana() + "|");
      out.write("\n");
      if(comprobante.getEstado()==0){
    	  out.write("|");
          out.write(comprobante.getRFC() + "|");
          out.write(comprobante.getSerie() + "|");
          out.write(comprobante.getFolio() + "|");
          out.write(comprobante.getNoAprobacionToString() + "|");
          out.write(comprobante.getFechaToString() + "|");
          out.write(comprobante.getMontoOperacion() + "|");
          out.write(comprobante.getMontoImpuesto() + "|");
          out.write("1|");
          out.write(comprobante.getTipoComprobante() + "|");
          out.write(comprobante.getPedimento() + "|");
          out.write(comprobante.getFechaPedimento() + "|");
          out.write(comprobante.getAduana() + "|");
          out.write("\n");
      }
    }
    out.close();
  }
}
