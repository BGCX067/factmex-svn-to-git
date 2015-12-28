package mx.com.factmex.app.client.form.factura;

import java.util.LinkedHashMap;

import mx.com.factmex.app.client.RPCService;
import mx.com.factmex.app.client.RPCServiceAsync;
import mx.com.factmex.app.client.ds.CboClientesDS;
import mx.com.factmex.app.client.ds.CboSeriesDS;
import mx.com.factmex.app.client.to.request.FacturaRequest;
import mx.com.factmex.app.client.to.request.Request;
import mx.com.factmex.app.client.to.response.FacturaResponse;
import mx.com.factmex.app.client.to.response.Response;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ClienteFacturaForm extends DynamicForm {
	public ComboBoxItem cboSerie;
	public ComboBoxItem cboTipoPago;
	public ComboBoxItem cbCliente;
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
	
	public TextItem itemParcialidad;
	public TextItem itemTotalParcialidades;
	
	public ClienteFacturaForm(){
		cbCliente = new ComboBoxItem();  
		final CboClientesDS cboClientesDS = new CboClientesDS();
		cbCliente.setTitle("Nombre");  
		cbCliente.setHint("<nobr>selecciona el cliente a facturar</nobr>");  
		cbCliente.setType("comboBox");
		cbCliente.setWidth(300);
		cbCliente.setOptionDataSource(cboClientesDS);
		cbCliente.setValueField("idCliente");
		cbCliente.setDisplayField("nombre");
		cbCliente.setRequired(true);
        
		cbCliente.addChangedHandler(new ChangedHandler() {
            public void onChanged(ChangedEvent event) {
            	try {
            		//Si se trata de un cliente seleccionado del combo, es un valor entero
            		//por lo tanto se consultara la informacion del cliente en B.D.
                	Integer idCliente = new Integer(event.getValue().toString());
                	RPCServiceAsync service = RPCService.Util.getInstance();
            		Request request = new Request("ClienteService" , "obtenCliente");
            		request.setSimpleValue(idCliente.toString());
            		service.invoke(request, new AsyncCallback<Response>() {
            			public void onFailure(Throwable caught) {
            				SC.say("Error al obtener los datos de la aplicacion: " + caught.getMessage());
            			}

            			public void onSuccess(Response response) {
            				if(!response.isSuccess()){
            					SC.warn(response.getMessage());
            				} else {
            					FacturaResponse facturaResponse = (FacturaResponse) response;
            					FacturaRequest facturaRequest = facturaResponse.getRequest();
            					itemRFC.setValue(facturaRequest.getRfc());
            					itemCalle.setValue(facturaRequest.getCalle());
            					itemNoExt.setValue(facturaRequest.getNoExt());
            					itemNoInt.setValue(facturaRequest.getNoInt());
            					itemColonia.setValue(facturaRequest.getColonia());
            					itemLocalidad.setValue(facturaRequest.getLocalidad());
            					itemMunicipio.setValue(facturaRequest.getMunicipio());
            					itemEstado.setValue(facturaRequest.getEstado());
            					itemPais.setValue(facturaRequest.getPais());
            					itemCP.setValue(facturaRequest.getCp());
            				}
            			}
            		});
            	} catch (Exception e){
            		
            		
            	}
            }
        });
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
        itemMunicipio.setRequired(true);
        
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
        itemCP.setRequired(true);
        
        cboSerie = new ComboBoxItem();  
		final CboSeriesDS cboSerieDS = new CboSeriesDS();
        cboSerie.setTitle("Serie");  
        cboSerie.setType("comboBox");
        cboSerie.setWidth(50);
        cboSerie.setOptionDataSource(cboSerieDS);
        cboSerie.setValueField("idSerie");
        cboSerie.setDisplayField("serie");
        cboSerie.setRequired(true);
        
        
        cboTipoPago= new ComboBoxItem();
        cboTipoPago.setTitle("Tipo de Pago");
        cboTipoPago.setType("comboBox");
		LinkedHashMap<String, String> valores = new LinkedHashMap<String, String>();
		valores.put("1", "Pago de contado");
		valores.put("0", "Pago con parcialidades");
		cboTipoPago.setValueMap(valores);
		cboTipoPago.setRequired(true);
        cboTipoPago.addChangedHandler(new ChangedHandler() {
            public void onChanged(ChangedEvent event) {
            	Integer idTipoPago = new Integer(event.getValue().toString());
            	if(idTipoPago == 0){
            		itemParcialidad.setDisabled(true);
            		itemTotalParcialidades.setDisabled(true);
            	} else {
            		itemParcialidad.setDisabled(false);
            		itemTotalParcialidades.setDisabled(false);
            	}
            }
        });
		
        
        itemParcialidad = new TextItem(); 
        itemParcialidad.setWidth(50);
        itemParcialidad.setDisabled(true);
        itemParcialidad.setTitle("Parcialidad");
        
        
        itemTotalParcialidades = new TextItem();
        itemTotalParcialidades.setWidth(50);
        itemTotalParcialidades.setDisabled(true);
        itemTotalParcialidades.setTitle("de");
        
		
        RPCServiceAsync service = RPCService.Util.getInstance();
		service.invoke(new Request("ClienteService" , "obtenClientesEmisorActual"), new AsyncCallback<Response>() {
			public void onFailure(Throwable caught) {
				SC.say("Error al obtener los datos de la aplicacion: " + caught.getMessage());
			}

			public void onSuccess(Response response) {
				if(response.getData() != null){
					for(String [] data : response.getData()){
						ListGridRecord record = new ListGridRecord();
						record.setAttribute("idCliente", data[0]);
						record.setAttribute("nombre", data[1]);
						cboClientesDS.addData(record);
					}
				}
			}
		});
		
		service = RPCService.Util.getInstance();
		service.invoke(new Request("SerieService" , "obtieneSeries"), new AsyncCallback<Response>() {
			public void onFailure(Throwable caught) {
				SC.say("Error al obtener los datos de la aplicacion: " + caught.getMessage());
			}

			public void onSuccess(Response response) {
				if(response.getData() != null){
					for(String [] data : response.getData()){
						ListGridRecord record = new ListGridRecord();
						record.setAttribute("idSerie", data[0]);
						record.setAttribute("serie", data[1]);
						cboSerieDS.addData(record);
					}
				}
			}
		});
        
        this.setFields(cbCliente, itemRFC, itemCalle, itemNoExt, itemNoInt, itemColonia, itemLocalidad, itemReferencia, itemMunicipio, itemEstado, itemPais, itemCP, cboSerie, cboTipoPago, itemParcialidad, itemTotalParcialidades);
	}
}
