package mx.com.factmex.app.server.services.rpc;

import static org.junit.Assert.*;

import mx.com.factmex.app.client.to.request.Request;
import mx.com.factmex.app.client.to.response.FacturaResponse;

import org.junit.Test;

public class ClienteServiceTest {

	@Test
	public void testObtenClientesEmisorActual() {
		
	}

	@Test
	public void testObtenCliente() {
		ClienteService clienteService = new ClienteService();
		Request request = new Request();
		request.setSimpleValue("1");
		FacturaResponse response = (FacturaResponse) clienteService.obtenCliente(request);
		assertTrue(response.isSuccess());
	}

}
