package mx.com.factmex.app.server.services.rpc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;


import mx.com.factmex.app.client.to.Session;
import mx.com.factmex.app.client.to.model.Concepto;
import mx.com.factmex.app.client.to.model.Factura;
import mx.com.factmex.app.client.to.model.Retencion;
import mx.com.factmex.app.client.to.model.Traslado;
import mx.com.factmex.app.client.to.request.FacturaRequest;
import mx.com.factmex.app.client.to.request.Request;
import mx.com.factmex.app.client.to.response.ClienteResponse;
import mx.com.factmex.app.client.to.response.ListFacturasResponse;
import mx.com.factmex.app.client.to.response.Response;
import mx.com.factmex.app.server.services.factura.LIB;
import mx.com.factmex.app.server.services.factura.ParametrosEnum;
import mx.com.factmex.app.server.services.factura.ReadNewGmailInvoices;
import mx.com.factmex.app.server.services.factura.cfdv2.Comprobante;
import mx.com.factmex.app.server.services.factura.cfdv2.exceptions.ParseComprobanteException;
import mx.com.factmex.app.server.services.factura.cfdv2.informes.InformeSAT;
import mx.com.factmex.app.server.services.factura.cfdv2.util.MarshallCFDv2XML;
import mx.com.factmex.app.server.sqlmaps.dao.DAOManager;
import mx.com.factmex.app.server.sqlmaps.model.CParametro;
import mx.com.factmex.app.server.sqlmaps.model.CParametroExample;
import mx.com.factmex.app.server.sqlmaps.model.CParametroExample.Criteria;
import mx.com.factmex.app.server.sqlmaps.model.TComprobante;
import mx.com.factmex.app.server.sqlmaps.model.TComprobanteExample;
import mx.com.factmex.app.server.sqlmaps.model.TDireccion;
import mx.com.factmex.app.server.sqlmaps.model.TDireccionExample;
import mx.com.factmex.app.server.sqlmaps.model.TEmisor;
import mx.com.factmex.app.server.sqlmaps.model.TSerie;

