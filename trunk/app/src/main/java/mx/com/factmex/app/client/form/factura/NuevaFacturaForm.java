package mx.com.factmex.app.client.form.factura;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.util.BooleanCallback;
import java.util.HashMap;

import mx.com.factmex.app.client.PanelFactory;
import mx.com.factmex.app.client.RPCService;
import mx.com.factmex.app.client.RPCServiceAsync;
import mx.com.factmex.app.client.ShowcasePanel;
import mx.com.factmex.app.client.to.model.Concepto;
import mx.com.factmex.app.client.to.model.Retencion;
import mx.com.factmex.app.client.to.model.Traslado;
import mx.com.factmex.app.client.to.request.FacturaRequest;
import mx.com.factmex.app.client.to.response.Response;
import mx.com.factmex.app.client.util.ConvertUtil;
import mx.com.factmex.app.client.util.ModalWindow;
import mx.com.factmex.app.client.window.DescargarComprobanteWindow;

public class NuevaFacturaForm extends ShowcasePanel {
    private static final String DESCRIPTION = "Escoge el cliente a facturar de la lista, " + 
    		"sino esta en la lista captura su informacion y quedara almacenado para futuras emisiones " + 
    		"si deseas cambiar la informacion del cliente de manera permanente ir al menu CLIENTES " + 
    		"si solo deseas cambiar la informacion para esta factura, editar directamente los datos que desees";
    private static NuevaFacturaForm formActual;
    private static ModalWindow modalWindow; 
    private ClienteFacturaForm clienteForm;
    private ConceptosForm conceptosForm;
    private RetencionesForm retencionesForm;
    private TrasladosForm trasladosForm;
    private IButton btnGenerarFactura;
    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            NuevaFacturaForm panel = new NuevaFacturaForm();
            formActual = panel;
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

