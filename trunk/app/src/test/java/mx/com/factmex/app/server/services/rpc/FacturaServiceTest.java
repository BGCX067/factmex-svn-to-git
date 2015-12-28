package mx.com.factmex.app.server.services.rpc;
import mx.com.factmex.app.client.to.Session;
import mx.com.factmex.app.client.to.model.Concepto;
import mx.com.factmex.app.client.to.model.Retencion;
import mx.com.factmex.app.client.to.model.Traslado;
import mx.com.factmex.app.client.to.request.FacturaRequest;
import mx.com.factmex.app.client.to.request.Request;
import mx.com.factmex.app.client.to.response.Response;

import org.junit.Test;


public class FacturaServiceTest {

	@Test
	public void testGeneraFactura() {
		FacturaRequest facturaRequest = new FacturaRequest();
		facturaRequest.getSession().setProperty(Session.Property.IDEMISOR.getName(), "1");
		facturaRequest.getSession().setProperty(Session.Property.RFC.getName(), "AAA010101AAA");
		facturaRequest.getSession().setProperty(Session.Property.RAZONSOCIAL.getName(), "Adriana Mendez");
		facturaRequest.setCliente("9");
		facturaRequest.setRfc("GUGG8110165S6");
		facturaRequest.setEstado("MEX");
		facturaRequest.setPais("MEX");
		facturaRequest.setIdSerie("1");
		
		Concepto concepto = new Concepto();
		concepto.setCantidad("1");
		concepto.setDescripcion("TornillosA");
		concepto.setImporte("100.00");
		concepto.setValorUnitario("100.00");
		facturaRequest.addConcepto(concepto);
		
		concepto = new Concepto();
		concepto.setCantidad("15");
		concepto.setDescripcion("TornillosB");
		concepto.setImporte("100.00");
		concepto.setValorUnitario("100.00");
		facturaRequest.addConcepto(concepto);
		
		Traslado traslado = new Traslado();
		traslado.setImporte("16");
		traslado.setImpuesto("IVA");
		traslado.setTasa("16");
		facturaRequest.addTraslado(traslado);
		
		Retencion retencion = new Retencion();
		retencion.setImporte("10");
		retencion.setImpuesto("ISR");
		retencion.setTasa("10");
		facturaRequest.addRetencion(retencion);
		
		new FacturaService().generaFactura(facturaRequest);
	}
	
	@Test
	public void testObtieneFacturasGmail(){
		Request request = new mx.com.factmex.app.client.to.request.Request("","");
		request.getSession().setProperty(Session.Property.IDEMISOR.getName(), "1");
		FacturaService facturaService = new FacturaService();
		Response response = facturaService.obtieneFacturasGmail(request);
		
	}

}
