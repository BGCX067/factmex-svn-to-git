package mx.com.factmex.app.client.grid;

import mx.com.factmex.app.client.RPCService;
import mx.com.factmex.app.client.RPCServiceAsync;
import mx.com.factmex.app.client.to.model.Cliente;
import mx.com.factmex.app.client.to.request.Request;
import mx.com.factmex.app.client.to.response.ListClientesResponse;
import mx.com.factmex.app.client.to.response.Response;
import mx.com.factmex.app.client.window.ClienteWindow;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;  
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ClientesGrid extends ListGrid {
	private final ClientesGrid actualGrid;
	public ClientesGrid(){
		this.setWidth(800);  
		this.setHeight(400);
		actualGrid = this;
		this.setShowAllRecords(true);  
		this.setCanEdit(false);  
		ListGridField idField = new ListGridField("idCliente", "idCliente");
		idField.setHidden(true);
        ListGridField nombreField = new ListGridField("nombre", "Nombre");
        nombreField.setWidth(400);
        ListGridField rfcField = new ListGridField("rfc", "RFC");
        rfcField.setWidth(150);
        ListGridField modificarField = new ListGridField("modificar", " ");
        modificarField.setWidth(25);
       
        ListGridField eliminarField = new ListGridField("eliminar", " ");
        eliminarField.setWidth(25);
       
        this.setShowRecordComponents(true);          
        this.setShowRecordComponentsByCell(true);  
        
        this.setFields(idField, nombreField, rfcField, modificarField, eliminarField);
		this.draw(); 
	}
	
	public void updateData(){
		RPCServiceAsync service = RPCService.Util.getInstance();
		Request request = new Request("ClienteService" , "obtenListadoClientes");
		service.invoke(request, new AsyncCallback<Response>() {
			public void onFailure(Throwable caught) {
				SC.say("Error al obtener los datos de la aplicacion: " + caught.getMessage());
			}

			public void onSuccess(Response response) {
				if(response.isSuccess()){
					ListClientesResponse clientesResponse = (ListClientesResponse)response;
					ListGridRecord records [] = new ListGridRecord[clientesResponse.getClientes().size()];
					int i = 0;
					for(Cliente cliente : clientesResponse.getClientes()){
						ListGridRecord record = new ListGridRecord();
						record.setAttribute("idCliente", cliente.getIdCliente());
						record.setAttribute("nombre", cliente.getNombre());
						record.setAttribute("rfc",cliente.getRfc());
						records[i] = record;
						i++;
					}
					actualGrid.setData(records);
					
				} else {
					SC.warn(response.getMessage());
				}
			}
		});
	}
	@Override  
    protected Canvas createRecordComponent(final ListGridRecord record, Integer colNum) {  

        String fieldName = this.getFieldName(colNum); 
        if (fieldName.equals("modificar")) {
            IButton button = new IButton();  
            button.setIconAlign("CENTER");
            button.setHeight(18);  
            button.setWidth(22);              
            button.setIcon("silk/comment_edit.png");  
            button.addClickHandler(new ClickHandler() {  
                public void onClick(ClickEvent event) {  
                	ClienteWindow clienteWindow = new ClienteWindow("U" , record.getAttribute("idCliente").toString(), record.getAttribute("nombre").toString(), null);
                	clienteWindow.show();
                }  
            });
              
            return button;
            
        	
        } else if (fieldName.equals("eliminar")) {
            IButton button = new IButton();  
            button.setIconAlign("CENTER");
            button.setHeight(18);  
            button.setWidth(22);              
            button.setIcon("silk/delete.png");  
            button.addClickHandler(new ClickHandler() {  
                public void onClick(ClickEvent event) {  
                	SC.ask("¿Deseas eliminar a " + record.getAttribute("nombre") + " ?", new BooleanCallback() {  
	                    public void execute(Boolean value) {  
	                        if (value != null && value) {  
	                        	removeRecord(record);
	                        }
	                    }  
	                });
                }  
            });
              
            return button;
            
        	
        }else {  
            return null;  
        }  

    }  
	public void removeRecord(final ListGridRecord record){
		RPCServiceAsync service = RPCService.Util.getInstance();
		Request request = new Request("ClienteService" , "eliminaCliente");
		request.setSimpleValue(record.getAttribute("idCliente"));
		service.invoke(request, new AsyncCallback<Response>() {
			public void onFailure(Throwable caught) {
				SC.warn("Error al obtener los datos de la aplicacion: " + caught.getMessage());
			}
			
			public void onSuccess(Response response) {
				if(response.isSuccess()){
					actualGrid.removeData(record);
				} else {
					SC.warn(response.getMessage());
				}
			}
		});
	}
}
