package mx.com.factmex.app.client.to;

import java.io.Serializable;
import java.util.HashMap;

public class Session implements Serializable{
	private final long serialVersionUID = 3858533948678595581L;
	private HashMap<String, String> data = new HashMap<String, String>();
	public HashMap<String, String> getData() {
		return data;
	}
	public void setData(HashMap<String, String> data) {
		this.data = data;
	}
	public String getProperty(String key){
		return data.get(key);
	}
	public void setProperty(String key, String value){
		data.put(key, value);
	}
	
	public enum Property{
		RAZONSOCIAL("RAZON_SOCIAL"),
		USUARIO("USUARIO"),
		IDPERFIL("ID_PERFIL"),
		IDEMISOR("ID_EMISOR"),
		PERFIL("PERFIL"),
		RFC("RFC"),
		CALLE_FISCAL("CALLE_FISCAL"),
		NOEXT_FISCAL("NOEXT_FISCAL"),
		NOINT_FISCAL("NOINT_FISCAL"),
		REFERENCIA_FISCAL("REFERENCIA_FISCAL"),
		REGION_FISCAL("REGION_FISCAL"),
		COLONIA_FISCAL("COLONIA_FISCAL"),
		LOCALIDAD_FISCAL("LOCALIDAD_FISCAL"),
		MUNICIPIO_FISCAL("MUNICIPIO_FISCAL"),
		CODIGO_POSTAL("CODIGO_POSTAL");
		
		
		private String name;
		Property(String s){
			this.name = s;
		}
		public String getName() {
			return this.name;
		}
	}
}
