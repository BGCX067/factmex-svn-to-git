package mx.com.factmex.app.client.ds;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CboEmisoresDS extends DataSource {
	public CboEmisoresDS() {
		setID("cboEmisoresDS"+ System.currentTimeMillis());
		setClientOnly(true); 
		DataSourceTextField idEmisor = new DataSourceTextField("idEmisor", "Id");
		idEmisor.setPrimaryKey(true);
		idEmisor.setHidden(true);
		DataSourceTextField nombre = new DataSourceTextField("nombre", "Nombre");
		setFields(idEmisor, nombre);
	}
}