public class FacturaService {
	public String idEmisor = null;
	public String pathXmlrecibidos = "";
	public Response generaFactura(Request request){
		idEmisor = request.getSession().getProperty(Session.Property.IDEMISOR.getName());
		Integer idCliente = null;
		String nombreCliente = null;
		System.out.println("generaFactura: emisor=" + idEmisor);
		Response response = new Response();
		FacturaRequest facturaRequest = (FacturaRequest) request;
		System.out.println("generaFactura: conceptos=" + facturaRequest.getConceptos().size());
		System.out.println("generaFactura: retenciones=" + facturaRequest.getRetenciones().size());
		System.out.println("generaFactura: subtotal=" + facturaRequest.getSubtotal());
		System.out.println("generaFactura: total=" + facturaRequest.getTotal());
		System.out.println("generaFactura: traslados=" + facturaRequest.getTraslados().size());
		System.out.println("generaFactura: cliente=" +facturaRequest.getCliente());
		System.out.println("generaFactura: RFC cliente=" +facturaRequest.getRfc());
		
		try{
			ClienteResponse clienteResponse = new ClienteService().guardarCliente(facturaRequest);
			if(!clienteResponse.isSuccess()){
				response.setMessage(clienteResponse.getMessage());
				response.setSuccess(clienteResponse.isSuccess());
				return response;
			} else {
				idCliente = clienteResponse.getCliente().getIdCliente();
				nombreCliente = clienteResponse.getCliente().getNombre();
			}
			
			
			System.out.println("generaFactura: Obteniendo configuracion de emisor ");
			String publica = getParameterString(idEmisor, ParametrosEnum.RUTA_CER_SELLO.getParam());
			System.out.println("generaFactura: " + publica);
			
			String pwdCer = getParameterString(idEmisor, ParametrosEnum.PASSWORD_KEY_SELLO.getParam());
			System.out.println("generaFactura: " + pwdCer);
			
			String privada = getParameterString(idEmisor,ParametrosEnum.RUTA_KEY_SELLO.getParam());
			System.out.println("generaFactura: " + privada);
			String nombreFactura = System.currentTimeMillis() + "";
				        
	        String imagen  = getParameterString(idEmisor,ParametrosEnum.RUTA_IMAGEN_FACTURA.getParam());
	        System.out.println("generaFactura: " + imagen);
	        String coordenadas = getParameterString(idEmisor,ParametrosEnum.RUTA_COORDENADAS_FACTURA.getParam());
	        System.out.println("generaFactura: " + coordenadas);
				
				
		         
	        //Servicio para generar factura
			LIB cfdLibrary = new LIB();
			TSerie tSerie = DAOManager.getInstance().getTSerieDAO().selectByPrimaryKey(facturaRequest.getIdSerie());
			tSerie.setFolioActual(new Integer(new Integer(tSerie.getFolioActual()) + 1).toString());
			
			//Actualiza el nuevo numero de serie
			DAOManager.getInstance().getTSerieDAO().updateByPrimaryKey(tSerie);
			//Prueba
			String contado ="1";
			String parcialidad = "";
			String totalParcialidad = "";
			cfdLibrary.setArgs(tSerie.getFolioActual(), formatDate(new Date(), "yyyy-MM-dd HH:mm:ss") , 
								tSerie.getNoAprobacion(), tSerie.getAnioAprobacion(), "", facturaRequest.getSubtotal() + "", facturaRequest.getTotal() + "", tSerie.getSerie()+"",contado,parcialidad,totalParcialidad);//Aqui debes pasar los nuevos parametros
			cfdLibrary.setEmisor(facturaRequest.getSession().getProperty(Session.Property.RAZONSOCIAL.getName()), facturaRequest.getSession().getProperty(Session.Property.RFC.getName()));
			
			TDireccionExample tDireccionExample = new TDireccionExample();
			mx.com.factmex.app.server.sqlmaps.model.TDireccionExample.Criteria tDireccionCriteria =  tDireccionExample.createCriteria();
			tDireccionCriteria.andIdEmisorEqualTo(idEmisor);
			tDireccionCriteria.andIdTipoDireccionEqualTo("1");
			
			List<TDireccion> tDirecciones = DAOManager.getInstance().getTDireccionDAO().selectByExample(tDireccionExample);
			TDireccion direccionEmisor = new TDireccion();
			if(tDirecciones.size() <= 0){
				response.setSuccess(false);
				response.setMessage("Error al generar la factura : \n el emisor no tiene direccion fiscal capturada");
				return response;
			} else {
				direccionEmisor = tDirecciones.get(0);
			}
			
			cfdLibrary.setDomicilioEmisor(direccionEmisor.getCalle(), direccionEmisor.getCodigoPostal(), direccionEmisor.getColonia(), direccionEmisor.getEstado() ,direccionEmisor.getLocalidad(),direccionEmisor.getMunicipio(), direccionEmisor.getNumeroExterior(), direccionEmisor.getNumeroInterior(), direccionEmisor.getPais(),direccionEmisor.getRefererncia());
			cfdLibrary.setLugarExpedicion(direccionEmisor.getCalle(), direccionEmisor.getCodigoPostal(), direccionEmisor.getColonia(), direccionEmisor.getEstado() ,direccionEmisor.getLocalidad(),direccionEmisor.getMunicipio(), direccionEmisor.getNumeroExterior(), direccionEmisor.getNumeroInterior(), direccionEmisor.getPais(),direccionEmisor.getRefererncia());
			cfdLibrary.setReceptor(nombreCliente, facturaRequest.getRfc());
			cfdLibrary.setDomicilioCliente(facturaRequest.getCalle(), facturaRequest.getCp(), facturaRequest.getColonia(), facturaRequest.getEstado() ,facturaRequest.getLocalidad(),facturaRequest.getMunicipio(), facturaRequest.getNoExt(), facturaRequest.getNoInt(), facturaRequest.getPais(),facturaRequest.getReferencia());
			cfdLibrary.setTotalConceptos(facturaRequest.getConceptos().size());
			for(int i = 0; i < facturaRequest.getConceptos().size(); i++){
				Concepto concepto = facturaRequest.getConceptos().get(i);
				cfdLibrary.setConceptos(i+1, "", concepto.getUnidad(), concepto.getCantidad(), concepto.getDescripcion(),concepto.getImporte(), concepto.getValorUnitario());
			}
			
			cfdLibrary.setTotalImp(facturaRequest.getRetenciones().size() + facturaRequest.getTraslados().size());
			int indiceImpuesto = 0;
			for(int i = 0 ; i < facturaRequest.getTraslados().size(); i++){
				Traslado traslado = facturaRequest.getTraslados().get(i);
				cfdLibrary.setImpuestos(indiceImpuesto + 1, traslado.getImporte(facturaRequest.getSubtotal()), traslado.getTasa(), traslado.getImpuesto());
				indiceImpuesto++;
			}
			
			for(int i = 0 ; i < facturaRequest.getRetenciones().size(); i++){
				Retencion retencion = facturaRequest.getRetenciones().get(i);
				cfdLibrary.setImpuestos(indiceImpuesto + 1, retencion.getImporte(facturaRequest.getSubtotal()), retencion.getTasa(), "-" + retencion.getImpuesto());
				indiceImpuesto++;
			}
		
			// Crea la estructura de datos del comprobante
			if(cfdLibrary.CreaComprobante(privada, pwdCer, publica) == 1){
				System.out.println("Comprobante creado correctamente");
			}
			
			String anoMes = formatDate(new Date(), "yyyy-MM");
	        String pathXml = getParameterString(idEmisor,ParametrosEnum.RUTA_XML_FACTURAS.getParam()) + "\\" + anoMes; //"C:/temp/AAA010101AAA/xml/FACTURA_2.xml";
	        String nombreXml = "\\" + nombreFactura + ".xml"; //"C:/temp/AAA010101AAA/xml/FACTURA_2.xml";
	        String pdf = getParameterString(idEmisor,ParametrosEnum.RUTA_PDF_FACTURAS.getParam()) + "\\" + anoMes + "\\" + nombreFactura + ".pdf";
	        File pdfPath = new File(getParameterString(idEmisor,ParametrosEnum.RUTA_PDF_FACTURAS.getParam()) + "\\" + anoMes + "\\");
	        if(!pdfPath.exists()){
	        	pdfPath.mkdir();
	        }
	        /*
	        File pathXmlrecibidos = new File(pathXml+"\\recibidas");
	        if(!pathXmlrecibidos.exists()){
	        	pathXmlrecibidos.mkdir();
	        }*/
	        pathXmlrecibidos = pathXml+"\\recibidas";
	        System.out.println("generaFactura: " + pdf);
	        String pathCompletoXML = pathXml+""+nombreXml;
	        System.out.println("generaFactura: " + nombreXml);

			// Crea el XML del comprobante 
			if(cfdLibrary.CreaXML(nombreXml,pathXml) == 1){
				System.out.println("XML creado correctamente " + pathCompletoXML);
				File xmlFile = new File(pathCompletoXML);
		        response.setSimpleValue(registraFacturaDB(xmlFile.getName(), xmlFile, "1" , "1" , idCliente.toString()) + "");
		        System.out.println("Factura registrada en BD correctamente " + nombreFactura);
		        // Crea el PDF del comprobante
				if(cfdLibrary.CreaPDF(pathCompletoXML, imagen, pdf, direccionEmisor.getEstado(), coordenadas) == 1){
					System.out.println("PDF creado correctamente " + pdf);
				}
			}

			//InformeSAT crea = new InformeSAT();
			//crea.preparaInforme(pathXml);
	        
			response.setSuccess(true);
			response.setMessage("Factura generada exitosamente");
			
		} catch(SQLException e) {
			response.setSuccess(false);
			response.setMessage("Error al generar la factura : \n"  + e.getMessage());
		} catch(Exception e) {
			response.setSuccess(false);
			response.setMessage("Error al generar la factura : \n"  + e.getMessage());
		}
		

		return response;
	}
	
