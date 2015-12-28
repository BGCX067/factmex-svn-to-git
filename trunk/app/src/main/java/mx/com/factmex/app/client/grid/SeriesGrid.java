package mx.com.factmex.app.client.grid;

import mx.com.factmex.app.client.RPCService;
import mx.com.factmex.app.client.RPCServiceAsync;
import mx.com.factmex.app.client.ShowcasePanel;
import mx.com.factmex.app.client.to.model.Cliente;
import mx.com.factmex.app.client.to.model.Serie;
import mx.com.factmex.app.client.to.request.Request;
import mx.com.factmex.app.client.to.response.ListClientesResponse;
import mx.com.factmex.app.client.to.response.ListSeriesResponse;
import mx.com.factmex.app.client.to.response.Response;
import mx.com.factmex.app.client.util.ModalWindow;
import mx.com.factmex.app.client.window.ClienteWindow;
import mx.com.factmex.app.client.window.SerieWindow;

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

public class SeriesGrid extends ListGrid {
	private final SeriesGrid actualGrid;
	private ModalWindow modalWindow; 
	private ShowcasePanel form;
	public SeriesGrid(ShowcasePanel form){
		this.form = form;
		this.setWidth(800);  
		this.setHeight(400);
		actualGrid = this;
		this.setShowAllRecords(true);  
		this.setCanEdit(false);  
		ListGridField idSerie = new ListGridField("idSerie", "idSerie");
		idSerie.setHidden(true);
        ListGridField serie = new ListGridField("serie", "Serie");
        serie.setWidth(100);
        ListGridField folioInicial = new ListGridField("folioInicial", "Folio Inicial");
        folioInicial.setWidth(100);
        ListGridField folioFinal = new ListGridField("folioFinal", "Folio Final");
        folioFinal.setWidth(100);
        ListGridField anioAprobacion = new ListGridField("anioAprobacion", "Anio Aprobacion");
        anioAprobacion.setWidth(100);
        ListGridField noAprobacion = new ListGridField("noAprobacion", "No. Aprobacion");
        noAprobacion.setWidth(100);
        ListGridField modificarField = new ListGridField("modificar", " ");
        modificarField.setWidth(25);
       
        ListGridField eliminarField = new ListGridField("eliminar", " ");
        eliminarField.setWidth(25);
       
        this.setShowRecordComponents(true);          
        this.setShowRecordComponentsByCell(true);  
        
        this.setFields(idSerie, serie, folioInicial, folioFinal, anioAprobacion, noAprobacion, modificarField, eliminarField);
		this.draw(); 
	}
	
	public void updateData(){
		RPCServiceAsync service = RPCService.Util.getInstance();
		Request request = new Request("SerieService" , "obtenListadoSeries");
		service.invoke(request, new AsyncCallback<Response>() {
			public void onFailure(Throwable caught) {
				SC.say("Error al obtener los datos de la aplicacion: " + caught.getMessage());
			}

			public void onSuccess(Response response) {
				if(response.isSuccess()){
					ListSeriesResponse seriesResponse = (ListSeriesResponse)response;
					ListGridRecord records [] = new ListGridRecord[seriesResponse.getSeries().size()];
					int i = 0;
					for(Serie serie : seriesResponse.getSeries()){
						ListGridRecord record = new ListGridRecord();
						record.setAttribute("idSerie", serie.getIdSerie());
						record.setAttribute("serie", serie.getSerie());
						record.setAttribute("folioInicial",serie.getFolioInicial());
						record.setAttribute("folioFinal",serie.getFolioFinal());
						record.setAttribute("anioAprobacion",serie.getAnioAprobacion());
						record.setAttribute("noAprobacion",serie.getNoAprobacion());
						records[i] = record;
						i++;
					}
					actualGrid.setData(records);
					
				} else {
					SC.warn(response.getMessage());
				}
				modalWindow.hide();
			}
		});
		modalWindow = new ModalWindow(form);
    	modalWindow.show("Consultando series", true);
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
                	SerieWindow serieWindow = new SerieWindow("U" , record.getAttribute("idSerie").toString(), record.getAttribute("serie").toString(), null);
                	serieWindow.show();
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
                	SC.ask("¿Deseas eliminar la serie " + record.getAttribute("serie") + " ?", new BooleanCallback() {  
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
		Request request = new Request("SerieService" , "eliminaSerie");
		request.setSimpleValue(record.getAttribute("idSerie"));
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
