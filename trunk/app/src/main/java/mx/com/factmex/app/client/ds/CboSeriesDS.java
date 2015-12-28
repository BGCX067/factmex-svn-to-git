package mx.com.factmex.app.client.ds;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CboSeriesDS extends DataSource {

	public CboSeriesDS() {
		setClientOnly(true); 
		DataSourceTextField idSerie = new DataSourceTextField("idSerie", "Id");
		idSerie.setPrimaryKey(true);
		idSerie.setHidden(true);
		DataSourceTextField serie = new DataSourceTextField("serie", "Serie");
		setFields(idSerie, serie);
	}
}
