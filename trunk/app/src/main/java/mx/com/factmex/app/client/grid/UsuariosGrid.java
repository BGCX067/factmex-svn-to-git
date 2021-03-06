package mx.com.factmex.app.client.grid;

import mx.com.factmex.app.client.RPCService;
import mx.com.factmex.app.client.RPCServiceAsync;
import mx.com.factmex.app.client.ds.GridFacturasDS;
import mx.com.factmex.app.client.to.model.Factura;
import mx.com.factmex.app.client.to.request.Request;
import mx.com.factmex.app.client.to.response.ListFacturasResponse;
import mx.com.factmex.app.client.to.response.Response;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;  
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class UsuariosGrid extends ListGrid {
	public final GridFacturasDS gridFacturasEnviadasDS = new GridFacturasDS();
	private final UsuariosGrid actualGrid;
	public UsuariosGrid(String estatus){
		this.setWidth(800);  
		this.setHeight(400);
		actualGrid = this;
		this.setShowAllRecords(true);  
		this.setDataSource(gridFacturasEnviadasDS);  
		this.setAutoFetchData(true);  
		this.setCanEdit(true);  
		RPCServiceAsync service = RPCService.Util.getInstance();
		Request request = new Request("FacturaService" , "obtenListadoFacturas");
		request.setSimpleValue(estatus);
		service.invoke(request, new AsyncCallback<Response>() {
			public void onFailure(Throwable caught) {
				SC.say("Error al obtener los datos de la aplicacion: " + caught.getMessage());
			}

			public void onSuccess(Response response) {
				if(response.isSuccess()){
					ListFacturasResponse facturasResponse = (ListFacturasResponse)response;
					ListGridRecord records [] = new ListGridRecord[facturasResponse.getFacturas().size()];
					int i = 0;
					for(Factura factura : facturasResponse.getFacturas()){
						ListGridRecord record = new ListGridRecord();
						record.setAttribute("idComprobante", factura.getIdComprobante());
						record.setAttribute("folio", factura.getFolio());
						record.setAttribute("fecha", factura.getFecha());
						record.setAttribute("nombre", factura.getFacturado());
						record.setAttribute("monto", factura.getMonto());
						records[i] = record;
						i++;
					}
					actualGrid.setData(records);
					
				} else {
					SC.warn(response.getMessage());
				}
			}
		});
		ListGridField idField = new ListGridField("idComprobante", "idComprobante");  
		idField.setHidden(true);
        ListGridField folioField = new ListGridField("folio", "Folio");
        folioField.setWidth(50);
        ListGridField fechaField = new ListGridField("fecha", "Fecha");
        fechaField.setWidth(150);
        ListGridField facturadoField = new ListGridField("nombre", "Nombre");  
        facturadoField.setWidth(400);
        ListGridField montoField = new ListGridField("monto", "Monto $");  
        montoField.setWidth(80);
        ListGridField xmlField = new ListGridField("xml", "XML");
        xmlField.setWidth(50);
        xmlField.setAlign(Alignment.CENTER);
        ListGridField pdfField = new ListGridField("pdf", "PDF");
        pdfField.setWidth(50);
        pdfField.setAlign(Alignment.CENTER);
        this.setShowRecordComponents(true);          
        this.setShowRecordComponentsByCell(true);  
        
        this.setFields(idField, folioField, fechaField, facturadoField, montoField, xmlField, pdfField);
		this.draw(); 
	}
	
	@Override  
    protected Canvas createRecordComponent(final ListGridRecord record, Integer colNum) {  

        String fieldName = this.getFieldName(colNum); 
        if (fieldName.equals("xml")) {
            IButton button = new IButton();  
            
            button.setHeight(18);  
            button.setWidth(50);                 
            button.setIconAlign("CENTER");
            button.setIcon("icons/16/xml.png");  
            button.addClickHandler(new ClickHandler() {  
                public void onClick(ClickEvent event) {  
                	com.google.gwt.user.client.Window.open(GWT.getModuleBaseURL() + "descargaFactura?tipo=xml&idComprobante=" + record.getAttribute("idComprobante"), "_self", "");
                }  
            });
              
            return button;
            
        	
        } else if (fieldName.equals("pdf")) {
            IButton button = new IButton();  
            
            button.setHeight(18);  
            button.setWidth(50);       
            button.setIconAlign("CENTER");
            button.setIcon("icons/16/pdf.png");   
            button.addClickHandler(new ClickHandler() {  
                public void onClick(ClickEvent event) {  
                	com.google.gwt.user.client.Window.open(GWT.getModuleBaseURL() + "descargaFactura?tipo=pdf&idComprobante=" + record.getAttribute("idComprobante"), "_self", "");
                }  
            });
              
            return button;
            
        	
        } else {  
            return null;  
        }  

    }  

}
