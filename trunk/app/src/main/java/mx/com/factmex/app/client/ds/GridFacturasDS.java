package mx.com.factmex.app.client.ds;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;

public class GridFacturasDS extends DataSource {
	public GridFacturasDS() {
		setClientOnly(true); 
		DataSourceField  idComprobante = new DataSourceField("idComprobante", FieldType.TEXT,"Id");
		idComprobante.setPrimaryKey(true);
		idComprobante.setHidden(true);
		
		DataSourceField  folio = new DataSourceField ("folio", FieldType.TEXT,"Folio");
		DataSourceField  fecha = new DataSourceField ("fecha", FieldType.TEXT,"Fecha");
		DataSourceField  facturado = new DataSourceField ("facturado", FieldType.TEXT,"Facturado a");
		DataSourceField  monto = new DataSourceField ("monto", FieldType.TEXT,"Monto");
		
		
		
		setFields(idComprobante, folio, fecha, facturado, monto);
	}
}
