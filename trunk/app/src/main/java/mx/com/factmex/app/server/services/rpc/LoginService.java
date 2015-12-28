package mx.com.factmex.app.server.services.rpc;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import mx.com.factmex.app.client.enums.TipoDireccion;
import mx.com.factmex.app.client.to.Session;
import mx.com.factmex.app.client.to.request.Request;
import mx.com.factmex.app.client.to.request.ValidaUsuarioRequest;
import mx.com.factmex.app.client.to.response.Response;
import mx.com.factmex.app.server.sqlmaps.dao.DAOManager;
import mx.com.factmex.app.server.sqlmaps.model.CPerfil;
import mx.com.factmex.app.server.sqlmaps.model.TDireccion;
import mx.com.factmex.app.server.sqlmaps.model.TDireccionExample;
import mx.com.factmex.app.server.sqlmaps.model.TEmisor;
import mx.com.factmex.app.server.sqlmaps.model.TEmisorExample;
import mx.com.factmex.app.server.sqlmaps.model.TUsuario;
import mx.com.factmex.app.server.sqlmaps.model.TUsuarioExample;
import mx.com.factmex.app.server.sqlmaps.model.TUsuarioExample.Criteria;

public class LoginService {
	public static int companiaActual = 1;
	public Response validaUsuario(Request request){
		Response response = new Response();
		ValidaUsuarioRequest validaUsuarioRequest = (ValidaUsuarioRequest) request;
		System.out.println("validaUsuario: usuario=" + validaUsuarioRequest.getUsuario() + ", password=" +validaUsuarioRequest.getPassword() + ", idEmisor=" + validaUsuarioRequest.getIdEmisor());
		TUsuarioExample exampleUsuario = new TUsuarioExample();
		Criteria criteriaUsuario =  exampleUsuario.createCriteria();
		criteriaUsuario.andUsuarioEqualTo(validaUsuarioRequest.getUsuario());
		criteriaUsuario.andPasswordEqualTo(validaUsuarioRequest.getPassword());
		criteriaUsuario.andIdEmisorEqualTo(new BigDecimal(validaUsuarioRequest.getIdEmisor()).toString());

		response.getSession().setProperty(Session.Property.IDEMISOR.getName(), validaUsuarioRequest.getIdEmisor()+"");
		try {
			int encontrados = DAOManager.getInstance().getTUsuarioDAO().countByExample(exampleUsuario);
			System.out.println("validaUsuario: encontrados?" + encontrados);
			if(encontrados > 0){
				response.setSuccess(true);
				List<TUsuario> usuarios = DAOManager.getInstance().getTUsuarioDAO().selectByExample(exampleUsuario);
				TUsuario tUsuario = usuarios.get(0);
				response.getSession().setProperty(Session.Property.USUARIO.getName(), tUsuario.getUsuario());
				response.getSession().setProperty(Session.Property.IDPERFIL.getName(), tUsuario.getIdPerfil());
				CPerfil cperfil = DAOManager.getInstance().getCPerfilDAO().selectByPrimaryKey(tUsuario.getIdPerfil());
				response.getSession().setProperty(Session.Property.PERFIL.getName(), cperfil.getNombre());
				
				TEmisor tEmisor = DAOManager.getInstance().getTEmisorDAO().selectByPrimaryKey(new BigDecimal(validaUsuarioRequest.getIdEmisor()).toString());
				response.getSession().setProperty(Session.Property.RAZONSOCIAL.getName(), tEmisor.getNombre());
				response.getSession().setProperty(Session.Property.RFC.getName(), tEmisor.getRfc());
				
				
				TDireccionExample tdireccionExample = new TDireccionExample();
				mx.com.factmex.app.server.sqlmaps.model.TDireccionExample.Criteria criteriaDireccion = tdireccionExample.createCriteria();
				criteriaDireccion.andIdTipoDireccionEqualTo(new BigDecimal(TipoDireccion.FISCAL.getIdTipoDireccion()).toString());
				criteriaDireccion.andIdEmisorEqualTo(new BigDecimal(validaUsuarioRequest.getIdEmisor()).toString());
				int encontradas = DAOManager.getInstance().getTDireccionDAO().countByExample(tdireccionExample);
				if(encontradas <= 0){
					response.setMessage("El emisor seleccionado, no tiene domicilio fiscal capturado");
				} else {
					List<TDireccion> direcciones = DAOManager.getInstance().getTDireccionDAO().selectByExample(tdireccionExample);
					TDireccion tDireccion = direcciones.get(0); 
					response.getSession().setProperty(Session.Property.CALLE_FISCAL.getName(), tDireccion.getCalle());
					response.getSession().setProperty(Session.Property.CODIGO_POSTAL.getName(), tDireccion.getCodigoPostal().toString());
					response.getSession().setProperty(Session.Property.COLONIA_FISCAL.getName(), tDireccion.getColonia());
					response.getSession().setProperty(Session.Property.LOCALIDAD_FISCAL.getName(), tDireccion.getLocalidad());
					response.getSession().setProperty(Session.Property.MUNICIPIO_FISCAL.getName(), tDireccion.getMunicipio());
					response.getSession().setProperty(Session.Property.NOEXT_FISCAL.getName(), tDireccion.getNumeroExterior());
					response.getSession().setProperty(Session.Property.NOINT_FISCAL.getName(), tDireccion.getNumeroInterior());
					response.getSession().setProperty(Session.Property.REFERENCIA_FISCAL.getName(), tDireccion.getRefererncia());					
				}
				System.out.println("validaUsuario[termina]" + response.isSuccess());
			} else {
				response.setSuccess(false);
				response.setMessage("Usuario o password incorrectos para el emisor seleccionado");
			}
		} catch (SQLException e) {
			response.setSuccess(false);
			response.setMessage("Error en el sistema : " + e.getMessage());
		}
		if(response.isSuccess()){
			request.setSession(response.getSession());
			Response responseFacturas = new FacturaService().obtieneFacturasGmail(request);
			if(responseFacturas.getMessage() != null){
				if(response.getMessage() == null){
					response.setMessage("");
				}
				response.setMessage(response.getMessage() + "\n" + responseFacturas.getMessage());
			}
		}
		return response;
	}
}
