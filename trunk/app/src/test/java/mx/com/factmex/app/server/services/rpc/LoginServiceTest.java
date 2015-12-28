package mx.com.factmex.app.server.services.rpc;

import static org.junit.Assert.*;

import mx.com.factmex.app.client.to.request.ValidaUsuarioRequest;
import mx.com.factmex.app.client.to.response.Response;

import org.junit.Test;

public class LoginServiceTest {

	@Test
	public void testValidaUsuario() {
		LoginService loginService = new LoginService();
		ValidaUsuarioRequest validaUsuarioRequest = new ValidaUsuarioRequest();
		validaUsuarioRequest.setUsuario("gguerrero");
		validaUsuarioRequest.setPassword("gguerrero");
		validaUsuarioRequest.setIdEmisor(1);
		Response response = loginService.validaUsuario(validaUsuarioRequest);
		assertTrue(response.isSuccess());
	}

}
