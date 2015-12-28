package mx.com.factmex.app.server.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.factmex.app.client.to.Session;
import mx.com.factmex.app.server.services.factura.cfdv2.informes.InformeSAT;
import mx.com.factmex.app.server.sqlmaps.dao.CParametroDAO;
import mx.com.factmex.app.server.sqlmaps.dao.DAOManager;
import mx.com.factmex.app.server.sqlmaps.model.CParametro;
import mx.com.factmex.app.server.sqlmaps.model.CParametroExample;
import mx.com.factmex.app.server.sqlmaps.model.CParametroExample.Criteria;

public class DescargaReporte extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int BYTES_DOWNLOAD = 1024;
	public String idEmisor = null;
	public String RFC = null;
	public String ruta = null;
	public String rutaArchivo = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		OutputStream os = response.getOutputStream();

			String anio = request.getParameter("anio");
			String mes = request.getParameter("mes");
			if (anio == null || mes == null) {
				response.getOutputStream().println(generaError("Año o mes incorrectos: " + anio + ", " + mes));
				return;
			}
			String anoMes = anio + "-" + mes;
			
			System.out.println("DescargaReporte año=" + anio);
			System.out.println("DescargaReporte mes=" + mes);
			System.out.println("DescargaReporte anoMes=" + anoMes);
			idEmisor = request.getSession().getAttribute(Session.Property.IDEMISOR.getName()).toString();
			RFC = request.getSession().getAttribute(Session.Property.RFC.getName()).toString();
			response.setContentType("text/txt");
			response.setHeader("Content-Disposition",
					"attachment;filename=" + RFC + mes + anio + ".txt");
			
			//pathReporte+"/"+RFC+""+anoMes+".txt";
			
			CParametroDAO parametroDAO = DAOManager.getInstance().getCParametroDAO();
			CParametroExample example = new CParametroExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdEmisorEqualTo(idEmisor);
			criteria.andNombreEqualTo("RUTA_XML_FACTURAS");
			try{
		List<CParametro> parametros = parametroDAO.selectByExample(example);
		for (CParametro parametro : parametros) {
			ruta = parametro.getValorCadena();
		}
		rutaArchivo = ruta +"/"+RFC;
		ruta = ruta + "\\" + anoMes;
		System.out.println(ruta);
		InformeSAT crea = new InformeSAT();
		anoMes = mes + "" + anio;
		rutaArchivo += ""+anoMes+".txt";
		crea.preparaInforme(ruta, anoMes, idEmisor);
			
							System.out.println("DescargaReporte rutaArchivo=" + rutaArchivo);

			InputStream is = new FileInputStream(new File(crea.rutaGenerada));

			int read = 0;
			byte[] bytes = new byte[BYTES_DOWNLOAD];

			while ((read = is.read(bytes)) != -1) {
				os.write(bytes, 0, read);
			}
			os.flush();
			os.close();
			System.out.println("DescargaReporte termina");
		} catch (Exception e) {
			response.setContentType("text/html");
			System.out.println("DescargaReporte termina excepcion " + e.getMessage());
			response.getOutputStream().println(generaError(e.getMessage()));
		}
	}

	public String generaError(String message) {
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<body>");
		sb.append("<strong>Error al obtener el reporte : <br> </strong>");
		sb.append(message);
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
}
