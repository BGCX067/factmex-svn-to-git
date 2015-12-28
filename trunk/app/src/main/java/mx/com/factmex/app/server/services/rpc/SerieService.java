package mx.com.factmex.app.server.services.rpc;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import mx.com.factmex.app.client.enums.TipoDireccion;
import mx.com.factmex.app.client.to.Session;
import mx.com.factmex.app.client.to.model.Cliente;
import mx.com.factmex.app.client.to.model.Serie;
import mx.com.factmex.app.client.to.request.FacturaRequest;
import mx.com.factmex.app.client.to.request.Request;
import mx.com.factmex.app.client.to.request.SerieRequest;
import mx.com.factmex.app.client.to.response.ClienteResponse;
import mx.com.factmex.app.client.to.response.FacturaResponse;
import mx.com.factmex.app.client.to.response.ListClientesResponse;
import mx.com.factmex.app.client.to.response.ListSeriesResponse;
import mx.com.factmex.app.client.to.response.Response;
import mx.com.factmex.app.client.util.ConvertUtil;
import mx.com.factmex.app.server.sqlmaps.dao.DAOManager;
import mx.com.factmex.app.server.sqlmaps.model.TCliente;
import mx.com.factmex.app.server.sqlmaps.model.TClienteExample;
import mx.com.factmex.app.server.sqlmaps.model.TDireccion;
import mx.com.factmex.app.server.sqlmaps.model.TDireccionExample;
import mx.com.factmex.app.server.sqlmaps.model.TSerie;
import mx.com.factmex.app.server.sqlmaps.model.TSerieExample;
import mx.com.factmex.app.server.sqlmaps.model.TSerieExample.Criteria;

public class SerieService {
	public Response obtieneSeries(Request request){
		Response response = new Response();
		System.out.println("obtieneSeries: emisor=" + request.getSession().getProperty(Session.Property.IDEMISOR.getName()));
		
		TSerieExample example = new TSerieExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEmisorEqualTo(new BigDecimal(new Integer(request.getSession().getProperty(Session.Property.IDEMISOR.getName()))).toString());
		try {
			int cuantasSeries = DAOManager.getInstance().getTSerieDAO().countByExample(example);
			String data [][] = new String[cuantasSeries][2];
			example.setOrderByClause("Serie");
			List<TSerie> series = DAOManager.getInstance().getTSerieDAO().selectByExample(example);
			for(int i = 0; i < series.size(); i++ ){
				TSerie serie = series.get(i);
				data[i][0] = serie.getIdSerie().toString();
				data[i][1] = serie.getSerie();
			}
			response.setData(data);
			response.setSuccess(true);
			response.setMessage("Series consultadas " + cuantasSeries);
		} catch (SQLException e) {
			response.setSuccess(false);
			response.setMessage("Error en el sistema : " + e.getMessage());
		}
		System.out.println(response.getMessage());
		return response;
	}
	public ListSeriesResponse obtenListadoSeries(Request request){
		//String idEmisor = request.getSimpleValue();
		ListSeriesResponse response = new ListSeriesResponse();
		try{
			TSerieExample serieExample = new TSerieExample();
			serieExample.setOrderByClause("SERIE ASC");
			mx.com.factmex.app.server.sqlmaps.model.TSerieExample.Criteria criteria = serieExample.createCriteria();
			criteria.andIdEmisorEqualTo(request.getSession().getProperty(Session.Property.IDEMISOR.getName()));
			
			
			List<TSerie> series =  (List<TSerie>) DAOManager.getInstance().getTSerieDAO().selectByExample(serieExample);
			for(TSerie tSerie :  series){
				Serie serie = new Serie();
				serie.setIdSerie(tSerie.getIdSerie());
				serie.setSerie(tSerie.getSerie());
				serie.setFolioInicial(tSerie.getFolioInicial());
				serie.setFolioFinal(tSerie.getFolioFinal());
				serie.setNoAprobacion(tSerie.getNoAprobacion());
				serie.setAnioAprobacion(tSerie.getAnioAprobacion());
				response.getSeries().add(serie);
			}
			
			response.setSuccess(true);
			response.setMessage("Obtencion de listado de series exitoso");
		} catch(SQLException e) {
			response.setSuccess(true);
			response.setMessage("Error al obtener listado series :" + e.getMessage());
		} catch(Exception e) {
			response.setSuccess(true);
			response.setMessage("Error al obtener listado series " + e.getMessage());
		}
		return response;
	}
	public Response guardarSerie(Request request){
		System.out.println("guardarSerie: Operacion=" + request.getSimpleValue());
		SerieRequest serieRequest = (SerieRequest) request;
		String operacion = serieRequest.getSimpleValue();		
		String idEmisor = serieRequest.getSession().getProperty(Session.Property.IDEMISOR.getName());
		Response response = new Response();
		try{
			if(operacion.equals("U")){
				TSerie tSerie = DAOManager.getInstance().getTSerieDAO().selectByPrimaryKey(serieRequest.getSerie().getIdSerie());
				tSerie.setAnioAprobacion(serieRequest.getSerie().getAnioAprobacion());
				tSerie.setFolioFinal(serieRequest.getSerie().getFolioFinal());
				tSerie.setFolioInicial(serieRequest.getSerie().getFolioInicial());
				tSerie.setNoAprobacion(serieRequest.getSerie().getNoAprobacion());
				tSerie.setSerie(serieRequest.getSerie().getSerie());
				tSerie.setIdEmisor(idEmisor);
				
				DAOManager.getInstance().getTSerieDAO().updateByPrimaryKey(tSerie);
			} else {
				TSerie tSerie = new TSerie();
				tSerie.setAnioAprobacion(serieRequest.getSerie().getAnioAprobacion());
				tSerie.setFolioFinal(serieRequest.getSerie().getFolioFinal());
				tSerie.setFolioInicial(serieRequest.getSerie().getFolioInicial());
				tSerie.setNoAprobacion(serieRequest.getSerie().getNoAprobacion());
				tSerie.setSerie(serieRequest.getSerie().getSerie());
				tSerie.setIdEmisor(idEmisor);
				tSerie.setFolioActual("0");
				DAOManager.getInstance().getTSerieDAO().insert(tSerie);
			}
			response.setSuccess(true);
			response.setMessage("Serie guardada ");
		} catch(SQLException e) {
			response.setSuccess(false);
			response.setMessage("Error al guardar serie :" + e.getMessage());
		} catch(Exception e) {
			response.setSuccess(false);
			response.setMessage("Error al guardar serie " + e.getMessage());
		}
		return response;
	}
	
