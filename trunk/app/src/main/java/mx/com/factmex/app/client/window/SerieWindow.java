package mx.com.factmex.app.client.window;

import mx.com.factmex.app.client.RPCService;
import mx.com.factmex.app.client.RPCServiceAsync;
import mx.com.factmex.app.client.grid.ClientesGrid;
import mx.com.factmex.app.client.grid.SeriesGrid;
import mx.com.factmex.app.client.to.model.Serie;
import mx.com.factmex.app.client.to.request.FacturaRequest;
import mx.com.factmex.app.client.to.request.Request;
import mx.com.factmex.app.client.to.request.SerieRequest;
import mx.com.factmex.app.client.to.response.FacturaResponse;
import mx.com.factmex.app.client.to.response.ListSeriesResponse;
import mx.com.factmex.app.client.to.response.Response;
import mx.com.factmex.app.client.util.ConvertUtil;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class SerieWindow extends Window {
	private SerieWindow actualWindow;
	private SeriesGrid seriesGrid;
	public TextItem itemSerie;
	public TextItem itemFolioInicial;
	public TextItem itemFolioFinal;
	public TextItem itemAnioAprobacion;
	public TextItem itemNoAprobacion;
	
	public SerieWindow(final String operacion, final String idSerie, final String nombre, final SeriesGrid seriesGrid) {
		this.seriesGrid = seriesGrid;
		actualWindow = this;
		final DynamicForm form = new DynamicForm();
		this.setWidth(350);
		this.setHeight(250);
		this.setShowModalMask(true);
		this.setShowMinimizeButton(false);
		this.setIsModal(true);  
		this.centerInPage();
		this.setTitle(nombre);
		
		VLayout vLayout = new VLayout();
		vLayout.setAlign(VerticalAlignment.CENTER);
		vLayout.setAlign(Alignment.CENTER);
        vLayout.setMembersMargin(20);
        vLayout.setEdgeImage("edges/custom/sharpframe_10_B.png"); 
        vLayout.setLayoutMargin(10);
        vLayout.setPageTop(10);
        
        itemSerie = new TextItem();
        itemSerie.setName("serie");
        itemSerie.setTitle("Serie");
        itemSerie.setRequired(true);        
        
        itemFolioInicial = new TextItem();
        itemFolioInicial.setName("folioInicial");
        itemFolioInicial.setTitle("Folio Inicial");
        itemFolioInicial.setKeyPressFilter("[0-9.]");   
        itemFolioInicial.setRequired(true);
        
        itemFolioFinal = new TextItem();
        itemFolioFinal.setName("folioFinal");
        itemFolioFinal.setTitle("Folio Final");
        itemFolioFinal.setKeyPressFilter("[0-9.]");
        itemFolioFinal.setRequired(true);
        
        itemAnioAprobacion = new TextItem();
        itemAnioAprobacion.setName("anioAprobacion");
        itemAnioAprobacion.setTitle("Anio aprobacion");
        itemAnioAprobacion.setKeyPressFilter("[0-9.]");
        itemAnioAprobacion.setRequired(true);
        
        itemNoAprobacion = new TextItem();
        itemNoAprobacion.setName("noAprobacion");
        itemNoAprobacion.setTitle("No. aprobacion");
        itemNoAprobacion.setKeyPressFilter("[0-9.]");
        itemNoAprobacion.setRequired(true);
        
        
        
        if(operacion.equals("U")){
    		RPCServiceAsync service = RPCService.Util.getInstance();
    		Request request = new Request("SerieService" , "obtenSerie");
    		request.setSimpleValue(idSerie + "");
    		service.invoke(request, new AsyncCallback<Response>() {
    			public void onFailure(Throwable caught) {
    				SC.warn("Error al obtener los datos de la aplicacion: " + caught.getMessage());
    			}
    			
    			public void onSuccess(Response response) {
    				if(response.isSuccess()){
    					ListSeriesResponse seriesResponse = (ListSeriesResponse) response;
    					if(seriesResponse.getSeries().size() >= 0){
    						Serie serie = seriesResponse.getSeries().get(0);
	    					itemSerie.setValue(serie.getSerie());
	    					itemFolioInicial.setValue(serie.getFolioInicial());
	    					itemFolioFinal.setValue(serie.getFolioFinal());
	    					itemAnioAprobacion.setValue(serie.getAnioAprobacion());
	    					itemNoAprobacion.setValue(serie.getNoAprobacion());
    					}
    				} else {
    					SC.warn(response.getMessage());
    				}
    			}
    		});
        }
        
        IButton okButton = new IButton();  
        okButton.setTitle("Guardar");  
        okButton.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {  
            	
                if(form.validate()) {
	                RPCServiceAsync service = RPCService.Util.getInstance();
	                SerieRequest request = new SerieRequest("SerieService" , "guardarSerie");
	                request.setSimpleValue(operacion);
	        		if(operacion.equals("U")){
	        			request.getSerie().setIdSerie(idSerie);
	        			
        			}
	        		request.getSerie().setFolioFinal(ConvertUtil.convertIsNull(itemFolioFinal.getValue()));
	        		request.getSerie().setAnioAprobacion(ConvertUtil.convertIsNull(itemAnioAprobacion.getValue()));
	        		request.getSerie().setSerie(ConvertUtil.convertIsNull(itemSerie.getValue()));
	        		request.getSerie().setNoAprobacion(ConvertUtil.convertIsNull(itemNoAprobacion.getValue()));
	        		request.getSerie().setFolioInicial(ConvertUtil.convertIsNull(itemFolioInicial.getValue()));
	        		
	        		service.invoke(request, new AsyncCallback<Response>() {
	        			public void onFailure(Throwable caught) {
	        				SC.warn("Error al obtener los datos de la aplicacion: " + caught.getMessage());
	        			}
	        			
	        			public void onSuccess(Response response) {
	        				if(response.isSuccess()){
	        					if(operacion.equals("I")){
	        						seriesGrid.updateData();
	        					}
	        					actualWindow.destroy();
	        				} else {
	        					SC.warn(response.getMessage());
	        				}
	        			}
	        		});
               }
            }  
        });
        
        IButton cancelButton = new IButton();  
        cancelButton.setTitle("Cancelar");  
        cancelButton.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {  
            	actualWindow.destroy();
            }  
        });
        
        
        form.setFields(itemSerie, itemFolioInicial, itemFolioFinal, itemAnioAprobacion, itemNoAprobacion);
        
        vLayout.addMember(form);
        
        
        HLayout hLayout = new HLayout();
        
        hLayout.setAlign(Alignment.CENTER);

        hLayout.addMember(okButton);
        hLayout.addMember(cancelButton);
        this.addItem(vLayout);
        this.addItem(hLayout);
	}
}