        public String getDescription() {
            return DESCRIPTION;
        }
    }

    public Canvas getViewPanel() {
        final ValuesManager vm = new ValuesManager();
        
        final TabSet theTabs = new TabSet();
        theTabs.setWidth(600);
        theTabs.setHeight(500);
        
        Tab item = new Tab();
        item.setTitle("Cliente");
        
        clienteForm = new ClienteFacturaForm();
        clienteForm.setID("form0");
        clienteForm.setValuesManager(vm);
        
        item.setPane(clienteForm);

        Tab conceptos = new Tab();
        conceptos.setTitle("Conceptos");
        conceptosForm = new ConceptosForm();
        conceptos.setPane(conceptosForm);
        
        Tab retenciones= new Tab();
        retenciones.setTitle("Retenciones");
        retencionesForm = new RetencionesForm();
        retenciones.setPane(retencionesForm);
        
        Tab traslados= new Tab();
        traslados.setTitle("Traslados");
        trasladosForm = new TrasladosForm();
        traslados.setPane(trasladosForm);
        
        theTabs.setTabs(item, conceptos, retenciones, traslados);
        
        btnGenerarFactura = new IButton();
        btnGenerarFactura.setTitle("Generar Factura");
        
        btnGenerarFactura.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				vm.validate();
				if (clienteForm.hasErrors()) {
					theTabs.selectTab(0);
				} else {
					
					if((conceptosForm.conceptosGrid.getDataAsRecordList().toArray().length <= 0 || trasladosForm.trasladosGrid.getDataAsRecordList().toArray().length <= 0) && !ConvertUtil.convertIsNull(clienteForm.itemRFC.getValue()).equals("XAXX010101000")){ 
						SC.warn("No es posible generar la factura, no hay conceptos o traslados capturados");
						return;
					} else {
						generaFactura();
					}
					
				}
				
			}
        });
        
        VLayout vLayout = new VLayout();
        vLayout.setMembersMargin(10);
        vLayout.addMember(theTabs);
        vLayout.addMember(btnGenerarFactura);

        vm.setValues(new HashMap<String,String>() {{
            put("price", "low");
            put("nextShipment", "256");
        }});
        return vLayout;
    }
    public void generaFactura() {
    	final RPCServiceAsync service = RPCService.Util.getInstance();
		final FacturaRequest request = new FacturaRequest("FacturaService" , "generaFactura");
		request.setCliente(ConvertUtil.convertIsNull(clienteForm.cbCliente.getValue()));
		request.setCalle(ConvertUtil.convertIsNull(clienteForm.itemCalle.getValue()));
		request.setColonia(ConvertUtil.convertIsNull(clienteForm.itemColonia.getValue()));
		request.setCp(ConvertUtil.convertIsNull(clienteForm.itemCP.getValue()));
		request.setEstado(ConvertUtil.convertIsNull(clienteForm.itemEstado.getValue()));
		request.setLocalidad(ConvertUtil.convertIsNull(clienteForm.itemLocalidad.getValue()));
		request.setMunicipio(ConvertUtil.convertIsNull(clienteForm.itemMunicipio.getValue()));
		request.setNoExt(ConvertUtil.convertIsNull(clienteForm.itemNoExt.getValue()));
		request.setNoInt(ConvertUtil.convertIsNull(clienteForm.itemNoInt.getValue()));
		request.setPais(ConvertUtil.convertIsNull(clienteForm.itemPais.getValue()));
		request.setReferencia(ConvertUtil.convertIsNull(clienteForm.itemReferencia.getValue()));
		request.setRfc(ConvertUtil.convertIsNull(clienteForm.itemRFC.getValue()));
		if(ConvertUtil.convertIsNull(clienteForm.itemRFC.getValue()).length() < 12 || ConvertUtil.convertIsNull(clienteForm.itemRFC.getValue()).length() > 13){
			SC.warn("La longitud del RFC debe ser de 12 o 13 caracteres");
			return;
		}
		request.setIdSerie(ConvertUtil.convertIsNull(clienteForm.cboSerie.getValue()));
		Record [] conceptosRecord = conceptosForm.conceptosGrid.getDataAsRecordList().toArray();
		for(Record conceptoRecord : conceptosRecord){
			Concepto concepto = new Concepto();
			concepto.setCantidad(conceptoRecord.getAttribute("cantidad"));
			concepto.setDescripcion(conceptoRecord.getAttribute("descripcion"));
			concepto.setImporte(conceptoRecord.getAttribute("importe").replaceAll("$", ""));
			concepto.setUnidad(conceptoRecord.getAttribute("unidad"));
			concepto.setValorUnitario(conceptoRecord.getAttribute("valorunitario").replaceAll("$", ""));
			request.addConcepto(concepto);
		}
		
		Record [] retencionesRecord = retencionesForm.retencionesGrid.getDataAsRecordList().toArray();
		for(Record retencionRecord : retencionesRecord){
			Retencion retencion = new Retencion();
			//retencion.setImporte(retencionRecord.getAttribute("importe").replaceAll("$", ""));
			retencion.setImpuesto(retencionRecord.getAttribute("impuesto"));
			retencion.setTasa(retencionRecord.getAttribute("tasa").replaceAll("$", ""));
			request.addRetencion(retencion);
		}
		
		Record [] trasladosRecord = trasladosForm.trasladosGrid.getDataAsRecordList().toArray();
		for(Record trasladoRecord : trasladosRecord){
			Traslado traslado = new Traslado();
			//traslado.setImporte(trasladoRecord.getAttribute("importe").replaceAll("$", ""));
			traslado.setImpuesto(trasladoRecord.getAttribute("impuesto"));
			traslado.setTasa(trasladoRecord.getAttribute("tasa").replaceAll("$", ""));
			request.addTraslado(traslado);
		}
		btnGenerarFactura.setDisabled(true);
		
		SC.ask("Vista preliminar: ¿Generar Factura?",  
			      "<strong>Importe: </strong> $" + ConvertUtil.redondear(request.getSubtotal(),6) + " <br><hr/><br>"
			    + "<strong>IVA Retenido: </strong> $" + ConvertUtil.redondear(request.getRetencionIVA(),6) + " <br>"
			    + "<strong>ISR Retenido: </strong> $" + ConvertUtil.redondear(request.getRetencionISR(),6) + " <br><hr/><br>"
			    + "<strong>IVA Trasladado: </strong> $" + ConvertUtil.redondear(request.getTrasladoIVA(),6) + " <br>"
			    + "<strong>IEPS Trasladado: </strong> $" + ConvertUtil.redondear(request.getTrasladoIEPS(),6) + " <br><hr/><br>"
			    + "<strong>Total: </strong> $" + ConvertUtil.redondear(request.getTotal(),6), new BooleanCallback() {  
            public void execute(Boolean value) {  
                if (value != null && value) {  
                	service.invoke(request, new AsyncCallback<Response>() {
            			public void onFailure(Throwable caught) {
            				modalWindow.hide();
            				SC.say("Error al obtener los datos de la aplicacion: " + caught.getMessage());
            			}

            			public void onSuccess(Response response) {
            				modalWindow.hide();
            				if(response.isSuccess()){
            					//SC.say(GWT.getModuleBaseURL());
            					btnGenerarFactura.setDisabled(true);
            					DescargarComprobanteWindow descargaWindow = new DescargarComprobanteWindow(new Integer(response.getSimpleValue()));
            					descargaWindow.show();
            					
            				} else {
            					SC.warn(response.getMessage());
            					btnGenerarFactura.setDisabled(false);
            				}
            			}
            		});
                	modalWindow = new ModalWindow(formActual);
                	modalWindow.show("Emitiendo factura", true);
                	
                } else {
                	btnGenerarFactura.setDisabled(false);
                }
            }  
        });
		
    	
    }
    public String getIntro() {
        return DESCRIPTION;
    }

}