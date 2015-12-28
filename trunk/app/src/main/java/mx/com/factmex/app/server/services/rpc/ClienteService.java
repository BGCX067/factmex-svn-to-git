package mx.com.factmex.app.server.services.rpc;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import mx.com.factmex.app.client.enums.TipoDireccion;
import mx.com.factmex.app.client.to.Session;
import mx.com.factmex.app.client.to.model.Cliente;
import mx.com.factmex.app.client.to.request.FacturaRequest;
import mx.com.factmex.app.client.to.request.Request;
import mx.com.factmex.app.client.to.response.ClienteResponse;
import mx.com.factmex.app.client.to.response.FacturaResponse;
import mx.com.factmex.app.client.to.response.ListClientesResponse;
import mx.com.factmex.app.client.to.response.Response;
import mx.com.factmex.app.client.util.ConvertUtil;
import mx.com.factmex.app.server.sqlmaps.dao.DAOManager;
import mx.com.factmex.app.server.sqlmaps.model.TClienteExample;
import mx.com.factmex.app.server.sqlmaps.model.TCliente;
import mx.com.factmex.app.server.sqlmaps.model.TDireccion;
import mx.com.factmex.app.server.sqlmaps.model.TDireccionExample;
import mx.com.factmex.app.server.sqlmaps.model.TClienteExample.Criteria;

public class ClienteService {
	public Response obtenClientesEmisorActual(Request request){
		System.out.println("obtenClientesEmisorActual: emisor=" + request.getSession().getProperty(Session.Property.IDEMISOR.getName()));
		Response response = new Response();
		
		TClienteExample example = new TClienteExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEmisorEqualTo(new BigDecimal(new Integer(request.getSession().getProperty(Session.Property.IDEMISOR.getName()))).toString());
		try {
			int cuantosClientes = DAOManager.getInstance().getTClienteDAO().countByExample(example);
			String data [][] = new String[cuantosClientes][2];
			example.setOrderByClause("Nombre");
			List<TCliente> clientes = DAOManager.getInstance().getTClienteDAO().selectByExample(example);
			for(int i = 0; i < clientes.size(); i++ ){
				TCliente cliente = clientes.get(i);
				data[i][0] = cliente.getIdCliente().toString();
				data[i][1] = cliente.getNombre();
			}
			response.setData(data);
			response.setSuccess(true);
			response.setMessage("Clientes consultados " + cuantosClientes);
		} catch (SQLException e) {
			response.setSuccess(false);
			response.setMessage("Error en el sistema : " + e.getMessage());
		}
		return response;
	}
	
	public Response obtenCliente(Request request){
		System.out.println("obtenCliente: idCliente=" + request.getSimpleValue());
		FacturaResponse facturaResponse = new FacturaResponse();
		FacturaRequest facturaRequest = new FacturaRequest();
		
		
		try {
			TCliente tCliente = DAOManager.getInstance().getTClienteDAO().selectByPrimaryKey(new BigDecimal(request.getSimpleValue()).toString());
			facturaRequest.setCliente(tCliente.getNombre());
			facturaRequest.setRfc(tCliente.getRfc());
			
			TDireccionExample tdireccionExample = new TDireccionExample();
			mx.com.factmex.app.server.sqlmaps.model.TDireccionExample.Criteria criteriaDireccion = tdireccionExample.createCriteria();
			criteriaDireccion.andIdTipoDireccionEqualTo(new BigDecimal(TipoDireccion.FISCAL.getIdTipoDireccion()).toString());
			criteriaDireccion.andIdClienteEqualTo(new BigDecimal(request.getSimpleValue()).toString());
			List<TDireccion> direcciones = DAOManager.getInstance().getTDireccionDAO().selectByExample(tdireccionExample);
			if(direcciones.size() > 0){
				TDireccion tDireccion = direcciones.get(0);
				facturaRequest.setCalle(tDireccion.getCalle());
				facturaRequest.setColonia(tDireccion.getColonia());
				facturaRequest.setCp(tDireccion.getCodigoPostal().toString());
				facturaRequest.setEstado(tDireccion.getEstado());
				facturaRequest.setLocalidad(tDireccion.getLocalidad());
				facturaRequest.setMunicipio(tDireccion.getMunicipio());
				facturaRequest.setNoExt(tDireccion.getNumeroExterior());
				facturaRequest.setNoInt(tDireccion.getNumeroInterior());
				facturaRequest.setPais(tDireccion.getPais());
				facturaRequest.setReferencia(tDireccion.getRefererncia());
			}
			facturaResponse.setRequest(facturaRequest);
			facturaResponse.setSuccess(true);
		} catch (SQLException e) {
			facturaResponse.setSuccess(false);
			facturaResponse.setMessage("Error en el sistema : " + e.getMessage());
		} catch (Exception e) {
			facturaResponse.setSuccess(false);
			facturaResponse.setMessage("Error en el sistema : " + e.getMessage());
		}
		System.out.println("obtenCliente [termina]: success=" + facturaResponse.isSuccess());
		
		return facturaResponse;
	}
	
