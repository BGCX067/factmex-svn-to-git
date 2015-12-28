package mx.com.factmex.app.server.services.factura.cfdv2.informes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import mx.com.factmex.app.server.services.factura.cfdv2.Comprobante;
import mx.com.factmex.app.server.services.factura.cfdv2.exceptions.ParseComprobanteException;
import mx.com.factmex.app.server.services.factura.cfdv2.util.MarshallCFDv2XML;
import mx.com.factmex.app.server.sqlmaps.dao.CParametroDAO;
import mx.com.factmex.app.server.sqlmaps.dao.DAOManager;
import mx.com.factmex.app.server.sqlmaps.dao.TComprobanteDAO;
import mx.com.factmex.app.server.sqlmaps.model.CParametro;
import mx.com.factmex.app.server.sqlmaps.model.CParametroExample;
import mx.com.factmex.app.server.sqlmaps.model.TComprobante;
import mx.com.factmex.app.server.sqlmaps.model.TComprobanteExample;
import mx.com.factmex.app.server.sqlmaps.model.TComprobanteExample.Criteria;
public class InformeSAT {
	Comprobante cfd = new Comprobante();
	ComprobantesInformeSAT crea = new ComprobantesInformeSAT();
	public String RFC;
	public String rutaGenerada;
	Comprobante.Emisor emisor;
	public boolean preparaInforme(String xml, String anoMes,String idEmisor) throws ParseComprobanteException, IOException, SQLException{
		short edo=0;
		File ruta =new File (xml);
		String lista [] = ruta.list();
		for(String archivo:lista){
			TComprobanteDAO comprobanteDAO = DAOManager.getInstance().getTComprobanteDAO();
			TComprobanteExample example = new TComprobanteExample();
			Criteria criteria = example.createCriteria();
			int tam = archivo.length()-4;
			String archivo2= archivo.substring(0,tam);
			criteria.andNombreArchivoXmlEqualTo(archivo2);
			List<TComprobante> comprobantes = comprobanteDAO.selectByExample(example);
			for(TComprobante comprobante : comprobantes){
				edo = Short.parseShort(comprobante.getEstatusSat());
			}
			criteria=null;
			creaInforme(xml+"/"+archivo,edo);
		}
		String pathReporte=null;
		CParametroDAO parametroDAO= DAOManager.getInstance().getCParametroDAO();
        CParametroExample example = new CParametroExample();
        mx.com.factmex.app.server.sqlmaps.model.CParametroExample.Criteria criteria = example.createCriteria();
		criteria.andIdEmisorEqualTo(idEmisor);
		criteria.andNombreEqualTo("RUTA_REPORTE_MENSUAL");
		List<CParametro> parametros= parametroDAO.selectByExample(example);
		for(CParametro parametro : parametros){
			pathReporte = parametro.getValorCadena();
		}
		String informa = pathReporte+"/"+RFC+""+anoMes+".txt";
		rutaGenerada= informa;
		System.out.println(informa);
		OutputStream  informe = new FileOutputStream(informa);
		crea.generarReporteSAT(informe);
		return true;
	}
	public void creaInforme(String xml, short edo) throws FileNotFoundException, ParseComprobanteException{
		
		this.cfd = MarshallCFDv2XML.unmarshalCfdV2(new FileInputStream(xml));
		crea.addComprobanteInformeSAT(new ComprobanteInformeSAT(cfd,edo));
		emisor=cfd.getEmisor();
		RFC = emisor.getRfc();
	}
	public String formatDate(Date date, String format){
		Format formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}
}
