package mx.com.factmex.app.server.services.factura;

public enum ParametrosEnum {
	RUTA_PDF_FACTURAS("RUTA_PDF_FACTURAS"),
	RUTA_IMAGEN_FACTURA("RUTA_IMAGEN_FACTURA"),
	RUTA_COORDENADAS_FACTURA("RUTA_COORDENADAS_FACTURA"),
	RUTA_XML_FACTURAS("RUTA_XML_FACTURAS"),
	RUTA_KEY_SELLO("RUTA_KEY_SELLO"),
	PASSWORD_KEY_SELLO("PASSWORD_KEY_SELLO"),
	RUTA_CER_SELLO("RUTA_CER_SELLO"),
	RUTA_REPORTE_MENSUAL("RUTA_REPORTE_MENSUAL");
	
	private String param;
	private ParametrosEnum(String param){
		this.param = param;
	}
	
	public String getParam(){
		return param;
	}
}