	public int registraFacturaDB(String xmlFileName, File xmlFile, String estatus, String idTipoComprobante , String idCliente) throws FileNotFoundException, IOException, ParseComprobanteException, SQLException{
		 Comprobante comprobante = MarshallCFDv2XML.unmarshalCfdV2(new FileInputStream(xmlFile));
		 TComprobante tComprobante = new TComprobante();
		 if(idCliente == null) {
			 tComprobante.setFacturadoA(comprobante.getEmisor().getNombre());
		 } else {
			 tComprobante.setFacturadoA(comprobante.getReceptor().getNombre());
		 }
		 System.out.println("Facturado: " + tComprobante.getFacturadoA());
		 tComprobante.setFecha(comprobante.getFecha());
		 tComprobante.setFolio(comprobante.getFolio());
		 tComprobante.setIdEmisor(idEmisor);
		 tComprobante.setAnio(Calendar.getInstance().get(Calendar.YEAR) + "");
		 tComprobante.setMes((Calendar.getInstance().get(Calendar.MONTH) + 1) + "");
		 tComprobante.setIdEstatus(estatus);
		 tComprobante.setMonto(comprobante.getTotal().toString());
		 tComprobante.setNombreArchivoXml(xmlFileName.replaceAll(".xml", ""));
		 tComprobante.setIdTipoComprobante(idTipoComprobante);
		 if(idCliente != null) {
			 tComprobante.setIdCliente(idCliente);
		 }
		 tComprobante.setEstatusSat("1");
		 DAOManager.getInstance().getTComprobanteDAO().insert(tComprobante);
		 return DAOManager.getInstance().getTComprobanteDAO().maxIdComprobante();
		 
	}
	public Response obtieneFacturasGmail(Request request){
		Response response = new Response();
		String idEmisor = request.getSession().getProperty(Session.Property.IDEMISOR.getName());
		String anoMes = formatDate(new Date(), "yyyy-MM");
		try {
			pathXmlrecibidos = getParameterString(idEmisor,ParametrosEnum.RUTA_XML_FACTURAS.getParam()) + "\\" + anoMes;
		} catch (SQLException e) {
			response.setSuccess(true);
			response.setMessage("Error al obtener facturas :" + e.getMessage());
		} //"C:/temp/AAA010101AAA/xml/FACTURA_2.xml";
		 pathXmlrecibidos = pathXmlrecibidos+"\\recibidas";
		this.idEmisor = idEmisor;
		
		String email = null;
		System.out.println("obtieneFacturasGmail: emisor=" + idEmisor);
		try{
			TEmisor tEmisor = DAOManager.getInstance().getTEmisorDAO().selectByPrimaryKey(idEmisor);
			email = tEmisor.getEmail();
			String emailPwd = tEmisor.getEmailPwd();
			if(email.equals("") || emailPwd.equals("")) {
				response.setSuccess(true);
				response.setMessage("No se encuentra configurada la cuenta de correo");
				return response;
			}
			
			ReadNewGmailInvoices readNewGmailInvoices = new ReadNewGmailInvoices(idEmisor);
			readNewGmailInvoices.retriveNewXMLMessages(email, emailPwd , pathXmlrecibidos);

		} catch(SQLException e) {
			response.setSuccess(true);
			response.setMessage("Error al registrar facturas en B.D. de :" + email+ "\n"  + e.getMessage());
		} catch(ParseComprobanteException e) {
			response.setSuccess(true);
			response.setMessage("Error al leer XML de factura recibida en :" + email+ "\n"  + e.getMessage());
		} catch(MessagingException e) {
			response.setSuccess(true);
			response.setMessage("No fue posible acceder a la cuenta :" + email+ "\n"  + e.getMessage());
		} catch(Exception e) {
			response.setSuccess(true);
			response.setMessage("Error al obtener facturas de :" + email+ "\n"  + e.getMessage());
		}
		return response;
	}
	
