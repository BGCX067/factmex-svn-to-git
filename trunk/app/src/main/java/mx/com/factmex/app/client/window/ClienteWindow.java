package mx.com.factmex.app.client.window;

import mx.com.factmex.app.client.RPCService;
import mx.com.factmex.app.client.RPCServiceAsync;
import mx.com.factmex.app.client.grid.ClientesGrid;
import mx.com.factmex.app.client.to.request.FacturaRequest;
import mx.com.factmex.app.client.to.request.Request;
import mx.com.factmex.app.client.to.response.FacturaResponse;
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

public class ClienteWindow extends Window {
	private ClienteWindow actualWindow;
	private ClientesGrid clientesGrid;
	public TextItem itemNombre;
	public TextItem itemRFC;
	public TextItem itemCalle;
	public TextItem itemNoExt;
	public TextItem itemNoInt;
	public TextItem itemColonia;
	public TextItem itemLocalidad;
	public TextItem itemReferencia;
	public TextItem itemMunicipio;
	public TextItem itemEstado;
	public TextItem itemPais;
	public TextItem itemCP;
	public ClienteWindow(final String operacion, final String idCliente, final String nombre, final ClientesGrid clientesGrid) {
		this.clientesGrid = clientesGrid;
		actualWindow = this;
		final DynamicForm form = new DynamicForm();
		this.setWidth(350);
		this.setHeight(450);
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
        
        itemNombre = new TextItem();
        itemNombre.setName("nombre");
        itemNombre.setTitle("Nombre");
        itemNombre.setRequired(true);        
        
        itemRFC = new TextItem();
        itemRFC.setName("rfc");
        itemRFC.setTitle("RFC");
        itemRFC.setLength(13);
        itemRFC.setRequired(true);
        
        itemCalle = new TextItem();
        itemCalle.setName("calle");
        itemCalle.setTitle("Calle");
        itemCalle.setRequired(true);
        
        itemNoExt = new TextItem();
        itemNoExt.setName("noext");
        itemNoExt.setTitle("No. Exterior");
        
        itemNoInt = new TextItem();
        itemNoInt.setName("noint");
        itemNoInt.setTitle("No. Interior");
        
        itemColonia = new TextItem();
        itemColonia.setName("colonia");
        itemColonia.setTitle("Colonia");
        
        itemLocalidad = new TextItem();
        itemLocalidad.setName("localidad");
        itemLocalidad.setTitle("Localidad");
        
        itemReferencia = new TextItem();
        itemReferencia.setName("referencia");
        itemReferencia.setTitle("Referencia");
        
        itemMunicipio = new TextItem();
        itemMunicipio.setName("municipio");
        itemMunicipio.setTitle("Municipio");
        
        itemEstado = new TextItem();  
        itemEstado.setTitle("Estado");  
        itemEstado.setRequired(true);
        
        itemPais = new TextItem();  
        itemPais.setTitle("Pais");
        itemPais.setRequired(true);
        
        itemCP = new TextItem();
        itemCP.setName("cp");
        itemCP.setTitle("Codigo Postal");
        itemCP.setLength(5);
        
        if(operacion.equals("U")){
    		RPCServiceAsync service = RPCService.Util.getInstance();
    		Request request = new Request("ClienteService" , "obtenCliente");
    		request.setSimpleValue(idCliente + "");
    		service.invoke(request, new AsyncCallback<Response>() {
    			public void onFailure(Throwable caught) {
    				SC.warn("Error al obtener los datos de la aplicacion: " + caught.getMessage());
    			}
    			
    			public void onSuccess(Response response) {
    				if(response.isSuccess()){
    					FacturaResponse facturaResponse = (FacturaResponse) response;
    					itemNombre.setValue(facturaResponse.getRequest().getCliente());
    					itemRFC.setValue(facturaResponse.getRequest().getRfc());
    					itemCalle.setValue(facturaResponse.getRequest().getCalle());
    					itemNoExt.setValue(facturaResponse.getRequest().getNoExt());
    					itemNoInt.setValue(facturaResponse.getRequest().getNoInt());
    					itemColonia.setValue(facturaResponse.getRequest().getColonia());
    					itemLocalidad.setValue(facturaResponse.getRequest().getLocalidad());
    					itemReferencia.setValue(facturaResponse.getRequest().getReferencia());
    					itemMunicipio.setValue(facturaResponse.getRequest().getMunicipio());
    					itemEstado.setValue(facturaResponse.getRequest().getEstado());
    					itemPais.setValue(facturaResponse.getRequest().getPais());
    					itemCP.setValue(facturaResponse.getRequest().getCp());
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
            	if(ConvertUtil.convertIsNull(itemRFC.getValue()).length() < 12 || ConvertUtil.convertIsNull(itemRFC.getValue()).length() > 13){
        			SC.warn("La longitud del RFC debe ser de 12 o 13 caracteres");
        			return;
        		}
                if(form.validate()) {
	                RPCServiceAsync service = RPCService.Util.getInstance();
	        		FacturaRequest request = new FacturaRequest("ClienteService" , "guardarCliente");
	        		if(operacion.equals("U")){
	        			request.setCliente(idCliente + "");
	        			request.setNuevoNombre(ConvertUtil.convertIsNull(itemNombre.getValue()));
        			} else {
        				request.setCliente(ConvertUtil.convertIsNull(itemNombre.getValue()));
	        			request.setNuevoNombre(ConvertUtil.convertIsNull(itemNombre.getValue()));
        			}
	        		request.setCalle(ConvertUtil.convertIsNull(itemCalle.getValue()));
	        		request.setColonia(ConvertUtil.convertIsNull(itemColonia.getValue()));
	        		request.setCp(ConvertUtil.convertIsNull(itemCP.getValue()));
	        		request.setEstado(ConvertUtil.convertIsNull(itemEstado.getValue()));
	        		request.setLocalidad(ConvertUtil.convertIsNull(itemLocalidad.getValue()));
	        		request.setMunicipio(ConvertUtil.convertIsNull(itemMunicipio.getValue()));
	        		request.setNoExt(ConvertUtil.convertIsNull(itemNoExt.getValue()));
	        		request.setNoInt(ConvertUtil.convertIsNull(itemNoInt.getValue()));
	        		request.setPais(ConvertUtil.convertIsNull(itemPais.getValue()));
	        		request.setReferencia(ConvertUtil.convertIsNull(itemReferencia.getValue()));
	        		request.setRfc(ConvertUtil.convertIsNull(itemRFC.getValue()));
	        		service.invoke(request, new AsyncCallback<Response>() {
	        			public void onFailure(Throwable caught) {
	        				SC.warn("Error al obtener los datos de la aplicacion: " + caught.getMessage());
	        			}
	        			
	        			public void onSuccess(Response response) {
	        				if(response.isSuccess()){
	        					if(operacion.equals("I")){
	        						clientesGrid.updateData();
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
        
        
        form.setFields(itemNombre, itemRFC, itemCalle, itemNoExt, itemNoInt, itemColonia, itemLocalidad, itemReferencia, itemMunicipio, itemEstado, itemPais, itemCP);
        
        vLayout.addMember(form);
        
        
        HLayout hLayout = new HLayout();
        
        hLayout.setAlign(Alignment.CENTER);

        hLayout.addMember(okButton);
        hLayout.addMember(cancelButton);
        this.addItem(vLayout);
        this.addItem(hLayout);
	}
}