	public Response eliminaSerie(Request request){
		System.out.println("eliminaSerie: idSerie=" + request.getSimpleValue());
		Response response = new Response();
		String idSerie = request.getSimpleValue();
		try{
			DAOManager.getInstance().getTSerieDAO().deleteByPrimaryKey(idSerie);
			response.setSuccess(true);
			response.setMessage("Serie eliminada " + idSerie);
		} catch(SQLException e) {
			response.setSuccess(true);
			response.setMessage("Error al eliminar serie :" + e.getMessage());
		} catch(Exception e) {
			response.setSuccess(true);
			response.setMessage("Error al eliminar serie " + e.getMessage());
		}
		return response;
	}
	
	public Response obtenSerie(Request request){
		System.out.println("obtenSerie: idSerie=" + request.getSimpleValue());
		ListSeriesResponse listSeriesResponse = new ListSeriesResponse();
		try {
			TSerie tSerie = DAOManager.getInstance().getTSerieDAO().selectByPrimaryKey(new BigDecimal(request.getSimpleValue()).toString());
			if(tSerie != null){
				Serie serie = new Serie();
				serie.setIdSerie(tSerie.getIdSerie());
				serie.setSerie(tSerie.getSerie());
				serie.setFolioInicial(tSerie.getFolioInicial());
				serie.setFolioFinal(tSerie.getFolioFinal());
				serie.setAnioAprobacion(tSerie.getAnioAprobacion());
				serie.setNoAprobacion(tSerie.getNoAprobacion());
				listSeriesResponse.getSeries().add(serie);
				listSeriesResponse.setSuccess(true);
			}
		} catch (SQLException e) {
			listSeriesResponse.setSuccess(false);
			listSeriesResponse.setMessage("Error en el sistema : " + e.getMessage());
		} catch (Exception e) {
			listSeriesResponse.setSuccess(false);
			listSeriesResponse.setMessage("Error en el sistema : " + e.getMessage());
		}
		System.out.println("obtenSerie [termina]: success=" + listSeriesResponse.isSuccess());
		
		return listSeriesResponse;
	}
}
