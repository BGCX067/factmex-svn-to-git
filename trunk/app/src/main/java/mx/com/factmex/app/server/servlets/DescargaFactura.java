package mx.com.factmex.app.server.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.factmex.app.client.to.Session;
import mx.com.factmex.app.server.services.factura.ParametrosEnum;
import mx.com.factmex.app.server.services.rpc.FacturaService;
import mx.com.factmex.app.server.sqlmaps.dao.DAOManager;
import mx.com.factmex.app.server.sqlmaps.model.TComprobante;

public class DescargaFactura extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int BYTES_DOWNLOAD = 1024;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		OutputStream os = response.getOutputStream();
		try {
			String idComprobante = request.getParameter("idComprobante");
			String tipo = request.getParameter("tipo");
			System.out
					.println("DescargaFactura idComprobante=" + idComprobante);
			System.out.println("DescargaFactura tipo=" + tipo);

			if (idComprobante == null || tipo == null) {
				throw new Exception("No se encuentra la factura "
						+ idComprobante + " con formato " + tipo);
			}

			TComprobante tComprobante = DAOManager.getInstance()
					.getTComprobanteDAO().selectByPrimaryKey(idComprobante);
			String nombreArchivo = tComprobante.getNombreArchivoXml();
			String idEmisor = request.getSession()
					.getAttribute(Session.Property.IDEMISOR.getName())
					.toString();
			System.out.println("DescargaFactura idEmisor=" + idEmisor);
			String rutaArchivo = "";

			if (tipo.equals("xml")) {
				rutaArchivo = FacturaService.getParameterString(idEmisor,
						ParametrosEnum.RUTA_XML_FACTURAS.getParam()) + tComprobante.getAnio() + "-" + tComprobante.getMes() + "\\"  ;
				System.out.println("Ruta descarga " + rutaArchivo);
				nombreArchivo = nombreArchivo + ".xml";
				response.setContentType("text/xml");
				response.setHeader("Content-Disposition",
						"attachment;filename=" + nombreArchivo);
			} else if (tipo.equals("pdf")) {
				rutaArchivo = FacturaService.getParameterString(idEmisor,
						ParametrosEnum.RUTA_PDF_FACTURAS.getParam()) + tComprobante.getAnio() + "-" + tComprobante.getMes() + "\\";
				System.out.println("Ruta descarga " + rutaArchivo);
				nombreArchivo = nombreArchivo + ".pdf";
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition",
						"attachment;filename=" + nombreArchivo);
			}

			rutaArchivo += nombreArchivo;
			System.out.println("DescargaFactura rutaArchivo=" + rutaArchivo);

			InputStream is = new FileInputStream(new File(rutaArchivo));

			int read = 0;
			byte[] bytes = new byte[BYTES_DOWNLOAD];

			while ((read = is.read(bytes)) != -1) {
				os.write(bytes, 0, read);
			}
			os.flush();
			os.close();
			System.out.println("DescargaFactura termina");
		} catch (Exception e) {
			response.setContentType("text/html");
			System.out.println("DescargaFactura termina excepcion " + e.getMessage());
			response.getOutputStream().println(generaError(e.getMessage()));
		}
	}

	public String generaError(String message) {
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<body>");
		sb.append("<strong>Error al obtener el comprobante : <br> </strong>");
		sb.append(message);
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
}
