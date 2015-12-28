package mx.com.factmex.app.server.services.rpc;

import static org.junit.Assert.*;

import mx.com.factmex.app.client.to.request.Request;
import mx.com.factmex.app.client.to.request.ValidaUsuarioRequest;

import org.junit.Test;

public class EmisorServiceTest {

	@Test
	public void testObtenEmisoresCompaniaActual() {
		ValidaUsuarioRequest validaUsuarioRequest = new ValidaUsuarioRequest("LoginService" , "validaUsuario");
		assertNotNull(validaUsuarioRequest.getSession());
		new EmisorService().obtenEmisoresCompaniaActual(new Request());
	}

}
