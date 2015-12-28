package mx.com.factmex.app.server.services.factura;

import java.sql.SQLException;

import mx.com.factmex.app.server.services.rpc.FacturaService;

import org.junit.Test;

public class LIBTest {

	@Test
	public void testCreaPDF() throws Exception {
		 String imagen  = FacturaService.getParameterString("1",ParametrosEnum.RUTA_IMAGEN_FACTURA.getParam());
	     String coordenadas  = FacturaService.getParameterString("1",ParametrosEnum.RUTA_COORDENADAS_FACTURA.getParam());
	     String pdfPath = FacturaService.getParameterString("1",ParametrosEnum.RUTA_PDF_FACTURAS.getParam());
	         System.out.println("generaFactura: " + imagen);
	     LIB cfdLibrary = new LIB();
	     cfdLibrary.CreaPDF("C:\\factmex\\xml\\AAA010101AAA\\1288571308833.xml", imagen, "C:\\factmex\\xml\\AAA010101AAA\\1288571308833.pdf", "Mexico", coordenadas);
	
	}

}