	public ListClientesResponse obtenListadoClientes(Request request){
		//String idEmisor = request.getSimpleValue();
		ListClientesResponse response = new ListClientesResponse();
		try{
			TClienteExample clienteExample = new TClienteExample();
			clienteExample.setOrderByClause("NOMBRE ASC");
			mx.com.factmex.app.server.sqlmaps.model.TClienteExample.Criteria criteria = clienteExample.createCriteria();
			criteria.andIdEmisorEqualTo(request.getSession().getProperty(Session.Property.IDEMISOR.getName()));
			
			
			List<TCliente> clientes =  (List<TCliente>) DAOManager.getInstance().getTClienteDAO().selectByExample(clienteExample);
			for(TCliente tCliente :  clientes){
				Cliente cliente = new Cliente();
				cliente.setIdCliente(new Integer(tCliente.getIdCliente()));
				cliente.setNombre(tCliente.getNombre());
				cliente.setRfc(tCliente.getRfc());
				response.getClientes().add(cliente);
			}
			
			response.setSuccess(true);
			response.setMessage("Obtencion de listado de clientes exitoso");
		} catch(SQLException e) {
			response.setSuccess(true);
			response.setMessage("Error al obtener listado clientes :" + e.getMessage());
		} catch(Exception e) {
			response.setSuccess(true);
			response.setMessage("Error al obtener listado clientes " + e.getMessage());
		}
		return response;
	}
	public ClienteResponse guardarCliente(Request request){
		FacturaRequest facturaRequest = (FacturaRequest) request;
		System.out.println("guardarCliente: Cliente=" + facturaRequest.getCliente());
		String idEmisor = facturaRequest.getSession().getProperty(Session.Property.IDEMISOR.getName());
		ClienteResponse response = new ClienteResponse();
		try{
			//Si se trata de un cliente nuevo
			if(!ConvertUtil.isNumeric(facturaRequest.getCliente())){
				System.out.println("Cliente Nuevo " + facturaRequest.getCliente());
				TCliente tCliente = new TCliente(); 
				tCliente.setIdEmisor(idEmisor);
				if(facturaRequest.getRfc().length() == 12) { //Persona Moral
					tCliente.setIdTipoPersona("2");
				} else {
					tCliente.setIdTipoPersona("1");
				}
				tCliente.setNombre(facturaRequest.getCliente());
				response.getCliente().setNombre(facturaRequest.getCliente());
				tCliente.setRfc(facturaRequest.getRfc());
				
				DAOManager.getInstance().getTClienteDAO().insert(tCliente);
				response.getCliente().setIdCliente(DAOManager.getInstance().getTClienteDAO().maxIdCliente());
				System.out.println("generaFactura: cliente insertado " + response.getCliente().getIdCliente());
				
				TDireccion tDireccion = new TDireccion();
				
				tDireccion.setIdCliente(response.getCliente().getIdCliente() + "");
				tDireccion.setCalle(facturaRequest.getCalle());
				tDireccion.setCodigoPostal(facturaRequest.getCp());
				tDireccion.setColonia(facturaRequest.getColonia());
				tDireccion.setEstado(facturaRequest.getEstado());
				tDireccion.setIdTipoDireccion("1");
				tDireccion.setLocalidad(facturaRequest.getLocalidad());
				tDireccion.setMunicipio(facturaRequest.getMunicipio());
				tDireccion.setNumeroExterior(facturaRequest.getNoExt());
				tDireccion.setNumeroInterior(facturaRequest.getNoInt());
				tDireccion.setPais(facturaRequest.getPais());
				tDireccion.setRefererncia(facturaRequest.getReferencia());
				tDireccion.setRegionFronteriza("1");
				DAOManager.getInstance().getTDireccionDAO().insert(tDireccion);
				
				
			} else { //Si es un cliente existente
				System.out.println("Cliente actualizar " + facturaRequest.getCliente());
				response.getCliente().setIdCliente(new Integer(facturaRequest.getCliente()));
				
				try{	
				TCliente tCliente = DAOManager.getInstance().getTClienteDAO().selectByPrimaryKey(response.getCliente().getIdCliente() + "");
				if(facturaRequest.getNuevoNombre() != null){
					tCliente.setNombre(facturaRequest.getNuevoNombre());
				}
				tCliente.setRfc(facturaRequest.getRfc());
				//TODO Guardar la direccion
				
				TDireccionExample tdireccionExample = new TDireccionExample();
				mx.com.factmex.app.server.sqlmaps.model.TDireccionExample.Criteria criteriaDireccion = tdireccionExample.createCriteria();
				criteriaDireccion.andIdTipoDireccionEqualTo(new BigDecimal(TipoDireccion.FISCAL.getIdTipoDireccion()).toString());
				criteriaDireccion.andIdClienteEqualTo(new BigDecimal(facturaRequest.getCliente()).toString());
				List<TDireccion> direcciones = DAOManager.getInstance().getTDireccionDAO().selectByExample(tdireccionExample);
				if(direcciones.size() > 0){
					TDireccion tDireccion = direcciones.get(0);
					tDireccion.setIdCliente(facturaRequest.getCliente());
					tDireccion.setCalle(facturaRequest.getCalle());
					tDireccion.setCodigoPostal(facturaRequest.getCp());
					tDireccion.setColonia(facturaRequest.getColonia());
					tDireccion.setEstado(facturaRequest.getEstado());
					tDireccion.setIdTipoDireccion("1");
					tDireccion.setLocalidad(facturaRequest.getLocalidad());
					tDireccion.setMunicipio(facturaRequest.getMunicipio());
					tDireccion.setNumeroExterior(facturaRequest.getNoExt());
					tDireccion.setNumeroInterior(facturaRequest.getNoInt());
					tDireccion.setPais(facturaRequest.getPais());
					tDireccion.setRefererncia(facturaRequest.getReferencia());
					tDireccion.setRegionFronteriza("1");
					DAOManager.getInstance().getTDireccionDAO().updateByPrimaryKey(tDireccion);
				} else {
					TDireccion tDireccion = new TDireccion();
					tDireccion.setIdCliente(facturaRequest.getCliente());
					tDireccion.setCalle(facturaRequest.getCalle());
					tDireccion.setCodigoPostal(facturaRequest.getCp());
					tDireccion.setColonia(facturaRequest.getColonia());
					tDireccion.setEstado(facturaRequest.getEstado());
					tDireccion.setIdTipoDireccion("1");
					tDireccion.setLocalidad(facturaRequest.getLocalidad());
					tDireccion.setMunicipio(facturaRequest.getMunicipio());
					tDireccion.setNumeroExterior(facturaRequest.getNoExt());
					tDireccion.setNumeroInterior(facturaRequest.getNoInt());
					tDireccion.setPais(facturaRequest.getPais());
					tDireccion.setRefererncia(facturaRequest.getReferencia());
					tDireccion.setRegionFronteriza("1");
					DAOManager.getInstance().getTDireccionDAO().insert(tDireccion);
				}
				
				DAOManager.getInstance().getTClienteDAO().updateByPrimaryKey(tCliente);
				response.getCliente().setNombre(tCliente.getNombre());
				}catch(SQLException e){
					System.out.println(e.getMessage());
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
				
			}
			response.setSuccess(true);
			response.setMessage("Cliente guardado " + response.getCliente().getIdCliente());
		} catch(SQLException e) {
			response.setSuccess(false);
			response.setMessage("Error al guardar cliente :" + e.getMessage());
		} catch(Exception e) {
			response.setSuccess(false);
			response.setMessage("Error al guardar cliente " + e.getMessage());
		}
		return response;
	}
	
	public Response eliminaCliente(Request request){
		Response response = new Response();
		String idCliente = request.getSimpleValue();
		try{
			DAOManager.getInstance().getTClienteDAO().deleteByPrimaryKey(idCliente);
			response.setSuccess(true);
			response.setMessage("Cliente eliminado " + idCliente);
		} catch(SQLException e) {
			response.setSuccess(true);
			response.setMessage("Error al eliminar cliente :" + e.getMessage());
		} catch(Exception e) {
			response.setSuccess(true);
			response.setMessage("Error al eliminar cliente " + e.getMessage());
		}
		return response;
	}
}
