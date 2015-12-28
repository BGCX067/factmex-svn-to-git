package mx.com.factmex.app.client.ds;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CboClientesDS extends DataSource {

	public CboClientesDS() {
		setClientOnly(true); 
		DataSourceTextField idCliente = new DataSourceTextField("idCliente", "Id");
		idCliente.setPrimaryKey(true);
		idCliente.setHidden(true);
		DataSourceTextField nombre = new DataSourceTextField("nombre", "Nombre");
		setFields(idCliente, nombre);
	}
}