	public static String getParameterString(String idEmisor, String param) throws SQLException {
		CParametroExample cparametroExample = new CParametroExample();
		Criteria parametroCriteria = cparametroExample.createCriteria();
		parametroCriteria.andNombreEqualTo(param);
		parametroCriteria.andIdEmisorEqualTo(idEmisor);
		List<CParametro> parameters = DAOManager.getInstance().getCParametroDAO().selectByExample(cparametroExample);
		if(parameters.size() <= 0) {
			throw new SQLException("No se encuentra configurado el parametro : " + param);
		} else {
			CParametro cparametro = parameters.get(0);
			return cparametro.getValorCadena();
		}
	}
	
	public String formatDate(Date date, String format){
		Format formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}
	
	public ListFacturasResponse obtenListadoFacturas(Request request){
		String status = request.getSimpleValue();
		 //Revisa mail para verificar facturas recibidas
		if(status.equals("3")){
			obtieneFacturasGmail(request);
		}
		
		idEmisor = request.getSession().getProperty(Session.Property.IDEMISOR.getName());
		ListFacturasResponse response = new ListFacturasResponse();
		try{
			TComprobanteExample comprobanteExample = new TComprobanteExample();
			comprobanteExample.setOrderByClause("FECHA DESC");
			mx.com.factmex.app.server.sqlmaps.model.TComprobanteExample.Criteria criteria = comprobanteExample.createCriteria();
			criteria.andIdEmisorEqualTo(idEmisor);
			criteria.andIdEstatusEqualTo(status);
			
			
			List<TComprobante> facturas =  (List<TComprobante>) DAOManager.getInstance().getTComprobanteDAO().selectByExample(comprobanteExample);
			for(TComprobante tComprobante :  facturas){
				Factura factura = new Factura();
				factura.setIdComprobante(new Integer(tComprobante.getIdFactura()));
				factura.setFacturado(tComprobante.getFacturadoA());
				factura.setFecha(tComprobante.getFecha());
				factura.setFolio(new Integer(tComprobante.getFolio()));
				factura.setMonto(new Double(tComprobante.getMonto()));
				response.getFacturas().add(factura);
			}
			
			response.setSuccess(true);
			response.setMessage("Obtencion de listado de facturas exitoso");
		} catch(SQLException e) {
			response.setSuccess(true);
			response.setMessage("Error al obtener listado facturas :" + e.getMessage());
		} catch(Exception e) {
			response.setSuccess(true);
			response.setMessage("Error al obtener listado facturas " + e.getMessage());
		}
		return response;
	}
	
}
